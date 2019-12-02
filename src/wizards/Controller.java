package wizards;
/*
 * Main controller class
 * Used to initialize the application and as a basis for the program
 * 
 * Author: Seth Tummillo
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

	private ArrayList<Campaign> campaignList;
	public static ArrayList<Account> accountList;
	public static Account currentAccount;
	public static LoginGUI login;

	
	public static void main(String[] args) {
		
		boolean loggedIn = false;
		Scanner in = new Scanner(System.in);
		int menuChoice = 0;
		
		accountList = new ArrayList<Account>();
		//accountList.add(new Account("Zero", "123456789"));
		
		login =  new LoginGUI();
		
		login.visibility(true);
		
		
		 System.out.println("There was an error");
		
		
		
	}
	
	public static void createAccount(String username, String password) {
		accountList.add(new Account(username, password));
	}
	
	public static void deleteAccount(String username) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getUsername().equals(username)) {
				accountList.remove(i);
			}
		}
	}
	
	public static void singletonAccount(Account account) {
		
		if(currentAccount== null) {
			currentAccount = account;
		} else if (account == null) {
			currentAccount = null;
		} else {
			System.out.println("User already logged in");
		}
		
	}
	
	
	
	

}


