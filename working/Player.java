package working;
import java.util.Scanner;

import graphic.Window;

public class Player {

	// Attributs
	
		private String name;
		private char symbol;
		private int number;
		private int numberOfMoves;
	
	// Methodes
		
		//Constructeur
		public Player(String pName, char psymbol, int pnumber){
			name = pName;
			symbol = psymbol;
			number = pnumber;
			numberOfMoves = 0;
		}
		

		
		//Accesseurs
		
			public String getName(){
				return name;
			}
			
			
			public char getSymbol(){
				return symbol;
			}
			
			
			public int getNumber(){
				return number;
			}
			
			
			public int getNumberOfMoves(){
				return numberOfMoves;
			}
	
			
			
		//Autres
			
			public void play(int answer, Grid grid, Window window, char symbol, char symbolOfOpponent){
				
				if(grid.squareValid(answer, symbol, symbolOfOpponent) == true){
					System.out.println(" TEST ");
					grid.setGrid(answer, symbol);
					numberOfMoves++;
					grid.setMoves();
					window.setDeactivate(answer);
				}else{
					window.setText("Au tour de " + this.getName() + " ! Veuillez choisir une case");
					answer = 0;
					
					System.out.println("FAIL");
					while(answer == 0){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}finally{
							answer = window.isBoxPressed();
						}
						
						
					}
					window.setBoxPressed(false);
					this.play(answer, grid, window, symbol, symbolOfOpponent);
				}
				
			}
	
}
