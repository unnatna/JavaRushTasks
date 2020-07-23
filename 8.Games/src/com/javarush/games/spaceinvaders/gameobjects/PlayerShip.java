package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.Iterator;
import java.util.List;

public class PlayerShip extends Ship {
    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN)
            this.direction = newDirection;
    }

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {
        if (bullets.size() != 0) {
            if (isAlive) {
                Iterator iterator = bullets.iterator();
                while (iterator.hasNext()) {
                    Bullet bullet = (Bullet) iterator.next();
                    if (bullet.isAlive && this.isCollision(bullet)) {
                        this.kill();
                        bullet.kill();
                    }
                }
            }
        }
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            setAnimatedView(false, ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER);
        }
    }

    public void move() {
        if (isAlive) {
            switch (direction) {
                case LEFT:
                    x--;
                    break;
                case RIGHT:
                    x++;
                    break;
            }

            if (x < 0)
                x = 0;

            if (x + width > SpaceInvadersGame.WIDTH)
                x = SpaceInvadersGame.WIDTH - width;
        }
    }

    @Override
    public Bullet fire() {
        if (isAlive)
            return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
        else
            return null;
    }

    public void win() {
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }
}
