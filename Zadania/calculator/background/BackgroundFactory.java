package ZadaniaWlasne.Zadania.calculator.background;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:43
 */
public enum BackgroundFactory {
    GREEN(204, 255, 153),
    RED(255, 153, 153),
    YELLOW(255, 255, 153),
    BLUE(153, 153, 255),
    WHITE(255, 255, 255),
    GRAY(105, 105, 105);

    private final int redValue;
    private final int greenValue;
    private final int blueValue;

    BackgroundFactory(int red, int green, int blue) {
        redValue = red;
        greenValue = green;
        blueValue = blue;
    }

    Background value() {
        Background background = new Background(
                new BackgroundFill(
                        Color.rgb(redValue, greenValue, blueValue),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                )
        );
        return background;
    }
}

