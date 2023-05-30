import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class CardsPanel extends JPanel{
	
	int numButtons;
	String[] pics = {"gon.jpg", "killua.jpg", "kurapika.jpeg", "leorio.jpeg", "hisokaFace.png", "chrollo.jpeg", "meruem.jpeg", "netero.png"};
	JButton[] buttons;
	ImageIcon[] icons;
	ImageIcon cardBack = new ImageIcon(this.getClass().getResource("cardLogo.jpg"));
	ImageIcon temp;
	int score = 0;
	Random random;
	Timer timer;
	
	int openImages;
	int currentIndex;
	int oddClickIndex;
	
	CardsPanel() {
		
		this.setBackground(new Color(245,245,220));
		this.setBounds(0,0,700,640);
		this.setLayout(new GridLayout(4,4,0,0));
		
		numButtons = pics.length * 2;
		buttons = new JButton[numButtons];
		icons = new ImageIcon[numButtons];
		
		
		for(int i=0, j=0; i<pics.length; i++) {
		
			icons[j] = new ImageIcon(this.getClass().getResource(pics[i]));
			addButton(j++);
			
			
			icons[j] = icons[j-1];
			addButton(j++);
			
	
		}
		
		random = new Random();
		//shuffle the cards
		for(int i=0; i<numButtons; i++) {
			
			int j = random.nextInt(numButtons);
			temp = icons[i];
			icons[i] = icons[j];
			icons[j] = temp;
		}
		
		timer = new Timer(1000, new TimerListener());
		
	}
	
	public void addButton(int j) {
		
		buttons[j] = new JButton();
		buttons[j].addActionListener(new ImageButtonListener());
		buttons[j].setIcon(cardBack);
		buttons[j].setBackground(Color.black);
		buttons[j].setFocusable(false);
		this.add(buttons[j]);
		
	}
	
	//"flips" the cards back
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			buttons[currentIndex].setIcon(cardBack);
			buttons[oddClickIndex].setIcon(cardBack);
			timer.stop();
			
		}
		
	}
	
	private class ImageButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(timer.isRunning()) 
				return;
			
			openImages++;
			
			for(int i=0; i<numButtons; i++) {
				if(e.getSource() == buttons[i]) {
					buttons[i].setIcon(icons[i]);
					currentIndex = i;
				}
			}
			
			if(openImages % 2 == 0) {
				
				//checks if they are the same card
				if(currentIndex == oddClickIndex) {
					return;
				}
				
				else {
					//if not the same icon, flip back
					if(icons[currentIndex] != icons[oddClickIndex]) {
						timer.start();
					}
					else {
						buttons[currentIndex].setDisabledIcon(icons[currentIndex]);
						buttons[oddClickIndex].setDisabledIcon(icons[currentIndex]);
						buttons[currentIndex].setEnabled(false);
						buttons[oddClickIndex].setEnabled(false);
						score++;
						ScorePanel.scoreLabel.setText(String.valueOf(score));
						
						if(score == pics.length) {
							GameFrame.winText.setText("Congrats it took you " + openImages/2 + " tries <3");
							GameFrame.winText.setVisible(true);
						}
					}
				}
			}
			else {
				oddClickIndex = currentIndex;
			}
			
		}
		
	}

	
}
