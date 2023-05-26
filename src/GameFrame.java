import javax.swing.*;


public class GameFrame extends JFrame{
	
	CardsPanel cardsPanel;
	ScorePanel scorePanel;
	
	GameFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850,675);
		this.setTitle("Memory Game");
		this.setLocationRelativeTo(null);
		
		cardsPanel = new CardsPanel();
		scorePanel = new ScorePanel();
		
		this.add(cardsPanel);
		this.add(scorePanel);
		this.setVisible(true);
	}
	
}
