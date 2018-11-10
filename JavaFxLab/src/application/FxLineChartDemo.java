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
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxLineChartDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Line Chart Sample");
		// defining the axes
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		yAxis.setLabel("Number of Month");
		// creating the chart
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Stock Monitoring, 2010");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("My portfolio");
		// populating the series with data
		series.getData().add(new XYChart.Data(-11, -11));
		series.getData().add(new XYChart.Data(2.2, 55.001));
		series.getData().add(new XYChart.Data(3, 15));
		series.getData().add(new XYChart.Data(4, 24));
		series.getData().add(new XYChart.Data(5, 34));
		Pane pane = new Pane();
		Button btn = new Button("Add");
		pane.getChildren().addAll(lineChart,btn);
		
		Scene scene = new Scene(pane, 800, 600);
		lineChart.setAnimated(true);
		lineChart.getData().add(series);
        saveAsPng(lineChart, "chart1.png");
		stage.setScene(scene);
		//saveAsPng(lineChart, "chart1.png");
		stage.show();
		System.out.println("After show");

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				XYChart.Series series1 = new XYChart.Series();
				series1.getData().add(new XYChart.Data((new Random().nextInt(20) + -10)	,(new Random().nextInt(15) + -10)));
				series1.getData().add(new XYChart.Data((new Random().nextInt(40) + -20)	,(new Random().nextInt(30) + -10)));
				series1.getData().add(new XYChart.Data((new Random().nextInt(20) + -5)	,(new Random().nextInt(25) + -30)));
				series1.setName("series1");
				lineChart.getData().add(series1);
				

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