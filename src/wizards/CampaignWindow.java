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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Component;

public class CampaignWindow extends JFrame {

	private JPanel contentPane;
	private Account currentAccount;

	/**
	 * Create the frame.
	 */
	public CampaignWindow(Account currentAccount) {
		this.currentAccount = currentAccount;

		setTitle("Hello " + currentAccount.getUsername() + "!");
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
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Campaign List: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 153, 34);
		panel.add(lblNewLabel);
		ArrayList<Campaign> campList = new ArrayList<Campaign>();
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));
		campList.add(new Campaign("test1", "02-04-1995"));

		String[] stringArray = new String[] { "hi", "my", "name", "is" };

		

		JList list = new JList(campList.toArray());

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 40, 294, 265);
		panel.add(scrollPane);
		
		JButton btnNewButton = new JButton("Add Campaign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CampaignBuilder builder = new CampaignBuilder();
			}
		});
		btnNewButton.setBounds(10, 318, 142, 23);
		panel.add(btnNewButton);

		JButton btnDeleteCampaign = new JButton("Delete Campaign");
		btnDeleteCampaign.setBounds(10, 352, 142, 23);
		panel.add(btnDeleteCampaign);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Account", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel usernameLabel = new JLabel("Current Username:");
		usernameLabel.setBounds(44, 41, 127, 37);
		panel_1.add(usernameLabel);

		JLabel nameLabel = new JLabel(currentAccount.getUsername());
		nameLabel.setBounds(181, 41, 169, 37);
		panel_1.add(nameLabel);

		JButton changeUsernameButton = new JButton("Change Username");
		changeUsernameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newUsername = JOptionPane.showInputDialog("Enter a new username");
				if (newUsername != null) {
					boolean accountExists = false;

					for (int i = 0; i < Controller.accountList.size(); i++) {
						if (Controller.accountList.get(i).getUsername().toLowerCase()
								.equals(newUsername.toLowerCase())) {
							accountExists = true;
						}
					}
					if (accountExists) {
						JOptionPane.showMessageDialog(contentPane, "Account Already Exists");
					} else {
						currentAccount.changeUsername(newUsername);
						nameLabel.setText(currentAccount.getUsername());
						setTitle(currentAccount.getUsername());
					}
				}
			}
		});
		changeUsernameButton.setBounds(44, 129, 156, 23);
		panel_1.add(changeUsernameButton);

		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPaneMultiInput pane = new JOptionPaneMultiInput();
				pane.initialize(currentAccount);
			}
		});
		changePasswordButton.setBounds(44, 180, 156, 23);
		panel_1.add(changePasswordButton);

		JButton deleteAccountButton = new JButton("Delete Account");
		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete your account?",
						"Delete Account?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					dispose();
					Controller.deleteAccount(currentAccount.getUsername());
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
		public void initialize(Account currentAccount) {
			JPasswordField oldPasswordField = new JPasswordField(20);
			JPasswordField newPasswordField = new JPasswordField(20);
			JPasswordField confirmPasswordField = new JPasswordField(20);

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			myPanel.add(new JLabel("Old Password: "));
			myPanel.add(oldPasswordField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("New Password(At least 8 Characters): "));
			myPanel.add(newPasswordField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("Confirm Password "));
			myPanel.add(confirmPasswordField);

			int result = JOptionPane.showConfirmDialog(null, myPanel, "Password Change Requested",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (oldPasswordField.getText().equals(currentAccount.getPassword())
						&& newPasswordField.getText().equals(confirmPasswordField.getText())
						&& newPasswordField.getText().length() > 7) {
					currentAccount.changePassword(confirmPasswordField.getText());
					JOptionPane.showMessageDialog(myPanel, "Password Change Successful!");
				} else {
					JOptionPane.showMessageDialog(myPanel, "Password was wrong, didn't match, or was too short.");
				}
			}
		}
	}

	public class CampaignBuilder {
		public void initialize(Account currentAccount) {
			JTextField campaignName = new JTextField();
			JTextField startDate = new JTextField();
			
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			myPanel.add(new JLabel("Campaign Name:"));
			myPanel.add(campaignName);
			myPanel.add(new JLabel("Start Date (MM/DD/YY):"));
			myPanel.add(startDate);
			
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Campaign Creator",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				currentAccount.addCampaign(new Campaign(campaignName.getText(), startDate.getText()));
			}
			
			
		}
	}
}
