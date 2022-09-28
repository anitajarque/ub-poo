package view;
import model.Drone;

public class SpriteDrone extends Sprite {

    public SpriteDrone(Drone drone) {
        super(drone, ImageResource.imageDrone);
    }

}
