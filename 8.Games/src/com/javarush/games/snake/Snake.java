package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();

    private static final String HEAD_SIGN = "\uD83D\uDC32";
    private static final String BODY_SIGN = "\uD83E\uDDA0";
    public boolean isAlive = true;

    public Direction getDirection() {
        return direction;
    }

    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        this.snakeParts.add(new GameObject(x, y));
        this.snakeParts.add(new GameObject(x + 1, y));
        this.snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x,
                    snakeParts.get(i).y,
                    Color.NONE,
                    i == 0 ? HEAD_SIGN : BODY_SIGN,
                    isAlive ? Color.GREEN : Color.RED,
                    75);
        }
    }

    public void setDirection(Direction direction) {
        if (!(this.direction == Direction.LEFT && (snakeParts.get(0).x == snakeParts.get(1).x)) &&
            !(this.direction == Direction.RIGHT && (snakeParts.get(0).x == snakeParts.get(1).x)) &&
            !(this.direction == Direction.UP && (snakeParts.get(0).y == snakeParts.get(1).y)) &&
            !(this.direction == Direction.DOWN && (snakeParts.get(0).y == snakeParts.get(1).y))) {

            if (direction == Direction.LEFT && this.direction != Direction.RIGHT) {
                this.direction = direction;
            }
            if (direction == Direction.RIGHT && this.direction != Direction.LEFT) {
                this.direction = direction;
            }
            if (direction == Direction.DOWN && this.direction != Direction.UP) {
                this.direction = direction;
            }
            if (direction == Direction.UP && this.direction != Direction.DOWN) {
                this.direction = direction;
            }
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();


        if (newHead.x < 0 || newHead.x > SnakeGame.WIDTH - 1 || newHead.y < 0 || newHead.y > SnakeGame.HEIGHT - 1) {
            this.isAlive = false;
        } else {
            if (checkCollision(newHead))
                this.isAlive = false;
            else {
                snakeParts.add(0, newHead);
                if (newHead.x == apple.x && newHead.y == apple.y) {
                    apple.isAlive = false;

                } else
                    removeTail();
            }
        }
    }

    public GameObject createNewHead() {
        GameObject gameObject = null;
        switch (direction) {
            case LEFT:
                gameObject = new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
                break;
            case UP:
                gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
                break;
            case DOWN:
                gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
                break;
            case RIGHT:
                gameObject = new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
                break;
            default:
        }
        return gameObject;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject snakePart : snakeParts) {
            if (snakePart.x == gameObject.x && snakePart.y == gameObject.y)
                return true;
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }
}
