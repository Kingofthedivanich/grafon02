package com.cgvsu.rasterizationfxapp;

import com.cgvsu.Interface.Object;
import com.cgvsu.interpolation.RadialInterpolation;
import com.cgvsu.models.Ellipse;
import com.cgvsu.models.Pixel;
import com.cgvsu.models.Point;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

//        Rasterization.drawRectangle(canvas.getGraphicsContext2D(), 200, 300, 200, 100, Color.CHOCOLATE);
//        Rasterization.drawRectangle(canvas.getGraphicsContext2D(), 250, 250, 50, 200, Color.AQUA);
//        Rasterization.drawCircle(canvas.getGraphicsContext2D(), 200, 200, 100, Color.CHOCOLATE);
//        Rasterization.drawPoint(canvas.getGraphicsContext2D(), 100, 100, Color.CHOCOLATE);
//        Rasterization.drawPoint(canvas.getGraphicsContext2D(), 99, 100, Color.CHOCOLATE);
//        Rasterization.drawPoint(canvas.getGraphicsContext2D(), 100, 99, Color.CHOCOLATE);
//        Rasterization.drawPoint(canvas.getGraphicsContext2D(), 99, 99, Color.CHOCOLATE);

        ArrayList<Object> d = new ArrayList<>();
        d.add(new Ellipse(300, 300, 200, 100));


        for (Object o:d){
            List<Point> p= o.getPoints();
            List<Pixel> pix = new RadialInterpolation(300, 300, 200, Color.AQUA, Color.CRIMSON).getInterpolation(p);
            for(Pixel p1:pix){
                p1.draw(canvas.getGraphicsContext2D());
            }
        }






    }

}