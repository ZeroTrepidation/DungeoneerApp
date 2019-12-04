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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

public class CampaignWindow extends JFrame {

	private JPanel contentPane;
	private Account currentAccount;
	private static boolean campaignLoaded = false;
	private static Campaign currentCampaign;
	private static DefaultListModel dlm2;

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

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		DefaultListModel dlm = new DefaultListModel();
		for (Campaign index : currentAccount.getCampaignList()) {
			dlm.addElement(index);
		}

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tabbedPane.addTab("Campaigns", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Campaign List: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 153, 34);
		panel.add(lblNewLabel);
		JList list = new JList(dlm);
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBorder(new LineBorder(Color.BLACK, 2, true));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 40, 296, 494);
		panel.add(scrollPane);

		JButton btnAddCampaign = new JButton("Add Campaign");
		btnAddCampaign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CampaignBuilder builder = new CampaignBuilder();
				builder.initialize(currentAccount, dlm);
				//list.updateUI();
			}
		});

		btnAddCampaign.setBounds(10, 545, 142, 23);
		panel.add(btnAddCampaign);

		JButton btnDeleteCampaign = new JButton("Delete Campaign");
		btnDeleteCampaign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
					currentAccount.deleteCampaign(list.getSelectedIndex());
					dlm.remove(list.getSelectedIndex());
				}
				campaignLoaded = false;
				currentCampaign = null;
			}
		});

		btnDeleteCampaign.setBounds(10, 613, 142, 23);
		panel.add(btnDeleteCampaign);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBounds(306, 40, 504, 494);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblCharName = new JLabel("Character Name:");
		lblCharName.setFont(new Font("Papyrus", Font.BOLD, 15));
		lblCharName.setBounds(10, 11, 146, 31);
		panel_2.add(lblCharName);

		JLabel fieldCharName = new JLabel();
		fieldCharName.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 14));
		fieldCharName.setBounds(150, 11, 203, 31);
		panel_2.add(fieldCharName);

		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setBounds(10, 42, 85, 31);
		panel_2.add(lblClass);

		JLabel lblRace = new JLabel("Race");
		lblRace.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblRace.setHorizontalAlignment(SwingConstants.CENTER);
		lblRace.setBounds(108, 42, 85, 31);
		panel_2.add(lblRace);

		JLabel lblAlignment = new JLabel("Alignment");
		lblAlignment.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblAlignment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlignment.setBounds(207, 42, 85, 31);
		panel_2.add(lblAlignment);

		JLabel lblEyes = new JLabel("Eyes");
		lblEyes.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblEyes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEyes.setBounds(302, 42, 85, 31);
		panel_2.add(lblEyes);

		JLabel lblHair = new JLabel("Hair");
		lblHair.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblHair.setHorizontalAlignment(SwingConstants.CENTER);
		lblHair.setBounds(397, 42, 85, 31);
		panel_2.add(lblHair);

		JLabel fieldClass = new JLabel("");
		fieldClass.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldClass.setHorizontalAlignment(SwingConstants.CENTER);
		fieldClass.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldClass.setBounds(10, 75, 85, 31);
		panel_2.add(fieldClass);

		JLabel fieldRace = new JLabel("");
		fieldRace.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldRace.setHorizontalAlignment(SwingConstants.CENTER);
		fieldRace.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldRace.setBounds(108, 75, 85, 31);
		panel_2.add(fieldRace);

		JLabel fieldAlignment = new JLabel("");
		fieldAlignment.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldAlignment.setHorizontalAlignment(SwingConstants.CENTER);
		fieldAlignment.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldAlignment.setBounds(207, 75, 85, 31);
		panel_2.add(fieldAlignment);

		JLabel fieldEyes = new JLabel("");
		fieldEyes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldEyes.setHorizontalAlignment(SwingConstants.CENTER);
		fieldEyes.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldEyes.setBounds(302, 75, 85, 31);
		panel_2.add(fieldEyes);

		JLabel fieldHair = new JLabel("");
		fieldHair.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldHair.setHorizontalAlignment(SwingConstants.CENTER);
		fieldHair.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldHair.setBounds(397, 75, 85, 31);
		panel_2.add(fieldHair);

		JLabel lblSkin = new JLabel("Skin");
		lblSkin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkin.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblSkin.setBounds(63, 117, 85, 31);
		panel_2.add(lblSkin);

		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblAge.setBounds(158, 117, 85, 31);
		panel_2.add(lblAge);

		JLabel lblWeight = new JLabel("Weight (kg)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblWeight.setBounds(253, 117, 85, 31);
		panel_2.add(lblWeight);

		JLabel lblHeight = new JLabel("Height (cm)");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblHeight.setBounds(348, 117, 85, 31);
		panel_2.add(lblHeight);

		JLabel fieldSkin = new JLabel("");
		fieldSkin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldSkin.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSkin.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldSkin.setBounds(63, 148, 85, 31);
		panel_2.add(fieldSkin);

		JLabel fieldAge = new JLabel("");
		fieldAge.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldAge.setHorizontalAlignment(SwingConstants.CENTER);
		fieldAge.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldAge.setBounds(158, 148, 85, 31);
		panel_2.add(fieldAge);

		JLabel fieldWeight = new JLabel("");
		fieldWeight.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldWeight.setHorizontalAlignment(SwingConstants.CENTER);
		fieldWeight.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldWeight.setBounds(253, 148, 85, 31);
		panel_2.add(fieldWeight);

		JLabel fieldHeight = new JLabel("");
		fieldHeight.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldHeight.setHorizontalAlignment(SwingConstants.CENTER);
		fieldHeight.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldHeight.setBounds(348, 148, 85, 31);
		panel_2.add(fieldHeight);

		JLabel lblStr = new JLabel("STR");
		lblStr.setHorizontalAlignment(SwingConstants.CENTER);
		lblStr.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblStr.setBounds(10, 201, 73, 31);
		panel_2.add(lblStr);

		JLabel lblDex = new JLabel("DEX");
		lblDex.setHorizontalAlignment(SwingConstants.CENTER);
		lblDex.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblDex.setBounds(10, 243, 73, 31);
		panel_2.add(lblDex);

		JLabel lblCon = new JLabel("CON");
		lblCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCon.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblCon.setBounds(10, 285, 73, 31);
		panel_2.add(lblCon);

		JLabel lblInt = new JLabel("INT");
		lblInt.setHorizontalAlignment(SwingConstants.CENTER);
		lblInt.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblInt.setBounds(10, 327, 73, 31);
		panel_2.add(lblInt);

		JLabel lblWis = new JLabel("WIS");
		lblWis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWis.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblWis.setBounds(10, 369, 73, 31);
		panel_2.add(lblWis);

		JLabel lblChr = new JLabel("CHR");
		lblChr.setHorizontalAlignment(SwingConstants.CENTER);
		lblChr.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblChr.setBounds(10, 411, 73, 31);
		panel_2.add(lblChr);

		JLabel fieldStr = new JLabel("");
		fieldStr.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldStr.setHorizontalAlignment(SwingConstants.CENTER);
		fieldStr.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldStr.setBounds(71, 201, 69, 31);
		panel_2.add(fieldStr);

		JLabel fieldDex = new JLabel("");
		fieldDex.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldDex.setHorizontalAlignment(SwingConstants.CENTER);
		fieldDex.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldDex.setBounds(71, 243, 69, 31);
		panel_2.add(fieldDex);

		JLabel fieldCon = new JLabel("");
		fieldCon.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldCon.setHorizontalAlignment(SwingConstants.CENTER);
		fieldCon.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldCon.setBounds(71, 285, 69, 31);
		panel_2.add(fieldCon);

		JLabel fieldInt = new JLabel("");
		fieldInt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldInt.setHorizontalAlignment(SwingConstants.CENTER);
		fieldInt.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldInt.setBounds(71, 327, 69, 31);
		panel_2.add(fieldInt);

		JLabel fieldWis = new JLabel("");
		fieldWis.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldWis.setHorizontalAlignment(SwingConstants.CENTER);
		fieldWis.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldWis.setBounds(71, 369, 69, 31);
		panel_2.add(fieldWis);

		JLabel fieldChr = new JLabel("");
		fieldChr.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldChr.setHorizontalAlignment(SwingConstants.CENTER);
		fieldChr.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldChr.setBounds(71, 411, 69, 31);
		panel_2.add(fieldChr);

		JLabel lblSavingThrow = new JLabel("Saving Throw 1");
		lblSavingThrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingThrow.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblSavingThrow.setBounds(150, 201, 119, 31);
		panel_2.add(lblSavingThrow);

		JLabel lblSavingThrow_1 = new JLabel("Saving Throw 2");
		lblSavingThrow_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingThrow_1.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblSavingThrow_1.setBounds(279, 201, 119, 31);
		panel_2.add(lblSavingThrow_1);

		JLabel fieldST1 = new JLabel("");
		fieldST1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldST1.setHorizontalAlignment(SwingConstants.CENTER);
		fieldST1.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldST1.setBounds(150, 243, 119, 31);
		panel_2.add(fieldST1);

		JLabel fieldST2 = new JLabel("");
		fieldST2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldST2.setHorizontalAlignment(SwingConstants.CENTER);
		fieldST2.setFont(new Font("Papyrus", Font.BOLD, 12));
		fieldST2.setBounds(279, 243, 119, 31);
		panel_2.add(fieldST2);

		JLabel lblSkills = new JLabel("Skills");
		lblSkills.setHorizontalAlignment(SwingConstants.LEFT);
		lblSkills.setFont(new Font("Papyrus", Font.BOLD, 13));
		lblSkills.setBounds(160, 294, 109, 31);
		panel_2.add(lblSkills);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, Color.GRAY));
		panel_3.setBounds(150, 326, 303, 116);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 2, 5, 5));

		JLabel fieldSkill1 = new JLabel("");
		fieldSkill1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.add(fieldSkill1);
		fieldSkill1.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSkill1.setFont(new Font("Papyrus", Font.BOLD, 12));

		JLabel fieldSkill2 = new JLabel("");
		fieldSkill2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.add(fieldSkill2);
		fieldSkill2.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSkill2.setFont(new Font("Papyrus", Font.BOLD, 12));

		JLabel fieldSkill3 = new JLabel("");
		fieldSkill3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.add(fieldSkill3);
		fieldSkill3.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSkill3.setFont(new Font("Papyrus", Font.BOLD, 12));

		JLabel fieldSkill4 = new JLabel("");
		fieldSkill4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.add(fieldSkill4);
		fieldSkill4.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSkill4.setFont(new Font("Papyrus", Font.BOLD, 12));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBounds(820, 40, 429, 494);
		panel.add(panel_4);
		panel_4.setLayout(null);

		dlm2 = new DefaultListModel();
		JList eventList = new JList(dlm2);
		
		JScrollPane scrollPane_1 = new JScrollPane(eventList);
		scrollPane_1.setBounds(10, 11, 409, 413);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_4.add(scrollPane_1);

		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campaignLoaded) {
					Event temp = new Event();
					addEventCampaign(temp);
					
				}
			}
		});
		btnCreateEvent.setBounds(10, 448, 121, 23);
		panel_4.add(btnCreateEvent);

		JButton btnEditEvent = new JButton("Edit Event");
		btnEditEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!eventList.isSelectionEmpty()) {
					int index = eventList.getSelectedIndex();
					Event.displayEventWindow(currentCampaign.getEvents(), index, dlm2);
				}
			}
		});
		btnEditEvent.setBounds(167, 448, 101, 23);
		panel_4.add(btnEditEvent);

		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!eventList.isSelectionEmpty()) {
					int index = eventList.getSelectedIndex();
					currentCampaign.getEvents().remove(index);
					dlm2.remove(index);
				}
			}
		});
		btnDeleteEvent.setBounds(298, 448, 121, 23);
		panel_4.add(btnDeleteEvent);

		JButton btnLoadCampaign = new JButton("Load Campaign");
		btnLoadCampaign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
					dlm2.clear();
					int index = list.getSelectedIndex();
					currentCampaign = currentAccount.getCampaignList().get(index);
					playerCharacter character = currentCampaign.getMainCharacter();
					fieldCharName.setText(character.getName());
					fieldClass.setText(String.valueOf(character.getCharacterClass()));
					fieldRace.setText(character.getRace());
					fieldAlignment.setText(character.getAlignment());
					fieldEyes.setText(character.getEyes());
					fieldHair.setText(character.getHair());
					fieldSkin.setText(character.getSkin());
					fieldAge.setText(String.valueOf(character.getAge()));
					fieldWeight.setText(String.valueOf(character.getWeight()));
					fieldHeight.setText(String.valueOf(character.getHeight()));
					fieldStr.setText(String.valueOf(character.getStr()));
					fieldDex.setText(String.valueOf(character.getDex()));
					fieldCon.setText(String.valueOf(character.getCon()));
					fieldInt.setText(String.valueOf(character.getIntel()));
					fieldWis.setText(String.valueOf(character.getWis()));
					fieldChr.setText(String.valueOf(character.getCha()));
					fieldST1.setText(character.getSave1());
					fieldST2.setText(character.getSave2());
					fieldSkill1.setText(character.getSkill1());
					fieldSkill2.setText(character.getSkill2());
					fieldSkill3.setText(character.getSkill3());
					fieldSkill4.setText(character.getSkill4());
					
					
					for (Event element : currentCampaign.getEvents()) {
						dlm2.addElement(element);
					}
					campaignLoaded = true;
				}
			}
		});
		btnLoadCampaign.setBounds(10, 579, 142, 23);
		panel.add(btnLoadCampaign);
		
		JButton btnEditCharacter = new JButton("Edit Character");
		btnEditCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campaignLoaded) {
					CharacterCreatorUI ccui = new CharacterCreatorUI(currentCampaign.getMainCharacter());
					ccui.setVisible(true);
					ccui.generateCharacter(currentCampaign.getMainCharacter().getShareCode());
				}
			}
		});
		btnEditCharacter.setBounds(316, 545, 142, 23);
		panel.add(btnEditCharacter);
		
		JButton btnRoomgenerator = new JButton("Room Generator");
		btnRoomgenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MapGUI();
			}
		});
		btnRoomgenerator.setBounds(1061, 545, 169, 34);
		panel.add(btnRoomgenerator);
		
		JButton btnEncounterGenerator = new JButton("Encounter Generator");
		btnEncounterGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncounterGUI window = new EncounterGUI();
				
				
			}
		});
		btnEncounterGenerator.setBounds(1061, 590, 169, 34);
		panel.add(btnEncounterGenerator);
		
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

	public static void addEventCampaign(Event temp) {
		if(campaignLoaded) {
			Vector<Event> eventList = currentCampaign.getEvents();
			eventList.add(temp);
			Event.displayEventWindow(eventList, eventList.indexOf(temp), dlm2);
			
		}
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
		public void initialize(Account currentAccount, DefaultListModel dlm) {
			JTextField campaignName = new JTextField();
			JTextField startDate = new JTextField();

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			myPanel.add(new JLabel("Campaign Name:"));
			myPanel.add(campaignName);
			myPanel.add(new JLabel("Start Date (MM/DD/YY):"));
			myPanel.add(startDate);

			int result = JOptionPane.showConfirmDialog(null, myPanel, "Campaign Creator", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				Campaign temp = new Campaign(campaignName.getText(), startDate.getText());
				currentAccount.addCampaign(temp, dlm);

			}

		}
	}
	

}
