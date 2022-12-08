package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.DB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
//import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * This is the Login page of this game
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Login;
	private JLabel lbl_username;
	private JLabel lblpassword;
	private JLabel lbl_login;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rushi\\Downloads\\smileicon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 694, 425);
		Login = new JPanel();
		Login.setBackground(new Color(0, 153, 255));
		Login.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Login);
		Login.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(306, 145, 183, 25);
		Login.add(txtPassword);
		
		lbl_username = new JLabel("User Name");
		lbl_username.setForeground(new Color(255, 255, 0));
		lbl_username.setBounds(145, 95, 81, 25);
		lbl_username.setFont(new Font("Tahoma", Font.BOLD, 14));
		Login.add(lbl_username);
		
		lblpassword = new JLabel("Password");
		lblpassword.setForeground(new Color(255, 255, 51));
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpassword.setBounds(145, 143, 89, 25);
		Login.add(lblpassword);
		
		lbl_login = new JLabel("MATH PUZZLE GAME");
		lbl_login.setForeground(new Color(255, 20, 147));
		lbl_login.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 24));
		lbl_login.setBounds(215, 11, 299, 40);
		Login.add(lbl_login);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(306, 92, 183, 26);
		Login.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(204, 102, 255));
		btnLogin.setForeground(new Color(255, 255, 0));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(309, 225, 89, 26);
		Login.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/**
 * Retrieve data from the signup table and matching with the details user entered.
 */
				try {
					
					Connection con=DB.createConnection();
					Statement stm =con.createStatement();
					String sql="select*from signup where sname='"+txtUsername.getText()+"'and spassword='"+txtPassword.getText()+"';";
					ResultSet rs=stm.executeQuery(sql);
					
					if (rs.next()) {
						dispose();
						new Home().setVisible(true);
					}
					else {
						JOptionPane.showInputDialog(this,"error");
						txtPassword.setText("");
					}
					
					
					
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		JLabel lblcreateaccount = new JLabel("Sign up here if you dont have an account");
		lblcreateaccount.setForeground(new Color(255, 204, 204));
		lblcreateaccount.setBounds(0, 366, 246, 14);
		Login.add(lblcreateaccount);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.setBackground(new Color(250, 235, 215));
		btnSignup.setForeground(new Color(199, 21, 133));
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignup.setBounds(256, 360, 89, 23);
		Login.add(btnSignup);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\rushi\\git\\Math-Puzzle-Game\\PuzzleGame\\src\\Sources\\gameback2.png"));
		background.setForeground(new Color(255, 0, 255));
		background.setBounds(0, 0, 678, 386);
		background.setFont(new Font("Tahoma", Font.PLAIN, 20));
		background.setBackground(new Color(255, 192, 203));
		Login.add(background);
		
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sign().setVisible(true);
				dispose();
			}
		});
	}
}
