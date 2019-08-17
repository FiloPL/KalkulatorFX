package ZadaniaWlasne.Zadania.calculator.background;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static ZadaniaWlasne.Zadania.calculator.background.BackgroundFactory.BLUE;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:45
 */
public class ClickButton extends Button {

    private Background back;

    public ClickButton(String text) {
        super(text);
        this.setOnMousePressed(event -> setOnMousePressed());
        this.setOnMouseReleased(event -> setOnMouseReleased());
        this.setFont(Font.font("", FontWeight.BOLD, 50));

    }

    private void setOnMousePressed() {
        back = getBackground();
        setBackground(BLUE.value());
    }

    private void setOnMouseReleased() {
        setBackground(back);
    }
}