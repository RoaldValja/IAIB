package thesistimetableplanning.domain;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import thesistimetableplanning.common.AbstractPersistable;

public class ThesisSupervisor extends AbstractPersistable{

	private String name;
	private String role;
	
	private Set<String> preferredTimeslotTagSet;
	private Set<String> notPreferredTimeslotTagSet;
	private Set<String> unavailableTimeslotTagSet;
	
	private Set<Timeslot> preferredTimeslotSet;
	private Set<Timeslot> notPreferredTimeslotSet;
	private Set<Timeslot> unavailableTimeslotSet;

	public ThesisSupervisor(){
		
	}
	
	public ThesisSupervisor(long id){
		super(id);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getRole(){
		return role;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public Set<String> getPreferredTimeslotTagSet(){
		return preferredTimeslotTagSet;
	}
	
	public void setPreferredTimeslotTagSet(Set<String> preferredTimeslotTagSet){
		this.preferredTimeslotTagSet = preferredTimeslotTagSet;
	}
	
	public Set<String> getNotPreferredTimeslotTagSet(){
		return notPreferredTimeslotTagSet;
	}
	
	public void setNotPreferredTimeslotTagSet(Set<String> notPreferredTimeslotTagSet){
		this.notPreferredTimeslotTagSet = notPreferredTimeslotTagSet;
	}
	
	public Set<String> getUnavailableTimeslotTagSet(){
		return unavailableTimeslotTagSet;
	}
	
	public void setUnavailableTimeslotTagSet(Set<String> unavailableTimeslotTagSet){
		this.unavailableTimeslotTagSet = unavailableTimeslotTagSet;
	}
	
	public Set<Timeslot> getPreferredTimeslotSet(){
		return preferredTimeslotSet;
	}
	
	public void setPreferredTimeslotSet(Set<Timeslot> preferredTimeslotSet){
		this.preferredTimeslotSet = preferredTimeslotSet;
	}
	
	public Set<Timeslot> getNotPreferredTimeslotSet(){
		return notPreferredTimeslotSet;
	}
	
	public void setNotPreferredTimeslotSet(Set<Timeslot> notPreferredTimeslotSet){
		this.notPreferredTimeslotSet = notPreferredTimeslotSet;
	}
	
	public Set<Timeslot> getUnavailableTimeslotSet(){
		return unavailableTimeslotSet;
	}
	
	public void setUnavailableTimeslotSet(Set<Timeslot> unavailableTimeslotSet){
		this.unavailableTimeslotSet = unavailableTimeslotSet;
	}
	
	/*
	 * With methods
	 */
	
	public ThesisSupervisor withPreferredTimeslotTagSet(Set<String> preferredTimeslotTagSet){
		this.preferredTimeslotTagSet = preferredTimeslotTagSet;
		return this;
	}
	
	public ThesisSupervisor withNotPreferredTimeslotTagSet(Set<String> notPreferredTimeslotTagSet){
		this.notPreferredTimeslotTagSet = notPreferredTimeslotTagSet;
		return this;
	}
	
	public ThesisSupervisor withUnavailableTimeslotTagSet(Set<String> unavailableTimeslotTagSet){
		this.unavailableTimeslotTagSet = unavailableTimeslotTagSet;
		return this;
	}
}
