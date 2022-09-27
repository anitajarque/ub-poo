package model;

import fr.ubx.poo.td2.Position;
import fr.ubx.poo.td2.Vehicule;
import fr.ubx.poo.td2.World;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DecorFactory {
    public static SpriteDecor create(Position position, int kind) {
        switch (kind) {
            case World.DUST:
                return new SpriteDust(position);
            case World.ROCK:
                return new SpriteRock(position);
            default:
                return null;
        }
    }
}