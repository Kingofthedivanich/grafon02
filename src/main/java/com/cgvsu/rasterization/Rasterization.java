package com.cgvsu.rasterization;

import com.cgvsu.models.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Rasterization {
    public static void drawCircle(
            final GraphicsContext graphicsContext,
            final int CenterX, int CenterY, int r,
            final Color color
    ) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        int d = (5 - r * 4) / 4;
        int x = 0;
        int y = r;

        do {
            pixelWriter.setColor(CenterX + x, CenterY + y, color);
            pixelWriter.setColor(CenterX + x, CenterY - y, color);
            pixelWriter.setColor(CenterX - x, CenterY + y, color);
            pixelWriter.setColor(CenterX - x, CenterY - y, color);
            pixelWriter.setColor(CenterX + y, CenterY + x, color);
            pixelWriter.setColor(CenterX + y, CenterY - x, color);
            pixelWriter.setColor(CenterX - y, CenterY + x, color);
            pixelWriter.setColor(CenterX - y, CenterY - x, color);
            if (d < 0) {
                d += 2 * x + 1;
            } else {
                d += 2 * (x - y) + 1;
                y--;
            }
            x++;
        } while (x <= y);
    }


}
