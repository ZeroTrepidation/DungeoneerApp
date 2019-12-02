package wizards;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;

public class Timeline {
	static int eventLimit = 20;
	static int eventCount = 0;


	public static void main(String[] args) {
		Timeline timeline = new Timeline();
		Vector<Event> events = new Vector<Event>();

		timeline.timelinePage(timeline, events);
	}

	public void timelinePage(Timeline timeline, Vector<Event> events) {
		JFrame f = new JFrame("Timeline");

		JLabel description = new JLabel("You get " + (eventLimit-eventCount) + " events");
		description.setBounds(30,30,200,30);

		JButton createEvent = new JButton("Create Event");
		createEvent.setBounds(510, 90, 120, 40);
		createEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eventCount < eventLimit) {
					timeline.createEvent(timeline, events);
					f.dispose();
				}
			}
		});

		String[] labels = new String[eventLimit];

		labels[0] = "Create an Event";

		for(int i = 0; i < events.size(); i++) {
			if(events.get(i) != null) {
				labels[i] = "Session " + events.get(i).getSessionNumber() + ": " + events.get(i).getLabel();
			}
		}
		JList list = new JList(labels);

		JScrollPane scrollableList = new JScrollPane(list);
		scrollableList.setBounds(40, 140, 600, 400);


		JButton editEvent = new JButton("Edit Event");
		editEvent.setBounds(510, 600, 120, 40);
		editEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int edit = list.getSelectedIndex();
				timeline.editEvent(timeline, events, edit);
				f.dispose();
			}
		});




		f.add(description); f.add(createEvent); f.add(scrollableList); f.add(editEvent);
		f.setSize(700,800);
		f.setLayout(null);
		f.setVisible(true);		
	}

	public void displayEventWindow(Timeline timeline, JFrame f, Vector<Event> events, int index) {
		JButton save = new JButton("Save");
		JButton cancel = new JButton("Cancel");

		int labelX = 40;
		int fieldX = 160;
		int height = 30;

		//Session Number
		JLabel sessionNum = new JLabel("Session Number");
		sessionNum.setBounds(labelX,30,100,height);
		double initial = 0;
		if(eventCount != 0) {
			initial = events.get(index).getSessionNumber();
		}

		SpinnerModel model = new SpinnerNumberModel(initial, 0, eventLimit, 0.5);
		JSpinner sessionSpin = new JSpinner(model);
		sessionSpin.setBounds(fieldX,30,50,height);

		//Label
		JLabel sessionLabel = new JLabel("Session Label");
		JTextField sessionL = new JTextField(events.get(index).getLabel());
		sessionLabel.setBounds(labelX,80,100,height);
		sessionL.setBounds(fieldX,80,300,height);

		//Session Date
		JLabel sessionDateLabel = new JLabel("Session Date");
		JFormattedTextField sessionDate = new JFormattedTextField(events.get(index).getSessionDate());
		sessionDateLabel.setBounds(labelX,130,100,height);
		sessionDate.setBounds(fieldX,130,300,height);

		//Game Weather
		JLabel gameWeatherLabel = new JLabel("In-Game Weather");
		JTextField gameWeather = new JTextField(events.get(index).getGameWeather());
		gameWeatherLabel.setBounds(labelX,180,100,height);
		gameWeather.setBounds(fieldX,180,300,height);

		//Game Time
		JLabel gameTimeLabel = new JLabel("In-Game Time");
		JTextField gameTime = new JTextField(events.get(index).getGameTime());
		gameTimeLabel.setBounds(labelX,230,100,height);
		gameTime.setBounds(fieldX,230,300,height);

		//Color

		//Description
		JTextArea description = new JTextArea(events.get(index).getDescription());
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(labelX,300,300,height);
		description.setBounds(fieldX,300,400,100);

		//Save
		save.setBounds(460, 500, 100, 40);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SessionNumber
				try {
					sessionSpin.commitEdit();
				}catch(java.text.ParseException e1) {
					System.out.println("The spinner did not commit");
				}

				double value = (Double) sessionSpin.getValue();
				events.get(index).setSessionNumber(value);

				//Session Date
				String sDate = sessionDate.getText();
				events.get(index).setSessionDate(sDate);

				//Game Weather
				String gWeather = gameWeather.getText();
				events.get(index).setGameWeather(gWeather);

				//Game Time
				String gTime = gameTime.getText();
				events.get(index).setGameTime(gTime);

				//Color

				//Description
				String desc = description.getText();
				events.get(index).setDescription(desc);

				//Label
				String sessLabel = sessionL.getText();
				events.get(index).setLabel(sessLabel);

				timelinePage(timeline, events);

				f.dispose();

			}
		});

		cancel.setBounds(360, 500, 100, 40);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timelinePage(timeline, events);
				f.dispose();
			}
		});
		f.add(save); f.add(cancel); f.add(sessionSpin); f.add(sessionNum);
		f.add(description); f.add(descriptionLabel);
		f.add(gameTime); f.add(gameTimeLabel); f.add(gameWeather); f.add(gameWeatherLabel);
		f.add(sessionDate); f.add(sessionDateLabel);
		f.add(sessionLabel); f.add(sessionL);

		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);

	}

	public void createEvent(Timeline timeline, Vector<Event> events) {
		JFrame f = new JFrame("New Event");

		events.add(new Event());
		displayEventWindow(timeline, f, events, eventCount);
		eventCount++;
	}	
	public void editEvent(Timeline timeline, Vector<Event> events, int i) {
		JFrame f = new JFrame("Editing Event");

		JButton deleteEvent = new JButton("Delete Event");
		deleteEvent.setBounds(40, 500, 120, 40);

		deleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				events.remove(i);
				eventCount--;
				timelinePage(timeline, events);
				f.dispose();
			}
		});

		f.add(deleteEvent);

		displayEventWindow(timeline, f, events, i);

	}
}
