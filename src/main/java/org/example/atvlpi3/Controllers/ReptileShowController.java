package org.example.atvlpi3.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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


    public void setReptileDetails(Reptile reptile) {
        speciesLabel.setText("Espécie: " + reptile.getSpecies());
        habitatLabel.setText("Habitat: " + reptile.getHabitat());
        weightLabel.setText("Peso: " + reptile.getWeight() + " kg");
    }
}
