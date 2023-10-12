package com.cgvsu.models;

import javafx.scene.paint.Color;

public class Point {
    private int x;
    private int y;
    private Color c0;

    public Point(int x, int y, Color c0){
        this.x = x;
        this.y = y;
        this.c0 = c0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getC0() {
        return c0;
    }
}
