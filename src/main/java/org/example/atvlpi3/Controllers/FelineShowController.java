package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Feline;


public class FelineShowController {
    @FXML
    private Button btnFelineFeed;

    @FXML
    private Button btnFelineMove;

    @FXML
    private Label habitatLabel;

    @FXML
    private Button makeFelineSound;

    @FXML
    private Label speciesLabel;

    @FXML
    private Label weightLabel;

    @FXML
    public void setFelineDetails(Feline feline) {
        speciesLabel.setText("Espécie: " + feline.getSpecies());
        habitatLabel.setText("Habitat: " + feline.getHabitat());
        weightLabel.setText("Peso: " + feline.getWeight() + " kg");
    }

    @FXML
    void feed(ActionEvent event) {

    }

    @FXML
    void makeSound(ActionEvent event) {

    }

    @FXML
    void move(ActionEvent event) {

    }
}
