package graphic;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MorpionCell extends JButton implements MouseListener {
		
	// ------------ Attributs ------------- //
	
	private String name = " ";
	private int number;
	private Color initialBackground = this.getBackground();
	private boolean isTicked;
	private boolean isLocked;
	

	
	// ------------ Methodes -------------- //
	
	public MorpionCell(int pnumber) {
		super(" ");
		number = pnumber;
		Font font = new Font("Tahoma", Font.BOLD, 56);
		this.setFont(font);
		this.addMouseListener(this);
	}

	public void isTicked(int playerNumber, String sign){
			if(playerNumber == 1){
			this.setBackground(Color.red);
		}else if(playerNumber == 2){
			this.setBackground(Color.blue);
		}else{
			this.setBackground(initialBackground);
		}
		this.setText(sign);
		}
		
		
	
	
	public void setTicked(boolean bool){
		isTicked = bool;
	}

	public boolean isPressed(){
		return isTicked;
	}
	
	public void setPressed(boolean bool){
		isTicked = bool;
	}
	
	
	public void deactivate(){
		this.setLocked();
	}
	
	public void activate(){
		this.addMouseListener(this);
	}
	
	public void setLocked(){
		isLocked = true;
	}
	
	
	// MouseListener methodes
	
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
		isTicked = true;		
	}

	

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
	
}
