package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.atvlpi3.models.Vegetal;

public class VegetalShowController {

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
    void comerVegetal(ActionEvent event) {
        comendo.setText("Nhac nhac");
    }

    @FXML
    void comprarVegetal(ActionEvent event) {
        comprando.setText("$$ dim dim");
        String caminho = getClass().getResource("/Sounds/cash.mp3").toExternalForm();
        Media som = new Media(caminho);
        MediaPlayer mediaPlayer = new MediaPlayer(som);
        mediaPlayer.play();
    }

    @FXML
    void cozinharVegetal(ActionEvent event) {
        cozinhando.setText("cuidado com o calor da panela");
        String caminho = getClass().getResource("/Sounds/alimento.mp3").toExternalForm();
        Media som = new Media(caminho);
        MediaPlayer mediaPlayer = new MediaPlayer(som);
        mediaPlayer.play();
    }

    @FXML
    public void setVegetalDetails(Vegetal vegetal) {
        tipoLabel.setText("Tipo: " + vegetal.getTipo());
        pesoLabel.setText("Peso: " + vegetal.getPeso());
        receitaLabel.setText("Prato: " + vegetal.getPrato());
    }

}