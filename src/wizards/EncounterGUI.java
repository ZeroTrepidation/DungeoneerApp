 
package wizards;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
 
public class EncounterGUI{
 
    private JFrame frame;
     static JTextField textField_enemy1;
     static JTextField textField_enemy2;
     static JTextField textField_enemy3;
     static JTextField textField_enemy4;
     static JTextField textField_enemy5;
     static JTextField textField_enemy6;
     static JComboBox comboEnemyList;
     static JLabel lblTotalXpValue;
     static JLabel lblAdjustedXpValue;
     static JLabel lblDiffValue;
     static JLabel lblCurrentEncounter;
     private JComboBox comboBoxDifficulty;
     private JLabel lblDifficultyChoice;
     private JButton btnGenerateShareCode;
     private JButton btnLoadShareCode;
     private JTextField textFieldShareCode;
     
     public int number_of_enemies = 0;
     public int xp = 0;
     public int adjusted = 0;
     public String shrCde;
     public String Diff = "Medium";
     

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        
    	
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EncounterGUI window = new EncounterGUI();
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
    public EncounterGUI() {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 808, 459);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        

        
        comboEnemyList = new JComboBox();
        comboEnemyList.setBounds(163, 44, 117, 22);
        frame.getContentPane().add(comboEnemyList);
        comboEnemyList.addItem("Select");
        comboEnemyList.addItem("Bandit");
        comboEnemyList.addItem("Bandit Chief");
        comboEnemyList.addItem("Cultist");
        comboEnemyList.addItem("Dire Wolf");
        comboEnemyList.addItem("Ghost");
        comboEnemyList.addItem("Goblin");
        comboEnemyList.addItem("Knight");
        comboEnemyList.addItem("Orc");
        comboEnemyList.addItem("Wererat");
        comboEnemyList.addItem("Werewolf");
        comboEnemyList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        
        
        JButton btnGenerate = new JButton("Random Encounter");
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Diff = comboBoxDifficulty.getSelectedItem().toString();
        		generateEncouter(Diff);
        	}
        });
        btnGenerate.setBounds(45, 95, 175, 25);
        frame.getContentPane().add(btnGenerate);
        
        JButton btnGetXp = new JButton("Get XP");
        btnGetXp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblTotalXpValue.setText(Integer.toString(getXP()));	
        		lblAdjustedXpValue.setText(Integer.toString(adjustedXP(xp)));
        		lblDiffValue.setText(getDifficulty(adjustedXP(xp)));
        	}
        });
        
        lblCurrentEncounter = new JLabel("Current Encounter(max size 6)");
        lblCurrentEncounter.setBounds(348, 47, 189, 16);
        frame.getContentPane().add(lblCurrentEncounter);
        btnGetXp.setBounds(614, 193, 81, 25);
        frame.getContentPane().add(btnGetXp);
        
        JButton btnAddEnemy = new JButton("Add Enemy");
        btnAddEnemy.setBounds(45, 43, 97, 25);
        frame.getContentPane().add(btnAddEnemy);
        btnAddEnemy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(!comboEnemyList.getSelectedItem().toString().equalsIgnoreCase("select")) {
            		String value = comboEnemyList.getSelectedItem().toString();
            		addEnemy(value);
            		//getXP();
            	}
            }
        });
         
        
        textField_enemy1 = new JTextField();
        textField_enemy1.setBounds(414, 80, 116, 22);
        frame.getContentPane().add(textField_enemy1);
        textField_enemy1.setColumns(10);
        
        textField_enemy2 = new JTextField();
        textField_enemy2.setBounds(414, 110, 116, 22);
        frame.getContentPane().add(textField_enemy2);
        textField_enemy2.setColumns(10);
        
        textField_enemy3 = new JTextField();
        textField_enemy3.setBounds(414, 145, 116, 22);
        frame.getContentPane().add(textField_enemy3);
        textField_enemy3.setColumns(10);
        
        textField_enemy4 = new JTextField();
        textField_enemy4.setBounds(414, 177, 116, 22);
        frame.getContentPane().add(textField_enemy4);
        textField_enemy4.setColumns(10);
        
        textField_enemy5 = new JTextField();
        textField_enemy5.setBounds(414, 212, 116, 22);
        frame.getContentPane().add(textField_enemy5);
        textField_enemy5.setColumns(10);
        
        textField_enemy6 = new JTextField();
        textField_enemy6.setBounds(414, 247, 116, 22);
        frame.getContentPane().add(textField_enemy6);
        textField_enemy6.setColumns(10);
        
        JButton btn_Clear1 = new JButton("X");
        btn_Clear1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!(textField_enemy1.getText().equalsIgnoreCase(""))||!(textField_enemy1.getText().equalsIgnoreCase(null))){
        			textField_enemy1.setText(null);
            		number_of_enemies --;
        		}
        	}
        });
        btn_Clear1.setBounds(348, 79, 54, 25);
        frame.getContentPane().add(btn_Clear1);
        
        JButton btn_Clear2 = new JButton("X");
        btn_Clear2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!(textField_enemy2.getText().equalsIgnoreCase(""))||!(textField_enemy2.getText().equalsIgnoreCase(null))){
        			textField_enemy2.setText(null);
            		number_of_enemies --;
        		}
        	}
        });
        btn_Clear2.setBounds(348, 112, 54, 25);
        frame.getContentPane().add(btn_Clear2);
        
        JButton btn_Clear3 = new JButton("X");
        btn_Clear3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!(textField_enemy3.getText().equalsIgnoreCase(""))||!(textField_enemy3.getText().equalsIgnoreCase(null))){
        			textField_enemy3.setText(null);
            		number_of_enemies --;
        		}
        	}
        });
        btn_Clear3.setBounds(348, 144, 54, 25);
        frame.getContentPane().add(btn_Clear3);
        
        JButton btn_Clear4 = new JButton("X");
        btn_Clear4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!(textField_enemy4.getText().equalsIgnoreCase(""))||!(textField_enemy4.getText().equalsIgnoreCase(null))){
        			textField_enemy4.setText(null);
            		number_of_enemies --;
        		}
        	}
        });
        btn_Clear4.setBounds(348, 176, 54, 25);
        frame.getContentPane().add(btn_Clear4);
        
        JButton btn_Clear5 = new JButton("X");
        btn_Clear5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!(textField_enemy5.getText().equalsIgnoreCase(""))||!(textField_enemy5.getText().equalsIgnoreCase(null))){
        			textField_enemy5.setText(null);
            		number_of_enemies --;
        		}
        	}
        });
        btn_Clear5.setBounds(348, 211, 54, 25);
        frame.getContentPane().add(btn_Clear5);
        
        JButton btn_Clear6 = new JButton("X");
        btn_Clear6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!(textField_enemy6.getText().equalsIgnoreCase(""))||!(textField_enemy6.getText().equalsIgnoreCase(null))){
        			textField_enemy6.setText(null);
            		number_of_enemies --;
        		}
        	}
        });
        btn_Clear6.setBounds(348, 246, 54, 25);
        frame.getContentPane().add(btn_Clear6);
        
        JLabel lblDifficulty = new JLabel("Difficulty: ");
        lblDifficulty.setBounds(614, 83, 71, 16);
        frame.getContentPane().add(lblDifficulty);
        
        JLabel lblTotalXp = new JLabel("Total XP:");
        lblTotalXp.setBounds(614, 116, 56, 16);
        frame.getContentPane().add(lblTotalXp);
        
        JLabel lblAdjustedXp = new JLabel("Adjusted XP:");
        lblAdjustedXp.setBounds(614, 148, 87, 16);
        frame.getContentPane().add(lblAdjustedXp);
        
        lblDiffValue = new JLabel("None");
        lblDiffValue.setBounds(726, 83, 97, 16);
        frame.getContentPane().add(lblDiffValue);
        
        lblTotalXpValue = new JLabel("0");
        lblTotalXpValue.setBounds(726, 116, 97, 16);
        frame.getContentPane().add(lblTotalXpValue);
        
        lblAdjustedXpValue = new JLabel("0");
        lblAdjustedXpValue.setBounds(726, 148, 97, 16);
        frame.getContentPane().add(lblAdjustedXpValue);
        
        comboBoxDifficulty = new JComboBox();
        comboBoxDifficulty.setBounds(113, 145, 97, 22);
        frame.getContentPane().add(comboBoxDifficulty);
        comboBoxDifficulty.addItem("Select");
        comboBoxDifficulty.addItem("Easy");
        comboBoxDifficulty.addItem("Medium");
        comboBoxDifficulty.addItem("Hard");
        comboBoxDifficulty.addItem("Deadly");
        
        lblDifficultyChoice = new JLabel("Difficulty");
        lblDifficultyChoice.setBounds(45, 148, 56, 16);
        frame.getContentPane().add(lblDifficultyChoice);
        
        btnGenerateShareCode = new JButton("Generate Share Code");
        btnGenerateShareCode.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		generateShareCode();
        	}
        });
        btnGenerateShareCode.setBounds(45, 354, 175, 25);
        frame.getContentPane().add(btnGenerateShareCode);
        
        btnLoadShareCode = new JButton("Load Share Code");
        btnLoadShareCode.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loadShareCode(textFieldShareCode.getText());
        	}
        });
        btnLoadShareCode.setBounds(232, 354, 175, 25);
        frame.getContentPane().add(btnLoadShareCode);
        
        textFieldShareCode = new JTextField();
        textFieldShareCode.setBounds(45, 319, 357, 22);
        frame.getContentPane().add(textFieldShareCode);
        textFieldShareCode.setColumns(10);
        
        JButton btnExportToNew = new JButton("Export to New Event");
        btnExportToNew.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Event temp =  new Event();
        		temp.setLabel("Generated Encounter");
        		temp.setDescription("Encounter Summary: \n"
        				+ "Monsters Encountered: \n"
        				+ ((textField_enemy1.getText()=="") ? "" : "\t" + textField_enemy1.getText() + "\n")
        				+ ((textField_enemy2.getText()=="") ? "" : "\t" + textField_enemy2.getText() + "\n")
        				+ ((textField_enemy3.getText()=="") ? "" : "\t" + textField_enemy3.getText() + "\n")
        				+ ((textField_enemy4.getText()=="") ? "" : "\t" + textField_enemy4.getText() + "\n")
        				+ ((textField_enemy5.getText()=="") ? "" : "\t" + textField_enemy5.getText() + "\n")
        				+ ((textField_enemy6.getText()=="") ? "" : "\t" + textField_enemy6.getText() + "\n")
        				+ "\nPotential EXP: " + getXP());
        		CampaignWindow.addEventCampaign(temp);
        	}
        	
        });
        btnExportToNew.setBounds(614, 355, 175, 25);
        frame.getContentPane().add(btnExportToNew);
        
        JLabel lblNewLabel = new JLabel("(Requires Campaign Loaded)");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(624, 393, 153, 14);
        frame.getContentPane().add(lblNewLabel);
        comboEnemyList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        
        frame.setVisible(true);
        
        
        
 
       }

    public void addEnemy(String Enemy) {
    	
    	
    	if(textField_enemy1.getText().equalsIgnoreCase("")||textField_enemy1.getText().equalsIgnoreCase(null)){
    		textField_enemy1.setText(Enemy);
    		number_of_enemies ++;
    		
		}
		else if(textField_enemy2.getText().equalsIgnoreCase("")||textField_enemy2.getText().equalsIgnoreCase(null)){
			textField_enemy2.setText(Enemy);
			number_of_enemies ++;
		}
		else if(textField_enemy3.getText().equalsIgnoreCase("")||textField_enemy3.getText().equalsIgnoreCase(null)){
			textField_enemy3.setText(Enemy);
			number_of_enemies ++;
		}
		else if(textField_enemy4.getText().equalsIgnoreCase("")||textField_enemy4.getText().equalsIgnoreCase(null)){
			textField_enemy4.setText(Enemy);
			number_of_enemies ++;
		}
		else if(textField_enemy5.getText().equalsIgnoreCase("")||textField_enemy5.getText().equalsIgnoreCase(null)){
			textField_enemy5.setText(Enemy);
			number_of_enemies ++;
		}
		else if(textField_enemy6.getText().equalsIgnoreCase("")||textField_enemy6.getText().equalsIgnoreCase(null)){
			textField_enemy6.setText(Enemy);
			number_of_enemies ++;
		}
    	
    }

    public void generateEncouter(String Difficulty) {
		textFieldShareCode.setText(null);
    	int xp_level = 0;
    	int max_level = 0;
    	int encounter_xp = 0;
    	int index = 0;
    	int counter = 0;
    	int check = 0;
    	Random r = new Random();
    	
    	textField_enemy1.setText(null);
    	textField_enemy2.setText(null);
    	textField_enemy3.setText(null);
    	textField_enemy4.setText(null);
    	textField_enemy5.setText(null);
    	textField_enemy6.setText(null);
    	
    	if(Difficulty.equalsIgnoreCase("Easy")) {
    		xp_level = 1250;
    		max_level = 2500;
    	}
    	else if(Difficulty.equalsIgnoreCase("Medium")) {
    		xp_level = 2500;
    		max_level = 3750;
    	}
    	else if(Difficulty.equalsIgnoreCase("Hard")) {
    		xp_level = 3750;
    		max_level = 5500;
    	}
    	else if(Difficulty.equalsIgnoreCase("Deadly")) {
    		xp_level = 5500;
    		max_level = 7000;
    	}
    	else {
    		xp_level = 2500;

    	}
    	
    	if(Difficulty.equalsIgnoreCase("Select")) 
    	{
    		while((encounter_xp < xp_level) && (counter < 6)) {
	    		index = r.nextInt((7)+1)+1;
	    		String temp = comboEnemyList.getItemAt(index).toString();
	    		addEnemy(temp);
	    		getXP();
	    		encounter_xp = adjustedXP(xp);
	    		counter ++;
	    	}
	    	lblTotalXpValue.setText(Integer.toString(getXP()));	
			lblAdjustedXpValue.setText(Integer.toString(adjustedXP(xp)));
			lblDiffValue.setText(getDifficulty(adjustedXP(xp)));
    	}
    	else
    	{
    	
	    	while(check == 0) 
	    	{
		    	while((encounter_xp < xp_level) && (counter < 6)) 
		    	{
		    		index = r.nextInt((7)+1)+1;
		    		String temp = comboEnemyList.getItemAt(index).toString();
		    		addEnemy(temp);
		    		getXP();
		    		encounter_xp = adjustedXP(xp);
		    		counter ++;
		    		//System.out.println("error in inner loop 410");
		    	
		    	}
				lblDiffValue.setText(getDifficulty(adjustedXP(xp)));
				
				if(Difficulty.equalsIgnoreCase(lblDiffValue.getText())) {
					check = 1;
				}
				else
				{

					for(int i = 0; i < 6; i++) {
						removeEnemy(i);
						
					}
					counter = 0;
					check = 0;
					encounter_xp = 0;
				}
				//System.out.println("error in outer loop 425");
	    	}
    	
    	lblTotalXpValue.setText(Integer.toString(getXP()));	
		lblAdjustedXpValue.setText(Integer.toString(adjustedXP(xp)));
		lblDiffValue.setText(getDifficulty(adjustedXP(xp)));
    	}
    	
    	

    }
    
    public void removeEnemy(int index) {
    	if(index == 1) {
    		textField_enemy1.setText(null);
    	}
    	else if(index == 2) {
    		textField_enemy2.setText(null);
    	}
    	else if(index == 3) {
    		textField_enemy3.setText(null);
    	}
    	else if(index == 4) {
    		textField_enemy4.setText(null);
    	}
    	else if(index == 5) {
    		textField_enemy5.setText(null);
    	}
    	else if(index == 6) {
    		textField_enemy6.setText(null);
    	}
    }
    
    public int getXP() {
    	xp = 0;
    	String temp = null;
    	
    	if( !(textField_enemy1.getText().equalsIgnoreCase(null)) && !(textField_enemy1.getText().equalsIgnoreCase("")) ) {
    		xp += getMonsterObj(textField_enemy1.getText()).getXp();
    	}
    	
    	if( !(textField_enemy2.getText().equalsIgnoreCase(null)) && !(textField_enemy2.getText().equalsIgnoreCase("")) ) {
    		xp += getMonsterObj(textField_enemy2.getText()).getXp();
    	}
    	
    	if( !(textField_enemy3.getText().equalsIgnoreCase(null)) && !(textField_enemy3.getText().equalsIgnoreCase("")) ) {
    		xp += getMonsterObj(textField_enemy3.getText()).getXp();
    	}
    	
    	if( !(textField_enemy4.getText().equalsIgnoreCase(null)) && !(textField_enemy4.getText().equalsIgnoreCase("")) ) {
    		xp += getMonsterObj(textField_enemy4.getText()).getXp();
    	}
    	
    	if( !(textField_enemy5.getText().equalsIgnoreCase(null)) && !(textField_enemy5.getText().equalsIgnoreCase("")) ) {
    		xp += getMonsterObj(textField_enemy5.getText()).getXp();
    	}
    	
    	if( !(textField_enemy6.getText().equalsIgnoreCase(null)) && !(textField_enemy6.getText().equalsIgnoreCase("")) ) {
    		xp += getMonsterObj(textField_enemy6.getText()).getXp();
    	}
    	
    	return xp;
    }
    
    public int adjustedXP(int xp) {
    	
    	int adjusted = 0;
    	if(number_of_enemies ==1) {
    		adjusted = xp * 1;
    	}
    	else if(number_of_enemies == 2) {
    		adjusted = (int) (xp * 1.5);
    	}
    	else if((number_of_enemies >=3) && (number_of_enemies <= 6)){
    		adjusted = xp * 2;
    	}
    	else if((number_of_enemies >= 7) && (number_of_enemies <= 10)) {
    		adjusted = (int) (xp * 2.5);
    	}
    	else if((number_of_enemies >= 11)&&(number_of_enemies <= 14)) {
    		adjusted = xp * 3;
    	}
    	else if(number_of_enemies > 15) {
    		adjusted = xp * 4;
    	}
    	return adjusted;
    }
    
    public String getDifficulty(int adjXp) {
    	String diff = "no difficulty";
    	

    	if(adjXp < 1250) {
    		diff = "Trivial";
    	}
    	else if(adjXp >= 1250 && adjXp < 2500) {
    		diff = "Easy";
    	}
    	else if(adjXp >= 2500 && adjXp < 3750) {
    		diff = "Medium";
    	}
    	else if(adjXp >= 3750 && adjXp < 5500) {
    		diff = "Hard";
    	}
    	else if(adjXp >= 5500) {
    		diff = "Deadly";
    	}
    	
    	
    	return diff;
    }
    
    public Monsters getMonsterObj(String name) {
    	if(name.equalsIgnoreCase("Bandit")) {
    		return Monsters.Bandit;
    	}
    	else if(name.equalsIgnoreCase("Bandit Chief")) {
    		return Monsters.BanditChief;
    	}
    	else if(name.equalsIgnoreCase("Cultist")) {
    		return Monsters.Goblin;
    	}
    	else if(name.equalsIgnoreCase("Goblin")) {
    		return Monsters.Orc;
    	}
    	else if(name.equalsIgnoreCase("Orc")) {
    		return Monsters.Cultist;
    	}
    	else if(name.equalsIgnoreCase("Werewolf")) {
    		return Monsters.Werewolf;
    	}
    	else if(name.equalsIgnoreCase("Knight")) {
    		return Monsters.Knight;
    	}
    	else if(name.equalsIgnoreCase("Wererat")) {
    		return Monsters.Wererat;
    	}
    	else if(name.equalsIgnoreCase("Dire Wolf")) {
    		return Monsters.DireWolf;
    	}
    	else if(name.equalsIgnoreCase("Ghost")) {
    		return Monsters.Ghost;
    	}

    	else return null;
    }
    
    public String generateShareCode(){
    	StringBuilder code = new StringBuilder("");
    	String nextEnemy = null;
    	
    	nextEnemy = textField_enemy1.getText();
    	code.append(convertToCode(nextEnemy));
    	nextEnemy = textField_enemy2.getText();
    	code.append(convertToCode(nextEnemy));
    	nextEnemy = textField_enemy3.getText();
    	code.append(convertToCode(nextEnemy));
    	nextEnemy = textField_enemy4.getText();
    	code.append(convertToCode(nextEnemy));
    	nextEnemy = textField_enemy5.getText();
    	code.append(convertToCode(nextEnemy));
    	nextEnemy = textField_enemy6.getText();
    	code.append(convertToCode(nextEnemy));
    	
    	textFieldShareCode.setText(code.toString());
    	
    	//System.out.printf("at 505, string is %s\n", code.toString());
    	
    	return code.toString();
    }
    
    public void loadShareCode(String code) {
    	String test = code;
    	
    	if(code.length() != 18) {
    		System.out.println("wrong length");
    	}
    	else {
    	
    	textField_enemy1.setText(null);
    	textField_enemy2.setText(null);
    	textField_enemy3.setText(null);
    	textField_enemy4.setText(null);
    	textField_enemy5.setText(null);
    	textField_enemy6.setText(null);
    	
    	String enemy1 = test.substring(0,3);
    	String enemy2 = test.substring(3,6);
    	String enemy3 = test.substring(6,9);
    	String enemy4 = test.substring(9,12);
    	String enemy5 = test.substring(12,15);
    	String enemy6 = test.substring(15,18);
    	
    	textField_enemy1.setText(convertFromCode(enemy1));
    	textField_enemy2.setText(convertFromCode(enemy2));
    	textField_enemy3.setText(convertFromCode(enemy3));
    	textField_enemy4.setText(convertFromCode(enemy4));
    	textField_enemy5.setText(convertFromCode(enemy5));
    	textField_enemy6.setText(convertFromCode(enemy6));
    	
    	}
    	
    	lblTotalXpValue.setText(Integer.toString(getXP()));	
		lblAdjustedXpValue.setText(Integer.toString(adjustedXP(xp)));
		lblDiffValue.setText(getDifficulty(adjustedXP(xp)));
    }
  
    public String convertToCode(String enemy) {
    	//String code = null;
    	if(enemy.equalsIgnoreCase("Bandit")) {
    		return Monsters.Bandit.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Bandit Chief")) {
    		return Monsters.BanditChief.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Cultist")) {
    		return Monsters.Goblin.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Goblin")) {
    		return Monsters.Orc.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Orc")) {
    		return Monsters.Cultist.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Werewolf")) {
    		return Monsters.Werewolf.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Knight")) {
    		return Monsters.Knight.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Wererat")) {
    		return Monsters.Wererat.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Dire Wolf")) {
    		return Monsters.DireWolf.getCode();
    	}
    	else if(enemy.equalsIgnoreCase("Ghost")) {
    		return Monsters.Ghost.getCode();
    	}
 

    	else return "nul";
    }
    
    public String convertFromCode(String code) {
    	String enemyName = code;
    	
    	if(enemyName.equalsIgnoreCase("nul")) {
    		enemyName = null;
    	}
    	else if(enemyName.equalsIgnoreCase("bdt")) {
    		enemyName =  Monsters.Bandit.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("bdc")) {
    		enemyName =  Monsters.BanditChief.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("gob")) {
    		enemyName =  Monsters.Goblin.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("orc")) {
    		enemyName =  Monsters.Orc.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("cul")) {
    		enemyName =  Monsters.Cultist.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("wrw")) {
    		enemyName =  Monsters.Werewolf.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("kni")) {
    		enemyName =  Monsters.Knight.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("wrr")) {
    		enemyName =  Monsters.Wererat.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("drw")) {
    		enemyName =  Monsters.DireWolf.getName();
    	}
    	else if(enemyName.equalsIgnoreCase("gho")) {
    		enemyName =  Monsters.Ghost.getName();
    	}
    	else {
    		enemyName = null;
    	}
 
    	
    	
    	return enemyName;
    }
}






