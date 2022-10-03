package fr.ubx.poo.td2;

import  javafx.application.Application;
import javafx.stage.Stage;
import model.Drone;
import model.Robot;
import model.Vehicule;
import view.DecorFactory;
import view.SpriteDecor;
import view.SpriteRock;
import view.View;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        Vehicule[] listVehicules = new Vehicule[2];
        Vehicule.Sprite listSprites[] = new Vehicule.Sprite[2];
        SpriteDecor listSpritesDecor[] = new SpriteDecor[10];
        // Creation du robot et du drone
        Position position = new Position(4,4);
        Position position1 = new Position(8, 8);
        Position position2 = new Position(10, 8);
        listVehicules[0] = new Robot(position, 200, 2);
        listSprites[0] = new Vehicule.SpriteRobot((Robot) listVehicules[0]);
        listSprites[0].animateMove(position2);


        listVehicules[1] = new Drone(position1, 100, 2);
        listSprites[1] = new Vehicule.SpriteDrone((Drone) listVehicules[1]);
        Random random = new Random();
        //Creation decoration
        for(int i=0; i<listSpritesDecor.length; i++){
            int r1 = random.nextInt(2)+1;
            Position position3 = position.random();
            listSpritesDecor[i]= DecorFactory.create(position3, r1);
        }

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
        //view.getPane().getChildren().addAll( listSprites[0].getImg(), listSprites[1].getImg());
        for(int i=0;i< listSprites.length;i++){
            view.getPane().getChildren().add(listSprites[i].getImg());
        }

        for(int i=0;i< listSpritesDecor.length;i++){
            view.getPane().getChildren().add(listSpritesDecor[i].getImg());
        }
        //TestPositions
        System.out.println(position.equals(position1));
        System.out.println(position.equals(position2));
        System.out.println(position.equals(position));
        System.out.println(position.equals(listVehicules[0]));
        System.out.println(position.equals(listVehicules[1]));
        System.out.println(position.equals(null));
        System.out.println(position.equals(new Position(4,4)));

    }

    public static void main(String[] args) { launch(); }
}