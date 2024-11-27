package org.example.atvlpi3.Controllers;

import org.example.atvlpi3.MainApplication;
import org.example.atvlpi3.dao.BirdDao;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.atvlpi3.models.Bird;
import org.example.atvlpi3.models.Feline;

import java.io.IOException;

public class BirdController {

    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnShowBird;

    @FXML
    private Button btnUpBird;

    @FXML
    private TextField fieldHabitat;

    @FXML
    private TextField fieldSpecie;

    @FXML
    private TextField fieldWeight;

    private Bird birdCadastrado;

    @FXML
    private void cadastrarAve() {
        try {
            // Captura os valores dos campos de texto
            String especieBird = fieldSpecie.getText();
            String pesoStrBird = fieldWeight.getText();
            String habitatBird = fieldHabitat.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (especieBird.isEmpty() || pesoStrBird.isEmpty() || habitatBird.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStrBird);

            // Criação da instância de Reptile
            birdCadastrado = new Bird(especieBird, habitatBird, peso);

            //Persistencia no banco
            BirdDao birdDao = new BirdDao();
            birdDao.saveBird(birdCadastrado);

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

    // Métdo para exibir alertas
    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
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
    //meth p limpar campos
    private void limparCampos() {
        fieldSpecie.clear();
        fieldWeight.clear();
        fieldHabitat.clear();
    }

    //ir para pagina dos metdos
    public void rootShowBird() {
        if (birdCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre um pássaro antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/birdShow.fxml"));
            Parent root = loader.load();

            BirdShowController controller = loader.getController();
            controller.setBirdDetails(birdCadastrado);

            Stage stage = new Stage();
            stage.setTitle("Detalhes do Pássaro");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (
                IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Não foi possível carregar a tela de detalhes.");
        }
    }
}
