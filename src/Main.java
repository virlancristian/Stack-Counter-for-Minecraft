import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StackCalculator calculator = new StackCalculator();

        UserInterface.createInterface();
        System.out.println("Welcome to the Minecraft Stack Counter!");

        calculator.run();

        System.out.println("Feel free to close this windows after the app closes");
        System.out.println("App closing...");
    }
}
