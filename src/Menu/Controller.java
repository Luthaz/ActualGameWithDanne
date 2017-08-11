package Menu;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    public Button startButton;

    @FXML
    public Button optionsButton;

    @FXML
    public Button exitButton;

    public void handleOnStart() {
        String music = "src/Music/Hej.mp3";
        Media hit = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void handleOnOptions() throws IOException{
        Scene scene = (Scene) optionsButton.getScene();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Menu/Options.fxml"));
        scene.setRoot(root);
    }

    public void switchMusic(){
        String music = "src/Music/random.mp3";
        Media hit = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        mediaPlayer.stop();
    }

    public void handleOnExit() {
        Platform.exit();
    }
}
