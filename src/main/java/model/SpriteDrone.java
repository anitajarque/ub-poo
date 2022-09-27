package model;
import fr.ubx.poo.td2.Drone;
import view.ImageResource;

public class SpriteDrone extends Sprite {

    public SpriteDrone(Drone drone) {
        super(drone, ImageResource.imageDrone);
    }

}
