package Menu;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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
    private Button mainMenuButton;

    @FXML
    private Button musicSwitch;

    @FXML
    private ComboBox musicOptions;

    @FXML
    private Canvas canvas;

    private static AudioClip ac = null;

    public void handleOnStart() throws IOException{
        if(ac == null){
            URL defaultMusic = getClass().getResource("../Music/Hej.mp3");
            ac = new AudioClip(defaultMusic.toString());
            //ac.play();
        }

        changeScene(startButton.getScene(), "Game.fxml");
    }

    public void handleOnOptions() throws IOException{
        changeScene(optionsButton.getScene(), "Options.fxml");
    }

    public void handleOnExit() {
        Platform.exit();
    }

    public void switchMusic(){
        if(ac != null) {
            ac.stop();
        }
        Object selectedValue = musicOptions.getSelectionModel().getSelectedItem();
        if(selectedValue != null) {
            URL music = getClass().getResource("../Music/" + selectedValue + ".mp3");
            ac = new AudioClip(music.toString());
            ac.play();
        }
    }

    public void goToMainMenu() throws IOException {
        changeScene(mainMenuButton.getScene(), "Menu.fxml");
    }

    public void changeScene(Scene currentScene, String filename) throws IOException{
        Parent newRoot = FXMLLoader.load(getClass().getResource(filename));
        currentScene.setRoot(newRoot);
    }

}
