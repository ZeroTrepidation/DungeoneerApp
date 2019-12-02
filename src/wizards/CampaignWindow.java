package wizards;
/*
 * Responsible for the initilization and functions of the Campaign Window which
 * should appear after a user logs in. Will use the current account in the Controller
 * class.
 * 
 * Author: Seth Tummillo
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class CampaignWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampaignWindow frame = new CampaignWindow();
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
	public CampaignWindow() {
		setTitle("Hello " + Controller.currentAccount.getUsername() + "!");
		setResizable(false);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Campaigns", null, panel, null);
		
		JList list = new JList();
		
		panel.add(list);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Account", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel usernameLabel = new JLabel("Current Username:");
		usernameLabel.setBounds(44, 41, 127, 37);
		panel_1.add(usernameLabel);

		JLabel nameLabel = new JLabel(Controller.currentAccount.getUsername());
		nameLabel.setBounds(181, 41, 169, 37);
		panel_1.add(nameLabel);

		JButton changeUsernameButton = new JButton("Change Username");
		changeUsernameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newUsername = JOptionPane.showInputDialog("Enter a new username");
				boolean accountExists = false;
				for (int i = 0; i < Controller.accountList.size(); i++) {
					if (Controller.accountList.get(i).getUsername().toLowerCase().equals(newUsername.toLowerCase())) {
						accountExists = true;
					}
				}
				if (accountExists) {
					JOptionPane.showMessageDialog(contentPane, "Account Already Exists");
				} else {
					Controller.currentAccount.changeUsername(newUsername);
					nameLabel.setText(Controller.currentAccount.getUsername());
					setTitle(Controller.currentAccount.getUsername());
				}
			}
		});
		changeUsernameButton.setBounds(44, 129, 156, 23);
		panel_1.add(changeUsernameButton);

		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPaneMultiInput pane = new JOptionPaneMultiInput();
				pane.initialize();
			}
		});
		changePasswordButton.setBounds(44, 180, 156, 23);
		panel_1.add(changePasswordButton);

		
		JButton deleteAccountButton = new JButton("Delete Account");
		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete your account?",
						"Close Window?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					dispose();
					Controller.deleteAccount(Controller.currentAccount.getUsername());
					Controller.login.visibility(true);
				}
			}
		});
		deleteAccountButton.setBounds(44, 233, 156, 23);
		panel_1.add(deleteAccountButton);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Controller.singletonAccount(null);
				Controller.login.visibility(true);
			}
		});
		btnLogOut.setBounds(44, 285, 156, 23);
		panel_1.add(btnLogOut);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to exit this application?",
						"Close Window?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}

	public class JOptionPaneMultiInput {
		public void initialize() {
			JPasswordField oldPasswordField = new JPasswordField(20);
			JPasswordField newPasswordField = new JPasswordField(20);
			JPasswordField confirmPasswordField = new JPasswordField(20);

			JPanel myPanel = new JPanel();
			myPanel.add(new JLabel("Old Password: "));
			myPanel.add(oldPasswordField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("New Password: "));
			myPanel.add(newPasswordField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("Confirm Password "));
			myPanel.add(confirmPasswordField);

			int result = JOptionPane.showConfirmDialog(null, myPanel, "Password Change Requested",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (oldPasswordField.getText().equals(Controller.currentAccount.getPassword())
						&& newPasswordField.getText().equals(confirmPasswordField.getText())
						&& newPasswordField.getText().length() > 7) {
					Controller.currentAccount.changePassword(confirmPasswordField.getText());
					JOptionPane.showMessageDialog(myPanel, "Password Change Successful!");
				} else {
					JOptionPane.showMessageDialog(myPanel, "Password was wrong, didn't match, or was too short.");
				}
			}
		}
	}
}
