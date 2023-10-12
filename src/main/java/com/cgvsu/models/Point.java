package com.cgvsu.models;

import com.cgvsu.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;

public class Point implements Drawable {
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

    @Override
    public void draw(GraphicsContext gc) {
        final PixelWriter px = gc.getPixelWriter();
        px.setColor(x, y, c0);
    }
}
