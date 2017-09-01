package Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Square {
    private int x;
    private int y;
    private int width;
    private int height;
    private double screenWidth;
    private double screenHeight;
    private double velocityX = 0;
    private double velocityY = 0;
    private double velIncrement = 0.2;
    private double defaultVelocity = 4;
    private double maxVelocity = 4;
    private double gravity = 0.05;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingRight = false;
    private boolean movingDown = false;
    private boolean inAir = true;
    private AudioClip ac = new AudioClip(getClass().getResource("../Music/pew.mp3").toString());

    public enum Direction {
        LEFT, UP, RIGHT, DOWN
    }

    public Square(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
        this.screenWidth = bounds.getWidth();
        this.screenHeight = bounds.getHeight();
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setMovingDirection(Direction direction, boolean state){
        switch(direction){
            case LEFT:
                movingLeft = state;
                break;
            case UP:
                movingUp = state;
                break;
            case RIGHT:
                movingRight = state;
                break;
            case DOWN:
                movingDown = state;
                break;
        }
    }

    public void jump(){
        if(!inAir) {
            inAir = true;
            velocityY = -defaultVelocity;
        }
    }

    public void resetVelocityX(){
        velocityX = 0;
    }

    public void resetVelocityY(){
        velocityY = 0;
    }

    private boolean onGround(){
        if(y + height + 100 > screenHeight){
            return true;
        }
        return false;
    }

    private void incrementSpeed(){
        if(Math.abs(velocityX) < maxVelocity) {
            velocityX += velIncrement;
        }
        else{
            velocityX = maxVelocity;
        }
    }

    public void update(){
        if(inAir){
            //System.out.println("In air: " + velocityY);
            move(0, velocityY);
            velocityY += gravity;
            y += velocityY;
        }

        // Ground
        if(onGround()){
            //System.out.println("Outside");
            Double groundY = screenHeight - height - 100;
            y = groundY.intValue();
            resetVelocityY();
            inAir = false;
            ac.play();
        }

        // Left
        if(x < 0){
            x = 0;
        }

        // Right
        if(x + width > screenWidth){
            Double temp = screenWidth;
            x = temp.intValue() - width;
        }

        if(movingLeft){
            incrementSpeed();
            move(-velocityX, 0);
        }

        if(movingRight){
            incrementSpeed();
            move(velocityX, 0);
        }

        if(movingUp){
            jump();
        }

        /*if(movingDown){
            move(0, velocityY);
        }*/
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillRect(x, y, width, height);
    }

    public void draw(GraphicsContext gc, Color color){
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }
}
