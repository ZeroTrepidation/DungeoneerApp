package wizards;

import java.util.Vector;

/**
 * @author setht
 *
 */
public class Campaign {

	private String campName;
	private String startDate;
	private playerCharacter mainCharacter;

	private Vector<Event> events;

	public Campaign(String campName, String startDate) {
		this.campName = campName;
		this.startDate = startDate;
		events = new Vector<Event>();
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public playerCharacter getMainCharacter() {
		return mainCharacter;
	}

	public void setMainCharacter(playerCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
	}

	public Vector<Event> getEvents() {
		return events;
	}

	public void setEvents(Vector<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return campName + " - " + startDate;
	}

}
