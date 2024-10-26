package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private AnchorPane menu_container;

    @FXML
    private ComboBox<String> classDropdown;

    @FXML
    private void initialize() {
        // Adiciona opções ao dropdown
        classDropdown.getItems().addAll("Réptil", "Felino", "Pássaro");

        // Define uma ação quando o usuário selecionar uma classe
        classDropdown.setOnAction(this::handleDropdownSelection);
    }

    // Método para tratar a seleção de classes
    private void handleDropdownSelection(ActionEvent event) {
        String selectedClass = classDropdown.getValue();
        switch (selectedClass) {
            case "Réptil":
                goToReptileScreen();
                break;
            case "Felino":
                goToFelineScreen();
                break;
            case "Pássaro":
                goToBirdScreen();
                break;
            default:
                break;
        }
    }

    private void goToBirdScreen() {
        // Código para navegar para a tela de Pássaro (Bird)
        System.out.println("Navegando para a tela de Pássaro");
    }

    private void goToReptileScreen() {
        // Código para navegar para a tela de Réptil (Reptile)
        System.out.println("Navegando para a tela de Réptil");
        try {
            // Carrega o arquivo FXML da tela de Réptil
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/reptile.fxml"));
            Parent root = loader.load();

            // Obtém a cena atual e troca para a nova cena
            Stage stage = (Stage) classDropdown.getScene().getWindow(); // Obtém a janela atual
            Scene scene = new Scene(root); // Cria uma nova cena com o layout carregado
            stage.setScene(scene); // Define a nova cena na janela
            stage.show(); // Exibe a nova tela
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso o arquivo FXML não seja encontrado
        }
    }

    private void goToFelineScreen() {
        // Código para navegar para a tela de Felino (Feline)
        System.out.println("Navegando para a tela de Felino");
    }
}

