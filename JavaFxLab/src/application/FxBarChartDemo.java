package application;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxBarChartDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Line Chart Sample");
		// defining the axes
		final NumberAxis yAxis = new NumberAxis();
		final CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Candidatos");
		yAxis.setLabel("Votos válidos");
		// creating the chart
		BarChart chart = new BarChart(xAxis, yAxis);
		chart.setTitle("Eleições 2018 - Presidência");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("Votos");
		// populating the series with data
		series.getData().add(new XYChart.Data("Haddad", 1));
		series.getData().add(new XYChart.Data("Nulos", 2));
//		series.getData().add(new XYChart.Data("", 24));
//		series.getData().add(new XYChart.Data("", 34));
		Pane pane = new Pane();
		Button btn = new Button("Add");
		pane.getChildren().addAll(chart,btn);
		
		Scene scene = new Scene(pane, 800, 600);
		chart.setAnimated(false);
		chart.getData().add(series);
        saveAsPng(chart, "chart1.png");
		stage.setScene(scene);
		//saveAsPng(lineChart, "chart1.png");
		stage.show();
		System.out.println("After show");

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				XYChart.Series series1 = new XYChart.Series();

				series.getData().add(new XYChart.Data("Bolsonaro", 97));
//				series1.getData().add(new XYChart.Data((new Random().nextInt(20) + -10)	,(new Random().nextInt(15) + -10)));
//				series1.getData().add(new XYChart.Data((new Random().nextInt(40) + -20)	,(new Random().nextInt(30) + -10)));
//				series1.getData().add(new XYChart.Data((new Random().nextInt(20) + -5)	,(new Random().nextInt(25) + -30)));
//				series1.setName("series1");
//				lineChart.getData().add(series1);
				

			}
		});
	}

	public void saveAsPng(Chart lineChart, String path) {
		WritableImage image = lineChart.snapshot(new SnapshotParameters(), null);


		File file = new File(path);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// usa o file no image do itext
		System.out.println(file.getPath());
		
	}
}