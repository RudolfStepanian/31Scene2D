package com.rockbite.bootcamp.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {
    Texture texture;

    public MyActor(){
        texture = new Texture("circle/red.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r,color.g,color.b, color.a * parentAlpha);
        batch.draw(texture,getX(),getY(),texture.getWidth(), texture.getHeight());
    }
}
