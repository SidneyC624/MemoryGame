import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardsPanel extends JPanel{
	
	int numButtons;
	String[] pics = {"gon.jpg", "killua.jpg", "kurapika.jpeg", "leorio.jpeg", "hisokaFace.png", "chrollo.jpeg", "meruem.jpeg", "netero.png"};
	JButton[] buttons;
	ImageIcon cardBack = new ImageIcon("cardLogo.jpg");
	ImageIcon[] icons;
	Timer timer;
	
	CardsPanel() {
		
		this.setBackground(new Color(245,245,220));
		this.setBounds(0,0,700,675);
		this.setLayout(new GridLayout(4,4,10,10));
		
		
	}
}
