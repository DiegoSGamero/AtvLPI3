package org.example.atvlpi3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.atvlpi3.MainApplication;

import java.io.IOException;

public class MenuController {

    @FXML
    private AnchorPane menu_container;

    @FXML
    private ComboBox<String> classDropdown;

    @FXML
    private void initialize() {
        // Adiciona opções ao dropdown
        classDropdown.getItems().addAll("Reptile", "Feline", "Bird");

        // Define uma ação quando o usuário selecionar uma classe
        classDropdown.setOnAction(this::handleDropdownSelection);
    }

    // Método para tratar a seleção de classes
    private void handleDropdownSelection(ActionEvent event) {
        String selectedClass = classDropdown.getValue();
        switch (selectedClass) {
            case "Reptile":
                navigateTo("reptile-view");
                break;
            case "Feline":
                navigateTo("feline-view");
                break;
            case "Bird":
                navigateTo("bird-view");
                break;
            default:
                break;
        }
    }

    // Método para navegar para uma nova tela (FXML)
    private void navigateTo(String fxml) {
        try {
            MainApplication.setRoot(fxml);  // Assume que MainApplication possui o método setRoot
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

