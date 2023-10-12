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

    public static void draw(final GraphicsContext gc,
                     List<Point> p){
        final PixelWriter px = gc.getPixelWriter();
        for(Point p1:p){
            px.setColor(p1.getX(), p1.getY(), p1.getC0());
        }
    }

    public static Color getColorByDistance(int xCenter, int yCenter, int x, int y, int radius){
        double distance = Math.sqrt(Math.pow(xCenter - x , 2)+Math.pow(yCenter - y, 2));
        return Color.CRIMSON.interpolate(Color.AQUA, distance/radius);

    }

    public static List<Point> drawSector(
            int center_x, int center_y, // center of circle (x,y)
            int sectstartx, int sectstarty, // start point of sector
            int sectendx, int sectendy, // end point of sector
            int radius // radius
            ) { // sector color
        List<Point> ans = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) { // circle fill algorithm
            int height = (int) Math.sqrt(radius * radius - x * x); // no radius check, high efficiency
            for (int y = -height; y <= height; y++)
                if (isInsideSector(x + center_x, y + center_y, center_x, center_y, sectstartx, sectstarty, sectendx, sectendy, radius)) {
                    ans.add(new Point(x + center_x, y + center_y, getColorByDistance(center_x, center_y, center_x+x, center_y+y, radius)));
                }
        }
        return ans;
    }

    private static boolean isInsideSector( // checks if point is inside certain sector
                                           int x, int y, // point in circle (vector S)
                                           int center_x, int center_y, // center of circle
                                           int sectstartx, int sectstarty, // start point of sector (vector V1)
                                           int sectendx, int sectendy, // end point of sector (vector V2)
                                           int radius) { // radius

        int relpointx = x - center_x; // because in drawSector x + center_x
        int relpointy = y - center_y;

        return (sectstartx * relpointy - relpointx * sectstarty > 0 && relpointx * sectendy - sectendx * relpointy > 0);
    }
}
