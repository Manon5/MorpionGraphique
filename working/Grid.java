package working;

public class Grid {
	
	
	// Attributs
		private char[] tab;
		private int moves;
	
	
	
	// Methodes
		
		//Constructeur
		public Grid(char[] pGrid){
			tab = pGrid;
			moves = 0;
		}
		
		
		
		// Accesseurs
		
			public char[] getGrid(){
				return tab;
			}
			
			public int getMoves(){
				return moves;
			}
			
			public char getSquare(int number){
				char square;
				square = tab[number-1];
				return square;
			}
			
		// Mutateurs
			
			public void setGrid(int answer, char character){
				switch(answer){
					case 1:
						tab[0] = character;
						break;
					case 2:
						tab[1] = character;
						break;
					case 3:
						tab[2] = character;
						break;
					case 4:
						tab[3] = character;
						break;
					case 5:
						tab[4] = character;
						break;
					case 6:
						tab[5] = character;
						break;
					case 7:
						tab[6] = character;
						break;
					case 8:
						tab[7] = character;
						break;
					case 9:
						tab[8] = character;
						break;
				}
			}
			
			public void setMoves(){
				moves++;
			}
			
			public void reset(){
				tab[0] = '1';
				tab[1] = '2';
				tab[2] = '3';
				tab[3] = '4';
				tab[4] = '5';
				tab[5] = '6';
				tab[6] = '7';
				tab[7] = '8';
				tab[8] = '9';
				moves = 0;
			}
			
			
		// Autres
			
			
			
			// Verifie si la grille est pleine
			public boolean isFull(){
				boolean isFull;
				if(moves >= 9){
					isFull = true;
				}else{
					isFull = false;
				}
				return isFull;
			}
			
			// Verifie si un des joueurs a gagné
			public boolean playerWin(){
				boolean pwin;
				if(tab[0] == tab[1] && tab[2] == tab[1]){
					pwin = true;
				}else if(tab[3] == tab[4] && tab[4] == tab[5]){
					pwin = true;
				}else if(tab[6] == tab[7] && tab[7] == tab[8]){
					pwin = true;
				}else if(tab[0] == tab[3] && tab[3] == tab[6]){
					pwin = true;
				}else if(tab[1] == tab[4] && tab[4] == tab[7]){
					pwin = true;
				}else if(tab[2] == tab[5] && tab[5] == tab[8]){
					pwin = true;
				}else if(tab[0] == tab[4] && tab[4] == tab[8]){
					pwin = true;
				}else if(tab[6] == tab[4] && tab[4] == tab[2]){
					pwin = true;
				}else{
					pwin = false;
				}
				return pwin;
			}
			
			// Verifie si la case choisie est valide
			public boolean squareValid(int answer, char playerOneSign, char playerTwoSign){
				char square = 'R';
				boolean valid;
				if(answer <= 0){
					valid = false;
				}else if (answer >= 10){
					valid = false;
				}else {
					square = getSquare(answer);
					if(square == playerOneSign || square == playerTwoSign){
					valid = false;
				}else{
					valid = true;
				}
				
				}
				return valid;
			
				
			}
			




}



