package fr.ubx.poo.td2;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Sprite{
    protected Vehicule object;
    protected ImageView img;

    public Sprite(Vehicule object) {
        this.object = object;
        img = null;
    }

    private void updateLocation(Position position) {
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
