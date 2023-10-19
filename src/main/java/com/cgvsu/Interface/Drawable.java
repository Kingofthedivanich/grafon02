package com.cgvsu.Interface;

import com.cgvsu.models.Pixel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import java.util.List;

public interface Drawable {
    public default void draw(final GraphicsContext gc,
                             List<Pixel> p){
        final PixelWriter px = gc.getPixelWriter();
        for(Pixel p1:p){
            px.setColor(p1.getX(), p1.getY(), p1.getC0());
        }
    };

    public void draw(final GraphicsContext gc);
}
