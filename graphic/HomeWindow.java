package graphic;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;
import working.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeWindow extends JFrame {
	
	// ------------- Attributs ------------- //
	
	private  HomeButton play =  new HomeButton(1, "Jouer");
	private HomeButton quit = new HomeButton(2, "Quitter");
	private HomeButton credit = new HomeButton(3, "Crédits");
	
	// ----------- Methodes --------- //
	
	public HomeWindow(){
		// Mise en place des éléments
		this.setLayout(new GridLayout(3, 1));
		this.getContentPane().add(play);
		this.getContentPane().add(quit);
		this.getContentPane().add(credit);
		
		
		this.setTitle("Accueil");
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    this.setResizable(false);
	    this.setVisible(true);
	}
	
	public int buttonPressed(){
		int number = 0;
		if(play.getIsPressed() == true){
			number = 1;
		}else if(quit.getIsPressed() == true){
			number = 2;
		}else if(credit.getIsPressed() == true){
			number = 3;
		}else{
			number = 0;
		}
		return number;
	}

	
	
}
