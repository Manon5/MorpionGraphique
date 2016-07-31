package graphic;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class HomeButton extends JButton implements MouseListener {

	// ------------- Attributs ------------- //
	
	private int number;
	private String label = new String();
	private boolean isPressed;
	
	// ----------- Methodes --------- //
	
	public HomeButton(int pNumber, String pLabel){
		super(pLabel);
		label = pLabel;
		number = pNumber; 
		isPressed = false;

	    this.addMouseListener(this);
	}
	
	
	// Mouse Listener

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {		
		isPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	
	// Accesseurs
	
	public boolean getIsPressed(){
		return isPressed;
	}
	
}
