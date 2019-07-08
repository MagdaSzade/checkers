package consoleMode.CommunicationWithPlayerConsoleMode;

import java.util.Scanner;

import boardElements.Position;
import boardElements.PositionError;
import boardElements.Board;
import boardElements.Player;
import checkers.PlayerAnswerValidation;
import interfaces.CommunicationWithPlayerInterface;

public class CommunicationWithThePlayer implements CommunicationWithPlayerInterface {
    Scanner scanner = new Scanner(System.in);
    PlayerAnswerValidation validator = new PlayerAnswerValidation();

    
    public void welcomeMassage() {
    	System.out.println("Hello! Zaczynamy grê w warcaby!");
    }


	@Override
	public String setName(String player) {
		String name = null;
		System.out.println("Podaj swoje imiê " + player + ":");
		name = scanner.next();
		return name;
	}


	@Override
	public boolean setOponentType() {
		boolean isHuman = true;
		boolean isAnswerValid = false;
		
		while (!isAnswerValid) {
			System.out.println("Wybierz przeciwnika:");
			System.out.println("1. komputer");
			System.out.println("2. cz³owiek");
			String answer = scanner.next();
			isAnswerValid = validator.isHumanValid(answer);
			if (isAnswerValid) {
				switch (answer) {
				case "1" : isHuman = false;
				break;
				case "2" : isHuman = true;
				break;
				} 
			} else {
				System.out.println("Niepoprawnie wybrany przeciwnik. Spróbuj jeszcze raz.");
			}
		}
		return isHuman;
	}


	@Override
	public boolean setColoure() {
		boolean colour = true;		
		boolean isAnswerValid = false;
		
		while (!isAnswerValid) {
			System.out.println("Wybierz kolor pionków:");
			System.out.println("1. czarne");
			System.out.println("2. bia³e");
			String answer = scanner.next();
			isAnswerValid = validator.isColourValid(answer);
			if (isAnswerValid) {
				switch (answer) {
				case "1" : colour = false;
				break;
				case "2" : colour = true;
				break;
				}
			} else {
				System.out.println("Niepoprawnie wybrany kolor. Spróbuj jeszcze raz.");
			}
		}
		return colour;
	}


	@Override
	public Position selectFigure(Board board, Player player) {
		boolean isAnswerCorrect = false;
		Position figurePosition = null;
		while (!isAnswerCorrect) {
			System.out.println("Twój ruch. Wybierz pionek.");
			String position = scanner.next();
			try {
				figurePosition = new Position(position);
				if (validator.isStartingPositionValid(board, player.getColour())) {
					isAnswerCorrect = true;
				} else {
					System.out.println("Spróbuj jeszcze raz.");
				}
			} catch (PositionError e) {
				System.out.println("Niepoprawny format.");
			}
		}
		return figurePosition;
	}

	@Override
	public Position selectEndPosition(Board board, Player player, Position startPosition) {
		boolean isAnswerCorrect = false;
		Position endPosition = null;
		while (!isAnswerCorrect) {
			System.out.println("Na którym polu chcesz zakoñczyæ ruch?");
			String position = scanner.next();
			try {
				endPosition = new Position(position);
				if (validator.isEndPositionValid(board, player.getColour(), startPosition)) {
					isAnswerCorrect = true;
				} else {
					System.out.println("Niepoprawny ruch. Spróbuj jeszcze raz.");
				}
			} catch (PositionError e) {
				System.out.println("Niepoprawny format.");
			}
		}
		return endPosition;
	}

}
