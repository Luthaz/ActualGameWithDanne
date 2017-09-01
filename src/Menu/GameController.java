package Menu;

import Game.Square;
import Game.Square.Direction;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class GameController {

    private Square player;
    private Square ground;

    @FXML
    public Canvas canvas;

    @FXML
    void initialize() {
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(this::onKeyPressHandler);
        canvas.setOnKeyReleased(this::onKeyReleaseHandler);

        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
        canvas.setWidth(bounds.getWidth());
        canvas.setHeight(bounds.getHeight());

        GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                update();
                draw(gc);
            }
        }.start();

        Double ny = bounds.getHeight();
        Double nw = bounds.getWidth();

        player = new Square(100, 100, 40, 40);
        ground = new Square(0, ny.intValue() - 100, nw.intValue(), 100);
    }

    private void update(){
        player.update();
    }

    private void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        player.draw(gc, Color.LAWNGREEN);
        ground.draw(gc, Color.LIGHTBLUE);
    }

    private void onKeyPressHandler(KeyEvent event){
        KeyCode kc = event.getCode();
        if(kc == kc.LEFT){
            player.setMovingDirection(Direction.LEFT, true);
        }
        else if(kc == kc.UP) {
            player.setMovingDirection(Direction.UP, true);
            player.jump();
        }
        else if(kc == kc.RIGHT) {
            player.setMovingDirection(Direction.RIGHT, true);
        }
        else if(kc == kc.DOWN) {
            player.setMovingDirection(Direction.DOWN, true);
        }
    }

    private void onKeyReleaseHandler(KeyEvent event){
        KeyCode kc = event.getCode();
        if(kc == kc.LEFT){
            player.setMovingDirection(Direction.LEFT, false);
            player.resetVelocityX();
        }
        else if(kc == kc.UP) {
            player.setMovingDirection(Direction.UP, false);
        }
        else if(kc == kc.RIGHT) {
            player.setMovingDirection(Direction.RIGHT, false);
            player.resetVelocityX();
        }
        else if(kc == kc.DOWN) {
            player.setMovingDirection(Direction.DOWN, false);
        }
    }

}
