package checkers;

import java.util.Scanner;

public class CommunicationWithThePlayer {
    Scanner scanner = new Scanner(System.in);
    PlayerAnswerValidation validator = new PlayerAnswerValidation();

    public String choseSetGameMode() {
        System.out.println("Hello! Zaczynamy grę w warcaby! Czy chcesz zagrać przeciwko: " +
                "\n[1] komputerowi " +
                "\n[2] człowiekowi" +
                "\n[q] rozmyśliłem się i nie chcę grać.");
        String gameMode = scanner.nextLine();
        while(!validator.isValid1or2(gameMode)) {
            System.out.println("Niestety wprowadzona wartość jest niepoprawna! " +
                    "Wybierz czy chcesz zagrać przeciwko: " +
                    "\n[1] komputerowi " +
                    "\n[2] człowiekowi" +
                    "\n[q] rozmyśliłem się i nie chcę grać.");
            gameMode = scanner.nextLine();
        }
        return gameMode;
    }


    public String chosePlayer1Name() {
        System.out.println( "Podaj swoje imię: ");
        String name = scanner.nextLine();
        return name;
    }

}
