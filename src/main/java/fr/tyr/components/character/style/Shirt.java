package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Shirt extends ImageComponent {
    public Shirt(Images image) {
        super(image);
    }
    public Shirt(Images image, Vector2D position) {
        super(image, position);
    }
    public Shirt(Images image, Vector2D position, Vector2D size, boolean center) {
        super(image, position, size, center);
    }
    @Override
    public void tick(int aps) {

    }
    @Override
    public void onClick(MouseButtons button) {

    }
    @Override
    public void onHover() {

    }
    @Override
    public void onHoverLost() {

    }
    @Override
    public void onWindowResized(Vector2D size) {

    }
}
