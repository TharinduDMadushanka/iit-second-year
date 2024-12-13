package step01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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

        /**

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

         */

        /**

        // ======= Step 03: VBox (Vertical Box) ================

        VBox vbox = new VBox(10); // Vertical spacing of 10 pixels

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        vbox.getChildren().addAll(button1, button2, button3); // Add buttons to VBox
        vbox.setAlignment(javafx.geometry.Pos.CENTER); // Align to center

        Scene scene = new Scene(vbox, 300, 200); // Create scene
        primaryStage.setTitle("VBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**

        // ======= Step 04: HBox (Horizontal Box) ================

        HBox hbox = new HBox(15); // Horizontal spacing of 15 pixels

        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");

        hbox.getChildren().addAll(btn1, btn2, btn3);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(hbox, 300, 100);
        primaryStage.setTitle("HBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**

        // ======= Step 05: GridPane (Grid-based Layout) ================

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal spacing
        gridPane.setVgap(10); // Vertical spacing

        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");

        // Add nodes to specific grid positions
        gridPane.add(btn1, 0, 0); // Column 0, Row 0
        gridPane.add(btn2, 1, 0); // Column 1, Row 0
        gridPane.add(btn3, 0, 1); // Column 0, Row 1
        gridPane.add(btn4, 1, 1); // Column 1, Row 1

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("GridPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**

        // ======= Step 05: GridPane (Grid-based Layout) ================

        BorderPane borderPane = new BorderPane();

        borderPane.setTop(new Button("Top"));
        borderPane.setBottom(new Button("Bottom"));
        borderPane.setLeft(new Button("Left"));
        borderPane.setRight(new Button("Right"));
        borderPane.setCenter(new Button("Center"));

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**
        // ======= Step 06: StackPane (Overlapping Nodes) ================

        StackPane stackPane = new StackPane();

        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");

        stackPane.getChildren().addAll(btn1, btn2);

        Scene scene = new Scene(stackPane, 300, 200);
        primaryStage.setTitle("StackPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**

        // ======= Step 07: Button Click Event Using EventHandler ================

        Button button = new Button("Click Me"); // Create a button

        // Attach an EventHandler to handle button clicks
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Clicked!"); // Code triggered on click
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Event Handling Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**

        // ======= Step 08: Button Click Event Using Lambda Expression ================

        Button button = new Button("Click Me");

        // Use lambda expression for event handling
        button.setOnAction(event -> {
            System.out.println("Button Clicked with Lambda!");
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Event Handling with Lambda");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        /**

        // ======= Step 09: Mouse Event Handling ================

        Button button = new Button("Hover or Click Me");

        // Mouse click event
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Button was clicked!");
        });

        // Mouse entered (hover) event
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            System.out.println("Mouse entered the button area.");
        });

        // Mouse exited event
        button.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            System.out.println("Mouse exited the button area.");
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Mouse Event Handling Example");
        primaryStage.setScene(scene);
        primaryStage.show();

         */

        // ======= Step 10: Handling Text Input ================

        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Label outputLabel = new Label();

        // Event handler for text input
        textField.setOnKeyReleased(event -> {
            String text = textField.getText();
            outputLabel.setText("You typed: " + text);
        });

        VBox vbox = new VBox(10, label, textField, outputLabel);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 300, 150);

        primaryStage.setTitle("Text Input Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}