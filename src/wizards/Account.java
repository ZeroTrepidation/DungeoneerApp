package wizards;

/*
 * Simple Account class. Stores a username and password and a list of campaigns
 * Author: Seth Tummillo
 */

import java.util.ArrayList;

public class Account {

	private String username;
	private String password;
	private ArrayList<Campaign> CampaignList;
	
	
	/*
	 * Constructor
	 * @param username = username for the account
	 * @param password = password for the account
	 */
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//getters and setters
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
		return CampaignList;
	}

	public void setCampaignList(ArrayList<Campaign> campaignList) {
		CampaignList = campaignList;
	}
	
	//methods used to change the username and password
	public void changeUsername(String username) {
		this.username = username;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
}
