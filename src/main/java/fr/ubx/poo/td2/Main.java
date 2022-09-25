package fr.ubx.poo.td2;

import  javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        Vehicule listVehicules[] = new Vehicule[2];
        Sprite listSprites[] = new Sprite[2];
        // Creation du robot et du drone
        Position position = new Position(4,4);
        Position position1 = new Position(8, 8);
        Position position2 = new Position(10, 8);
        listVehicules[0] = new Robot(position, 200, 2);
        listSprites[0] = new SpriteRobot((Robot) listVehicules[0]);
        listSprites[0].animateMove(position2);

        listVehicules[1] = new Drone(position1, 100, 2);
        listSprites[1] = new SpriteDrone((Drone) listVehicules[1]);

        // Affiche la fenetre
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();



        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(int i=0;i< listSprites.length;i++){
                if (listVehicules[i].canMove(target)) {
                    listSprites[i].animateMove(target);
                }
            }
        });
        view.getPane().getChildren().addAll( listSprites[0].getImg(), listSprites[1].getImg());
        for(int i=0;i< listSprites.length;i++){

        }

    }

    public static void main(String[] args) { launch(); }
}