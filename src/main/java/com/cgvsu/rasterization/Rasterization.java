package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {
    public static void drawCircle(
            final GraphicsContext graphicsContext,
            final int CenterX, int CenterY, int r,
            final Color color
    ){
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
//        while (x < y){
//            pixelWriter.setColor(x, y, color);
//            pixelWriter.setColor(-x, y, color);
//            pixelWriter.setColor(x, -y, color);
//            pixelWriter.setColor(-x, - y, color);
//            y = y + 1;
//            t1 = t1 + y;
//            t2 = t1 - x;
//            if (t2 >= 0){
//                t1 = t2;
//                x = x - 1;
//            }
//
//        }
        
            int d = (5 - r * 4)/4;
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
