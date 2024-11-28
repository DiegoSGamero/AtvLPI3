package org.example.atvlpi3.Controllers;

import org.example.atvlpi3.MainApplication;
import org.example.atvlpi3.dao.FelineDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.atvlpi3.models.Feline;

import java.io.IOException;


public class FelineController  {
    @FXML
    private Button btnShowFeline;

    @FXML
    private Button btnUpFeline;

    @FXML
    private AnchorPane feline_container;

    @FXML
    private TextField fieldHabitat;

    @FXML
    private TextField fieldSpecie;

    @FXML
    private TextField fieldWeight;

    @FXML
    private Button btnBackMenu;

    private Feline felineCadastrado;

    //meth para cadastro de felino
    @FXML
    public void cadastrarFeline() {
        try {
            // Captura os valores dos campos de texto
            String especieFeline = fieldSpecie.getText();
            String pesoStrFeline = fieldWeight.getText();
            String habitatFeline = fieldHabitat.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (especieFeline.isEmpty() || pesoStrFeline.isEmpty() || habitatFeline.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStrFeline);

            // Criação da instância de Feline
            felineCadastrado = new Feline(especieFeline, habitatFeline, peso);

            //Persistencia no banco
            FelineDao felineDao = new FelineDao();
            felineDao.saveFeline(felineCadastrado);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Felino cadastrado com sucesso:\n" + felineCadastrado.toString());

            // Limpa os campos após o cadastro
            limparCampos();

        } catch (
                NumberFormatException e) {
            // Exibe alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }

    // Método para exibir alertas
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
        //reptile_up_btn.setOnAction(event -> cadastrarReptil());
        //btnToShow.setOnAction(event -> rootShowReptile());
        btnBackMenu.setOnAction(event -> {
            try {
                backToMenu();
            } catch (IOException e) {
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

    public String makeSound() {
        return "Raaooow!";
    }

    //@Override
    public void move() {
        System.out.println("Correndo...");
    }

    //@Override
    public void feed() {
        System.out.println("Comendo...");
    }

    //ir para pagina dos metdos
    public void rootShowFeline() {
        if (felineCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre um felino antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/felineShow.fxml"));
            Parent root = loader.load();

            FelineShowController controller = loader.getController();
            controller.setFelineDetails(felineCadastrado);

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
