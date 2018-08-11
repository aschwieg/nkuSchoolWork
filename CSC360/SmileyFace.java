/* Alex Schwiegeraht
 * Description: Creates a Smiley Face
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class SmileyFace extends Application{

	public void start(Stage primaryStage) {
	    Circle head = new Circle();
	    head.setCenterX(100);
	    head.setCenterY(100);
	    head.setRadius(50);
	    head.setStroke(Color.BLACK);
	    head.setFill(null);
	    
	    Circle rightEyePupil = new Circle();
	    rightEyePupil.setCenterX(120);
	    rightEyePupil.setCenterY(80);
	    rightEyePupil.setRadius(5);
	    rightEyePupil.setStroke(Color.BLACK);
	    rightEyePupil.setFill(Color.BLACK);
	    
	    Circle leftEyePupil = new Circle();
	    leftEyePupil.setCenterX(80);
	    leftEyePupil.setCenterY(80);
	    leftEyePupil.setRadius(5);
	    leftEyePupil.setStroke(Color.BLACK);
	    leftEyePupil.setFill(Color.BLACK);
	    
	    Rectangle leftEye = new Rectangle();
	    leftEye.setX(65);
	    leftEye.setY(70);
	    leftEye.setWidth(30);
	    leftEye.setHeight(20);
	    leftEye.setArcWidth(30);
	    leftEye.setArcHeight(30);
	    leftEye.setStroke(Color.BLACK);
	    leftEye.setFill(null);
	    
	    Rectangle rightEye = new Rectangle();
	    rightEye.setX(105);
	    rightEye.setY(70);
	    rightEye.setWidth(30);
	    rightEye.setHeight(20);
	    rightEye.setArcWidth(30);
	    rightEye.setArcHeight(30);
	    rightEye.setStroke(Color.BLACK);
	    rightEye.setFill(null);
	    
	    Arc smile = new Arc();
	    smile.setCenterX(100.0f);
	    smile.setCenterY(125.0f);
	    smile.setRadiusX(15.0f);
	    smile.setRadiusY(10.0f);
	    smile.setStartAngle(0.0f);
	    smile.setLength(-180.0f);
	    smile.setType(ArcType.OPEN);
	    smile.setFill(Color.WHITE);
	    smile.setStroke(Color.BLACK);
	    
	    Polygon nose = new Polygon();
	    nose.getPoints().addAll(new Double[]{
	    	    100.0, 90.0,
	    	    120.0, 110.0,
	    	    80.0, 110.0 });
	    nose.setFill(null);
	    nose.setStroke(Color.BLACK);
	    
	    Pane pane = new Pane();
	    pane.getChildren().add(head);
	    pane.getChildren().add(leftEye);
	    pane.getChildren().add(rightEye);
	    pane.getChildren().add(rightEyePupil);
	    pane.getChildren().add(leftEyePupil);
	    pane.getChildren().add(smile);
	    pane.getChildren().add(nose);
	    
	    Scene scene = new Scene(pane, 200, 200);
	    primaryStage.setTitle("Smiley Face");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	 public static void main(String[] args) {
		    launch(args);
		  }

}
