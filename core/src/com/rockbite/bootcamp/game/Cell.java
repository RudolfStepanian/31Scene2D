package com.rockbite.bootcamp.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Cell extends Actor {

    private Texture texture;
    private int row;
    private int column;
    private Circle circle;

    public Cell(int row, int column, Circle circle){
        texture = new Texture("cell.png");
        this.row = row;
        this.column = column;
        this.circle = circle;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r,color.g,color.b, color.a * parentAlpha);
        batch.draw(texture,getX(),getY(),50, 50);
//        batch.draw(circle.getTexture(),circle.getTexture().getWidth(),circle.getTexture().getHeight());
    }

    public boolean canBeChanged(Cell cell){
        int diff = this.getColumn() - cell.getColumn() + this.getRow() - cell.getRow();
        if (diff == 1 || diff == -1){
            return true;
        }
        return false;
    }

    public void changeCircleWithCell(Cell cell){
        Circle temp = cell.circle;
        cell.getCircle().addAction(Actions.sequence(
                Actions.moveTo(this.getX(), this.getY() - 50,0.5f))
        );
        this.getCircle().addAction(Actions.sequence(
                Actions.moveTo(this.getX(), this.getY() + 50,0.5f))
        );
        cell.setCircle(this.getCircle());
        this.setCircle(temp);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    public String toString() {
        return "Cell: " + getRow()+ ", " + getColumn();
    }
}
