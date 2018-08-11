//Alex Schwiegeraht
//Description: Displays an interactive binary search tree 

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BSTAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		BST<Integer> tree = new BST<>(); // Create a tree

		BorderPane pane = new BorderPane();
		BTView view = new BTView(tree); // Create a View
		pane.setCenter(view);

		TextField tfKey = new TextField();
		tfKey.setPrefColumnCount(3);
		tfKey.setAlignment(Pos.BASELINE_RIGHT);
		Button btInsert = new Button("Insert");
		Button btDelete = new Button("Delete");
		Button btSearch = new Button("Search");
		Button btInorder = new Button("Inorder");
		Button btPreorder = new Button("Preorder");
		Button btPostorder = new Button("Postorder");
		Button btBreadthFirst = new Button("Breadth-first");
		Button btHeight = new Button("Height");
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete, btSearch, btInorder, btPreorder, btPostorder, btBreadthFirst, btHeight);
		hBox.setAlignment(Pos.CENTER);
		pane.setBottom(hBox);

		btInsert.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			if (tree.search(key)) { // key is in the tree already
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			} 
			else {
				tree.insert(key); // Insert a new key
				view.displayTree();
				view.setStatus(key + " is inserted in the tree");
			}
		});

		btDelete.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			if (!tree.search(key)) { // key is not in the tree
				view.displayTree();
				view.setStatus(key + " is not in the tree");
			} 
			else {
				ArrayList<BST.TreeNode<Integer>> path = tree.path(key);
				if(view.getShadedNodes().contains(path.get(path.size() - 1))){
					view.clearShadedNodes();
				}	
				tree.delete(key); // Delete a key
				view.displayTree();
				view.setStatus(key + " is deleted from the tree");
			}
		});

		btSearch.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			view.setShadedNodes(tree.path(key));
			if (!tree.search(key)) { // key is not in the tree
				view.displayTree();
				view.setStatus(key + " is not in the tree");
			} 
			else {
				tree.search(key);
				view.displayTree();
				view.setStatus("Found " + key + " in the tree");
			}
		});

		btInorder.setOnAction(e -> {
			view.displayTree();
			view.setStatus("Inorder Traversal: " + tree.inorderList().toString());
		});

		btPreorder.setOnAction(e -> {
			view.displayTree();
			view.setStatus("Preorder Traversal: " + tree.preorderList().toString());
		});

		btPostorder.setOnAction(e -> {
			view.displayTree();
			view.setStatus("Postorder Traversal: " + tree.postorderList().toString());
		});

		btBreadthFirst.setOnAction(e -> {
			view.displayTree();
			view.setStatus("Breadth First Order Traversal: " + tree.breadthFirstOrderList().toString());
		});

		btHeight.setOnAction(e -> {
			view.displayTree();
			view.setStatus("Height is " + tree.height());
		});

		// Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 650, 250);
		primaryStage.setTitle("BSTAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}