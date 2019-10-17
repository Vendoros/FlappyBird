package com.flappybird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch; //область для отрисовки
    private Backgorund bg;
    private Bird bird;
    private Obstacles obstacles;
    private boolean gameOver;
    private Texture restartTexture;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Backgorund();
        bird = new Bird();
        obstacles = new Obstacles();
        gameOver = false;
        restartTexture = new Texture("RestartBtn.png");
    }
    //загружает в память все необходимые элементы

    @Override
    public void render() {
        upDate();
        batch.begin();//начало отрисовки
        bg.render(batch);
        obstacles.render(batch);
        if (!gameOver) {
            bird.render(batch);
        } else {
            batch.draw(restartTexture, 200, 200);
        }
        batch.end();//заканчивается отрисовка
    }


    private void upDate() {
        bg.upDate();
        bird.upDate();
        obstacles.upDate();
        for (int i = 0; i < Obstacles.wall.length; i++) {
            if (bird.position.x > Obstacles.wall[i].position.x
                    && bird.position.x > Obstacles.wall[i].position.x + 50) {
                if (Obstacles.wall[i].emptySpace.contains(bird.position)) {
                    gameOver = true;
                }
            }
        }
        if (bird.position.y < 0 || bird.position.y > 600) { gameOver = true; }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
            reCreate();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    //очищяет ресурсы.

    public void reCreate() {
        bird.reCreate();
        obstacles.reCreate();
        gameOver = false;
    }

}
