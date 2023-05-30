import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScorePanel extends JPanel{

	int score;
	Font font;
	JLabel textLabel;
	static JLabel scoreLabel;
	
	ScorePanel() {
		
		this.setBackground(new Color(102,102,102));
		this.setBounds(700,0,150,300);
		this.setLayout(new GridLayout(8,0));
		
		font = new Font("MV Boli", Font.PLAIN, 15);
		
		textLabel = new JLabel("No. of matches:");
		textLabel.setFont(font);
		textLabel.setForeground(Color.blue);
		textLabel.setBackground(new Color(102,102,102));
		textLabel.setOpaque(true);
		
		scoreLabel = new JLabel("0");
		scoreLabel.setForeground(Color.blue);
		scoreLabel.setFont(font);
		scoreLabel.setBackground(new Color(102,102,102));
		scoreLabel.setOpaque(true);
		
		this.add(textLabel);
		this.add(scoreLabel);
		
	}
}
