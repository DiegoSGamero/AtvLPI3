package org.example.atvlpi3.Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.atvlpi3.models.Reptile;

public class ReptileController {

    @FXML
    private Button btnToShow;

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
            Reptile reptil = new Reptile(especie, habitat, peso);

            // Exibe uma mensagem de sucesso
            exibirAlerta("Cadastro Concluído", "Réptil cadastrado com sucesso:\n" + reptil.toString());

            // Limpa os campos após o cadastro
            limparCampos();

        } catch (NumberFormatException e) {
            // Exibe um alerta caso o valor de peso não seja numérico
            exibirAlerta("Erro de Cadastro", "Peso deve ser um valor numérico.");
        }
    }

    // Inicialização do controller
    @FXML
    public void initialize() {
        // Conectar o botão ao método de cadastro
        reptile_up_btn.setOnAction(event -> cadastrarReptil());
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
}
