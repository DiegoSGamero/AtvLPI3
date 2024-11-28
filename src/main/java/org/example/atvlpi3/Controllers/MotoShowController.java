package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Carro;
import org.example.atvlpi3.models.Moto;

public class MotoShowController {

    @FXML
    private Label acelerando;

    @FXML
    private Button btbnLigar;

    @FXML
    private Button btnAcelerar;

    @FXML
    private Button btnFrear;

    @FXML
    private Label corLabel;

    @FXML
    private Label freando;

    @FXML
    private Label ligando;

    @FXML
    private Label marcaLabel;

    @FXML
    private Label modeloLabel;

    @FXML
    void acelerarMoto(ActionEvent event) {
        acelerando.setText("ren ten ten");
    }

    @FXML
    void frearMoto(ActionEvent event) {
        freando.setText("eiiiiik");
    }

    @FXML
    void ligarMoto(ActionEvent event) {
        ligando.setText("vrummm-vrummm");
    }

    @FXML
    public void setMotoDetails(Moto moto) {
        marcaLabel.setText("Marca: " + moto.getMarca());
        modeloLabel.setText("Modelo: " + moto.getModelo());
        corLabel.setText("Cor: " + moto.getCor());
    }
}
