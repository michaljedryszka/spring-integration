package com.cybercom.pl.spint.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SIMessage {

	private String payload;

	private String origin;

	private List<TrackItem> track = new ArrayList<TrackItem>();

	public SIMessage() {

	}

	public SIMessage(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public List<TrackItem> getTrack() {
		return new ArrayList<TrackItem>(track);
	}

	public void addArrivalEvent(String systemName){
		if(track == null){
			track = new ArrayList<TrackItem>();
		}
		track.add(new TrackItem(systemName, new Date().getTime(), TrackEventType.ARRIVAL));
	}
	
	public void addDepartureEvent(String systemName){
		if(track == null){
			track = new ArrayList<TrackItem>();
		}
		track.add(new TrackItem(systemName, new Date().getTime(), TrackEventType.DEPARTURE));
	}

}

enum TrackEventType {
	ARRIVAL, DEPARTURE;
}

class TrackItem {

	long timestamp;

	String systemName;

	TrackEventType eventType;
	
	public TrackItem(String systemName, long timestamp, TrackEventType eventType){
		this.timestamp = timestamp;
		this.systemName = systemName;
		this.eventType = eventType;
	}
	
	public TrackItem(){
		
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public TrackEventType getEventType() {
		return eventType;
	}

	public void setEventType(TrackEventType eventType) {
		this.eventType = eventType;
	}
}