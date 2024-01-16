// package com.example.ajeet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FractalTree extends Application
{
	private Color[] colors = { Color.LIME, Color.YELLOW, Color.BROWN, Color.ORANGE, Color.CYAN, Color.MAGENTA,
			Color.PINK, Color.RED, Color.DARKORCHID, Color.CORNFLOWERBLUE };
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Fractal Tree");
		
		Canvas canvas = new Canvas(800, 700);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		FlowPane root = new FlowPane();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root, 800, 700);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 800, 700);
		drawFractalTree(gc, 400, 575, -90, 100);
		
	}
	
  
	private void drawFractalTree(GraphicsContext gc, int x1, int y1, int angle, int length)
	{
		if(length < 10)
		{
			return;
		}
		
		int x2 = (int) (x1 + length * Math.cos(Math.toRadians(angle)));
		int y2 = (int) (y1 + length * Math.sin(Math.toRadians(angle)));
		
		gc.setStroke(colors[length/10 - 1]);
		// gc.setStroke(Color.WHITE);
		gc.strokeLine(x1, y1, x2, y2);
		
		drawFractalTree(gc, x2, y2, angle - 20, length - 10);
		drawFractalTree(gc, x2, y2, angle , length - 10);
		drawFractalTree(gc, x2, y2, angle + 20, length - 10);
	}
}