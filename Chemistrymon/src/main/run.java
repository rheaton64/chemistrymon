package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class run extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		TextField tf = new TextField();
		tf.setPrefSize(500, 30);
		tf.setFont(Font.font("Helvetica", 35));
		Label ann = new Label("The attack was super effective!");
		ann.setWrapText(true);
		ann.setPrefSize(500, 200);
		ann.setFont(Font.font("Helvetica", 35));
		ann.setAlignment(Pos.TOP_LEFT);
		VBox leftText = new VBox(ann, tf);
		leftText.setStyle("-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +  
                "-fx-border-color: black;");
		Label question = new Label("fiwbfgiasbgkuqwbfgiorwbgiodsiefgowbfowdfobwkwngwlbglglahgkslbgslghjlgbajlgbajlbgaljbgaslgaghajldhgajlghajldgaljbgjlg");
		question.setWrapText(true);
		question.setPrefSize(1300, 400);
		question.setAlignment(Pos.TOP_LEFT);
		question.setStyle("-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +  
                "-fx-border-color: black;");
		question.setFont(Font.font("Helvetica", 45));
		HBox input = new HBox(leftText, question);
		input.setLayoutY(550);
		Scene scene = new Scene(input, 1920, 1080);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chemistry Battle Simulator");
		primaryStage.show();
	}
}
