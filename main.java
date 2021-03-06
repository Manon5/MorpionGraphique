import java.util.InputMismatchException;
import java.util.Scanner;
import working.*;
import graphic.*;


public class main {

	public static void main(String[] args) {
		// Initialisation des variables & objets
		String playerName1;
		String playerName2;
		String symbol;
		char symbol1 = ' ';
		int isBoxPressed = 0;
		char symbol2 = ' ';
		char playAgain;
		int answer;
		int answerAtHome = 0;
		char[] tab = {'1', '2', '3', 'O', '5', '6', '7', '8', '9'};
		Grid grid = new Grid(tab);
		Scanner sc = new Scanner(System.in);
		int score1;
		int score2;
		// Page d'accueil
		
		HomeWindow homeWindow = new HomeWindow();
		while(answerAtHome == 0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				answerAtHome = homeWindow.buttonPressed();
				System.out.println(answerAtHome);
			}
			
		}
		
		if(answerAtHome == 2){
			// Si "quitter" est press�
			homeWindow.dispose();
		}else if(answerAtHome == 3){
			// Si "Cr�dits" est press�
			homeWindow.dispose();
		}else{
			// Commencement du jeu
			score1 = 0;
			score2 = 0;
			Window window = new Window();
			homeWindow.dispose();
			grid.reset();
			window.update('X', 'O', grid);
			window.setText("\n****** \n  Jeu du morpion \n****** \n ");
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
			if(playerName1.equals("       ")){
				while(playerName1.equals("       ")){
					window.setText("Ce nom n'est pas valide. Joueur 1, quel est votre nom ?");
					while(window.isValidatePressed() == false){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					window.setValidate(false);
					playerName1 = window.getSaisie();
				}
			}
			
			
			playerName1.replaceAll(" ", "");
			
			
			
			window.setValidate(false);
			window.changeLayoutToChooseSymbol();
			window.setText("<html> Bienvenue, " + playerName1 + " ! Avec quel symbole <br>  souhaitez-vous jouer ? </html>");
			while(window.getSymbol() == ' '){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			symbol1 = window.getSymbol();
			window.changeLayoutToEnterName();
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
			if(playerName2.equals("       ")){
				while(playerName2.equals("       ")){
					window.setText("Ce nom n'est pas valide. Joueur 2, quel est votre nom ?");
					while(window.isValidatePressed() == false){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					window.setValidate(false);
					playerName2 = window.getSaisie();
				}
			}	
			playerName2.replaceAll(" ", "");
			if (symbol1 == 'X'){
				symbol2 = 'O';
			}else {
				symbol2 = 'X';
			}
			window.setText("<html>Bienvenue, " + playerName2 + " ! Vous jouerez avec <br>le  symbole " + symbol2 + "</html>");
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			
			
			Player playerOne = new Player(playerName1, symbol1, 1);
			Player playerTwo = new Player(playerName2, symbol2, 2);
			window.setText("Merci, la partie peut commencer.");
			window.setAllEnabled(true);
			window.setLayoutForGame();
			
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
				window.setText(playerTwo.getName() + " a gagn� !");
				score2++;
			}else{
				window.setText(playerOne.getName() + " a gagn� !");
				score1++;
			}
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			window.setLayoutToReplay();
			window.setText("Voulez-vous recommencer ? (Score : " + score1 + " / " + score2 + ")");
			while(window.getReplay() == ' '){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			playAgain = window.getReplay();
			window.resetReplay();
			window.resetLayoutReplay();
			
			}while(playAgain == 'Y');	
			
			window.setText("Au revoir !");
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			window.dispose();
		}	
		}
		
		
		
	}


