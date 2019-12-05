package wizards;
/*
 * This class is used for the creation and functions of the log in window.
 * Author: Seth Tummillo
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginGUI {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initializeLogin();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeLogin() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 258);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(50, 55, 90, 14);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(150, 52, 166, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Password: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(50, 95, 90, 14);
		panel_1.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 92, 166, 20);
		panel_1.add(passwordField);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

		JButton loginB = new JButton("Login");
		loginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String username = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean accountFound = false;
				OUTER_LOOP: for (int i = 0; i < Controller.accountList.size(); i++) {
					if (username.toLowerCase().equals(Controller.accountList.get(i).getUsername().toLowerCase())) {
						if (password.equals(Controller.accountList.get(i).getPassword())) {
							visibility(false);
							accountFound = true;
							CampaignWindow campaignWindow = new CampaignWindow(Controller.accountList.get(i));
							campaignWindow.setVisible(true);
							break OUTER_LOOP;
						}
					}
				}
				if (accountFound == false) {
					JOptionPane.showMessageDialog(frame, "Account does not exist or Password is wrong.");
				}
			}
		});

		panel.add(loginB);

		JButton registerB = new JButton("Register");
		registerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterWindow register = new RegisterWindow();
				register.setVisible(true);
			}
		});

		panel.add(registerB);

		JButton cancelB = new JButton("Cancel");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		panel.add(cancelB);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.NORTH);

		JLabel lblAccountLogin = new JLabel("Account Login");
		panel_2.add(lblAccountLogin);
	}

	public void visibility(boolean bool) {
		frame.setVisible(bool);
	}

}
