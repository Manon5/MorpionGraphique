package graphic;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import working.*;

public class ValidateButton extends JButton implements MouseListener {	
	
	// ---------------- Attributs ------------- //
	
	private String name;
	private JFormattedTextField textArea;
	private boolean isPressed;
	private Window window;
	
	
	// ---------------- Methodes -------------- //
	
	
	public ValidateButton(String str, JFormattedTextField txtField, Window pwindow){
		super(str);
		textArea = txtField;
		name = str;
		window = pwindow;
		this.addMouseListener(this);
	}

	// Accesseurs / Mutateurs
	
	public boolean isPressed(){
		return isPressed;
	}
	
	public void setIsPressed(boolean bool){
		isPressed = bool;
	}
	
	
	
	
	// Mouse Listener methodes
	
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
	public void mousePressed(MouseEvent e) {
		isPressed = true;
		window.getSaisie();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		window.clearSaisie();
		
	}

	@Override
	public void mouseReleased(MouseEvent e){ 
		
	}

}
