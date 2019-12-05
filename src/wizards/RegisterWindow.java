package wizards;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow frame = new RegisterWindow();
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
	public RegisterWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// centers the location of the campaign window
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New Username: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(24, 29, 137, 14);
		panel.add(lblNewLabel);

		JLabel lblNewPassword = new JLabel("New Password: ");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setBounds(24, 54, 137, 14);
		panel.add(lblNewPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmPassword.setBounds(24, 79, 137, 14);
		panel.add(lblConfirmPassword);

		textField = new JTextField();
		textField.setBounds(165, 26, 96, 20);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(165, 51, 96, 20);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(165, 76, 96, 20);
		panel.add(passwordField_1);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				String passConfirm = String.valueOf(passwordField_1.getPassword());

				if (pass.length() < 8) {
					JOptionPane.showMessageDialog(contentPane,
							"Password is too short. (Must be at least 8 characters)");
				}

				else if (!pass.equals(passConfirm)) {
					JOptionPane.showMessageDialog(contentPane, "Passwords do not match.");
					passwordField.setText("");
					passwordField_1.setText("");
				} else {

					boolean isUnique = true;
					if (Controller.accountList.size() == 0) {
						Controller.accountList.add(new Account(username, passConfirm));
						JOptionPane.showMessageDialog(contentPane, "Account successfully created!");
						dispose();
					} else {
						for (int i = 0; i < Controller.accountList.size(); i++) {
							if (Controller.accountList.get(i).getUsername().toLowerCase()
									.equals(username.toLowerCase())) {
								isUnique = false;
								JOptionPane.showMessageDialog(contentPane, "Account Already Exists");
							}
							if (isUnique == true) {
								Controller.accountList.add(new Account(username, passConfirm));
								JOptionPane.showMessageDialog(contentPane, "Account successfully created!");
								dispose();
							}
						}
					}
				}

			}
		});

		panel_1.add(register);

		JButton cancel = new JButton("Cancel");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		panel_1.add(cancel);
	}
}
