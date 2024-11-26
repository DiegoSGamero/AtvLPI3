package org.example.atvlpi3.Controllers;

import org.example.atvlpi3.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.atvlpi3.MainApplication;
import org.example.atvlpi3.dao.FelineDao;
import org.example.atvlpi3.dao.ReptileDao;
import org.example.atvlpi3.models.Reptile;

import java.io.IOException;

public class ReptileController {

    @FXML
    private Button btnToShow;

    @FXML
    private Button btnBackMenu;

    @FXML
    private AnchorPane container_birds;

    @FXML
    private TextField reptile_habitat_up;

    @FXML
    private TextField reptile_specie_up;

    @FXML
    private TextField reptile_weight_up;

    @FXML
    private Button reptile_up_btn;

    private Reptile reptileCadastrado;

    // Método para cadastrar o réptil
    private void cadastrarReptil() {
        try {
            // Captura os valores dos campos de texto
            String especie = reptile_specie_up.getText();
            String pesoStr = reptile_weight_up.getText();
            String habitat = reptile_habitat_up.getText();

            // Validação básica dos dados (por exemplo, se os campos estão preenchidos)
            if (especie.isEmpty() || pesoStr.isEmpty() || habitat.isEmpty()) {
                exibirAlerta("Erro de Cadastro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Conversão do peso para double
            double peso = Double.parseDouble(pesoStr);

            // Criação da instância de Reptile
            reptileCadastrado = new Reptile(especie, habitat, peso);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Réptil cadastrado com sucesso:\n" + reptileCadastrado.toString());

            //Persistencia no banco
            ReptileDao felineDao = new ReptileDao();
            felineDao.saveRetile(reptileCadastrado);

            // Limpa os campos após o cadastro
            //limparCampos();

        } catch (
                NumberFormatException e) {
            // Exibe alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }

    // Inicialização do controller
    @FXML
    public void initialize() {
        // Conectar o botão ao método de cadastro
        reptile_up_btn.setOnAction(event -> cadastrarReptil());
        btnToShow.setOnAction(event -> rootShowReptile());
        btnBackMenu.setOnAction(event -> {
            try {
                backToMenu();
            } catch (IOException e) {
                e.printStackTrace();
                exibirAlerta("Erro", "Não foi possível voltar ao menu.");
            }
        });
    }

    private void rootShowReptile() {
        if (reptileCadastrado == null) {
            exibirAlerta("Aviso", "Cadastre um réptil antes de visualizar os detalhes.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/org/example/atvlpi3/reptileShow.fxml"));
            Parent root = loader.load();

            ReptileShowController controller = loader.getController();
            controller.setReptileDetails(reptileCadastrado);

            Stage stage = new Stage();
            stage.setTitle("Detalhes do Réptil");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (
                IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Não foi possível carregar a tela de detalhes.");
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

    // Método para limpar os campos após o cadastro
    private void limparCampos() {
        reptile_specie_up.clear();
        reptile_weight_up.clear();
        reptile_habitat_up.clear();
    }


    //Metodos para interagir

    public String makeSound() {
        return "Hiss!";
    }

    //@Override
    public void move() {
        System.out.println("Slithering...");
    }

    //@Override
    public void feed() {
        System.out.println("Eating insects...");
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
}
