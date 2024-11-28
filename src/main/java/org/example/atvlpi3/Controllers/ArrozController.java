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
import org.example.atvlpi3.dao.ArrozDao;
import org.example.atvlpi3.dao.BirdDao;
import org.example.atvlpi3.models.Arroz;
import org.example.atvlpi3.models.Bird;

import java.io.IOException;

public class ArrozController {
    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowArroz;

    @FXML
    private Button btnUpArroz;

    @FXML
    private TextField fieldRecipe;

    @FXML
    private TextField fieldType;

    @FXML
    private TextField fieldWeight;

    @FXML
    private Arroz arrozCadastrado;

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

    // Inicialização do controller
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
    void cadastrarArroz(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String tipoArroz = fieldType.getText();
            String pesoStrArroz = fieldWeight.getText();
            String pratoArroz = fieldRecipe.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (tipoArroz.isEmpty() || pesoStrArroz.isEmpty() || pratoArroz.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStrArroz);

            // Criação da instância de Reptile
            arrozCadastrado = new Bird(tipoArroz, peso, pratoArroz);

            //Persistencia no banco
            ArrozDao arrozDao = new ArrozDao();
            arrozDao.saveArroz(arrozCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Ave cadastrada com sucesso:\n" + birdCadastrado.toString());

            // Limpa os campos após o cadastro
            //limparCampos();

        } catch (
                NumberFormatException e) {
            // Exibe alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }

    @FXML
    void rootShowArroz(ActionEvent event) {

    }
}
