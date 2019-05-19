package main;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class run extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	Label question;
	Label ann;
	TextField tf;
	Text p1Name;
	Text p2Name;
	Rectangle[] p1HealthArray = new Rectangle[20];
	Rectangle[] p2HealthArray = new Rectangle[20];
	
	@Override
	public void start(Stage primaryStage) {
		
		tf = new TextField();
		tf.setPrefSize(500, 30);
		tf.setFont(Font.font("Helvetica", 35));
		
		ann = new Label("The attack was super effective!");
		ann.setWrapText(true);
		ann.setPrefSize(500, 200);
		ann.setFont(Font.font("Helvetica", 35));
		ann.setAlignment(Pos.TOP_LEFT);
		
		VBox leftText = new VBox(ann, tf);
		leftText.setStyle("-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +  
                "-fx-border-color: black;");
		
		question = new Label("fiwbfgiasbgkuqwbfgiorwbgiodsiefgowbfowdfobwkwngwlbglglahgkslbgslghjlgbajlgbajlbgaljbgaslgaghajldhgajlghajldgaljbgjlg");
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
		
		HBox p1Health = new HBox();
		p1Health.setStyle("-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-color: black;");
		p1Health.setPrefSize(400, 20);
		for(int i = 0; i < 18; i++) {
			p1HealthArray[i] = new Rectangle(20, 20);
			p1HealthArray[i].setFill(Color.RED);
			p1Health.getChildren().add(p1HealthArray[i]);
		}
		
		Rectangle p1Rect = new Rectangle(400, 400);
		p1Rect.setFill(Color.ORANGE);
		p1Name = new Text("P1");
		p1Name.setFont(Font.font("Helvetica", 200));
		StackPane p1 = new StackPane(p1Rect, p1Name);
		
		VBox player1 = new VBox(p1Health, p1);
		player1.setSpacing(20);
		
		HBox p2Health = new HBox();
		p2Health.setStyle("-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-color: black;");
		p2Health.setPrefSize(400, 20);
		for(int i = 0; i < 20; i++) {
			p2HealthArray[i] = new Rectangle(20, 20);
			p2HealthArray[i].setFill(Color.RED);
			p2Health.getChildren().add(p2HealthArray[i]);
		}
		
		
		Rectangle p2Rect = new Rectangle(400, 400);
		p2Rect.setFill(Color.HOTPINK);
		p2Name = new Text("P2");
		p2Name.setFont(Font.font("Helvetica", 200));
		StackPane p2 = new StackPane(p2Rect, p2Name);
		
		VBox player2 = new VBox(p2Health, p2);
		player2.setSpacing(20);
		
		HBox players= new HBox(player1, player2);
		players.setSpacing(300);
		players.setPadding(new Insets(50, 0, 50, 170));
		
		VBox gui = new VBox(players, input);
		gui.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(gui, 1920, 1080);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chemistry Battle Simulator");
		primaryStage.show();
	}
}
