package ZadaniaWlasne.Zadania.calculator.calculator;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:26
 */
public interface ICalculator extends IPressnNumber {

    void pressNumber(Object number);
    String display();
    String memoryDisplay();
    void add();
    void sub();
    void div();
    void multi();

    void result();

    void clearDisplay();
    void clearEverything();

    void plusMinus();
}
