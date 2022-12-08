package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	/**
	 * This is the home page of this game
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 705, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBackground(new Color(255, 182, 193));
		btnStartGame.setForeground(new Color(0, 0, 255));
		btnStartGame.setBounds(190, 189, 285, 33);
		btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnStartGame);
		
		/**
		 * Button used to move from one JFrame to another JFrame
		 */
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameGUI().setVisible(true);
				dispose();
			}
		});
		
		JButton btnScoreboard = new JButton("Score Board");
		btnScoreboard.setBackground(new Color(255, 182, 193));
		btnScoreboard.setForeground(new Color(0, 0, 255));
		btnScoreboard.setBounds(190, 268, 285, 33);
		btnScoreboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnScoreboard);
		
		btnScoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Scoreboard().setVisible(true);
				dispose();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 182, 193));
		btnLogout.setForeground(new Color(0, 0, 255));
		btnLogout.setBounds(190, 346, 285, 33);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		
		
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setBounds(292, 11, 97, 40);
		lblHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblHome.setForeground(new Color(255, 20, 147));
		contentPane.add(lblHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\EclipseProjects\\PuzzleGame\\src\\Sources\\gamehome.png"));
		lblNewLabel.setBackground(new Color(255, 182, 193));
		lblNewLabel.setBounds(0, 0, 689, 461);
		contentPane.add(lblNewLabel);
	}

}
