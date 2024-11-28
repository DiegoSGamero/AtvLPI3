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
import org.example.atvlpi3.dao.CaminhaoDao;
import org.example.atvlpi3.dao.CarroDao;
import org.example.atvlpi3.models.Caminhao;
import org.example.atvlpi3.models.Carro;

import java.io.IOException;

public class CaminhaoController {
    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowCaminhao;

    @FXML
    private Button btnUpCaminhao;

    @FXML
    private TextField fieldColor;

    @FXML
    private TextField fieldMark;

    @FXML
    private TextField fieldModel;

    @FXML
    private Caminhao caminhaoCadastrado;

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
    void cadastrarCaminhao(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String marcaCaminhao = fieldMark.getText();
            String modeloCaminhao = fieldModel.getText();
            String corCaminhao = fieldColor.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (marcaCaminhao.isEmpty() || modeloCaminhao.isEmpty() || corCaminhao.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Criação da instância de carro
            caminhaoCadastrado = new Caminhao(marcaCaminhao, modeloCaminhao, corCaminhao);

            //Persistencia no banco
            CaminhaoDao caminhaoDao = new CaminhaoDao();
            caminhaoDao.salvarCaminhao(caminhaoCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Caminhao cadastrado com sucesso:\n" + caminhaoCadastrado.toString());

        } catch (
                NumberFormatException e) {
        }
    }

    @FXML
    void rootShowCaminhao(ActionEvent event) {
        if (caminhaoCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre um caminhao antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/caminhaoShow.fxml"));
            Parent root = loader.load();

            CaminhaoShowController controller = loader.getController();
            controller.setCaminhaoDetails(caminhaoCadastrado);

            Stage stage = new Stage();
            stage.setTitle("Detalhes do Caminhão");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (
                IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Não foi possível carregar a tela de detalhes.");
        }
    }

}
