package wizards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Event {
	private double sessionNumber;
	private String sessionDate;
	private String gameWeather;
	private String gameTime;
	private String color;
	private String description;
	private String label;

	public static void main(String[] args) {
		displayEventWindow(new Vector<Event>(), 0, new DefaultListModel());
	}

	public Event() {

	}

	// Getters&Setters
	public void setSessionNumber(double sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public double getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}

	public String getSessionDate() {
		return sessionDate;
	}

	public void setGameWeather(String gameWeather) {
		this.gameWeather = gameWeather;
	}

	public String getGameWeather() {
		return gameWeather;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public String getGameTime() {
		return gameTime;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	// Requirements
	public void colorCodeEvent() {

	}

	public void trackDayNight(String gameTime) {

	}

	public void trackWeather(String gameWeather) {

	}

	@Override
	public String toString() {
		return "Session No: " + sessionNumber + " | " + label + " | " + sessionDate;
	}

	public static void displayEventWindow(Vector<Event> events, int index, DefaultListModel dlm) {
		JFrame f = new JFrame();
		f.setLocationRelativeTo(null);

		JButton save = new JButton("Save");

		int labelX = 40;
		int fieldX = 160;
		int height = 30;

		// Session Number
		JLabel sessionNum = new JLabel("Session Number");
		sessionNum.setBounds(labelX, 30, 100, height);
		double initial = 0;

		initial = events.get(index).getSessionNumber();

		SpinnerModel model = new SpinnerNumberModel(initial, 0, 30, 0.5);
		JSpinner sessionSpin = new JSpinner(model);
		sessionSpin.setBounds(fieldX, 30, 50, height);

		// Label
		JLabel sessionLabel = new JLabel("Session Label");
		JTextField sessionL = new JTextField(events.get(index).getLabel());
		sessionLabel.setBounds(labelX, 80, 100, height);
		sessionL.setBounds(fieldX, 80, 300, height);

		// Session Date
		JLabel sessionDateLabel = new JLabel("Session Date");
		JFormattedTextField sessionDate = new JFormattedTextField(events.get(index).getSessionDate());
		sessionDateLabel.setBounds(labelX, 130, 100, height);
		sessionDate.setBounds(fieldX, 130, 300, height);

		// Game Weather
		JLabel gameWeatherLabel = new JLabel("In-Game Weather");
		JTextField gameWeather = new JTextField(events.get(index).getGameWeather());
		gameWeatherLabel.setBounds(labelX, 180, 100, height);
		gameWeather.setBounds(fieldX, 180, 300, height);

		// Game Time
		JLabel gameTimeLabel = new JLabel("In-Game Time");
		JTextField gameTime = new JTextField(events.get(index).getGameTime());
		gameTimeLabel.setBounds(labelX, 230, 100, height);
		gameTime.setBounds(fieldX, 230, 300, height);

		// Color

		// Description
		JTextArea description = new JTextArea(events.get(index).getDescription());
		description.setBorder(new LineBorder(new Color(0, 0, 0)));
		description.setLineWrap(true);
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(labelX, 300, 300, height);
		description.setBounds(160, 300, 300, 153);

		JScrollPane scrollPane = new JScrollPane(description);
		scrollPane.setBounds(160, 300, 300, 153);

		// Save
		save.setBounds(460, 500, 100, 40);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SessionNumber
				try {
					sessionSpin.commitEdit();
				} catch (java.text.ParseException e1) {
					System.out.println("The spinner did not commit");
				}

				double value = (Double) sessionSpin.getValue();
				events.get(index).setSessionNumber(value);

				// Session Date
				String sDate = sessionDate.getText();
				events.get(index).setSessionDate(sDate);

				// Game Weather
				String gWeather = gameWeather.getText();
				events.get(index).setGameWeather(gWeather);

				// Game Time
				String gTime = gameTime.getText();
				events.get(index).setGameTime(gTime);

				// Color

				// Description
				String desc = description.getText();
				events.get(index).setDescription(desc);

				// Label
				String sessLabel = sessionL.getText();
				events.get(index).setLabel(sessLabel);
				if (!dlm.contains(events.get(index))) {
					dlm.addElement(events.get(index));
				}

				f.dispose();

			}
		});
		f.getContentPane().add(save);
		f.getContentPane().add(sessionSpin);
		f.getContentPane().add(sessionNum);
		f.getContentPane();
		f.getContentPane().add(descriptionLabel);
		f.getContentPane().add(gameTime);
		f.getContentPane().add(gameTimeLabel);
		f.getContentPane().add(gameWeather);
		f.getContentPane().add(gameWeatherLabel);
		f.getContentPane().add(sessionDate);
		f.getContentPane().add(sessionDateLabel);
		f.getContentPane().add(sessionLabel);
		f.getContentPane().add(sessionL);
		f.getContentPane().add(scrollPane);

		f.setSize(600, 600);
		f.getContentPane().setLayout(null);

		f.setVisible(true);

	}
}
