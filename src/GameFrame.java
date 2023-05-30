import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GameFrame extends JFrame implements ActionListener{
	
	CardsPanel cardsPanel;
	ScorePanel scorePanel;
	JButton restartButton;
	static JTextArea winText;
	
	GameFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850,675);
		this.setTitle("Memory Game");
		this.getContentPane().setBackground(new Color(102,102,102));
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		cardsPanel = new CardsPanel();
		scorePanel = new ScorePanel();
		
		restartButton = new JButton("Restart");
		restartButton.setBounds(705, 500, 100, 50);
		restartButton.setFocusable(false);
		restartButton.setBorder(BorderFactory.createBevelBorder(1));
		restartButton.addActionListener(this);
		
		winText = new JTextArea();
		winText.setBounds(700,320,100,100);
		winText.setFont(new Font("Ink Free", Font.BOLD, 20));
		winText.setBackground(new Color(102,102,102));
		winText.setForeground(new Color(245,245,220));
		winText.setEditable(false);
		winText.setLineWrap(true);
		winText.setWrapStyleWord(true);
		winText.setVisible(false);
		
		this.add(cardsPanel);
		this.add(scorePanel);
		this.add(restartButton);
		this.add(winText);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == restartButton) {
			winText.setVisible(false);
			this.remove(cardsPanel);
			this.remove(scorePanel);
			cardsPanel = new CardsPanel();
			scorePanel = new ScorePanel();
			this.add(cardsPanel);
			this.add(scorePanel);
			SwingUtilities.updateComponentTreeUI(this);
		}
		
	}
	
}
