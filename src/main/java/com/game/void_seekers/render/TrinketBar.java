package com.game.void_seekers.render;

import com.game.void_seekers.item.base.Active;
import com.game.void_seekers.item.base.Trinket;
import com.game.void_seekers.logic.GameAssets;
import com.game.void_seekers.logic.GameLogic;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class TrinketBar extends Scene {
    private final Canvas canvas;
    private Image image;

    public TrinketBar(Pane parent, double width, double height) {
        super(parent);
        canvas = new Canvas(width, height);
        parent.getChildren().add(canvas);
    }

    public void redraw() {
        Thread thread = new Thread(() -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Platform.runLater(() -> {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                int xPos = 0;
                int yPos = 0;
                Trinket item = GameLogic.getInstance().getCharacter().getTrinket();
                setImage(item.getAssetImage());

                gc.drawImage(getImage(), xPos, yPos);

                Paint p = gc.getFill();
                Font ft = gc.getFont();
                gc.setFont(GameAssets.loadGameFont(40));


                gc.setFill(p);
                gc.setFont(ft);
            });
        });
        thread.start();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
