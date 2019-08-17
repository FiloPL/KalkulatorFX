package ZadaniaWlasne.Zadania.calculator.calculator;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:29
 */
public interface IOperation {
    void add();
    void sub();
    void div();
    void multi();

    void result();

    void clearDisplay();
    void clearEverything();

    void plusMinus();
}
