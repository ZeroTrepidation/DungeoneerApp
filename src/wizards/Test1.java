package wizards;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Test1 {

	String username;
	String password;
	Account testAccount;
	Campaign testCampaign;

	@BeforeEach
	void setUp() throws Exception {
		username = "Seth";
		password = "1234";

		testCampaign = new Campaign("Test campaign", "12/12/12");
		testAccount = new Account(username, password);

	}

	@AfterEach
	void tearDown() throws Exception {
		username = null;
		password = null;
		testAccount = null;
		testCampaign = null;
	}

	@Test
	//test that account is added correctly
	void testAccount() {

		 assertTrue(testAccount.getUsername().equals(username) && testAccount.getPassword().equals(password));


	}

	@Test
	//test that Campaigns can be added to list
	void testCampaign() {
		DefaultListModel dlm = new DefaultListModel();
		testAccount.addCampaign(testCampaign, dlm);
		assertTrue(testCampaign.equals(testAccount.getCampaignList().get(0)));

		
	}
	
	@Test
	//test that events are only added if campaign is loaded
	void testAddEvent() {
		DefaultListModel dlm = new DefaultListModel();
		testAccount.addCampaign(testCampaign, dlm);
		CampaignWindow cw = new CampaignWindow(testAccount);
		Event temp = new Event();
		cw.addEventCampaign(temp);
		assertEquals(0,testCampaign.getEvents().size());
		
	}
	

	
	

}
