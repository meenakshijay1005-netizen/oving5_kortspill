package com.example.kortspill;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameApp extends Application {

    private final DeckOfCards deck = new DeckOfCards();
    private HandOfCards currentHand;

    private final Label handLabel = new Label("No hand dealt yet");

    private final TextField sumField = new TextField();
    private final TextField heartsField = new TextField();
    private final TextField queenField = new TextField();
    private final TextField flushField = new TextField();

    @Override
    public void start(Stage stage) {
        Button dealButton = new Button("Deal hand");
        Button checkButton = new Button("Check hand");

        sumField.setEditable(false);
        heartsField.setEditable(false);
        queenField.setEditable(false);
        flushField.setEditable(false);

        dealButton.setOnAction(e -> dealHand());
        checkButton.setOnAction(e -> checkHand());

        VBox centerBox = new VBox(10, new Label("Current hand:"), handLabel);
        centerBox.setPadding(new Insets(20));

        VBox rightBox = new VBox(15, dealButton, checkButton);
        rightBox.setPadding(new Insets(20));

        HBox row1 = new HBox(10, new Label("Sum of faces:"), sumField);
        HBox row2 = new HBox(10, new Label("Cards of hearts:"), heartsField);
        HBox row3 = new HBox(10, new Label("Queen of spades:"), queenField);
        HBox row4 = new HBox(10, new Label("Flush:"), flushField);

        VBox bottomBox = new VBox(10, row1, row2, row3, row4);
        bottomBox.setPadding(new Insets(20));

        BorderPane root = new BorderPane();
        root.setCenter(centerBox);
        root.setRight(rightBox);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 700, 400);

        stage.setTitle("Kortspill");
        stage.setScene(scene);
        stage.show();
    }

    private void dealHand() {
        currentHand = deck.dealHand(5);
        handLabel.setText(currentHand.asString());

        sumField.clear();
        heartsField.clear();
        queenField.clear();
        flushField.clear();
    }

    private void checkHand() {
        if (currentHand == null) {
            handLabel.setText("You have to deal a hand first");
            return;
        }

        sumField.setText(String.valueOf(currentHand.sumOfFaces()));
        heartsField.setText(currentHand.heartsAsString());
        queenField.setText(currentHand.containsQueenOfSpades() ? "Yes" : "No");
        flushField.setText(currentHand.isFlush() ? "Yes" : "No");
    }

    public static void main(String[] args) {
        launch(args);
    }
}