package ZadaniaWlasne.Zadania.calculator.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:25
 */
public class Calculator implements ICalculator, IPressnNumber, IOperation {
    String disp = "0";
    String mem = "0";

    char operation = '=';


    @Override
    public void pressNumber(Object number) {
        if (isZeroOrError())
            disp = number.toString();
        else
            disp = new StringBuilder(disp).append(number).toString();
    }

    @Override
    public String display() {
        if (disp.equals("E"))
            return "E";
        NumberFormat formatter = new DecimalFormat("0.#########");
        return formatter.format(Double.parseDouble(disp));
    }

    @Override
    public String memoryDisplay(){
        NumberFormat formatter = new DecimalFormat("0.#########");
        String result = formatter.format(Double.parseDouble(mem));
        result += " "+operation;

        return result;
    }

    @Override
    public void add() {
        doOperation();
        operation = '+';
        storeMem();
    }

    @Override
    public void sub() {
        doOperation();
        operation = '-';
        storeMem();
    }

    @Override
    public void div() {
        doOperation();
        operation = '/';
        storeMem();
    }

    @Override
    public void multi() {
        doOperation();
        operation = '*';
        storeMem();
    }

    private void storeMem() {
        if (!disp.equals("0")) {
            mem = disp;
            disp = "0";
        }
    }

    private Double toCalc(String val) {
        return Double.parseDouble(val);
    }

    @Override
    public void result() {
        doOperation();
        operation = '=';
    }

    @Override
    public void clearDisplay() {
        disp = "0";
    }

    @Override
    public void clearEverything() {
        disp = "0";
        mem = "0";
        operation = '=';
    }

    @Override
    public void plusMinus() {
        disp = Double.toString(-1.0 * toCalc(disp));

    }

    private void doOperation() {
        switch (operation) {
            case '+':
                disp = Double.toString(toCalc(mem) + toCalc(disp));
                break;
            case '-':
                disp = Double.toString(toCalc(mem) - toCalc(disp));
                break;
            case '*':
                disp = Double.toString(toCalc(mem) * toCalc(disp));
                break;
            case '/':
                if (isZeroOrError())
                    disp = "E";
                else
                    disp = Double.toString(toCalc(mem) / toCalc(disp));
        }
    }

    private boolean isZeroOrError() {
//        return disp.equals("0") || disp.equals("E");
        return disp.equals("E");
    }
}