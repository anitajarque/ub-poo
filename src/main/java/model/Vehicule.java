package model;

import fr.ubx.poo.td2.Position;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import view.ImageResource;

public abstract class Vehicule {
    protected final double cost;
    protected Position position;
    protected double energy;


    public Vehicule(Position position, double energy, double cost) {
        //this.position = position; for having a not independant variable of position
        this.position=new Position(position.getX(), position.getY()); //for having an independant variable of position
        this.energy = energy;
        this.cost = cost;
    }

    public Position getPosition() {
        return position;
    }

    // TODO
    private int range() {
        return (int) (this.energy/this.cost);
    }

    // TODO
    public int distance(Position target) {
        return (int) Math.sqrt(Math.pow(position.getY() - target.getY(), 2) + Math.pow(position.getX() - target.getX(), 2));
    }

        // TODO
    public boolean canMove(Position target) {

        return this.range() >= this.distance(target);
    }

    // TODO
    public void move(Position target) {
        this.position = target; //new Position(position.getX(), position.getY());
        System.out.println("Move completed: " + this);
    }

    // TODO
    public Position[] getPathTo(Position target) {

        Position[] positions = new Position[1000];
        int numPositions=0;

        if(target.getX()>= position.getX()){
            for(int i =position.getX(); i<=target.getX(); i++){
                positions[numPositions] = new Position(i, getPosition().getY());
                numPositions++;
            }
        }
        else{
            for(int i =position.getX(); i>=target.getX(); i--){
                positions[numPositions] = new Position(i, getPosition().getY());
                numPositions++;
            }
        }


        if(target.getY()>= position.getY()){
            for(int i =position.getY(); i<=target.getY(); i++){
                positions[numPositions] = new Position(target.getX(), i);
                numPositions++;
            }
        }
        else{
            for(int i =position.getY(); i>=target.getY(); i--){
                positions[numPositions] = new Position(target.getX(), i);
                numPositions++;
            }
        }
        Position[] positions1 = new Position[numPositions];
        for(int i=0; i<numPositions; i++){
            positions1[i]=positions[i];
        }
        return positions1;
    }

    public abstract static class Sprite{
        protected Vehicule object;
        protected ImageView img;

        public Sprite(Vehicule object, Image imageRobot) {
            this.object = object;
            img = new ImageView(imageRobot);
            updateLocation(object.getPosition());
        }

        protected void updateLocation(Position position) {
            img.setX(position.getX() * ImageResource.size);
            img.setY(position.getY() * ImageResource.size);
        }

        public ImageView getImg() {
            return img;
        }

        public void animateMove(Position target) {
            // Make the path movement
            Position[] positionPath = object.getPathTo(target);

            if (positionPath != null) {
                Path path = new Path();

                path.getElements().add(new MoveTo(object.getPosition().getX() * ImageResource.size + ImageResource.size / 2,
                        object.getPosition().getY() * ImageResource.size + ImageResource.size / 2));
                for (Position pos : positionPath) {
                    path.getElements().add(new LineTo(pos.getX() * ImageResource.size + ImageResource.size / 2, pos.getY() * ImageResource.size + ImageResource.size / 2));
                }

                PathTransition ptr = new PathTransition();
                ptr.setDuration(Duration.millis(300 * object.distance(target)));
                ptr.setPath(path);
                ptr.setNode(getImg());
                ptr.play();

                ptr.setOnFinished(e -> {
                    object.move(target);
                });
            } else {
                // Direct move
                object.move(target);
                updateLocation(target);
            }
        }
    }

    public static class SpriteDrone extends Sprite {

        public SpriteDrone(Drone drone) {
            super(drone, ImageResource.imageDrone);
        }

    }

    public static class SpriteRobot extends Sprite {

        public SpriteRobot(Robot robot) {
            super(robot, ImageResource.imageRobot);
        }

    }
}




