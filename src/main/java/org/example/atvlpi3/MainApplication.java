package org.example.atvlpi3;

import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Carregar o arquivo FXML corretamente
        scene = new Scene(loadFXML("reptile.fxml"), 340, 540);
        stage.setTitle("LPI Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //Método para carregar o arquivo FXML e garantir que retorna um Parent
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/menu-view.fxml"));
        return fxmlLoader.load();  // raiz é do tipo Parent
    }

    public static void main(String[] args) {
        launch(args);
    }
}