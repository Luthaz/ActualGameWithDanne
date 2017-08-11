package Menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    public Button startButton;

    @FXML
    public Button optionsButton;

    @FXML
    public Button exitButton;

    public void handleOnStart() {
        System.out.println("Start");
    }

    public void handleOnOptions() {
        System.out.println("Options");
    }

    public void handleOnExit() {
        System.out.println("Exit");
    }
}
