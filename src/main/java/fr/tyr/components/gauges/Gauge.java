package fr.tyr.components.gauges;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.tools.Vector2D;

public class Gauge extends ComposedComponent {

    private final boolean isVertical;
    private int currentProgress = 100;
    private final ImageComponent progressBar;

    public Gauge(Vector2D position, boolean isVertical, ImageComponent progressBar) {
        super(position);
        this.isVertical = isVertical;
        this.progressBar = progressBar;
    }

    public ImageComponent getProgressBar() {
        return progressBar;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(int newProgress) {
        currentProgress = newProgress;
        int gaugeSize = 100 - newProgress;
        Main.getLogger().info("%s set to %d%%".formatted(getClass().getSimpleName(), newProgress));
        if(newProgress == 0){
            progressBar.setVisible(false);
            return;
        }else
            progressBar.setVisible(true);
        if(isVertical){
            int y = (int) (progressBar.getOriginalSize().y * (gaugeSize / 100D));
            progressBar.crop(0, y, (int) progressBar.getOriginalSize().x, (int) progressBar.getOriginalSize().y - y);
            progressBar.move(getPosition().getAdded(new Vector2D(progressBar.getPosition().x - getPosition().x, (int) (progressBar.getOriginalSize().y * ((100 - currentProgress) / 100D)))));
        }else{
            int x = (int) (progressBar.getOriginalSize().x * (gaugeSize / 100D));
            progressBar.crop(0, 0, (int) progressBar.getOriginalSize().x - x, (int) progressBar.getOriginalSize().y);
        }
    }
}
