package wizards;

import java.awt.Frame;

/*
 * Simple Account class. Stores a username and password and a list of campaigns
 * Author: Seth Tummillo
 */

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Account {

	private String username;
	private String password;
	private ArrayList<Campaign> campaignList;

	/*
	 * Constructor
	 * 
	 * @param username = username for the account
	 * 
	 * @param password = password for the account
	 */
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
		campaignList = new ArrayList<Campaign>();
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(ArrayList<Campaign> campaignList) {
		campaignList = campaignList;
	}

	// methods used to change the username and password
	public void changeUsername(String username) {
		this.username = username;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public void addCampaign(Campaign newCampaign, DefaultListModel dlm) {
		boolean isUnique = true;
		for (int i = 0; i < campaignList.size(); i++) {
			if (newCampaign.getCampName().toLowerCase().equals(campaignList.get(i).getCampName().toLowerCase())) {
				isUnique = false;
			}
		}
		if (isUnique) {
			dlm.addElement(newCampaign);
			playerCharacter mainCharacter = new playerCharacter();
			newCampaign.setMainCharacter(mainCharacter);
			new CharacterCreatorUI(mainCharacter).setVisible(true);
			campaignList.add(newCampaign);

		} else {
			JOptionPane.showMessageDialog(new Frame(), "Please choose a Unique Name for your Campaign");
		}

	}

	public void deleteCampaign(int index) {

		if (JOptionPane.showConfirmDialog(new Frame(), "Are you sure you want to remove this Campaign?",
				"Delete Campaign?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

			campaignList.remove(index);
			return;

		}
	}

}
