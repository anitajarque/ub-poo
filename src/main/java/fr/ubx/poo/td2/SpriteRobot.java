package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;

public class SpriteRobot extends Sprite{

    public SpriteRobot(Robot robot) {
        super(robot);
        img = new ImageView(ImageResource.imageRobot);
        updateLocation(robot.getPosition());
    }

    private void updateLocation(Position position) {
        img.setX(position.getX() * ImageResource.size);
        img.setY(position.getY() * ImageResource.size);
    }

}
