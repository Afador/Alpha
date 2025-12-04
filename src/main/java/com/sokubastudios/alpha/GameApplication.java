package src.main.java.com.sokubastudios.alpha;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;

public class GameApplication extends Application {
    TextArea output;
    TextField input;

    public static void main(String[] args) {
        GameApplication.launch(args);
    }

    @Override
    public void start(Stage stage) {
        output = new TextArea();
        input = new TextField();

        output.setPrefHeight(600 - 80);
        output.setFont(Font.font(24));
        output.setEditable(false);
        output.setFocusTraversable(false);
        output.setWrapText(true);

        input.setFont(Font.font(24));
        input.setOnAction(_ -> {
            try {
                Main.inputQueue.put(input.getText());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            input.clear();
        });

        VBox layout = new VBox(10, output, input);
        Scene scene = new Scene(layout, 600, 600);

        stage.setScene(scene);
        stage.show();

        Thread textThread = new Thread(() -> {
            try {
                while (true) {
                    output.appendText(Main.outputQueue.take());
                }
            } catch (Exception e) {
                System.out.println("ERROR: GA-54");
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        });

        textThread.start();
    }
}
