package view;

import fr.ubx.poo.td2.Position;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteDecor {
    protected Position object;
    protected ImageView img;

    public SpriteDecor(Position objectDeco, Image imageDeco) {
        this.object=objectDeco;
        img = new ImageView(imageDeco);
    }

    public ImageView getImg() {
        return img;
    }
}
