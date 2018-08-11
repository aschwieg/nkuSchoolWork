/* Alex Schwiegeraht
 * CSC 360-001
 * Description:Solves for the quadratic formula in a JavaFX application
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuadraticFormulaCalculator extends Application{
	private TextField tfA = new TextField();
	private TextField tfB = new TextField();
	private TextField tfC = new TextField();
	private TextField tfSolution = new TextField();
	private Button btSolve = new Button("Solve");
	
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		HBox topHBox = new HBox();
		HBox bottomHBox = new HBox();
		pane.setTop(topHBox);
		pane.setBottom(bottomHBox);
		
		topHBox.getChildren().add(new Label("a: "));
		topHBox.getChildren().add(tfA);
		topHBox.getChildren().add(new Label("b: "));
		topHBox.getChildren().add(tfB);
		topHBox.getChildren().add(new Label("c: "));
		topHBox.getChildren().add(tfC);
		topHBox.getChildren().add(new Label("Roots of ax\u00B2 + bx + c: "));
		topHBox.getChildren().add(tfSolution);
		bottomHBox.getChildren().add(btSolve);
		
		topHBox.setSpacing(10);
		bottomHBox.setSpacing(10);
		topHBox.setPadding(new Insets(15,15,15,15));
		bottomHBox.setPadding(new Insets(15,15,15,15));
		bottomHBox.setAlignment(Pos.CENTER);
		tfA.setPrefColumnCount(10);
		tfB.setPrefColumnCount(10);
		tfC.setPrefColumnCount(10);
		tfSolution.setPrefColumnCount(10);
		
		btSolve.setOnAction(e -> solveQuadraticFormula());

		 Scene scene = new Scene(pane, 800, 100);
		    primaryStage.setTitle("QuadraticFormulaCalculator");
		    primaryStage.setScene(scene); 
		    primaryStage.show();
	}

	public static void main(String[] args) {
	    launch(args);
	  }
	
	private void solveQuadraticFormula() {	
		
		double a = 0;
		double b = 0;
		double c = 0;
		
		try{
		a = Double.parseDouble(tfA.getText());
		b = Double.parseDouble(tfB.getText());
		c = Double.parseDouble(tfC.getText());
		}
		catch(NumberFormatException ex){
			if(tfA.getText().equals("")){
				tfA.setText("0");
			}
			if(tfB.getText().equals("")){
				tfB.setText("0");
			}
			if(tfC.getText().equals("")){
				tfC.setText("0");
			}
		}
		
		double discriminant = Math.pow(b, 2)-4*a*c;
		double answer1 = (-b + Math.pow(discriminant, .5))/(2*a);
		double answer2 = (-b - Math.pow(discriminant, .5))/(2*a);
		double answer3 = -b/(2*a);
		if(a==0 && b==0 && c==0){
			tfSolution.setText("All x");
		}
		else if(a==0 && b==0 && c!=0){
			tfSolution.setText("No x");
		}
		else if(discriminant < 0){
			tfSolution.setText("No real roots");
		}
		else if(discriminant == 0){
			tfSolution.setText(String.format("%.1f", answer3));
			}
		else{
			tfSolution.setText(String.format("%.1f", answer1) + ", " + String.format("%.1f", answer2));
		}
	}

	
}
