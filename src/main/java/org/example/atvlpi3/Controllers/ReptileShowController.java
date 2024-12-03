package org.example.atvlpi3.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.atvlpi3.models.Reptile;

public class ReptileShowController {

    @FXML
    private AnchorPane containerShowReptile;
    @FXML
    private Label speciesLabel;
    @FXML
    private Label habitatLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Button makeSound;
    @FXML
    private Button btnMove;
    @FXML
    private Button btnFeed;
    @FXML
    private Label labelMakeSound;
    @FXML
    private Label labelMove;
    @FXML
    private Label labelFeed;


    public void setReptileDetails(Reptile reptile) {
        speciesLabel.setText("Espécie: " + reptile.getSpecies());
        habitatLabel.setText("Habitat: " + reptile.getHabitat());
        weightLabel.setText("Peso: " + reptile.getWeight() + " kg");
    }

    //@Override
    public void makeSound() {
        labelMakeSound.setText("Hiss...");
        String caminho = getClass().getResource("/Sounds/snake-rattle-sound-hq-240150.mp3").toExternalForm();
        Media som = new Media(caminho);
        MediaPlayer mediaPlayer = new MediaPlayer(som);
        mediaPlayer.play();
    }

    //@Override
    public void move() {
        labelMove.setText("Slithering...");
    }

    //@Override
    public void feed() {
        labelFeed.setText("Nhac nhac!");
    }
}
