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
import org.example.atvlpi3.dao.CarneDao;
import org.example.atvlpi3.models.Carne;

import java.io.IOException;

public class CarneController {
    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowCarne;

    @FXML
    private Button btnUpCarne;

    @FXML
    private TextField fieldRecipe;

    @FXML
    private TextField fieldType;

    @FXML
    private TextField fieldWeight;

    @FXML
    private Carne carneCadastrado;

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
    void cadastrarCarne(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String tipoCarne = fieldType.getText();
            String pesoStrCarne = fieldWeight.getText();
            String pratoCarne = fieldRecipe.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (tipoCarne.isEmpty() || pesoStrCarne.isEmpty() || pratoCarne.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStrCarne);

            // Criação da instância de Reptile
            carneCadastrado = new Carne(tipoCarne, peso, pratoCarne);

            //Persistencia no banco
            CarneDao carneDao = new CarneDao();
            carneDao.saveCarne(carneCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Carne cadastrada com sucesso:\n" + carneCadastrado.toString());

            // Limpa os campos após o cadastro
            //limparCampos();

        } catch (
                NumberFormatException e) {
            // Exibe alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }

    @FXML
    void rootShowCarne(ActionEvent event) {
        if (carneCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre uma carne antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/carneShow.fxml"));
            Parent root = loader.load();

            CarneShowController controller = loader.getController();
            controller.setCarneDetails(carneCadastrado);

            Stage stage = new Stage();
            stage.setTitle("Detalhes da Carne");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (
                IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Não foi possível carregar a tela de detalhes.");
        }
    }

}
