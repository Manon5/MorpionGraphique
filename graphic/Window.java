package graphic;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import working.*;

public class Window extends JFrame {
	
	
	// ------------- Attributs ------------- //
	
	private JLabel message = new JLabel("Bienvenue !");	
	private JFormattedTextField saisie;
	private String textSaisie = new String();
	private ValidateButton button = new ValidateButton("Valider", saisie, this);
	private SymbolButton XButton = new SymbolButton('X', "X", 250, 50);
	private SymbolButton OButton = new SymbolButton('O', "O", 250, 50);
	private MorpionCell one = new MorpionCell(1);
	private MorpionCell two = new MorpionCell(2);
	private MorpionCell three = new MorpionCell(3);
	private MorpionCell four = new MorpionCell(4);
	private MorpionCell five = new MorpionCell(5);
	private MorpionCell six = new MorpionCell(6);
	private MorpionCell seven = new MorpionCell(7);
	private MorpionCell eight = new MorpionCell(8);
	private MorpionCell nine = new MorpionCell(9);
	
	private JPanel south = new JPanel();
	private BorderLayout layout = new BorderLayout(4, 4);
	private JPanel up = new JPanel();
	private BorderLayout upLayout = new BorderLayout();
	
	private ReplayButton yes = new ReplayButton(true, "Yes", 250, 50);
	private ReplayButton no = new ReplayButton(false, "No", 250, 50);
	
	
	// ----------- Methodes --------- //
	
	
	//Constructeur
	public Window(){
		// Mise en place des composants
		
		// Creation du JPanel principal
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(500, 700));
		try {
			MaskFormatter formatter = new MaskFormatter("???????");
			JFormattedTextField pSaisie = new JFormattedTextField(formatter);
			
			saisie = pSaisie;
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		saisie.requestFocus(true);
		
		// Parametres partie sup
		up.setPreferredSize(new Dimension(500, 200));
		
		up.setLayout(upLayout);
			// Ajout du JLabel
			JPanel messageP = new JPanel();
			messageP.setBackground(Color.WHITE);
			messageP.add(message);
			Font font = new Font("Tahoma", Font.PLAIN, 25);
			message.setHorizontalAlignment(JLabel.CENTER);
			message.setFont(font);
			up.add(message, upLayout.NORTH);
			// Ajout de la zone de saisie
			south.setLayout(layout);
			up.add(south, upLayout.SOUTH);
			saisie.setFont(font);
			south.add(saisie, layout.CENTER);
			south.add(button, layout.EAST);
		
			
			
			
		// Parametres partie inf
		JPanel down = new JPanel();
		down.setPreferredSize(new Dimension(450, 450));
		down.setBackground(Color.MAGENTA);
		down.setLayout(new GridLayout(3, 3));
		down.add(one);
	    down.add(two);
	    down.add(three);
	    down.add(four);
	    down.add(five);
	    down.add(six);
	    down.add(seven);
	    down.add(eight);
	    down.add(nine);
		
		// Ajout des JPanel au JPanel principal
		content.add(up);
		content.add(down);
		
		this.setContentPane(content);
		// Parametres
		this.setTitle("Morpion");
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    this.setResizable(false);
	    this.setVisible(true);
	    
	    
	}
	
	
	public void update(char signOne, char signTwo, Grid grid){
		char[] tab = grid.getGrid();
		int i = 0;
		for(i = 0; i <= 8; i++){
		if(tab[i] == signOne){
			this.checkBox(1, signOne, i);
		}else if(tab[i] == signTwo){
			this.checkBox(2, signTwo, i);
		}else{
			 int j = i + 1;
			 String number = new String("" + j);
			 char carac = ' ';
			this.checkBox(3, carac, i);
		}
		}
	}
	
	public void clearSaisie(){
		saisie.setText(null);
	}
		
	
	
	public void checkBox(int playerNumber, char sign, int boxNumber){
		String sSign = new String("" + sign);
		switch(boxNumber){
		case 0:
			one.isTicked(playerNumber, sSign);
			break;
		case 1:
			two.isTicked(playerNumber, sSign);
			break;
		case 2:
			three.isTicked(playerNumber, sSign);
			break;
		case 3:
			four.isTicked(playerNumber, sSign);
			break;
		case 4:
			five.isTicked(playerNumber, sSign);
			break;
		case 5:
			six.isTicked(playerNumber, sSign);
			break;
		case 6:
			seven.isTicked(playerNumber, sSign);
			break;
		case 7:
			eight.isTicked(playerNumber, sSign);
			break;
		case 8:
			nine.isTicked(playerNumber, sSign);
			break;
		}
	}
	
	
	public void setText(String text){
		message.setText(text);
	}
	
	
	public boolean isValidatePressed(){
		return button.isPressed();
	}
	
	
	public String getSaisie(){
		textSaisie = saisie.getText();
		return textSaisie;
	}
	
	public void setValidate(boolean bool){
		button.setIsPressed(bool);
	}
	
	public int getBoxTicked(int number){
		return number;
	}
	
	public int isBoxPressed(){
		int i = 0;
		if(one.isPressed() == true){
			i = 1;
		}else if(two.isPressed() == true){
			i = 2;
		}else if(three.isPressed() == true){
			i = 3;
		}else if(four.isPressed() == true){
			i = 4;
		}else if(five.isPressed() == true){
			i = 5;
		}else if(six.isPressed() == true){
			i = 6;
		}else if(seven.isPressed() == true){
			i = 7;
		}else if(eight.isPressed() == true){
			i = 8;
		}else if(nine.isPressed() == true){
			i = 9;
		}else{
			i = 0;
		}
		return i;
		
		}
	
	public void setBoxPressed(boolean bool){
		one.setPressed(bool);
		two.setPressed(bool);
		three.setPressed(bool);
		four.setPressed(bool);
		five.setPressed(bool);
		six.setPressed(bool);
		seven.setPressed(bool);
		eight.setPressed(bool);
		nine.setPressed(bool);
	}
	
	public void setDeactivate(int x){
		switch(x){
		case 1: 
			one.deactivate();
			break;
		case 2:
			two.deactivate();
			break;
		case 3:
			three.deactivate();
			break;
		case 4:
			four.deactivate();
			break;
		case 5:
			five.deactivate();
			break;
		case 6:
			six.deactivate();
			break;
		case 7:
			seven.deactivate();
			break;
		case 8:
			eight.deactivate();
			break;
		case 9:
			nine.deactivate();
			break;
		}}
		
	public void setAllDeactivate(){
		one.deactivate();
		two.deactivate();
		three.deactivate();
		four.deactivate();
		five.deactivate();
		six.deactivate();
		seven.deactivate();
		eight.deactivate();
		nine.deactivate();
	}
	
	public void setAllActivate(){
		one.activate();
		one.setTicked(false);
		two.activate();
		two.setTicked(false);
		three.activate();
		three.setTicked(false);
		four.activate();
		four.setTicked(false);
		five.activate();
		five.setTicked(false);
		six.activate();
		six.setTicked(false);
		seven.activate();
		seven.setTicked(false);
		eight.activate();
		eight.setTicked(false);
		nine.activate();
		nine.setTicked(false);
	}
	
	public void setAllEnabled(boolean bool){
		one.setEnabled(bool);
		two.setEnabled(bool);
		three.setEnabled(bool);
		four.setEnabled(bool);
		five.setEnabled(bool);
		six.setEnabled(bool);
		seven.setEnabled(bool);
		eight.setEnabled(bool);
		nine.setEnabled(bool);
	}
	
	
	public void changeLayoutToChooseSymbol(){
		south.remove(saisie);
		south.remove(button);
		south.add(XButton, layout.WEST);
		south.add(OButton, layout.EAST);
	}
	
	public void changeLayoutToEnterName(){
		south.remove(XButton);
		south.remove(OButton);
		south.add(saisie, layout.CENTER);
		south.add(button, layout.EAST);
	}
	
	public char getSymbol(){
		char symbol = ' ';
		
		if(XButton.getIsPressed() == true){
			symbol = 'X';
		}else if(OButton.getIsPressed() == true){
			symbol = 'O';
		}else {
			symbol = ' ';
		}
		
		return symbol;
	}
	
	public void setLayoutForGame(){
		south.remove(saisie);
		south.remove(button);
		int y = 700;
		int x = 200;
		while(x > 50){
			this.setSize(new Dimension(500, y));
			up.setPreferredSize(new Dimension(500, x));
			up.repaint();
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y = y - 1;
			x = x - 1;
		}

	}
	
	
	
	public void setLayoutToReplay(){
		int x = 50;
		int y = 550;
		while(x < 100){
			this.setSize(new Dimension(500, y));
			up.setPreferredSize(new Dimension(500, x));
			up.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x = x + 1;
			y = y + 1;
		}

	}
		
		
	
		
	}

