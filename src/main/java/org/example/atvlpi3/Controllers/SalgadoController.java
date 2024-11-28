package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SalgadoController {

    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowSalgado;

    @FXML
    private Button btnUpSalgado;

    @FXML
    private TextField fieldFlavour;

    @FXML
    private TextField fieldType;

    @FXML
    private TextField fieldWeight;

    // Métdo para exibir alertas
    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void backToMenu() throws IOException {
        try {
            // Carrega o arquivo FXML do menu
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/menu-view.fxml"));
            Parent menuRoot = loader.load();

            Stage stage = (Stage) btnBackMenu.getScene().getWindow();

            // Define a nova cena no Stage atual
            stage.setScene(new Scene(menuRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a cena do menu.");
        }
    }

    @FXML
    public void initialize() {
        // Conectar o botão ao métdo de cadastro
        btnBackMenu.setOnAction(event -> {
            try {
                backToMenu();
            } catch (
                    IOException e) {
                e.printStackTrace();
                exibirAlerta("Erro", "Não foi possível voltar ao menu.");
            }
        });
    }

    @FXML
    void cadastrarSalgado(ActionEvent event) {

    }

    @FXML
    void rootShowSalgado(ActionEvent event) {

    }

}