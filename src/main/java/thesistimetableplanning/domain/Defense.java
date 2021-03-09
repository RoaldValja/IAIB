package thesistimetableplanning.domain;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import thesistimetableplanning.common.AbstractPersistable;

@PlanningEntity
public class Defense extends AbstractPersistable{

	private String code;
	private String degree;
	private int commissionSize;
	private String thesisTitle;
	private String thesisTheme;
	private DefenseType defenseType;
	private List<Commitee> commiteeList;
	private ThesisAuthor thesisAuthor;
	private String roomNumber;
	private int roomCapacity;
	
	private Commitee[] commissionArray;
	
	
	private Set<String> preferredTimeslotTagSet;
	private Set<String> notPreferredTimeslotTagSet;
	private Set<String> unavailableTimeslotTagSet;
	
	@PlanningVariable(valueRangeProviderRefs = "timeslotRange")
	private Timeslot timeslot;

	public Defense(){
		
	}
	
	public Defense(long id){
		super(id);
	}

	@ValueRangeProvider(id = "timeslotRange")
	public Set<Timeslot> getTimeslotRange(){
		return defenseType.getCompatibleTimeslotSet();
	}
	
	
    ////// Example code
    //////------------------------------------------
/*    
    public boolean hasSpeaker(Speaker speaker) {
        return speakerList.contains(speaker);
    }

    public boolean hasAnyUnavailableSpeaker() {
        if (timeslot == null) {
            return false;
        }
        for (Speaker speaker : speakerList) {
            if (speaker.getUnavailableTimeslotSet().contains(timeslot)) {
                return true;
            }
        }
        return false;
    }

    public int overlappingThemeTrackCount(Talk other) {
        return (int) themeTrackTagSet.stream().filter(tag -> other.themeTrackTagSet.contains(tag)).count();
    }

    public int overlappingSectorCount(Talk other) {
        return (int) sectorTagSet.stream().filter(tag -> other.sectorTagSet.contains(tag)).count();
    }

    public int overlappingAudienceTypeCount(Talk other) {
        return (int) audienceTypeSet.stream().filter(audienceType -> other.audienceTypeSet.contains(audienceType)).count();
    }

    public int overlappingContentCount(Talk other) {
        return (int) contentTagSet.stream().filter(tag -> other.contentTagSet.contains(tag)).count();
    }

    public int missingRequiredTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) requiredTimeslotTagSet.stream().filter(tag -> !timeslot.hasTag(tag)).count();
    }

    public int missingPreferredTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) preferredTimeslotTagSet.stream().filter(tag -> !timeslot.hasTag(tag)).count();
    }

    public int prevailingProhibitedTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) prohibitedTimeslotTagSet.stream().filter(tag -> timeslot.hasTag(tag)).count();
    }

    public int prevailingUndesiredTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) undesiredTimeslotTagSet.stream().filter(tag -> timeslot.hasTag(tag)).count();
    }

    public int missingRequiredRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) requiredRoomTagSet.stream().filter(tag -> !room.hasTag(tag)).count();
    }

    public int missingPreferredRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) preferredRoomTagSet.stream().filter(tag -> !room.hasTag(tag)).count();
    }

    public int prevailingProhibitedRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) prohibitedRoomTagSet.stream().filter(tag -> room.hasTag(tag)).count();
    }

    public int prevailingUndesiredRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) undesiredRoomTagSet.stream().filter(tag -> room.hasTag(tag)).count();
    }

    public int missingSpeakerRequiredTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getRequiredTimeslotTagSet().stream())
                .filter(tag -> !timeslot.hasTag(tag)).count();
    }

    public int missingSpeakerPreferredTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getPreferredTimeslotTagSet().stream())
                .filter(tag -> !timeslot.hasTag(tag)).count();
    }

    public int prevailingSpeakerProhibitedTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getProhibitedTimeslotTagSet().stream())
                .filter(tag -> timeslot.hasTag(tag)).count();
    }

    public int prevailingSpeakerUndesiredTimeslotTagCount() {
        if (timeslot == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getUndesiredTimeslotTagSet().stream())
                .filter(tag -> timeslot.hasTag(tag)).count();
    }

    public int missingSpeakerRequiredRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getRequiredRoomTagSet().stream())
                .filter(tag -> !room.hasTag(tag)).count();
    }

    public int missingSpeakerPreferredRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getPreferredRoomTagSet().stream())
                .filter(tag -> !room.hasTag(tag)).count();
    }

    public int prevailingSpeakerProhibitedRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getProhibitedRoomTagSet().stream())
                .filter(tag -> room.hasTag(tag)).count();
    }

    public int prevailingSpeakerUndesiredRoomTagCount() {
        if (room == null) {
            return 0;
        }
        return (int) speakerList.stream().flatMap(speaker -> speaker.getUndesiredRoomTagSet().stream())
                .filter(tag -> room.hasTag(tag)).count();
    }

    public boolean hasUnavailableRoom() {
        if (timeslot == null || room == null) {
            return false;
        }
        return room.getUnavailableTimeslotSet().contains(timeslot);
    }

    public int overlappingMutuallyExclusiveTalksTagCount(Talk other) {
        return (int) mutuallyExclusiveTalksTagSet.stream().filter(tag -> other.mutuallyExclusiveTalksTagSet.contains(tag)).count();
    }

    public int missingPrerequisiteCount() {
        return (int) prerequisiteTalkSet.stream()
                .filter(prerequisite -> prerequisite.getTimeslot() == null || timeslot.endsBefore(prerequisite.getTimeslot()))
                .count();
    }

    public boolean hasMutualSpeaker(Talk talk) {
        for (Speaker speaker : talk.getSpeakerList()) {
            if (speakerList.contains(speaker)) {
                return true;
            }
        }
        return false;
    }

    public Integer getDurationInMinutes() {
        return timeslot == null ? null : timeslot.getDurationInMinutes();
    }

    public boolean overlapsTime(Talk other) {
        return timeslot != null && other.getTimeslot() != null && timeslot.overlapsTime(other.getTimeslot());
    }

    public int overlappingDurationInMinutes(Talk other) {
        if (timeslot == null) {
            return 0;
        }
        if (other.getTimeslot() == null) {
            return 0;
        }
        return timeslot.getOverlapInMinutes(other.getTimeslot());
    }

    @Override
    public String toString() {
        return code;
    }
*/
    //////------------------------------------------
	
	// ************************************************************************
    // Simple getters and setters
    // ************************************************************************
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public String getDegree(){
		return degree;
	}
	
	public void setDegree(String degree){
		this.degree = degree;
	}
	
	public int getCommissionSize(){
		return commissionSize;
	}
	
	public void setCommissionSize(int commissionSize){
		this.commissionSize = commissionSize;
	}
	
	public String getThesisTitle(){
		return thesisTitle;
	}
	
	public void setThesisTitle(String thesisTitle){
		this.thesisTitle = thesisTitle;
	}
	
	public String getThesisTheme(){
		return thesisTheme;
	}
	
	public void setThesisTheme(String thesisTheme){
		this.thesisTheme = thesisTheme;
	}

	public String getRoomNumber(){
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber){
		this.roomNumber = roomNumber;
	}
	
	public int getRoomCapacity(){
		return roomCapacity;
	}
	
	public void setRoomCapacity(int roomCapacity){
		this.roomCapacity = roomCapacity;
	}
	
	public DefenseType getDefenseType(){
		return defenseType;
	}
	
	public void setDefenseType(DefenseType defenseType){
		this.defenseType = defenseType;
	}
	
	public Timeslot getTimeslot(){
		return timeslot;
	}
	
	public void setTimeslot(Timeslot timeslot){
		this.timeslot = timeslot;
	}
	
	public List<Commitee> getCommiteeList(){
		return commiteeList;
	}
	
	public void setCommiteeList(List<Commitee> commiteeList){
		this.commiteeList = commiteeList;
	}
	
	public ThesisAuthor getThesisAuthor(){
		return thesisAuthor;
	}
	
	public void setThesisAuthor(ThesisAuthor thesisAuthor){
		this.thesisAuthor = thesisAuthor;
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
	
	/*
	 * Complex methods
	 */
	// Vaja täiendada
	// Võibolla vaja commiteeList või commiteeArray ümber nimetata et kaotada segadust.
	// getTimeslotUnsuitableTagSet vaja täiendada et seda saaks siin kasutada.
	// võibolla täiendada meetodit, kus algul lisatakse liikmed, kellele täitsa sobivad need kellaajad ning kui pole
	// piisav arv liikmeid, siis lisatakse neid, kes ei eelista seda aega.
	
	public void setCommission(){
		commissionArray = new Commitee[commissionSize];
		int addedToList = 0;
		for(int i = 0; i < commiteeList.size(); i++){
			if (addedToList >= commissionSize){
				break;
			}
			if(!commiteeList.get(i).getUnavailableTimeslotSet().contains(timeslot)){
				commissionArray[addedToList++] = commiteeList.get(i);
			}
		}
	}
	
	public Commitee[] getCommission(){
		return commissionArray;
	}
	
	public boolean enoughCommiteeMembers(){
		for(int i = 0; i < commissionSize; i++){
			if(commissionArray[i] == null){
				return false;
			}
		}
		return true;
	}
	
	public boolean authorHasPreconditionsDone(){
		return thesisAuthor.getPreconditionsFulfilled();
	}
	
	/**
	 * võibolla siin vaja kontrollida ka kas ajaslot on selle aja sees või mitte
	 * @param timeslotSet
	 * @return
	 */
	public boolean checkWholeSetTimeslot(Set<Timeslot> timeslotSet) {
		Iterator<Timeslot> value = timeslotSet.iterator();
		Timeslot valueTimeslot;
		while(value.hasNext()) {
			valueTimeslot = value.next();
			int startTime = valueTimeslot.getStartTime().compareTo(timeslot.getStartTime());
			int endTime = valueTimeslot.getEndTime().compareTo(timeslot.getEndTime());
			int date = valueTimeslot.getDate().compareTo(timeslot.getDate());
			if(startTime == 0 && endTime == 0 && date == 0) {
				return true;
			}
			/*
			if(valueTimeslot.equals(timeslot)) {
				return true;
			}
			*/
		}
		return false;
	}
	
	public boolean isAuthorsUnavailableTimeslot() {
		if(timeslot == null) {
			return false;
		}
		return checkWholeSetTimeslot(thesisAuthor.getUnavailableTimeslotSet());
	}
	
	public boolean isAuthorsPreferredTimeslot() {
		if(timeslot == null) {
			return false;
		}
		return checkWholeSetTimeslot(thesisAuthor.getPreferredTimeslotSet());
	}
	
	public int isCommissionMembersUnavailableTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++) {
			if(commissionArray[i] == null) {
				break;
			}
			if(checkWholeSetTimeslot(commissionArray[i].getUnavailableTimeslotSet())) {
				count++;
			}
		}
		return count;
	}
	
	public int isCommissionMembersPreferredTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++) {
			if(commissionArray[i] == null) {
				break;
			}
			if(checkWholeSetTimeslot(commissionArray[i].getPreferredTimeslotSet())) {
				count++;
			}
		}
		return count;
	}

	public boolean hasChairmanAmongCommitee(){
		int chairmanCount = 0;
		for(int i = 0; i < commissionArray.length; i++){
			if(commissionArray[i] == null) {
				break;
			}
			if(commissionArray[i].getChairman()){
				chairmanCount++;
			}
		}
		if(chairmanCount == 1){
			return true;
		} else {
			return false;
		}
	}
/**
 * Kas seda on üldse vaja
 * @return
 */
	public boolean isDefenseClosed(){
		if (defenseType.getType().equals("Kinnine")){
			return true;
		}
		return false;
	}
	
	public boolean isClosedDefenseTimeslot(){
		boolean foundTimeslot = false;
		if(!defenseType.getType().equals("Kinnine")){
			return false;
		}
		Set<Timeslot> defenseTypeTimeslotSet = defenseType.getCompatibleTimeslotSet();
		Iterator<Timeslot> defenseTypeTimeslotIterator = defenseTypeTimeslotSet.iterator();
		Timeslot defenseTypeTimeslot;
		
		while(defenseTypeTimeslotIterator.hasNext()){
			defenseTypeTimeslot = defenseTypeTimeslotIterator.next();
			if(timeslot.equals(defenseTypeTimeslot)){
				foundTimeslot = true;
				break;
			}
		}
		return foundTimeslot;
	}
	
	public boolean happensOnClosedTimes(){
		LocalTime time = timeslot.getStartTime();
		if(time.isBefore(LocalTime.of(10, 0))){
			return true;
		} else if(time.isAfter(LocalTime.of(13, 0)) && time.isBefore(LocalTime.of(14, 0))){
			return true;
		} else if(time.isAfter(LocalTime.of(17, 0))){
			return true;
		} else {
			return false;
		}
	}
	
	public int isAuthorsSupervisorsPreferredTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		int count = 0;
		while(thesisSupervisorSetIterator.hasNext()) {
			if(checkWholeSetTimeslot(thesisSupervisorSetIterator.next().getPreferredTimeslotSet())) {
				count++;
			}
		}
		return count;
	}
	
	public int isAuthorsSupervisorsUnavailableTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		int count = 0;
		while(thesisSupervisorSetIterator.hasNext()) {
			if(checkWholeSetTimeslot(thesisSupervisorSetIterator.next().getUnavailableTimeslotSet())) {
				count++;
			}
		}
		return count;
	}

	public ThesisSupervisor getPrimarySupervisor(){
		ThesisSupervisor supervisor = null;
		if(!thesisAuthor.getThesisSupervisorSet().isEmpty()){
			Iterator<ThesisSupervisor> supervisorIterator = thesisAuthor.getThesisSupervisorSet().iterator();
			while(supervisorIterator.hasNext()){
				supervisor = supervisorIterator.next();
				if(supervisor.getRole().equals("Peajuhendaja")){
					break;
				}
				supervisor = null;
			}
		}
		return supervisor;
	}
	
	public boolean isAuthorsNotPreferredTimeslot() {
		if(timeslot == null) {
			return false;
		}
		return checkWholeSetTimeslot(thesisAuthor.getNotPreferredTimeslotSet());
	}
	
	public int isCommissionMembersNotPreferredTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++) {
			if(commissionArray[i] == null) {
				break;
			}
			if(checkWholeSetTimeslot(commissionArray[i].getNotPreferredTimeslotSet())) {
				count++;
			}
		}
		return count;
	}
	
	public int isAuthorsSupervisorsNotPreferredTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		int count = 0;
		while(thesisSupervisorSetIterator.hasNext()) {
			if(checkWholeSetTimeslot(thesisSupervisorSetIterator.next().getNotPreferredTimeslotSet())) {
				count++;
			}
		}
		return count;
	}
	
	public boolean checkWholeSetTimeslotTag(Set<String> tagSet){
		Iterator<String> checkedTagIterator = tagSet.iterator();
		Iterator<String> timeslotTagIterator = timeslot.getTagSet().iterator();
		String checkedTag = "";
		String timeslotTag = "";
		while(checkedTagIterator.hasNext()){
			checkedTag = checkedTagIterator.next();
			while(timeslotTagIterator.hasNext()){
				timeslotTag = timeslotTagIterator.next();
				if(checkedTag.equals(timeslotTag)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isAuthorsPreferredTimeslotTag(){
		if(timeslot == null){
			return false;
		}
		return checkWholeSetTimeslotTag(thesisAuthor.getPreferredTimeslotTagSet());
	}
	
	public boolean isAuthorsNotPreferredTimeslotTag(){
		if(timeslot == null){
			return false;
		}
		return checkWholeSetTimeslotTag(thesisAuthor.getNotPreferredTimeslotTagSet());
	}
	
	public boolean isAuthorsUnavailableTimeslotTag(){
		if(timeslot == null){
			return false;
		}
		return checkWholeSetTimeslotTag(thesisAuthor.getUnavailableTimeslotTagSet());
	}
	
	public int isCommissionMembersPreferredTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++){
			if(commissionArray[i] == null) {
				break;
			}
			if(checkWholeSetTimeslotTag(commissionArray[i].getPreferredTimeslotTagSet())){
				count++;
			}
		}
		return count;
	}
	
	public int isCommissionMembersNotPreferredTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++){
			if(commissionArray[i] == null) {
				break;
			}
			if(checkWholeSetTimeslotTag(commissionArray[i].getNotPreferredTimeslotTagSet())){
				count++;
			}
		}
		
		return count;
	}
	
	public int isCommissionMembersUnavailableTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++){
			if(commissionArray[i] == null) {
				break;
			}
			if(checkWholeSetTimeslotTag(commissionArray[i].getUnavailableTimeslotTagSet())){
				count++;
			}
		}
		
		return count;
	}
	
	public int isAuthorsSupervisorsPreferredTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		while(thesisSupervisorSetIterator.hasNext()){
			if(checkWholeSetTimeslotTag(thesisSupervisorSetIterator.next().getPreferredTimeslotTagSet())){
				count++;
			}
		}
		return count;
	}
	
	public int isAuthorsSupervisorsNotPreferredTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		while(thesisSupervisorSetIterator.hasNext()){
			if(checkWholeSetTimeslotTag(thesisSupervisorSetIterator.next().getNotPreferredTimeslotTagSet())){
				count++;
			}
		}
		return count;
	}
	
	public int isAuthorsSupervisorsUnavailableTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		while(thesisSupervisorSetIterator.hasNext()){
			if(checkWholeSetTimeslotTag(thesisSupervisorSetIterator.next().getUnavailableTimeslotTagSet())){
				count++;
			}
		}
		return count;
	}

	/**
	 * with methods
	 */
	
	public Defense withDefenseType(DefenseType defenseType) {
		this.defenseType = defenseType;
		return this;
	}
}
