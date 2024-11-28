package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Arroz;
import org.example.atvlpi3.models.Caminhao;

public class ArrozShowController {

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
    void comerArroz(ActionEvent event) {
        comendo.setText("Nhac nhac");
    }

    @FXML
    void comprarArroz(ActionEvent event) {
        comprando.setText("$$ dim dim");
    }

    @FXML
    void cozinharArroz(ActionEvent event) {
        cozinhando.setText("cuidado com o calor da panela");
    }

    @FXML
    public void setArrozDetails(Arroz arroz) {
        tipoLabel.setText("Tipo: " + arroz.getTipo());
        pesoLabel.setText("Peso: " + arroz.getPeso());
        receitaLabel.setText("Prato: " + arroz.getPrato());
    }
}