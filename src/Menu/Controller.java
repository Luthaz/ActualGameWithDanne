package Menu;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import java.io.IOException;
import java.net.URL;

public class Controller {

    @FXML
    public Button startButton;

    @FXML
    public Button optionsButton;

    @FXML
    public Button exitButton;

    URL music = getClass().getResource("../Music/Hej.mp3");
    public AudioClip ac = new AudioClip(music.toString());

    public void handleOnStart() {
        ac.play();
    }

    public void handleOnOptions() throws IOException{
        Scene scene = (Scene) optionsButton.getScene();
        Parent root = FXMLLoader.load(getClass().getResource("Options.fxml"));
        scene.setRoot(root);
    }

    public void switchMusic(){
        ac.stop();
    }

    public void handleOnExit() {
        Platform.exit();
    }
}
