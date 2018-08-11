/* Alex Schwiegeraht
 * Description: Uses iteration rather than recursion to create the branging tree by using Stacks.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.Stack;

public class Exercise18_36StackRecursion extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {       
    TreePane pane = new TreePane(); 
    TextField tfOrder = new TextField(); 
    tfOrder.setOnAction(
      e -> pane.setDepth(Integer.parseInt(tfOrder.getText())));
    tfOrder.setPrefColumnCount(4);
    tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

    // Pane to hold label, text field, and a button
    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
    hBox.setAlignment(Pos.CENTER);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
        
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 200, 210);
    primaryStage.setTitle("Exercise18_38"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    scene.widthProperty().addListener(ov -> pane.paint());
    scene.heightProperty().addListener(ov -> pane.paint());
  }

  /** Pane for displaying triangles */
  static class TreePane extends Pane {
    private int order = 0;
    private double angleFactor = Math.PI / 5;
    private double sizeFactor = 0.58;

    public void setDepth(int depth) {
      this.order = depth;
      paint();
    }

    public void paint() {
      getChildren().clear();
      double x1 = getWidth() / 2;
      double y1 = getHeight() - 10;
      double length = getHeight() / 3;
      double angle = Math.PI / 2;
      
      paintBranch(order, x1, y1,length, angle);
    }

    public void paintBranch(int order, double x1, double y1,
        double length, double angle) {
    	Stack<stackFrame> frames = new Stack<>();
    	frames.add(new stackFrame(order,x1,y1,length,angle));
    	while (!frames.isEmpty()){
    		stackFrame frame = frames.remove(frames.size()-1);
    		order = frame.order;
    		x1 = frame.x1;
    		y1 = frame.y1;
    		length = frame.length;
    		angle = frame.angle;
    		if(order>=0){
    			double x2 = x1 + Math.cos(angle) * length;
    			double y2 = y1 - Math.sin(angle) * length;
    			getChildren().add(new Line(x1, y1, x2, y2));
    			frames.add(new stackFrame(order-1,x2,y2,length*sizeFactor,angle+angleFactor));
    			frames.add(new stackFrame(order-1,x2,y2,length*sizeFactor,angle-angleFactor));
    		}
    	}
    }
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  private static class stackFrame {
	  int order;
	  double x1;
	  double y1;
	  double length;
	  double angle;
	  public stackFrame(int order, double x1, double y1, double length, double angle) {
		  this.order = order;
		  this.x1 = x1;
		  this.y1 = y1;
		  this.length = length;
		  this.angle=angle;
	  }
  }
}
