package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Creation du robot et du drone
        Position position = new Position(4,4);
        Position position1 = new Position(8, 8);
        Robot robot = new Robot(position, 200, 2);
        //robot.getPosition().translate(10);
        SpriteRobot spriteRobot = new SpriteRobot(robot);
        spriteRobot.animateMove(position1);
        Drone drone = new Drone(position, 100, 2);
        SpriteDrone spriteDrone = new SpriteDrone(drone);
        spriteDrone.animateMove(position1);

        // Affiche la fenetre
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            if (robot.canMove(target)) {
                spriteRobot.animateMove(target);
            }
        });

        view.getPane().getChildren().addAll(spriteRobot.getImg(),spriteDrone.getImg());

    }

    public static void main(String[] args) { launch(); }
}