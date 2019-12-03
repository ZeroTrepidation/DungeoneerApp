package wizards;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Filter {
	private static String answer = "";

	private JFrame filterFrame;
	private static JCheckBox arctic = new JCheckBox("Arctic");
	private static JCheckBox temperate = new JCheckBox("Temperate");
	private static JCheckBox tropical = new JCheckBox("Tropical");
	private static JCheckBox dry = new JCheckBox("Dry");

	/**
	 * Launch the application.
	 */

	public static void display() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filter window = new Filter();
					window.filterFrame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public Filter() {
		initialize();
	}

	public static String getAnswer() {
		return answer;
	}

	public static void resetFilters() {
		arctic.setSelected(false);
		temperate.setSelected(false);
		tropical.setSelected(false);
		dry.setSelected(false);

		answer = "";
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		answer = "";
		filterFrame = new JFrame();
		filterFrame.requestFocus();
		filterFrame.setTitle("Apply Filters");
		filterFrame.setBounds(100, 100, 450, 300);
		filterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		filterFrame.setLocationRelativeTo(null);

		arctic.setHorizontalAlignment(SwingConstants.CENTER);
		temperate.setHorizontalAlignment(SwingConstants.CENTER);
		tropical.setHorizontalAlignment(SwingConstants.CENTER);
		dry.setHorizontalAlignment(SwingConstants.CENTER);

		JButton save = new JButton("Save");

		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (arctic.isSelected()) {
					answer += "You find yourself in extreme cold temperatures.\n";
				}

				if (temperate.isSelected()) {
					answer += "You find yourself suddenly surrounded by trees in a forest/grassland.\n";
				}

				if (tropical.isSelected()) {
					answer += "You find yourself in the svanna/woodlands. The atmosphere is very humid.\n";
				}

				if (dry.isSelected()) {
					answer += "You find yourself thirsty. You are in a dry place that is extremely hot.\n";
				}
				filterFrame.dispose();
			}
		});

		GroupLayout groupLayout = new GroupLayout(filterFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tropical)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(dry)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(temperate)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(arctic)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(save, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(155))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(arctic)
					.addGap(18)
					.addComponent(temperate)
					.addGap(18)
					.addComponent(tropical)
					.addGap(18)
					.addComponent(dry)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		filterFrame.getContentPane().setLayout(groupLayout);
		resetFilters();
	}
}
