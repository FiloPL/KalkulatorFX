package ZadaniaWlasne.Zadania.calculator.background;

import ZadaniaWlasne.Zadania.calculator.calculator.Calculator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static ZadaniaWlasne.Zadania.calculator.background.BackgroundFactory.GRAY;
import static ZadaniaWlasne.Zadania.calculator.background.BackgroundFactory.WHITE;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:44
 */


public class CalculatorApp implements IWindow, IRefresh {

    private final Stage primaryStage;
    private final String[][] buttons = {
            {"1", "."}, {"2", "."}, {"3", "."}, {"+", "s"},
            {"4", "."}, {"5", "."}, {"6", "."}, {"-", "s"},
            {"7", "."}, {"8", "."}, {"9", "."}, {"×", "s"},
            {"0", "."}, {".", "."}, {"00", "."}, {"÷", "s"},
            {"±", "s"}, {"C", "s"}, {"CE", "s"}, {"=", "s"}
    };
    private Label lblDisplay;
    private Label lblMemDisplay;
    private Calculator calculator;


    public CalculatorApp(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        primaryStage.setTitle("Calculator v1.02");

        calculator = new Calculator();
    }

    @Override
    public void show() {

        VBox back = new VBox();

        back.getChildren().add(getSpace());
        back.getChildren().add(getMemoryDisplay());
        back.getChildren().add(getDisplay());
        back.getChildren().add(getSpace());
        back.getChildren().add(getKeyboard());
        back.setBackground(GRAY.value());

        Scene scene = new Scene(back, 222, 364);
        primaryStage.setScene(scene);
        primaryStage.show();


        refreshControls();
    }

    private Node getKeyboard() {
        HBox keyboard = new HBox();

        keyboard.getChildren().add(getSpace());

        GridPane keys = new GridPane();
        keys.setVgap(8);
        keys.setHgap(8);

        for (int i = 0; i < buttons.length; i++)
            addCalcButton(keys, i);

        keyboard.getChildren().add(keys);

        return keyboard;
    }

    private Node getMemoryDisplay() {
        HBox box = new HBox();

        box.getChildren().add(getSpace());

        lblMemDisplay = new Label("123456 +");
        lblMemDisplay.setMinWidth(216);

        lblMemDisplay.setFont(Font.font("", FontWeight.BOLD, 16));
//        lblDisplay.setTextAlignment(TextAlignment.RIGHT);
//        lblDisplay.setAlignment(Pos.CENTER_RIGHT);
        lblMemDisplay.setBackground(WHITE.value());

        box.getChildren().add(lblMemDisplay);
        box.getChildren().add(getSpace());

        return box;
    }

    private Node getDisplay() {
        HBox box = new HBox();

        box.getChildren().add(getSpace());

        lblDisplay = new Label("123456");
        lblDisplay.setMinWidth(216);

        lblDisplay.setFont(Font.font("", FontWeight.BOLD, 36));
        lblDisplay.setTextAlignment(TextAlignment.RIGHT);
        lblDisplay.setAlignment(Pos.CENTER_RIGHT);
        lblDisplay.setBackground(WHITE.value());

        box.getChildren().add(lblDisplay);
        box.getChildren().add(getSpace());

        return box;
    }

    private Node getSpace() {
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(8, 8);
        return borderPane;
    }

    private void addCalcButton(GridPane gridPane, int index) {
        Button btn;
        if (buttons[index][1].equals(".")) {
            // digit button
            btn = new DigitButton(buttons[index][0], calculator, this);
            btn.setMinSize(48, 48);
            btn.setFont(Font.font("", FontWeight.BOLD, 18));
        } else {
            //special button
            btn = new OperButton(buttons[index][0], (Calculator) calculator, this);
            btn.setMinSize(48, 48);
            btn.setFont(Font.font("", FontWeight.BOLD, 18));
        }
        gridPane.add(btn, index % 4, index / 4);
    }


    @Override
    public void refreshControls() {
        lblDisplay.setText(calculator.display());
        lblMemDisplay.setText(calculator.memoryDisplay());
    }
}