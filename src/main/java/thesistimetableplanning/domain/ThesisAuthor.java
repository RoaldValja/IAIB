package thesistimetableplanning.domain;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import thesistimetableplanning.common.AbstractPersistable;

public class ThesisAuthor extends AbstractPersistable{
	
	private String name;
	private boolean preconditionsFulfilled = false;
	private Set<ThesisSupervisor> thesisSupervisorSet;
	
	private Set<String> preferredTimeslotTagSet;
	private Set<String> notPreferredTimeslotTagSet;
	private Set<String> unavailableTimeslotTagSet;
	
	private Set<Timeslot> preferredTimeslotSet;
	private Set<Timeslot> notPreferredTimeslotSet;
	private Set<Timeslot> unavailableTimeslotSet;

	
	
	public ThesisAuthor(){
		
	}
	
	public ThesisAuthor(long id){
		super(id);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void hasPreconditionsFulfilled(){
		preconditionsFulfilled = true;
	}
	
	public boolean getPreconditionsFulfilled(){
		return preconditionsFulfilled;
	}
	
	public Set<ThesisSupervisor> getThesisSupervisorSet(){
		return thesisSupervisorSet;
	}
	
	public void setThesisSupervisorSet(Set<ThesisSupervisor> thesisSupervisorSet){
		this.thesisSupervisorSet = thesisSupervisorSet;
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
	
	public ThesisAuthor withPreferredTimeslotTagSet(Set<String> preferredTimeslotTagSet){
		this.preferredTimeslotTagSet = preferredTimeslotTagSet;
		return this;
	}
	
	public ThesisAuthor withNotPreferredTimeslotTagSet(Set<String> notPreferredTimeslotTagSet){
		this.notPreferredTimeslotTagSet = notPreferredTimeslotTagSet;
		return this;
	}
	
	public ThesisAuthor withUnavailableTimeslotTagSet(Set<String> unavailableTimeslotTagSet){
		this.unavailableTimeslotTagSet = unavailableTimeslotTagSet;
		return this;
	}
}
