package org.example.atvlpi3.Controllers;

import javafx.fxml.FXML;
import org.example.atvlpi3.models.Carro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CarroShowController {

    @FXML
    private Label aceleraCar;

    @FXML
    private Button btbnLigar;

    @FXML
    private Button btnAcelerar;

    @FXML
    private Button btnFrear;

    @FXML
    private Label corLabel;

    @FXML
    private Label marcaLabel;

    @FXML
    private Label modeloLabel;

    @FXML
    private Label startCar;

    @FXML
    private Label stopCar;

    @FXML
    void acelerarCarro(ActionEvent event) {
        aceleraCar.setText("vrrrrrooooom");
    }

    @FXML
    void frearCarro(ActionEvent event) {
        stopCar.setText(" iiiiiissshhh");
    }

    @FXML
    void ligarCarro(ActionEvent event) {
        startCar.setText("vruuum");
    }

    @FXML
    public void setCarroDetails(Carro carro) {
        marcaLabel.setText("Marca: " + carro.getMarca());
        modeloLabel.setText("Modelo: " + carro.getModelo());
        corLabel.setText("Cor: " + carro.getCor());
    }
}
