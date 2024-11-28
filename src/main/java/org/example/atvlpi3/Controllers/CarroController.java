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
import org.example.atvlpi3.MainApplication;
import org.example.atvlpi3.dao.BirdDao;
import org.example.atvlpi3.dao.CarroDao;
import org.example.atvlpi3.models.Bird;
import org.example.atvlpi3.models.Carro;

import java.io.IOException;

public class CarroController {

    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowCarro;

    @FXML
    private Button btnUpCarro;

    @FXML
    private TextField fieldColor;

    @FXML
    private TextField fieldMark;

    @FXML
    private TextField fieldModel;

    @FXML
    private Carro carroCadastrado;

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

    // Métdo para exibir alertas
    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    void cadastrarCarro(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String marcaCarro = fieldMark.getText();
            String modeloCarro = fieldModel.getText();
            String corCarro = fieldColor.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (marcaCarro.isEmpty() || modeloCarro.isEmpty() || corCarro.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Criação da instância de carro
            carroCadastrado = new Carro(marcaCarro, modeloCarro, corCarro);

            //Persistencia no banco
            CarroDao carroDao = new CarroDao();
            carroDao.salvarCarro(carroCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Carro cadastrado com sucesso:\n" + carroCadastrado.toString());

        } catch (
                NumberFormatException e) {
        }
    }

    @FXML
    void rootShowCarro(ActionEvent event) {
        if (carroCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre um carro antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/carroShow.fxml"));
            Parent root = loader.load();

            CarroShowController controller = loader.getController();
            controller.setCarroDetails(carroCadastrado);

            Stage stage = new Stage();
            stage.setTitle("Detalhes do Felino");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (
                IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Não foi possível carregar a tela de detalhes.");
        }
    }

}
