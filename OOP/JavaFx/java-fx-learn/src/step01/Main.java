package step01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        /**

         // ======= Step 01: Initialize ================

        // Create a label to display text
        Label label = new Label("Hello World");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 400);

         primaryStage.setTitle("My first JavaFX application");
         primaryStage.setScene(scene);
         primaryStage.show();

         */

        // ======= Step 02: JavaFX Basics ================

        // Create a label and a button
        Label label = new Label("Welcome to JavaFX!");
        Button button = new Button("Click Me");

        // Event handling for button click
        button.setOnAction(event -> label.setText("Button Clicked!"));

        // Create a VBox layout and add components
        VBox root = new VBox(10, label, button); // Spacing of 10 pixels
        Scene scene = new Scene(root, 300, 200); // Window size

        // Set up the stage
        primaryStage.setTitle("JavaFX Basics");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}