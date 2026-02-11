package com.example.sistemavendas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        var url = getClass().getResource("fxml/estrutura.fxml");
        System.out.println("CAMINHO ENCONTRADO: " + url);

        if (url == null) {
            System.out.println("ARQUIVO NÃO ENCONTRADO!");
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[] args)  {
        launch();
    }
}
