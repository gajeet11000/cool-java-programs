//package com.example.ajeet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SierpinskiCarpet extends Application
{
	Color[] colors = new Color[] { Color.BLACK, Color.DARKRED };
	short index = 0;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage myStage)
	{
		
		Canvas canvas = new Canvas(729, 729);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		FlowPane root = new FlowPane();
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root, 729, 729);
		
		myStage.setTitle("Seripinski Carpet");
		myStage.setScene(scene);
		myStage.show();
		
		drawSeripinskiCarpet(gc, 0, 0, 729, 729);
	}
	
	public void drawSeripinskiCarpet(GraphicsContext gc, int x, int y, int width, int height)
	{
		if(width != height || width < 3)
			return;
		
		int size = width /= 3;
		gc.setFill(colors[index]);
		gc.fillRect(x + size, y + size, size, size);
		
		index++;
		
		if(index == colors.length)
		{
			index = 0;
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			for(int j = 0 ; j < 3 ; j++)
			{
				if(i == 1 && j == 1)
				{
					continue;
				}
				drawSeripinskiCarpet(gc, x + j * size, y + i * size, size, size);
			}
		}
	}
}
