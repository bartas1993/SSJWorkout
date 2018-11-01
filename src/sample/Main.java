package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("ssjpanel.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("SSJ Workout");
        primaryStage.setResizable(false);

        if (root != null) {
            primaryStage.setScene(new Scene(root, 595, 485));
            primaryStage.show();
        }
        else
            {
                System.out.println("Something went wrong");
            }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
