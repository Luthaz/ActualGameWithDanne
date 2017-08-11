package Menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Controller {

    @FXML
    public Button startButton;

    @FXML
    public Button optionsButton;

    @FXML
    public Button exitButton;

    public void handleOnStart() {
        String bip = "src/Images/random.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void handleOnOptions() {

    }

    public void handleOnExit() {
        Platform.exit();
    }
}
