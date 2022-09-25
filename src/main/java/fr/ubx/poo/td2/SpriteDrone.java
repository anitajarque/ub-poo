package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;

public class SpriteDrone extends Sprite{

    public SpriteDrone(Drone drone) {
        super(drone);
        img = new ImageView(ImageResource.imageDrone);
        updateLocation(drone.getPosition());
    }

    private void updateLocation(Position position) {
        img.setX(position.getX() * ImageResource.size);
        img.setY(position.getY() * ImageResource.size);
    }

}
