package wizards;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Conditions {
	private static String answer = "";


	private static JCheckBox blinded = new JCheckBox("Blinded");
	private static JCheckBox charmed = new JCheckBox("Charmed");
	private static JCheckBox deafened = new JCheckBox("Deafened");
	private static JCheckBox fatigued = new JCheckBox("Fatigued");
	private static JCheckBox invisible = new JCheckBox("Invisible");
	private static JCheckBox blessing = new JCheckBox("Blessing");
	private static JCheckBox petrified = new JCheckBox("Petrified");
	private static JCheckBox poisoned = new JCheckBox("Poisoned");
	private static JCheckBox stunned = new JCheckBox("Stunned");
	private static JCheckBox unconscious = new JCheckBox("Unconscious");

	private JFrame frameConditions;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conditions window = new Conditions();
					window.frameConditions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Conditions() {
		initialize();
	}

	public static String getAnswer() {
		return answer;
	}

	public static void resetConditions() {
		blinded.setSelected(false);
		charmed.setSelected(false);
		deafened.setSelected(false);
		fatigued.setSelected(false);
		invisible.setSelected(false);
		blessing.setSelected(false);
		stunned.setSelected(false);
		poisoned.setSelected(false);
		unconscious.setSelected(false);
		petrified.setSelected(false);

		answer = "";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		answer = "";
		frameConditions = new JFrame();
		frameConditions.requestFocus();
		frameConditions.setTitle("Apply Conditions");
		frameConditions.setBounds(100, 100, 450, 300);
		frameConditions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameConditions.setLocationRelativeTo(null);

		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (blinded.isSelected()) {
					answer += "You have become blinded by the darkness. Your dexterity temporarily decreases.\n";
				}

				if (charmed.isSelected()) {
					answer += "An adventurer finds you to be of great help. Your charisma increases.\n";
				}

				if (deafened.isSelected()) {
					answer += "A loud, screeching noise occurs. Your sense of hearing is dulled for awhile. Your strength decreases for awhile\n";
				}

				if (fatigued.isSelected()) {
					answer += "You are in need of food and water. Your movement speed is halved.\n";
				}

				if (invisible.isSelected()) {
					answer += "You spot an invisibility cloack nearby. Go collect it! This will allow you to dodge a specific encounter.\n";
				}

				if (blessing.isSelected()) {
					answer += "You find something glowing underneath a rock. It is a treasure that increases your intelligence. \n";
				}

				if (petrified.isSelected()) {
					answer += "You sense something awful, as your body fills with fear. Your accuracy decreases. \n";
				}

				if (poisoned.isSelected()) {
					answer += "You ate something bad. You have food poisoning. Your attack power has been decreased.\n";
				}

				if (stunned.isSelected()) {
					answer += "You see a spark of light, and suddenly your character is stunned. Your constitution decreases.\n";
				}

				if (unconscious.isSelected()) {
					answer += "You have overexerted yourself, and find yourself slipping away into a deep sleep. You must find somewhere safe to rest.\n";
				}
				frameConditions.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frameConditions.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(blinded)
								.addComponent(charmed)
								.addComponent(deafened)
								.addComponent(fatigued)
								.addComponent(invisible))
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(blessing)
								.addComponent(stunned)
								.addComponent(poisoned)
								.addComponent(unconscious)
								.addComponent(petrified)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(blinded)
						.addComponent(blessing))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(poisoned)
							.addGap(18)
							.addComponent(stunned)
							.addGap(18)
							.addComponent(unconscious))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(charmed)
								.addComponent(petrified))
							.addGap(18)
							.addComponent(deafened)
							.addGap(18)
							.addComponent(fatigued)
							.addGap(18)
							.addComponent(invisible)))
					.addGap(18)
					.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addContainerGap())
		);
		frameConditions.getContentPane().setLayout(groupLayout);
		resetConditions();

	}

}
