package com.flappybird.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {

    class WallPair {
        Vector2 position;
        float speed;
        int offset;
        Rectangle emptySpace;

        public WallPair(Vector2 pos) {
            position = pos;
            speed = 2;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x, position.y - offset + 300,50, betweenDistance);
        }

        public void upDate() {
            position.x -= speed;
            if (position.x < -50) {
                position.x = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.y= position.y - offset +300;
            emptySpace.x = position.x;
        }
    }
//======================================================================================================================
    static WallPair[] wall;
    private Texture txt;
    private int betweenDistance;


    public Obstacles() {
        txt = new Texture("Wall.png");
        wall = new WallPair[4];
        betweenDistance = 250;
        int startPosX = 400;
        for (int i = 0; i < wall.length; i++) {
            wall[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }

    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < wall.length; i++) {
            batch.draw(txt, wall[i].position.x, wall[i].position.y - wall[i].offset);
            batch.draw(txt, wall[i].position.x, wall[i].position.y + betweenDistance + txt.getHeight() - wall[i].offset) ;
        }
    }

    public void upDate() {
        for (WallPair ob : wall) {
            ob.upDate();
        }
    }

    public void reCreate(){
        int startPosX = 400;
        for (WallPair ob : wall) {
            ob = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }

}
