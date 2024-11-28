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
import org.example.atvlpi3.dao.CaminhaoDao;
import org.example.atvlpi3.dao.MotoDao;
import org.example.atvlpi3.models.Moto;

import java.io.IOException;

public class MotoController {
    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowMoto;

    @FXML
    private Button btnUpMoto;

    @FXML
    private TextField fieldColor;

    @FXML
    private TextField fieldMark;

    @FXML
    private TextField fieldModel;

    @FXML
    private Moto motoCadastrado;

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
    void cadastrarMoto(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String marcaMoto = fieldMark.getText();
            String modeloMoto = fieldModel.getText();
            String corMoto = fieldColor.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (marcaMoto.isEmpty() || modeloMoto.isEmpty() || corMoto.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Criação da instância de carro
            motoCadastrado = new Moto(marcaMoto, modeloMoto, corMoto);

            //Persistencia no banco
            MotoDao motoDao = new MotoDao();
            motoDao.salvarMoto(motoCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Carro cadastrado com sucesso:\n" + motoCadastrado.toString());

        } catch (
                NumberFormatException e) {
        }
    }

    @FXML
    void rootShowMoto(ActionEvent event) {

    }
}
