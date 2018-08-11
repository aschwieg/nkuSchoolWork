/* Alex Schwiegeraht
 * Description: Makes a Swirl to the users specifications
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Swirls extends Application {
  @Override
  public void start(Stage primaryStage) {       
	  SwirlPane pane = new SwirlPane(); 
	  TextField tfOrder = new TextField(); 
	  TextField tfBranches = new TextField(); 
	  tfOrder.setOnAction(
    		e -> pane.setDepth(Integer.parseInt(tfOrder.getText())));
	  tfBranches.setOnAction(
    		e -> pane.setBranches(Integer.parseInt(tfBranches.getText())));
	  tfOrder.setPrefColumnCount(4);
	  tfOrder.setAlignment(Pos.BOTTOM_RIGHT);
	  tfBranches.setPrefColumnCount(4);
	  tfBranches.setAlignment(Pos.BOTTOM_RIGHT);

	  HBox hBox = new HBox(10);
	  hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder,new Label("Enter the number of Branches: "),tfBranches);
	  hBox.setAlignment(Pos.CENTER);
    
	  BorderPane borderPane = new BorderPane();
	  borderPane.setCenter(pane);
	  borderPane.setBottom(hBox);
        

	  Scene scene = new Scene(borderPane, 200, 210);
	  primaryStage.setTitle("Swirls");
	  primaryStage.setScene(scene);
	  primaryStage.show(); 
    
	  scene.widthProperty().addListener(ov -> pane.paint());
	  scene.heightProperty().addListener(ov -> pane.paint());
}

static class SwirlPane extends Pane {
	private int depth = 0;
	private int branches = 0;
    private double sizeFactor = 0.4;

    public void setDepth(int depth) {
    	this.depth = depth;
	    paint();
    }
    public void setBranches(int branches) {
    	this.branches = branches;
	    paint();
    }

	public void paint() {
		getChildren().clear();     
	    paintSwirl(depth, getWidth() / 2, getHeight() / 2, getHeight() / 4, Math.PI / 12);
	}

	public void paintSwirl(int depth, double x1, double y1,double length, double angle) {
		for(int i=-1;i<depth;i++){
			Color c = Color.color(Math.random(), Math.random(), Math.random());
			for(int j=0;j<branches;j++){
				double x2 = x1 + Math.cos(angle) * length;
	        	double y2 = y1 - Math.sin(angle) * length;
	        	Line l = new Line(x1, y1, x2, y2);
	        	l.setStroke(c);
		        getChildren().add(l);
				paintSwirl(depth-1,x2,y2,length*sizeFactor,angle+Math.PI/3);
				angle += 2*Math.PI/branches;
			}
			
		}
	}
}
	  
	  public static void main(String[] args) {
	    launch(args);
	  }
	}
