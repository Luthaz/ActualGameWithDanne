package Menu;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.media.AudioClip;
import java.io.IOException;
import java.net.URL;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    private Button optionsButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button musicSwitchButton;

    @FXML
    private ComboBox musicOptions;

    private URL defaultMusic = getClass().getResource("../Music/Hej.mp3");
    private AudioClip ac = new AudioClip(defaultMusic.toString());

    public void handleOnStart() {
        ac.play();
    }

    public void handleOnOptions() throws IOException{
        Scene scene = (Scene) optionsButton.getScene();
        Parent root = FXMLLoader.load(getClass().getResource("Options.fxml"));
        scene.setRoot(root);
    }

    public void switchMusic(String url){
        if(ac != null){
            ac = null;
        }
        if(ac.isPlaying()){
            ac.stop();
        }
        URL music = getClass().getResource("../Music/" + musicOptions.getId());
        AudioClip ac = new AudioClip(music.toString());
        ac.play();
    }

    public void handleOnExit() {
        Platform.exit();
    }
}
