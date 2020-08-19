package com.rockbite.bootcamp.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Circle extends Actor {
    private Texture texture;
    private Color color;

    public Circle(Color color){
        this.color = color;
        texture = new Texture(color.getValue());
    }

    public void draw(Batch batch, float parentAlpha) {
        com.badlogic.gdx.graphics.Color color = getColor();
        batch.setColor(color.r,color.g,color.b, color.a * parentAlpha);
        batch.draw(texture,getX(),getY(),50, 50);
    }

    public void changePlace(int countUp, int countSide){
        this.addAction(Actions.sequence(
                Actions.moveTo(this.getX() + countSide, this.getY() + countUp,1f))
        );
        this.setZIndex(0);
    }

    public void fade(){
        this.addAction(Actions.sequence(
                Actions.fadeOut(1f))
        );
        this.setZIndex(0);
    }

    public Texture getTexture() {
        return texture;
    }

    public Color getCircleColor() {
        return color;
    }
}
