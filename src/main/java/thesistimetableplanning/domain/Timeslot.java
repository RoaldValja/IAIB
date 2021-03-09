package thesistimetableplanning.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import thesistimetableplanning.common.AbstractPersistable;

public class Timeslot extends AbstractPersistable{

	private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private int session;
    private int durationInMinutes;
    private Set<String> tagSet;
	public Timeslot(){
		
	}
	
	public Timeslot(long id){
		super(id);
	}
	
	public Set<String> getTagSet(){
		return tagSet;
	}
	
	public void setTagSet(Set<String> tagSet){
		this.tagSet = tagSet;
	}
	
    public LocalTime getStartTime(){
    	return startTime;
    }
    
    public void setStartTime(LocalTime startTime){
    	this.startTime = startTime;
    }
    
    public LocalTime getEndTime(){
    	return endTime;
    }
    
    public void setEndTime(LocalTime endTime){
    	this.endTime = endTime;
    }
    
    public LocalDate getDate(){
    	return date;
    }
    
    public void setDate(LocalDate date){
    	this.date = date;
    }
    
    public int getSession() {
    	return session;
    }
    
    public void setSession(int session) {
    	this.session = session;
    }
    
    public int getDurationInMinutes(){
    	return durationInMinutes;
    }
    
    /*
     * Complex methods
     */
    
    public void setDurationInMinutes(){
    	if(startTime != null && endTime != null){
    		durationInMinutes = (int) Duration.between(startTime, endTime).toMinutes();
    	}
    }

}
