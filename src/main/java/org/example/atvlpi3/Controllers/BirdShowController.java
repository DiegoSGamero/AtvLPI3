package org.example.atvlpi3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.atvlpi3.models.Bird;

public class BirdShowController {

    @FXML
    private Button btnBirdFeed;

    @FXML
    private Button btnBirdMove;

    @FXML
    private Label habitatLabel;

    @FXML
    private Button makeBirdSound;

    @FXML
    private Label speciesLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label labelFeed;

    @FXML
    private Label labelMove;

    @FXML
    private Label labelSound;


    @FXML
    public void setBirdDetails(Bird bird) {
        speciesLabel.setText("Espécie: " + bird.getSpecies());
        habitatLabel.setText("Habitat: " + bird.getHabitat());
        weightLabel.setText("Peso: " + bird.getWeight() + " kg");
    }

    @FXML
    void feed(ActionEvent event) {
        labelFeed.setText("nhac nhac...");
    }

    @FXML
    void makeSound(ActionEvent event) {
        labelSound.setText("AAAAA  aaaa  AAAA!");
    }

    @FXML
    void move(ActionEvent event) {
        labelMove.setText("Batendo asas...");
    }
}
