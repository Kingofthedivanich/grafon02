package com.cgvsu.models;

import com.cgvsu.Interface.Object;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Ellipse implements Object {
    private List<Point> points = new ArrayList<>();
    private int centerX;
    private int centerY;
    private int a;
    private int b;

    public Ellipse(int centerX, int centerY, int a, int b){
        this.centerX = centerX;
        this.centerY = centerY;
        this.a = a;
        this.b = b;

        points = getPoints();
    }

    @Override
    public void draw(GraphicsContext gc){
        for(Point c1: points){
            new Pixel(c1, Color.BLACK).draw(gc);
        }
    }
//    @Override
//    public List<Point> getPoints() {
//        List<Point> ans = new ArrayList<>();
//
//        int x = a;
//        int y = 0;
//        int aSquare = a * a;
//        int bSquare = b * b;
//        int twoASquare = 2 * aSquare;
//        int twoBSquare = 2 * bSquare;
//        int fourASquare = 4 * aSquare;
//        int fourBSquare = 4 * bSquare;
//        int error = bSquare - (aSquare * b) + (aSquare / 4);
//
//        while (twoBSquare * x >= twoASquare * y) {
//            ans.add(new Point(centerX + x, centerY + y));
//            ans.add(new Point(centerX - x, centerY - y));
//            ans.add(new Point(centerX + x, centerY - y));
//            ans.add(new Point(centerX - x, centerY + y));
//
//            y++;
//
//            if (error < 0) {
//                error += twoBSquare * (2 * y + 1);
//            } else {
//                x--;
//                error += twoBSquare * (2 * y + 1) - fourASquare * (x - 1);
//            }
//        }
//
//        x = 0;
//        y = b;
//        error = aSquare - (bSquare * a) + (bSquare / 4);
//
//        while (twoASquare * y >= twoBSquare * x) {
//            ans.add(new Point(centerX + x, centerY + y));
//            ans.add(new Point(centerX - x, centerY - y));
//            ans.add(new Point(centerX + x, centerY - y));
//            ans.add(new Point(centerX - x, centerY + y));
//
//            x++;
//
//            if (error < 0) {
//                error += twoASquare * (2 * x + 1);
//            } else {
//                y--;
//                error += twoASquare * (2 * x + 1) - fourBSquare * (y - 1);
//            }
//        }
//
//        return ans;
//    }

//    @Override
//    public List<Point> getPoints()
//    {
//        List<Point> ans = new ArrayList<>();
//        int dx, dy, d1, d2, x, y;
//        x = 0;
//        y = centerY;
//
//        // Initial decision parameter of region 1
//        d1 = (centerY * centerY) - (centerX * centerX * centerY) +
//                (centerX * centerX /4);
//        dx = 2 * centerY * centerY * x;
//        dy = 2 * centerX * centerX * y;
//
//        // For region 1
//        while (dx < dy)
//        {
//
//            // Print points based on 4-way symmetry
//            ans.add(new Point(x+a, y+b));
//            ans.add(new Point(-x+a, y+b));
//            ans.add(new Point(x+a, -y+b));
//            ans.add(new Point(-x+a, -y+b));
//
//            // Checking and updating value of
//            // decision parameter based on algorithm
//            if (d1 < 0)
//            {
//                x++;
//                dx = dx + (2 * centerY * centerY);
//                d1 = d1 + dx + (centerY * centerY);
//            }
//            else
//            {
//                x++;
//                y--;
//                dx = dx + (2 * centerY * centerY);
//                dy = dy - (2 * centerX * centerX);
//                d1 = d1 + dx - dy + (centerY * centerY);
//            }
//        }
//
//        // Decision parameter of region 2
//        d2 = ((centerY * centerY) * ((x + 1/2) * (x + 1/2)))
//                + ((centerX * centerX) * ((y - 1) * (y - 1)))
//                - (centerX * centerX * centerY * centerY);
//
//        // Plotting points of region 2
//        while (y >= 0) {
//
//            // printing points based on 4-way symmetry
//            ans.add(new Point(x+a, y+b));
//            ans.add(new Point(-x+a, y+b));
//            ans.add(new Point(x+a, -y+b));
//            ans.add(new Point(-x+a, -y+b));
//
////            System.out.println(df.format((x + a)) +
////                    ", " + df.format((y + b)));
////            System.out.println(df.format((-x + a)) +
////                    ", "+ df.format((y + b)));
////            System.out.println(df.format((x + a)) +
////                    ", " + df.format((-y + b)));
////            System.out.println(df.format((-x + a)) +
////                    ", " + df.format((-y + b)));
//
//            // Checking and updating parameter
//            // value based on algorithm
//            if (d2 > 0) {
//                y--;
//                dy = dy - (2 * centerX * centerX);
//                d2 = d2 + (centerX * centerX) - dy;
//            }
//            else {
//                y--;
//                x++;
//                dx = dx + (2 * centerY * centerY);
//                dy = dy - (2 * centerX * centerX);
//                d2 = d2 + dx - dy + (centerX * centerX);
//            }
//        }
//        return ans;
//    }

    @Override
    public List<Point> getPoints()
    {
        List<Point> ans = new ArrayList<>();
        int dx, dy, d1, d2, x, y;
        x = 0;
        y = b;

        // Initial decision parameter of region 1
        d1 = (b * b) - (a * a * b) +
                (a * a / 4);
        dx = 2 * b * b * x;
        dy = 2 * a * a * y;

        // For region 1
        while (dx < dy)
        {

            ans.add(new Point(x+centerX, y+centerY));
            ans.add(new Point(-x+centerX, y+centerY));
            ans.add(new Point(x+centerX, -y+centerY));
            ans.add(new Point(-x+centerX, -y+centerY));

            // Checking and updating value of
            // decision parameter based on algorithm
            if (d1 < 0)
            {
                x++;
                dx = dx + (2 * b * b);
                d1 = d1 + dx + (b * b);
            }
            else
            {
                x++;
                y--;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                d1 = d1 + dx - dy + (b * b);
            }
        }

        // Decision parameter of region 2
        d2 = ((b * b) * ((x + 1/2) * (x + 1/2)))
                + ((a * a) * ((y - 1) * (y - 1)))
                - (a * a * b * b);

        // Plotting points of region 2
        while (y >= 0) {

            // printing points based on 4-way symmetry
            ans.add(new Point(x+centerX, y+centerY));
            ans.add(new Point(-x+centerX, y+centerY));
            ans.add(new Point(x+centerX, -y+centerY));
            ans.add(new Point(-x+centerX, -y+centerY));

            // Checking and updating parameter
            // value based on algorithm
            if (d2 > 0) {
                y--;
                dy = dy - (2 * a * a);
                d2 = d2 + (a * a) - dy;
            }
            else {
                y--;
                x++;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                d2 = d2 + dx - dy + (a * a);
            }
        }
        return ans;
    }

}
