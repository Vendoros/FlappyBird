package com.flappybird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch; //область для отрисовки
    Backgorund bg;
    Bird bird;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Backgorund();
        bird = new Bird();

    }
    //загружает в память все необходимые элементы

    @Override
    public void render() {
        upDate();
        Gdx.gl.glClearColor(1, 1, 1, 1);//указываем цвет для заливки отрисованной области
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//заливаем отрисованную область
        batch.begin();//начало отрисовки
        bg.render(batch);
		bird.render(batch);
        batch.end();//заканчивается отрисовка
    }
    //вызывается 60р в с. отрисовывает все

    public void upDate() {
        bg.upDate();
        bird.upDate();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    //очищяет ресурсы.

}
