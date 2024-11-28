package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Carne;

public class CarneShowController {

    @FXML
    private Button btbnComprar;

    @FXML
    private Button btnComer;

    @FXML
    private Button btnCozinhar;

    @FXML
    private Label comendo;

    @FXML
    private Label comprando;

    @FXML
    private Label cozinhando;

    @FXML
    private Label pesoLabel;

    @FXML
    private Label receitaLabel;

    @FXML
    private Label tipoLabel;

    @FXML
    void comerCarne(ActionEvent event) {
        comendo.setText("Nhac nhac");
    }

    @FXML
    void comprarCarne(ActionEvent event) {
        comprando.setText("$$ dim dim");
    }

    @FXML
    void cozinharCarne(ActionEvent event) {
        cozinhando.setText("cuidado com o calor da panela");
    }

    @FXML
    public void setCarneDetails(Carne carne) {
        tipoLabel.setText("Tipo: " + carne.getTipo());
        pesoLabel.setText("Peso: " + carne.getPeso());
        receitaLabel.setText("Prato: " + carne.getPrato());
    }

}

