package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

	Scene PRIMARY_SCENE;

	@Override
	public void start(Stage primaryStage) throws Exception {
//		-----------------------------------------------------------------------------
//		Purely cosmetic stuff
		primaryStage.setTitle("Memory Manager Simulator");
		primaryStage.getIcons()
				.add(new Image("https://img7.androidappsapk.co/300/a/f/7/com.smartprojects.RAMOptimization.png"));

//		-----------------------------------------------------------------------------
//		Setting up the Title & Credits
		VBox titleBox = new VBox();
		titleBox.setAlignment(Pos.CENTER);
		Text titleText = new Text("Memory Manager Simulator");
		titleText.setFont(Font.font("Impact", 32));
		Text creditText = new Text("by Dan Fayaud & Katie Porter :)");
		creditText.setFont(Font.font("Tahoma", 14));
		titleBox.setPadding(new Insets(10, 10, 10, 10));
		titleBox.setSpacing(5);
		titleBox.getChildren().addAll(titleText, creditText);

//		-----------------------------------------------------------------------------
//		Setting up the main content HBox
//		This HBox will contain the 2 VBoxes
//		which will make up the main meat of the
//		simulator
		HBox contentBox = new HBox();

//		Algorithm and Process half of
//		the main contentBox
		VBox inputBox = new VBox();
		inputBox.setSpacing(20);

//		-----------------------------------------------------------------------------
//		box1 setup
//		box1 = algorithm, total memory, & os allotment
		VBox box1 = new VBox();
		box1.setSpacing(15);

//		algorithm chooser
		HBox algorithmBox = new HBox();
		algorithmBox.setSpacing(25);
		Label algorithmLabel = new Label("Select Algorithm:");
		ComboBox<String> algorithmComboBox = new ComboBox<String>();
		algorithmComboBox.setPromptText("--Select--");
		algorithmComboBox.getItems().addAll("First Fit", "Best Fit", "Worst Fit");
		algorithmBox.setAlignment(Pos.BASELINE_CENTER);
		algorithmBox.getChildren().addAll(algorithmLabel, algorithmComboBox);

//		total memory setter
		HBox memoryBox = new HBox();
		memoryBox.setSpacing(25);
		Label totalMemLabel = new Label("Total Memory:");
		TextField totalMemoryInput = new TextField();
		totalMemoryInput.setPromptText("Total Memory");
		HBox memInput = new HBox();
		memInput.setSpacing(5);
		memInput.getChildren().addAll(totalMemoryInput, new Constant().K);
		memoryBox.getChildren().addAll(totalMemLabel, memInput);

//		os memory setter
		HBox osMemBox = new HBox();
		osMemBox.setSpacing(25);
		Label totalOSLabel = new Label("OS Memory:");
		TextField osMemoryInput = new TextField();
		osMemoryInput.setPromptText("OS Memory");
		HBox osInput = new HBox();
		osInput.setSpacing(5);
		osInput.getChildren().addAll(osMemoryInput, new Constant().K);
		osMemBox.getChildren().addAll(totalOSLabel, osInput);

		box1.getChildren().addAll(algorithmBox, memoryBox, osMemBox);
		box1.setAlignment(Pos.CENTER);

//		-----------------------------------------------------------------------------
//		box2 setup
//		box2 = pid, process size, ADD button
		VBox box2 = new VBox();
		box2.setSpacing(15);

//		PID chooser
		HBox pidBox = new HBox();
		pidBox.setSpacing(25);
		Label pidLabel = new Label("Process ID:");
		ComboBox<String> pidComboBox = new ComboBox<String>();
		pidComboBox.setPromptText("--Select--");
		pidComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8");
		pidBox.setAlignment(Pos.BASELINE_CENTER);
		pidBox.getChildren().addAll(pidLabel, pidComboBox);

//		process size setter
		HBox processSizeBox = new HBox();
		processSizeBox.setSpacing(25);
		Label pSizeLabel = new Label("Process Size:");
		TextField pSizeInput = new TextField();
		pSizeInput.setPromptText("Process Size");
		pSizeInput.setPrefWidth(100);
		HBox pInput = new HBox();
		pInput.setSpacing(5);
		pInput.getChildren().addAll(pSizeInput, new Constant().K);
		processSizeBox.getChildren().addAll(pSizeLabel, pInput);

//		add to memory button
		Button addToMem = new Button("ADD TO MEMORY!");

		box2.getChildren().addAll(pidBox, processSizeBox, addToMem);
		box2.setAlignment(Pos.CENTER);

//		-----------------------------------------------------------------------------
//		compact memory button

		Button compactMem = new Button("COMPACT MEMORY!!");

//		-----------------------------------------------------------------------------

//		finalizing inputBox
		inputBox.getChildren().addAll(box1, new Constant().LINE, box2, new Constant().LINE, compactMem);
		inputBox.setAlignment(Pos.CENTER);
//		-----------------------------------------------------------------------------
//		Memory Visualization half of the
//		main contentBox
		HBox memoryMainBox = new HBox();
		Rectangle memoryPlaceHolder = new Rectangle();
		memoryPlaceHolder.setHeight(400);
		memoryPlaceHolder.setWidth(200);
		Text memTitle = new Text("MEMORY");
		memTitle.setFont(Font.font("Impact", 40));
		memTitle.setRotate(90);

		memoryMainBox.getChildren().addAll(memoryPlaceHolder, memTitle);
		memoryMainBox.setAlignment(Pos.CENTER);

//		-----------------------------------------------------------------------------
//		Final (lol) Finalization
		contentBox.setSpacing(20);
		Separator separator = new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		contentBox.getChildren().addAll(inputBox, separator, memoryMainBox);
		contentBox.setAlignment(Pos.CENTER);
		VBox mainView = new VBox();
		mainView.getChildren().addAll(titleBox, new Constant().LINE, contentBox);

		PRIMARY_SCENE = new Scene(mainView, 800, 500);
		primaryStage.setScene(PRIMARY_SCENE);
		primaryStage.show();
	}

	public Scene getScene() {
		return PRIMARY_SCENE;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
