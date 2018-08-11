//Alex Schwiegeraht
//Game of Life


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.FileChooser.ExtensionFilter;

public class GameOfLife extends Application {
	
	private int DIM = 32;
	private Cell[][] cell =  new Cell[DIM][DIM];	
	private Timeline animation;
	private Button btnPlay = new Button("Play");
	private Button btnStep = new Button("Step");
	private boolean life = true;
	private RadioButton rbtnLife = new RadioButton("Life");
    private RadioButton rbtnHighLife = new RadioButton("High Life");
	
	public void start(Stage primaryStage) {
		
		BorderPane borderPane = new BorderPane();
		
		MenuBar menuBar = new MenuBar();    
		Menu menuFile = new Menu("File");
		menuBar.getMenus().addAll(menuFile);
		MenuItem menuItemClear = new MenuItem("Clear");
		MenuItem menuItemSaveAs = new MenuItem("Save As...");
		MenuItem menuItemLoad = new MenuItem("Load");
		MenuItem menuItemExit = new MenuItem("Exit");
		menuFile.getItems().addAll(menuItemClear, new SeparatorMenuItem(), menuItemSaveAs, menuItemLoad, new SeparatorMenuItem(),menuItemExit);
		
		menuItemClear.setOnAction(e -> clear());
		menuItemSaveAs.setOnAction(e -> saveAs(primaryStage));
		menuItemLoad.setOnAction(e -> load(primaryStage));
	    menuItemExit.setOnAction(e -> System.exit(0));
		
	    GridPane pane = new GridPane(); 
	    for (int i = 0; i <DIM; i++){
	    	for (int j = 0; j < DIM; j++){
	    		pane.add(cell[i][j] = new Cell(), j, i);
	    	}
	    }
	    	
	    animation = new Timeline(new KeyFrame(Duration.millis(200),e -> step()));
		animation.setCycleCount(Timeline.INDEFINITE);	

	    btnStep.setOnAction(e -> step());
	    btnPlay.setOnAction(e -> play());
	    Label lbSlider = new Label("Rate:");
	    Slider slSpeed = new Slider();
	    slSpeed.setMax(1);
	    animation.rateProperty().bind(slSpeed.valueProperty());
	    Button btnClear = new Button("Clear");
	    btnClear.setOnAction(e -> clear());
	    rbtnLife.setSelected(life);
	    rbtnLife.setOnAction(e -> life=true);
	    rbtnHighLife.setOnAction(e -> life=false);
	    
	    ToggleGroup group = new ToggleGroup();
	    rbtnLife.setToggleGroup(group);
	    rbtnHighLife.setToggleGroup(group);
	    
	    btnStep.setPadding(new Insets(5,5,5,5));
	    btnPlay.setPadding(new Insets(5,5,5,5));
	    rbtnLife.setPadding(new Insets(5,5,5,5));
	    slSpeed.setPadding(new Insets(5,5,5,5));
	    lbSlider.setPadding(new Insets(5,5,5,5));
	    rbtnHighLife.setPadding(new Insets(5,5,5,5));
	    btnClear.setPadding(new Insets(5,5,5,5));
	    
	    HBox hBox = new HBox(btnStep,btnPlay,lbSlider,slSpeed,btnClear,rbtnLife,rbtnHighLife);
	    hBox.setAlignment(Pos.CENTER);
	    hBox.setPadding(new Insets(10,10,10,10));
	    
	    borderPane.setBottom(hBox);
	    borderPane.setCenter(pane);
	    borderPane.setTop(menuBar);
	    Scene scene = new Scene(borderPane, 475, 550);
	    primaryStage.setTitle("Game Of Life");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public class Cell extends Pane {
		
	    private boolean isAlive = false;

	    public Cell() {
	    	setStyle("-fx-border-color:white;-fx-background-color:black; -fx-border-width:.25px;");
	    	this.setPrefSize(15, 15);
	    	this.setOnMouseClicked(e -> handleMouseClick());
	    }

	    public boolean getIsAlive() {
	    	return isAlive;
	    }
	    
	    public void setIsAlive(boolean b){
	    	if (b == false) {
	    		setStyle("-fx-border-color:white;-fx-background-color:black; -fx-border-width:.25px;");
	    	}
	    	else{
	    		setStyle("-fx-border-color:white;-fx-background-color:green; -fx-border-width:.25px;");
	    	}
	    	isAlive = b;
	    }
	   
	    private void handleMouseClick() {
	    	if (isAlive == false) {
	    		setIsAlive(true);
	    	}
	    	else if(isAlive == true){
	    		setIsAlive(false);
	    	}
	    }
	}
	
	public void clear() {
		for (int i = 0; i < DIM; i++){
			for (int j = 0; j < DIM; j++) {
				cell[i][j].setIsAlive(false);
				cell[i][j].getChildren().clear();
			}
		}
	}
	
	public void saveAs(Stage primaryStage){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("."));
		fileChooser.setTitle("Enter file name");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Game of Life files", "*.lif"));
		File selectedFile = fileChooser.showSaveDialog(primaryStage);
		if (selectedFile != null) {
			try (
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(selectedFile));) {
			  boolean[][] cellStates = new boolean[DIM][DIM];
			  for (int i = 0; i < DIM; i++){
				  for (int j = 0; j < DIM; j++){
					  cellStates[i][j] = cell[i][j].getIsAlive();
				  }
			  }
			  output.writeBoolean(life);
			  output.writeObject(cellStates);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void load(Stage primaryStage){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("."));
		fileChooser.setTitle("Enter file name");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Game of Life files", "*.lif"));
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		if (selectedFile != null)
		try {
			try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(selectedFile)); ) {
			    life = input.readBoolean();
		    boolean[][] cellStates = (boolean[][])(input.readObject());
		    for (int i = 0; i < DIM; i++){
		    	for (int j = 0; j < DIM; j++){
			    	  cell[i][j].setIsAlive(cellStates[i][j]);
			      }
		    }

			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		if(life){
			rbtnLife.setSelected(true);
		}
		else{
			rbtnHighLife.setSelected(true);
		}
	}
	
	public int checkSoroundings(int row,int col){
		int liveCount = 0;
		for (int i = -1; i <= 1; i++){
			for (int j = -1; j <= 1; j++){
				if (cell[(row + i + DIM) % DIM][(col + j + DIM) % DIM].isAlive){
					liveCount++;
				} 
			} 
		}
		if(cell[row][col].isAlive){
			liveCount--;
		}
		return liveCount;
	}
	
	public void step(){
		boolean[][] nextCell =  new boolean[DIM][DIM];
		if(life){
			for(int row=0;row<DIM;row++){
				for(int col=0;col<DIM;col++){
					if(checkSoroundings(row,col)==3){
						nextCell[row][col]=true;
					}
					else if(checkSoroundings(row,col)==2){
						if(cell[row][col].getIsAlive()){
							nextCell[row][col]=true;
						}
						else{
							nextCell[row][col]=false;
						}
					}
					else{
						nextCell[row][col]=false;
					}
				}
			}
		}
		else{
			for(int row=0;row<DIM;row++){
				for(int col=0;col<DIM;col++){
					if(checkSoroundings(row,col)==3 || checkSoroundings(row,col)==6){
						nextCell[row][col]=true;
					}
					else if(checkSoroundings(row,col)==2){
						if(cell[row][col].getIsAlive()){
							nextCell[row][col]=true;
						}
						else{
							nextCell[row][col]=false;
						}
					}
					else{
						nextCell[row][col]=false;
					}
				}
			}
		}
		
		for(int i=0;i<DIM;i++){
			for(int j=0;j<DIM;j++){
				cell[i][j].setIsAlive(nextCell[i][j]);
			}
		}
		
	}
	
	public void play(){
		if(btnPlay.getText().equals("Play")){
			animation.play();
			btnPlay.setText("Stop");
			btnStep.setDisable(true);
		}
		else{
			animation.pause();
			btnPlay.setText("Play");
			btnStep.setDisable(false);
		}
	    
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
