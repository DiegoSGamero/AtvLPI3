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
        classDropdown.getItems().addAll("Réptil", "Felino", "Pássaro", "Carro", "Moto", "Caminhao", "Arroz", "Carne", "Vegetal", "Salgado");

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
            case "Carro":
                goToCarroScreen();
                break;
            case "Moto":
                goToMotoScreen();
                break;
            case "Caminhao":
                goToCaminhaoScreen();
                break;
            case "Arroz":
                goToArrozScreen();
                break;
            case "Carne":
                goToCarneScreen();
                break;
            case "Vegetal":
                goToVegetalScreen();
                break;
            case "Salgado":
                goToSalgadoScreen();
                break;
            default:
                break;
        }
    }

    private void goToBirdScreen() {
        // Código para navegar para a tela de Pássaro (Bird)
        System.out.println("Navegando para a tela de Pássaro");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/bird.fxml"));
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
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/feline.fxml"));
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

    private void goToCarroScreen() {
        // Código para navegar para a tela de carro
        System.out.println("Navegando para a tela de Carro");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/carro.fxml"));
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

    private void goToMotoScreen() {
        // Código para navegar para a tela de moto
        System.out.println("Navegando para a tela de Moto");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/moto.fxml"));
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

    private void goToCaminhaoScreen() {
        // Código para navegar para a tela de caminhao
        System.out.println("Navegando para a tela de Caminhao");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/caminhao.fxml"));
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

    private void goToArrozScreen() {
        // Código para navegar para a tela de arroz
        System.out.println("Navegando para a tela de Arroz");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/arroz.fxml"));
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

    private void goToCarneScreen() {
        // Código para navegar para a tela de carne
        System.out.println("Navegando para a tela de Carne");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/carne.fxml"));
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

    private void goToVegetalScreen() {
        // Código para navegar para a tela de vegetal
        System.out.println("Navegando para a tela de Vegetal");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/vegetal.fxml"));
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

    private void goToSalgadoScreen() {
        // Código para navegar para a tela de salgado
        System.out.println("Navegando para a tela de Salgado");
        try {
            // Carrega o arquivo FXML da tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/atvlpi3/salgado.fxml"));
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
}

