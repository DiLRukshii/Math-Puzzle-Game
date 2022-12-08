package View;

//import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;

import Controller.GameEngine;

//import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * A Simple Graphical User Interface for the Six Equation Game.
 * 
 * @author Marc Conrad
 *
 */
public class GameGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;

	/**
	 * Method that is called when a button has been pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(currentGame, solution);
		int score = myGame.getScore(); 
/**
* taking the value from getLevel method to upgrade the level
*/
		int level=myGame.getLevel();
		if (correct) {
			System.out.println("YEAH!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score);
/**
* Upgraded level's value set to the JLabel 
*/
			lblLevel.setText("Level:"+level);
/**
* Timer set for new Level
*/
			timer.stop();
			second =30;
			minute =0;
			counterLabel.setText("00:30");
			countdownTimer();
			timer.start();		
		} else { 
			System.out.println("Not Correct"); 
			infoArea.setText("Oops. Try again!  Score: "+score);
		}
	}

	JLabel questArea = null;
	GameEngine myGame = null;
	URL currentGame = null;
	JTextArea infoArea = null;
/**
* set variables for the components(level and time)
*/
	JLabel lblLevel = new JLabel("Level");
	//Set timer to game
	JLabel counterLabel;
	Font font1 = new Font("Arial", Font.PLAIN, 30);	
	Timer timer;	
	int second=0, minute=1;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
	
/**
 * Initializes the game. 
 * @param player
 */
	private void initGame(String player) {
		setBounds(450, 100,701, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		infoArea = new JTextArea(1, 40);
		infoArea.setForeground(new Color(138, 43, 226));
		infoArea.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		panel.add(infoArea);
		
		infoArea.setEditable(false);
		infoArea.setText("What is the missing value?   Score: 0");
		
		JScrollPane infoPane = new JScrollPane();
		panel.add(infoPane);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
	    
	  		JScrollPane questPane = new JScrollPane(questArea);
	  		panel.add(questPane);
	  		lblLevel.setForeground(new Color(255, 0, 0));
	  		questPane.setColumnHeaderView(lblLevel);
	  		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 25));
	  		lblLevel.setText("Level: 1");
	    
		

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}

		getContentPane().add(panel);
		panel.repaint();
		
		counterLabel = new JLabel("");
		counterLabel.setForeground(new Color(30, 144, 255));
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(font1);
		panel.add(counterLabel);
		panel.setVisible(true);
		
		counterLabel.setText("00:30");
/**
* Button click events and action listener used 
*/
		JButton btnQuite = new JButton("Quit");
		btnQuite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				dispose();
			}
		});
		btnQuite.setBackground(new Color(244, 164, 96));
		btnQuite.setForeground(new Color(220, 20, 60));
		btnQuite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnQuite);
/**
* when the time is zero the player will be redirect to the EndGame JFrame
*/
		
		countdownTimer();
		timer.start();		

	}
public void countdownTimer() {// Used the https://www.youtube.com/watch?v=zWw72j-EbqI video to set count down timer for the game
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				counterLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 30;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
					new EndGame().setVisible(true);
					dispose();
				}
			}
		});		
	}		
/**
 * Default player is null. 
 */
	public GameGUI() {
		super();
		initGame(null);
	}

	/**
	 * Use this to start GUI, e.g., after login.
	 * 
	 * @param player
	 */
	public GameGUI(String player) {
		super();
		initGame(player);
	}

	/**
	 * Main entry point into the equation game.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		GameGUI myGUI = new GameGUI();
		myGUI.setVisible(true);

	}
}