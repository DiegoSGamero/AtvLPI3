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
import org.example.atvlpi3.dao.VegetalDao;
import org.example.atvlpi3.models.Vegetal;

import java.io.IOException;

public class VegetalController {

    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowVegetal;

    @FXML
    private Button btnUpVegetal;

    @FXML
    private TextField fieldRecipe;

    @FXML
    private TextField fieldType;

    @FXML
    private TextField fieldWeight;

    @FXML
    private Vegetal vegetalCadastrado;

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
    void cadastrarVegetal(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String tipoVegetal = fieldType.getText();
            String pesoStrVegetal = fieldWeight.getText();
            String pratoVegetal = fieldRecipe.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (tipoVegetal.isEmpty() || pesoStrVegetal.isEmpty() || pratoVegetal.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStrVegetal);

            // Criação da instância de Reptile
            vegetalCadastrado = new Vegetal(tipoVegetal, peso, pratoVegetal);

            //Persistencia no banco
            VegetalDao vegetalDao = new VegetalDao();
            vegetalDao.saveVegetal(vegetalCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Vegetal cadastrado com sucesso:\n" + vegetalCadastrado.toString());

            // Limpa os campos após o cadastro
            //limparCampos();

        } catch (
                NumberFormatException e) {
            // Exibe alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }


    @FXML
    void rootShowVegetal(ActionEvent event) {

    }

}
