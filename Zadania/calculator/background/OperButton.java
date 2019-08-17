package ZadaniaWlasne.Zadania.calculator.background;

import ZadaniaWlasne.Zadania.calculator.calculator.IOperation;

import static ZadaniaWlasne.Zadania.calculator.background.BackgroundFactory.RED;
import static ZadaniaWlasne.Zadania.calculator.background.BackgroundFactory.YELLOW;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:50
 */
public class OperButton extends ClickButton {
    private final String operation;
    private final IOperation operations;
    private final IRefresh refresh;

    public OperButton(String operation, IOperation operations, IRefresh refresh) {
        super(operation);
        this.operation = operation;
        this.operations = operations;
        this.refresh = refresh;


        if (operation.contains("C"))
            this.setBackground(RED.value());
        else
            this.setBackground(YELLOW.value());

        this.setOnMouseClicked(event -> {
            doOperation();
            refresh.refreshControls();
        });

    }

    private void doOperation() {
        switch (operation) {
            case "+":
                operations.add();
                break;
            case "-":
                operations.sub();
                break;
            case "×":
                operations.multi();
                break;
            case "÷":
                operations.div();
                break;
            case "C":
                operations.clearDisplay();
                break;
            case "CE":
                operations.clearEverything();
                break;
            case "±":
                operations.plusMinus();
                break;
            default:
                operations.result();
        }
    }
}