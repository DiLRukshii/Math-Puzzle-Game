package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.SaveSign;
import Model.SignIn;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Sign extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_name;
	private JTextField txt_mail;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sign dialog = new Sign();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sign() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rushi\\Downloads\\PicturePuzzleGame\\smileicon.jpg"));
		setBounds(450, 100, 694, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_name = new JLabel("Name");
			lbl_name.setForeground(new Color(255, 255, 0));
			lbl_name.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbl_name.setBounds(354, 87, 50, 28);
			contentPanel.add(lbl_name);
		}
		{
			txt_name = new JTextField();
			txt_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_name.setBounds(496, 89, 156, 28);
			contentPanel.add(txt_name);
			txt_name.setColumns(10);
		}
		{
			JLabel lbl_password = new JLabel("Password");
			lbl_password.setForeground(new Color(255, 255, 0));
			lbl_password.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbl_password.setBounds(354, 209, 100, 28);
			contentPanel.add(lbl_password);
		}
		{
			JButton btn_signup = new JButton("Sign In");
			btn_signup.setForeground(new Color(255, 0, 0));
			btn_signup.setBackground(new Color(255, 204, 255));
			btn_signup.setFont(new Font("Tahoma", Font.BOLD, 14));
			btn_signup.setBounds(525, 292, 105, 28);
			btn_signup.addActionListener(new ActionListener() {
/**
 * Validating the user name and password
 * @param e
 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(txt_name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null," User name cannot be blank");
					}
		 			
					else if(txt_password.getPassword().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Password cannot be blank");
					}
					else {
						try {
							SignIn signIn = new SignIn(txt_name.getText(),txt_mail.getText(),txt_password.getText());
			                SaveSign save = new SaveSign(signIn);
			                save.saveSignInToDataBase();
			                JOptionPane.showInputDialog(this, "Sign in Successfull...");

						}
						/**
						 * Exception handling
						 */
						catch(Exception ex)
						{
							JOptionPane.showInputDialog(this, "Sign Up unsuuccessfull..");
							
						}
					}
				}
				}
				
			);
			contentPanel.add(btn_signup);
		}
		{
			JLabel lbl_mail = new JLabel("Email");
			lbl_mail.setForeground(new Color(255, 255, 0));
			lbl_mail.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbl_mail.setBounds(354, 156, 50, 19);
			contentPanel.add(lbl_mail);
		}
		{
			txt_mail = new JTextField();
			txt_mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_mail.setBounds(496, 153, 156, 28);
			contentPanel.add(txt_mail);
			txt_mail.setColumns(10);
		}
		{
			JLabel lbl_sign = new JLabel("Sign In");
			lbl_sign.setForeground(new Color(0, 250, 154));
			lbl_sign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lbl_sign.setBounds(447, 21, 100, 28);
			contentPanel.add(lbl_sign);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rushi\\git\\Math-Puzzle-Game\\PuzzleGame\\src\\Sources\\playboy.png"));
			lblNewLabel.setForeground(Color.GREEN);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(0, 0, 324, 353);
			contentPanel.add(lblNewLabel);
		}
		{
			txt_password = new JPasswordField();
			txt_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_password.setBounds(496, 209, 156, 28);
			contentPanel.add(txt_password);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(216, 191, 216));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_back = new JButton("<<");
				btn_back.setBackground(new Color(64, 224, 208));
				btn_back.setFont(new Font("Tahoma", Font.BOLD, 11));
				btn_back.setActionCommand("Cancel");
				buttonPane.add(btn_back);
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new Login().setVisible(true);
						dispose();
					}
				});
			}
		}
	}

}
