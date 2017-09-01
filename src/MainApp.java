import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/Menu.fxml"));

        primaryStage.getIcons().add(new Image(("Images/jw.png")));
        primaryStage.setTitle("Sagan om SpoderJW");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(loader.load()));

        primaryStage.show();
    }

}
