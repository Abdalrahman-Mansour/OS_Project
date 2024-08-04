package Algorithims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.*;
public class Scheduling extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Algorithims");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch ( IOException ex2) {
            System.out.println(ex2);
        }
    }
    public static void main(String args[]) {
               launch(args);
    }
}





