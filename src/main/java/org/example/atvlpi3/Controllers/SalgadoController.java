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
import org.example.atvlpi3.dao.SalgadoDao;
import org.example.atvlpi3.models.Salgado;

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

    @FXML
    private Salgado salgadoCadastrado;

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
    void cadastrarSalgado(ActionEvent event) {
        try {
            // Captura os valores dos campos de texto
            String tipoSalgado = fieldType.getText();
            String pesoStrSalgado = fieldWeight.getText();
            String saborSalgado = fieldFlavour.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (tipoSalgado.isEmpty() || pesoStrSalgado.isEmpty() || saborSalgado.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStrSalgado);

            // Criação da instância de Reptile
            salgadoCadastrado = new Salgado(tipoSalgado, peso, saborSalgado);

            //Persistencia no banco
            SalgadoDao salgadoDao = new SalgadoDao();
            salgadoDao.saveSalgado(salgadoCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Salgado cadastrado com sucesso:\n" + salgadoCadastrado.toString());

            // Limpa os campos após o cadastro
            //limparCampos();

        } catch (
                NumberFormatException e) {
            // Exibe alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }

    @FXML
    void rootShowSalgado(ActionEvent event) {
        if (salgadoCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre um Salgado antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/salgadoShow.fxml"));
            Parent root = loader.load();

            SalgadoShowController controller = loader.getController();
            controller.setSalgadoDetails(salgadoCadastrado);

            Stage stage = new Stage();
            stage.setTitle("Detalhes do Salgado");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (
                IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Não foi possível carregar a tela de detalhes.");
        }
    }

}