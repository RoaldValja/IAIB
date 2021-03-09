package thesistimetableplanning.domain;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import thesistimetableplanning.common.AbstractPersistable;

public class DefenseType extends AbstractPersistable{

	private Set<Timeslot> compatibleTimeslotSet;
	
	private String type;

	public DefenseType(){
		
	}
	
	public DefenseType(long id){
		super(id);
	}
	
	public DefenseType(long id, String type) {
		super(id);
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}

	public Set<Timeslot> getCompatibleTimeslotSet(){
		return compatibleTimeslotSet;
	}
	
	public void setCompatibleTimeslotSet(Set<Timeslot> compatibleTimeslotSet){
		this.compatibleTimeslotSet = compatibleTimeslotSet;
	}


}
