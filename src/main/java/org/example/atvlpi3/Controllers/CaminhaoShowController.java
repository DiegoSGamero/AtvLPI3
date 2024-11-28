package org.example.atvlpi3.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Caminhao;


public class CaminhaoShowController {
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
    void acelerarCaminhao(ActionEvent event) {
        acelerando.setText("vruuuuuuuuuhhhh");
    }

    @FXML
    void frearCaminhao(ActionEvent event) {
        freando.setText("tsssshhhhhh");
    }

    @FXML
    void ligarCaminhao(ActionEvent event) {
        ligando.setText("vrum-vrum-vrum");
    }

    @FXML
    public void setCaminhaoDetails(Caminhao caminhao) {
        marcaLabel.setText("Marca: " + caminhao.getMarca());
        modeloLabel.setText("Modelo: " + caminhao.getModelo());
        corLabel.setText("Cor: " + caminhao.getCor());
    }
}
