package model;

import fr.ubx.poo.td2.Position;
import view.ImageResource;

public class SpriteRock extends SpriteDecor{
    public SpriteRock(Position rock) {
        super(rock, ImageResource.imageRock);
    }
}

