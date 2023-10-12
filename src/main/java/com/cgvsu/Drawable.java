package com.cgvsu;

import com.cgvsu.models.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import java.util.List;

public interface Drawable {
    public default void draw(final GraphicsContext gc,
                             List<Point> p){
        final PixelWriter px = gc.getPixelWriter();
        for(Point p1:p){
            px.setColor(p1.getX(), p1.getY(), p1.getC0());
        }
    };
}
