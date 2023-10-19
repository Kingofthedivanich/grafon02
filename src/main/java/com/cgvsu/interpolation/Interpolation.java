package com.cgvsu.interpolation;

import com.cgvsu.models.Pixel;
import com.cgvsu.models.Point;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Interpolation {

    private static Color getRadialInterpolationPixelColor(int xCenter, int yCenter, int x, int y, int radius, Color centerColor, Color endColor){
        double distance = Math.sqrt(Math.pow(xCenter - x , 2)+Math.pow(yCenter - y, 2));
        return centerColor.interpolate(endColor, distance/radius);
    }

    public static ArrayList<Pixel> getRadialInterpolation(List<Point> p, int xCenter, int yCenter, int radius, Color centerColor, Color endColor){
        ArrayList<Pixel> pixels = new ArrayList<>();
        for(Point p1:p){
            pixels.add(new Pixel(p1.x, p1.y,
                    getRadialInterpolationPixelColor(xCenter, yCenter, p1.x, p1.y, radius, centerColor, endColor)));
        }
        return pixels;
    }

}
