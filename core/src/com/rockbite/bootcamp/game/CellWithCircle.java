package com.rockbite.bootcamp.game;

import com.badlogic.gdx.scenes.scene2d.Group;

import javax.swing.*;

public class CellWithCircle extends Group {
    private Cell cell;
    private Circle circle;

    public CellWithCircle(Cell cell, Circle circle) {
        this.cell = cell;
        this.circle = circle;
    }
}
