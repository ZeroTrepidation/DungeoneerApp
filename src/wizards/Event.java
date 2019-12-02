package wizards;

import java.util.Date;

public class Event {
	private double sessionNumber;
	private String sessionDate;
	private String gameWeather;
	private String gameTime;
	private String color;
	private String description;
	private String label;
	
	public Event() {
		
	}
	//Getters&Setters
	public void setSessionNumber(double sessionNumber){
		this.sessionNumber = sessionNumber;
	}
	public double getSessionNumber(){
		return sessionNumber;
	}
	public void setSessionDate(String sessionDate){
		this.sessionDate = sessionDate;
	}
	public String getSessionDate(){
		return sessionDate;
	}
	public void setGameWeather(String gameWeather){
		this.gameWeather = gameWeather;
	}
	public String getGameWeather(){
		return gameWeather;
	}
	public void setGameTime(String gameTime){
		this.gameTime = gameTime;
	}
	public String getGameTime(){
		return gameTime;
	}
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return color;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setLabel(String label){
		this.label = label;
	}
	public String getLabel(){
		return label;
	}
	
	//Requirements
	public void colorCodeEvent() {
		
	}
	public void trackDayNight(String gameTime) {
		
	}
	public void trackWeather(String gameWeather) {
		
	}
}
