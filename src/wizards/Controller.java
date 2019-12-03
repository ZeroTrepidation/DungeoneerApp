package wizards;
/*
 * Main controller class
 * Used to initialize the application and as a basis for the program
 * 
 * Author: Seth Tummillo
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import com.google.gson.*;

public class Controller {


	public static ArrayList<Account> accountList = new ArrayList<Account>();
	public static LoginGUI login;

	public static void main(String[] args) {
		
		deserializeAccount();

		login = new LoginGUI();

		login.visibility(true);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				serializeAccount();
			}
		});
		

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
	
	private static void deserializeAccount() {
		try {
			 String json = ""; 
			 json = new String(Files.readAllBytes(Paths.get("accounts.json"))); 
			Account[] accounts = new Gson().fromJson(json, Account[].class);
			Collections.addAll(accountList, accounts);
		} catch (FileNotFoundException e) {
			new File("accounts.json");
		} catch (IOException e) {
			new File("accounts.json");
		}
	}
	
	private static void serializeAccount() {
		String json = new Gson().toJson(accountList);
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.json", false));
			writer.append(json);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
