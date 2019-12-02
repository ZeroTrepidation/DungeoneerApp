 
package wizards;




//package swing_1;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
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
     
     public int number_of_enemies = 0;
     public int xp = 0;
     public int adjusted = 0;
     public String Diff = "Medium";
     private JComboBox comboBoxDifficulty;
     private JLabel lblBiome;

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
        comboEnemyList.addItem("Goblin");
        comboEnemyList.addItem("Orc");
        comboEnemyList.addItem("Werewolf");
        comboEnemyList.addItem("Knight");
        comboEnemyList.addItem("Wererat");
        comboEnemyList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        
        
        JButton btnGenerate = new JButton("Generate New Encounter");
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Diff = comboBoxDifficulty.getSelectedItem().toString();
        		generateEncouter(Diff);
        	}
        });
        btnGenerate.setBounds(45, 95, 175, 25);
        frame.getContentPane().add(btnGenerate);
        
        lblCurrentEncounter = new JLabel("Current Encounter(max size 6)");
        lblCurrentEncounter.setBounds(348, 47, 189, 16);
        frame.getContentPane().add(lblCurrentEncounter);
        
        JButton btnGetXp = new JButton("Get XP");
        btnGetXp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblTotalXpValue.setText(Integer.toString(getXP()));	
        		lblAdjustedXpValue.setText(Integer.toString(adjustedXP(xp)));
        		lblDiffValue.setText(getDifficulty(adjustedXP(xp)));
        	}
        });
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
        
        lblBiome = new JLabel("Difficulty");
        lblBiome.setBounds(45, 148, 56, 16);
        frame.getContentPane().add(lblBiome);
        comboEnemyList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        
        
        
        
 
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
    	int xp_level = 0;
    	int encounter_xp = 0;
    	int index = 0;
    	int counter = 0;
    	Random r = new Random();
    	
    	textField_enemy1.setText(null);
    	textField_enemy2.setText(null);
    	textField_enemy3.setText(null);
    	textField_enemy4.setText(null);
    	textField_enemy5.setText(null);
    	textField_enemy6.setText(null);
    	
    	
    	
    	if(Difficulty.equalsIgnoreCase("Easy")) {
    		xp_level = 1250;
    	}
    	else if(Difficulty.equalsIgnoreCase("Medium")) {
    		xp_level = 2500;
    	}
    	else if(Difficulty.equalsIgnoreCase("Hard")) {
    		xp_level = 3750;
    	}
    	else if(Difficulty.equalsIgnoreCase("Deadly")) {
    		xp_level = 5500;
    	}
    	else {
    		xp_level = 2500;
    	}
    	
    	while((encounter_xp < xp_level) && (counter < 6)) {
    		index = r.nextInt((7)+1)+1;
    		
    		String temp = comboEnemyList.getItemAt(index).toString();
    		//System.out.println(temp);
    		addEnemy(temp);
    		getXP();
    		encounter_xp = adjustedXP(xp);
    		//System.out.printf("at 385 ecounter adjusted  = %d\n", encounter_xp);
    		counter ++;
    		    		
    		
    		//System.out.printf("at 363, mosnter xp xp = ", getMonsterObj(comboEnemyList.getItemAt(index).toString()).getXp());
    		
    	}

    }
    
    public int getXP() {
    	xp = 0;
    	String temp = null;
    	//System.out.printf("at 362 xp = %d\n", xp);
    	
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
    	
    	//System.out.printf("at 416 adj = %d\n", adjXp);
    	
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
    	else return null;
    }
}






