/* Alex Schwiegeraht
 * Description: Creates a plot of the sine and cosine function
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlotFunctions extends Application{
	public void start(Stage primaryStage) {
		
		Polyline sine = new Polyline();
        ObservableList<Double> sineList = sine.getPoints(); 
        for (double x = -170; x <= 170; x++) {
        	sineList.add(x + 200);
        	sineList.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));
        }
        sine.setStroke(Color.RED);
        
        Polyline cosine = new Polyline();
        ObservableList<Double> cosineList = cosine.getPoints(); 
        for (double x = -170; x <= 170; x++) {
        	cosineList.add(x + 200);
        	cosineList.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));
        }
        cosine.setStroke(Color.BLUE);
        
        Polyline yArrow = new Polyline();
        yArrow.getPoints().addAll(new Double[]{
	    	    190.0,40.0,
	    	    200.0,20.0,
	    	    210.0,40.0});
        yArrow.setFill(null);
        yArrow.setStroke(Color.BLACK);
	    
	    Polyline xArrow = new Polyline();
	    xArrow.getPoints().addAll(new Double[]{
	    	    365.0, 90.0,
	    	    380.0, 100.0,
	    	    365.0, 110.0 });
	    xArrow.setFill(null);
	    xArrow.setStroke(Color.BLACK);
        
        Text text0 = new Text(205, 110, "0");
        
        Text textX = new Text(370, 80, "X");
        
        Text textY = new Text(220, 30, "Y");
        
        Text textNegativePI = new Text(100, 110, "-2\u03c0");
        
        Text textPositivePI = new Text(300, 110, "2\u03c0");
        
        
        Line xLine = new Line();
		xLine.setStartX(20.0f);
		xLine.setStartY(100.0f);
		xLine.setEndX(380.0f);
		xLine.setEndY(100.0f);
		
		Line yLine = new Line();
		yLine.setStartX(200.0f);
		yLine.setStartY(20.0f);
		yLine.setEndX(200.0f);
		yLine.setEndY(180.0f);
		
		Pane pane = new Pane();
	    pane.getChildren().add(sine);
	    pane.getChildren().add(cosine);
	    pane.getChildren().add(xLine);
	    pane.getChildren().add(yLine);
	    pane.getChildren().add(text0);
	    pane.getChildren().add(textY);
	    pane.getChildren().add(textX);
	    pane.getChildren().add(textNegativePI);
	    pane.getChildren().add(textPositivePI);
	    pane.getChildren().add(xArrow);
	    pane.getChildren().add(yArrow);
	    
	    
	    Scene scene = new Scene(pane, 400, 200);
	    primaryStage.setTitle("Plot Function");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
		
	

	public static void main(String[] args) {
		launch(args);

	}

}
