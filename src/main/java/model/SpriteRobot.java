package model;
import fr.ubx.poo.td2.Robot;
import view.ImageResource;

public class SpriteRobot extends Sprite {

    public SpriteRobot(Robot robot) {
        super(robot, ImageResource.imageRobot);
    }

}
