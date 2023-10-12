package com.cgvsu.rasterizationfxapp;

import com.cgvsu.Drawable;
import com.cgvsu.models.Sector;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

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

        ArrayList<Drawable> d = new ArrayList<>();
        d.add(new Sector(300, 300, 100, 600, 500, 500, 200));

        for(Drawable d1:d){
            d1.draw(canvas.getGraphicsContext2D());
        }



    }

}