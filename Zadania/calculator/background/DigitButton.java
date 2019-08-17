package ZadaniaWlasne.Zadania.calculator.background;

import ZadaniaWlasne.Zadania.calculator.calculator.Calculator;
import ZadaniaWlasne.Zadania.calculator.calculator.IPressnNumber;

import static ZadaniaWlasne.Zadania.calculator.background.BackgroundFactory.*;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:47
 */

public class DigitButton extends ClickButton {
    private final String digit;
    private final IPressnNumber pressNumber;
    private final IRefresh refresh;

    public DigitButton(String digit, Calculator pressNumber, IRefresh refresh ) {
        super(digit);
        this.digit = digit;
        this.pressNumber = pressNumber;
        this.refresh = refresh;

        this.setBackground(WHITE.value());

        this.setOnMouseClicked(event -> {
            pressNumber.pressNumber(digit);
            refresh.refreshControls();});
    }
}