package step01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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



    }

    public static void main(String[] args) {
        launch(args);
    }
}