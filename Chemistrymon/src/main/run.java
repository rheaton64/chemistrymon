package main;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
	
	String[] questions = {"test 1", "test 2", "test 3", "test 4", "test 5", "test 6"};
	String[] answers = {"a", "a", "a", "a", "a", "a", "a"};
	String[] difficulty = {"easy", "hard", "easy", "hard", "easy", "hard"};
	ArrayList<Integer> answered;
	int qInUse = 0;
	int p1HealthValue = 20;
	int p2HealthValue = 20;
	boolean p1Turn = true;
	Scanner scan = new Scanner(System.in);
	
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
		
		tf.setOnAction(value -> {
			if(tf.getText().equals("!reset")) {
				resetGame();
			} else {
			answerSubmitted(tf.getText());
			}
		});
		
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
		resetGame();
	}

	public void startQuestions() {
		answered = new ArrayList<Integer>();
		newQuestion();
	}
	
	public int newRandom() {
		Random rand = new Random();
		int gen = rand.nextInt(questions.length);
		return gen;
	}
	
	public void newQuestion() {
		
		int gen = 0;
		
		while(true) {
			gen = newRandom();
			if(!hasBeenUsed(gen)) {
				break;
			}
			
			if(answered.size() == questions.length) {
				answered.clear();
			}
			
		}
		
		question.setText(questions[gen]);
		qInUse = gen;
	}
	
	public boolean hasBeenUsed(int gen) {
		if(answered.contains(gen)) {
			return true;
		}
		return false;
	}
	
	public void answerSubmitted(String a) {
		
		answered.add(qInUse);
		
		boolean isSuperEffective;
		
		if(a.equalsIgnoreCase(answers[qInUse])) {
			if(p1Turn) {
				isSuperEffective = p2Damage(difficulty[qInUse]);
			} else {
				isSuperEffective = p1Damage(difficulty[qInUse]);
			}
			
			if(isSuperEffective) {
				ann.setText("Wow! Super effective!");
			} else {
				ann.setText("Good attack!");
			}
			
		} else {
			ann.setText("Oh no! The attack missed!");
		}
		

		
	}
	
	public boolean p1Damage(String diff) {
		if(diff.equals("easy")) {
			for(int i = 0; i < 5; i++) {
				p1HealthArray[p1HealthValue - 1].setFill(Color.WHITE);
				p1HealthValue--;
				if(p1HealthValue == 0) {
					break;
				}
			}
			return false;
		} else {
			for(int i = 0; i < 10; i++) {
				p1HealthArray[p1HealthValue - 1].setFill(Color.WHITE);
				p1HealthValue--;
				if(p1HealthValue == 0) {
					break;
				}
			}
			return true;
		}
	}
	
	public boolean p2Damage(String diff) {
		if(diff.equals("easy")) {
			for(int i = 0; i < 5; i++) {
				p2HealthArray[p2HealthValue - 1].setFill(Color.WHITE);
				p2HealthValue--;
				if(p2HealthValue == 0) {
					break;
				}
			}
			return false;
		} else {
			for(int i = 0; i < 10; i++) {
				p2HealthArray[p2HealthValue - 1].setFill(Color.WHITE);
				p2HealthValue--;
				if(p2HealthValue == 0) {
					break;
				}
			}
			return true;
		}
	}
	
	public void finishTurn() throws InterruptedException {
		if(p1Turn) {
			if(p2HealthValue == 0) {
				ann.setText("Congrats! " + p1Name.getText() + " wins!");
			} else {
				Thread.sleep(1000);
				ann.setText("" + p2Name.getText() + ", it's your turn");
				p1Turn = false;
				newQuestion();
			}
		} else {
			if(p1HealthValue == 0) {
				ann.setText("Congrats! " + p2Name.getText() + " wins!");
			} else {
				Thread.sleep(1000);
				ann.setText("" + p1Name.getText() + ", it's your turn");
				p1Turn = true;
				newQuestion();
			}
		}
	}
	
	public void resetGame() {
		p1HealthValue = 20;
		p2HealthValue = 20;
		///for(int i = 0; i < 20; i++) {
		//	p1HealthArray[i].setFill(Color.RED);
		//	p2HealthArray[i].setFill(Color.RED);
		//}
		p1Name.setText(scan.next());
		p2Name.setText(scan.next());
		p1Turn = true;
		startQuestions();
		
	}
}
