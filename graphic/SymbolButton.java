package graphic;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class SymbolButton extends JButton implements MouseListener {
	
	// ------------- Attributs ------------- //
	
	private char symbol;
	private boolean isPressed;
	
	// ----------- Methodes --------- //
	
	public SymbolButton(char carac, String str, int h, int l){
		super(str);
		symbol = carac;
		isPressed = false;
		Dimension size = new Dimension(h, l);
		this.addMouseListener(this);
		this.setPreferredSize(size);
	}
	
	public boolean getIsPressed(){
		return isPressed;
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
}
