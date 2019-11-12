package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

	Scene PRIMARY_SCENE;
	static final Separator LINE = new Separator();

	@Override
	public void start(Stage primaryStage) throws Exception {
//		Purely cosmetic stuff
		primaryStage.setTitle("Memory Manager Simulator");
		primaryStage.getIcons()
				.add(new Image("https://img7.androidappsapk.co/300/a/f/7/com.smartprojects.RAMOptimization.png"));

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

//		Setting up the main content HBox
//		This HBox will contain the 2 VBoxes
//		which will make up the main meat of the
//		simulator
		HBox contentBox = new HBox();

//		Algorithm and Process half of
//		the main contentBox
		VBox inputBox = new VBox();

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

		inputBox.getChildren().addAll(algorithmBox, LINE);
		inputBox.setAlignment(Pos.CENTER);

//		Memory Visualization half of the
//		main contentBox
		VBox memoryBox = new VBox();
		Rectangle memoryPlaceHolder = new Rectangle();
		memoryPlaceHolder.setHeight(400);
		memoryPlaceHolder.setWidth(200);

		memoryBox.getChildren().addAll(LINE, memoryPlaceHolder);
		memoryBox.setAlignment(Pos.CENTER);

//		Finalization
		contentBox.setSpacing(100);
		Separator separator = new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		contentBox.getChildren().addAll(inputBox, separator, memoryBox);
		contentBox.setAlignment(Pos.CENTER);
		VBox mainView = new VBox();
		mainView.getChildren().addAll(titleBox, LINE, contentBox);

		PRIMARY_SCENE = new Scene(mainView, 800, 600);
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
