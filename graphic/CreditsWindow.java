import javax.swing.JFrame;

public class CreditsWindow extends JFrame {
	// ------------- Attributs ------------- //
	
	
	
	// ----------- Methodes --------- //
	
	
	public CreditsWindow(){
		this.setTitle("Crédits");
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    this.setResizable(false);
	    this.setVisible(true);
	}
	
}
