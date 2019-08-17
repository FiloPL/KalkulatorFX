package ZadaniaWlasne.Zadania.calculator;

import ZadaniaWlasne.Zadania.calculator.background.CalculatorApp;
import ZadaniaWlasne.Zadania.calculator.background.IWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Tomasz Filo Zegarlicki
 * [https://github.com/FiloPL]
 * @date : 17.08.2019 17:25
 */
public class App extends Application{
    public static void main( String[] args )
    {
        System.out.println( "Calculator v1.02" );
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        IWindow calc = new CalculatorApp(primaryStage);
        calc.show();

    }
}