package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.MessageType.*;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {

            ConsoleHelper.writeMessage("Server is started.");

            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }
    
    private static class Handler extends Thread {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            ConsoleHelper.writeMessage(String.format("Connection with remote server [%s] is established.", socket.getRemoteSocketAddress()));
            String newUserName = null;

            try (Connection connection = new Connection(socket)) {
                        
                newUserName = serverHandshake(connection);
                
                sendBroadcastMessage(new Message(USER_ADDED, newUserName));
                
                notifyUsers(connection, newUserName);
                
                serverMainLoop(connection, newUserName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            } finally {
                if (newUserName != null) {
                    connectionMap.remove(newUserName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName));
                }
            }

            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто.");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message message = connection.receive();
                if (message.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                    continue;
                }

                String userName = message.getData();

                if (userName.isEmpty()) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с пустым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }

                if (connectionMap.containsKey(userName)) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с уже используемым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }
                connectionMap.put(userName, connection);

                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == TEXT) {
                    sendBroadcastMessage(new Message(TEXT, String.format("%s: %s", userName, message.getData())));
                } else {
                    ConsoleHelper.writeMessage("Your message type is not correct.");
                }
            }
        }

    }


    public static void sendBroadcastMessage(Message message) {
        // Рассылаем сообщение по всем соединениям
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Can't send your message.");
            }
        }
    }
}
