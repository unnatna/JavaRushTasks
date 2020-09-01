package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        //super.onKeyPress(key);
        if (!isGameStopped) {

            if (!canUserMove())
                gameOver();
            else if (key == Key.LEFT) {
                moveLeft();
                drawScene();
            } else if (key == Key.RIGHT) {
                moveRight();
                drawScene();
            } else if (key == Key.UP) {
                moveUp();
                drawScene();
            } else if (key == Key.DOWN) {
                moveDown();
                drawScene();
            }
        }
        else if (key == Key.SPACE) {
            isGameStopped = false;
            score = 0;
            setScore(score);
            createGame();
            drawScene();
        }
    }

    private void moveLeft() {
        boolean result = false;
        for (int i = 0; i < gameField.length; i++) {
            if (compressRow(gameField[i]))
                result = true;
            if (mergeRow(gameField[i])) {
                result = true;
            }
            if (compressRow(gameField[i]))
                result = true;
        }

        if (result)
            createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void rotateClockwise() {
        for (int i = 0; i < gameField.length / 2; i++) {
            for (int j = i; j < gameField.length - i - 1; j++) {
                int temp = gameField[i][j];

                gameField[i][j] = gameField[gameField.length - 1 - j][i];
                gameField[gameField.length - 1 - j][i] = gameField[gameField.length - 1 - i][gameField.length - 1 - j];
                gameField[gameField.length - 1 - i][gameField.length - 1 - j] = gameField[j][gameField.length - 1 - i];
                gameField[j][gameField.length - 1 - i] = temp;
            }
        }
    }

    private void createGame() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                gameField[y][x] = 0;
            }
        }

        createNewNumber();
        createNewNumber();

    }

    private void drawScene() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
                //System.out.print(gameField[y][x] + " ");
            }
            //System.out.println();
        }
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048)
            win();
        else {
            boolean check = true;
            while (check) {
                int x = getRandomNumber(SIDE);
                int y = getRandomNumber(SIDE);

                if (gameField[y][x] == 0) {
                    switch (getRandomNumber(10)) {
                        case 9:
                            gameField[y][x] = 4;
                            break;
                        default:
                            gameField[y][x] = 2;
                            break;
                    }
                    check = false;
                }
            }
        }
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.SLATEGREY, "WINNER!!!", Color.GREENYELLOW, 100);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.SLATEGREY, "LOOSE!!!", Color.ORANGERED, 100);
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), value != 0 ? String.valueOf(value) : "");
        //setCellValueEx(x, y, getColorByValue(value), String.valueOf(value));
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.WHITE;

            case 2:
                return Color.BLUE;

            case 4:
                return Color.FORESTGREEN;

            case 8:
                return Color.SALMON;

            case 16:
                return Color.AQUAMARINE;

            case 32:
                return Color.AZURE;

            case 64:
                return Color.CYAN;

            case 128:
                return Color.ORANGE;

            case 256:
                return Color.YELLOW;

            case 512:
                return Color.RED;

            case 1024:
                return Color.PINK;

            case 2048:
                return Color.PURPLE;

        }
        return null;
    }

    private boolean compressRow(int[] row) {
        boolean result = false;
        int [] tail = new int[0];
        int[] newTail;
        for (int i = row.length - 1; i >= 0 ; i--) {
            int[] cur = new int[1];
            cur[0] = row[i];
            if (row[i] != 0) {
                newTail = new int[tail.length + 1];
                System.arraycopy(cur, 0, newTail, 0, cur.length);
                System.arraycopy(tail, 0, newTail, cur.length, tail.length);
                tail = newTail;
            } else {
                if (tail.length > 0) {
                    result = true;
                    System.arraycopy(tail, 0, row, i, tail.length);
                    System.arraycopy(cur, 0, row, i + tail.length, cur.length);
                }
            }
        }
        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i + 1] == row[i]) {
                result = true;
                row[i] = row[i] + row[i + 1];
                score = score + row[i];
                setScore(score);
                row[i + 1] = 0;
            }
        }
        return result;
    }

    private int getMaxTileValue() {
        int result = gameField[0][0];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] > result)
                    result = gameField[i][j];
            }
        }
        return result;
    }

    private boolean canUserMove() {
        boolean result = false;

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == 0)
                    return true;
            }
        }

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length - 1; j++) {
                if ((gameField[i][j] == gameField[i][j + 1] && gameField[i][j] != 0))
                    return true;
            }
        }

        for (int i = 0; i < gameField.length - 1; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if ((gameField[i][j] == gameField[i + 1][j] && gameField[i][j] != 0))
                    return true;
            }
        }

        return result;
    }
}
