package fi.tuni.prog3.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;

/**
 * JavaFX App
 */
public class Calculator extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Label fieldRes = new Label("");
        
        // Set the ID of the Label to "fieldRes"
        fieldRes.setId("fieldRes");
        
        // Set the background color of the Label to white
        fieldRes.setStyle("-fx-background-color: white;");
        
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}