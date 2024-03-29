package com.flappybird.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {

    Texture img;
    Vector2 position;
    float vy;
    float gravity;

    public Bird (){
        img = new Texture("bird1.png");
        position = new Vector2(100,380);
        vy=0;
        gravity = -0.7f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(img,position.x, position.y);
    }

    public void upDate(){

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            vy=8;
        }
        vy +=gravity;
        position.y += vy;
    }

    public void reCreate(){
        position = new Vector2(100,380);
        vy=0;
    }
}
