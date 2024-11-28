package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Salgado;
import org.example.atvlpi3.models.Vegetal;

public class SalgadoShowController {

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
    private Label saborLabel;

    @FXML
    private Label tipoLabel;

    @FXML
    void comerSalgado(ActionEvent event) {
        comendo.setText("Nhac nhac");
    }

    @FXML
    void comprarSalgado(ActionEvent event) {
        comprando.setText("$$ dim dim");
    }

    @FXML
    void cozinharSalgado(ActionEvent event) {
        cozinhando.setText("cuidado com o calor da panela");
    }

    @FXML
    public void setSalgadoDetails(Salgado salgado) {
        tipoLabel.setText("Tipo: " + salgado.getTipo());
        pesoLabel.setText("Peso: " + salgado.getPeso());
        saborLabel.setText("Prato: " + salgado.getSabor());
    }
}
