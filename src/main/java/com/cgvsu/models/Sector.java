package com.cgvsu.models;

import com.cgvsu.Interface.Object;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Sector implements Object {

    private List<Point> points = new ArrayList<>();
   private int center_x;
    private int center_y; // center of circle (x,y)
    private int sectstartx;
    private int sectstarty; // start point of sector
    private int sectendx;
    private int sectendy; // end point of sector
    private int radius;

    public Sector(int center_x, int center_y, // center of circle (x,y)
                  int sectstartx, int sectstarty, // start point of sector
                  int sectendx, int sectendy, // end point of sector
                  int radius // radius
    ) {
        this.center_x = center_x;
        this.center_y = center_y;
        this.sectstartx = sectstartx;
        this.sectstarty = sectstarty;
        this.sectendx = sectendx;
        this.sectendy = sectendy;
        this.radius = radius;

        points = getPoints();
    }
    @Override
    public void draw(GraphicsContext gc){
        for(Point c1: points){
            new Pixel(c1, Color.BLACK).draw(gc);
        }
    }

//    public void drawRadialInterpolation(GraphicsContext gc, int center_x, int center_y, int radius, Color centerColor, Color endColor){
//        for(Point c1: points){
//            new Pixel(c1, Interpolation.getColorByDistance(center_x, center_y, c1.x, c1.y, radius, centerColor, endColor)).draw(gc);
//        }
//    }
    @Override
    public List<Point> getPoints() { // sector color
        List<Point> ans = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) { // circle fill algorithm
            int height = (int) Math.sqrt(radius * radius - x * x); // no radius check, high efficiency
            for (int y = -height; y <= height; y++)
                if (isInsideSector(x + center_x, y + center_y, center_x, center_y, sectstartx, sectstarty, sectendx, sectendy, radius)) {
                    ans.add(new Point(x + center_x, y + center_y));
                }

            //getColorByDistance(center_x, center_y, center_x+x, center_y+y, radius))
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
