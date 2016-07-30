import java.util.InputMismatchException;
import java.util.Scanner;
import working.*;
import graphic.*;


public class main {

	public static void main(String[] args) {
		
		Window window = new Window();
		String playerName1;
		String playerName2;
		String symbol;
		char symbol1 = ' ';
		int isBoxPressed = 0;
		char symbol2 = ' ';
		String sPlayAgain;
		char playAgain;
		int answer;
		char[] tab = {'1', '2', '3', 'O', '5', '6', '7', '8', '9'};
		Grid grid = new Grid(tab);
		Scanner sc = new Scanner(System.in);
		Scanner sString = new Scanner(System.in);
		grid.reset();
		window.update('X', 'O', grid);
		window.setText("\n**************** \n  Jeu du morpion \n*************** \n ");
		window.setAllEnabled(false);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		window.setText("Joueur 1, quel est votre nom ?");
		while(window.isValidatePressed() == false){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		window.setValidate(false);
		playerName1 = window.getSaisie();
		window.setValidate(false);
		window.setText("Bienvenue, " + playerName1 + " ! Avec quel symbole souhaitez-vous jouer ?");
		while(window.isValidatePressed() == false){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		window.setValidate(false);
		symbol = window.getSaisie();
		symbol1 = symbol.charAt(0);
		window.setText("Merci ! Joueur 2, quel est votre nom ?");
		while(window.isValidatePressed() == false){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		window.setValidate(false);
		playerName2 = window.getSaisie();
		window.setText("Bienvenue, " + playerName2 + " ! Avec quel symbole souhaitez-vous jouer ?");
		while(window.isValidatePressed() == false){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		window.setValidate(false);
			symbol2 = window.getSaisie().charAt(0);
			if(symbol1 == symbol2){
				while(symbol1==symbol2){
					window.setText("Le symbole entré est le même que pour le joueur 1. Veuillez choisir un autre symbole");
					while(window.isValidatePressed() == false){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				window.setValidate(false);
				symbol2 = window.getSaisie().charAt(0);
				}
				
		}
			}
		window.setValidate(false);
		symbol = window.getSaisie();
		symbol2 = symbol.charAt(0);
		Player playerOne = new Player(playerName1, symbol1, 1);
		Player playerTwo = new Player(playerName2, symbol2, 2);
		window.setText("Merci, la partie peut commencer.");
		window.setAllEnabled(true);
		
		// ----------- Commencement du tour de jeu ! ----------- //
		do{
		window.setValidate(false);
		playAgain = 'N';
		grid.reset();
		window.update(symbol1, symbol2, grid);
		
		
		while(grid.isFull() == false && grid.playerWin() == false){
			window.setText("Au tour de " + playerOne.getName() + " ! Veuillez choisir une case");
			answer = 0;
			while(answer == 0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					answer = window.isBoxPressed();
				}
				
			}
			playerOne.play(answer, grid, window, symbol1, symbol2);
			window.update(symbol1, symbol2, grid);
			window.setBoxPressed(false);
			if(grid.isFull() == true || grid.playerWin() == true){
				
			}else{
				window.setText("Au tour de " + playerTwo.getName() + " ! Veuillez choisir une case");
				answer = 0;
				while(answer == 0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally{
						answer = window.isBoxPressed();
					}					
				}
				playerTwo.play(answer, grid, window, symbol2, symbol1);
				window.update(symbol1, symbol2, grid);
				window.setBoxPressed(false);
			}
			}
		if(grid.getMoves() == 9){
			window.setText("La grille est pleine !");
		}else if(grid.getMoves()%2 == 0){
			window.setText(playerTwo.getName() + " a gagné !");
		}else{
			window.setText(playerOne.getName() + " a gagné !");
		}
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window.setText("Voulez-vous recommencer ?");
		while(window.isValidatePressed() == false){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		playAgain = window.getSaisie().charAt(0);
		
		}while(playAgain == 'O');	
		
		window.setText("Au revoir !");
	}	
		
	}


