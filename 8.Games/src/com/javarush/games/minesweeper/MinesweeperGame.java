package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "⚑";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[i][j].isMine)
                    for (GameObject object:
                         getNeighbors(gameField[i][j])) {
                        if (object.isMine)
                            gameField[i][j].countMineNeighbors++;
                    }

            }

        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) { if (isGameStopped) restart(); else openTile(x, y); }

    @Override
    public void onMouseRightClick(int x, int y) {
        if (!isGameStopped) markTile(x, y);
    }

    private void restart() {
        isGameStopped = false;

        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;


        setScore(score);
        createGame();
    }

    private void markTile(int x, int y) {
        if (!gameField[y][x].isOpen)
            if (gameField[y][x].isFlag) {
                gameField[y][x].isFlag = false;
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
                countFlags++;
            } else
                if (countFlags > 0) {
                    gameField[y][x].isFlag = true;
                    setCellColor(x, y, Color.ORANGERED);
                    setCellValue(x, y, FLAG);
                    countFlags--;
                }

    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.DARKGRAY, "LOOSER!!!", Color.RED, 100);
    }
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.DARKGRAY, "WINNER!!!", Color.GREEN, 100);
    }

    private void openTile(int x, int y) {
        if (!isGameStopped && !gameField[y][x].isOpen && !gameField[y][x].isFlag) {

            if (!gameField[y][x].isMine) {

                if (gameField[y][x].countMineNeighbors != 0) {
                    gameField[y][x].isOpen = true;
                    countClosedTiles--;
                    score += 5;
                    setCellColor(x, y, Color.LIGHTGRAY);
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                } else {
                    gameField[y][x].isOpen = true;
                    countClosedTiles--;
                    score += 5;
                    setCellValue(x, y, "");
                    setCellColor(x, y, Color.LIGHTGRAY);
                    List<GameObject> neighbors = new ArrayList<>();
                    for (GameObject cell :
                            getNeighbors(gameField[y][x])) {
                        if (!cell.isOpen && !cell.isFlag)
                            neighbors.add(cell);
                        for (GameObject neighbor :
                                neighbors) {
                            openTile(neighbor.x, neighbor.y);
                        }
                    }
                }
            } else {
//                gameField[y][x].isOpen = true;
//                countClosedTiles--;
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
            setScore(score);
            if (countClosedTiles == countMinesOnField)
                win();
        }
    }
}