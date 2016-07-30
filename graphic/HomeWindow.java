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
	
	private  JButton play =  new JButton("Jouer");
	private JButton quit = new JButton("Quitter");
	private JButton credit = new JButton("Crédits");
	
	// ----------- Methodes --------- //
	
	public HomeWindow(){
		// Mise en place des éléments
		this.setLayout(new GridLayout(3, 1));
		this.getContentPane().add(play);
		this.getContentPane().add(quit);
		this.getContentPane().add(credit);
		
		
		this.setTitle("Morpion");
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    this.setResizable(false);
	    this.setVisible(true);
	}

	
	
}
