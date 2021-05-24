package thesistimetableplanning.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import thesistimetableplanning.common.AbstractPersistable;

@PlanningEntity
public class Defense extends AbstractPersistable {

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
	
	private Commitee[] commissionArray; // kustutada võibolla
	private List<Commitee> currentCommissionMembersList;
	//private List<Commission> commissionsList = new ArrayList<Commission>();
	
	
	private Set<String> preferredTimeslotTagSet;
	private Set<String> notPreferredTimeslotTagSet;
	private Set<String> unavailableTimeslotTagSet;
	
	private List<Commitee[]> commiteeArrays;
	

	private Set<String> droolsCommentsAuthor = new LinkedHashSet<>();
	private Set<String> droolsCommentsSupervisor = new LinkedHashSet<>();
	private Set<String> droolsCommentsCommission = new LinkedHashSet<>();
	private Set<String> droolsCommentsUnique = new LinkedHashSet<>();
	
	public Set<String> getDroolsCommentsAuthorList(){
		return droolsCommentsAuthor;
	}
	
	public Set<String> getDroolsCommentsSupervisorList(){
		return droolsCommentsSupervisor;
	}
	
	public Set<String> getDroolsCommentsCommissionList(){
		return droolsCommentsCommission;
	}
	
	public Set<String> getDroolsCommentsUniqueList(){
		return droolsCommentsUnique;
	}
	
	public void setCommiteeArrays(List<Commitee[]> commiteeArrays) {
		this.commiteeArrays = commiteeArrays;
	}
	
	@PlanningVariable(valueRangeProviderRefs = "timeslotRange")
	private Timeslot timeslot;

	public Defense(){
		
	}
	
	public Defense(long id){
		super(id);
	}
	
	@Override
	public int compareTo(Defense other) {
		//LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		return 0;
    }

	@ValueRangeProvider(id = "timeslotRange")
	public Set<Timeslot> getTimeslotRange(){
		setCommission2();
		for(Commitee commiteeMember : commissionArray) {
			//System.out.println(this + " " + commiteeMember);
		}
		droolsCommentsAuthor = new LinkedHashSet<>();
		droolsCommentsAuthor.clear();
		droolsCommentsSupervisor = new LinkedHashSet<>();
		droolsCommentsSupervisor.clear();
		droolsCommentsCommission = new LinkedHashSet<>();
		droolsCommentsCommission.clear();
		droolsCommentsUnique = new LinkedHashSet<>();
		droolsCommentsUnique.clear();
		return defenseType.getCompatibleTimeslotSet();
	}
	
	public boolean hasSameCommiteeOnSameSession(Defense other) {
		int sameMembers = 0;
		boolean sameSession = true;
		if(timeslot.getSession() != other.getTimeslot().getSession()) {
			sameSession = false;
		}
		Commitee[] otherCommission = other.getCommission2();
		for(Commitee commiteeMember : commissionArray) {
			for(Commitee otherMember : otherCommission) {
				if(commiteeMember == otherMember) {
					sameMembers++;
				}
			}
		}
		if(sameMembers != commissionSize) {
			if(sameSession) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	public boolean hasSameSupervisorOnSameSession(Defense other) {
		boolean sameSession = true;
		boolean sameSupervisor = false;
		if(timeslot.getSession() != other.getTimeslot().getSession()) {
			sameSession = false;
		}
		for(ThesisSupervisor supervisor : thesisAuthor.getThesisSupervisorSet()) {
			for(ThesisSupervisor supervisorNew : other.getThesisAuthor().getThesisSupervisorSet()) {
				if(supervisor == supervisorNew) {
					sameSupervisor = true;
				}
			}
		}
		if(sameSupervisor) {
			if(sameSession) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean hasSameCommiteeOnSameDate(Defense other) {
		int sameMembers = 0;
		if(timeslot.getDate() != other.getTimeslot().getDate()) {
			return true;
		}
		Commitee[] otherCommission = other.getCommission2();
		for(Commitee commiteeMember : commissionArray) {
			for(Commitee otherMember : otherCommission) {
				if(commiteeMember == otherMember) {
					sameMembers++;
				}
			}
		}
		if(sameMembers == commissionSize) {
			return true;
		}
		return false;
	}
	
	
	// proov lahendus
/*	@ValueRangeProvider(id = "commiteeArrayRange")
	public List<Commitee[]> getCommiteeArrayRange(){
		return commiteeArrays;
	}
*/	
	
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
	
	public void vanaSetCommission(){
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
	
	public void fillCommissionMembersList(int addedMembers, List<Commitee> chairmanList) {
		while(currentCommissionMembersList.size() < commissionSize) {
			if(addedMembers == 0) {
				int rand = (int)(Math.random() * chairmanList.size());
				currentCommissionMembersList.add(chairmanList.get(rand));
				addedMembers++;
			} else {
				int rand = (int)(Math.random() * commiteeList.size());
				Commitee chosenCommitee = commiteeList.get(rand);
				if(!currentCommissionMembersList.contains(chosenCommitee)) {
					currentCommissionMembersList.add(chosenCommitee);
				}
			}
		}
	}
/*	
	public void setCommission() {
		int addedMembers = 0;
		boolean foundSession = false;
		currentCommissionMembersList = new ArrayList<Commitee>();
		List<Commitee> chairmanList = new ArrayList<Commitee>();
		for(int i = 0; i < commiteeList.size(); i++) {
			if(commiteeList.get(i).getChairman()) {
				chairmanList.add(commiteeList.get(i));
			}
		}
		if(commissionsList.size() != 0) {
			for(int i = 0; i < commissionsList.size(); i++) {
				if(commissionsList.get(i).getSession() == timeslot.getSession()) {
					currentCommissionMembersList = commissionsList.get(i).getCommissionList();
					foundSession = true;
				}
			}
			if(!foundSession) {
				fillCommissionMembersList(addedMembers, chairmanList);
*/				/*
				while(currentCommissionMembersList.size() < commissionSize) {
					if(addedMembers == 0) {
						int rand = (int)(Math.random() * chairmanList.size());
						currentCommissionMembersList.add(chairmanList.get(rand));
						addedMembers++;
					} else {
						int rand = (int)(Math.random() * commiteeList.size());
						Commitee chosenCommitee = commiteeList.get(rand);
						if(!currentCommissionMembersList.contains(chosenCommitee)) {
							currentCommissionMembersList.add(chosenCommitee);
						}
					}
				}*/
/*				Commission commission = new Commission(timeslot.getSession(), currentCommissionMembersList);
				commissionsList.add(commission);
			}
		} else {
			fillCommissionMembersList(addedMembers, chairmanList);
*/			/*
			while(currentCommissionMembersList.size() < commissionSize) {
				if(addedMembers == 0) {
					int rand = (int)(Math.random() * chairmanList.size());
					currentCommissionMembersList.add(chairmanList.get(rand));
					addedMembers++;
				} else {
					int rand = (int)(Math.random() * commiteeList.size());
					Commitee chosenCommitee = commiteeList.get(rand);
					if(!currentCommissionMembersList.contains(chosenCommitee)) {
						currentCommissionMembersList.add(chosenCommitee);
					}
				}
			}*/
/*			Commission commission = new Commission(timeslot.getSession(), currentCommissionMembersList);
			commissionsList.add(commission);
		}
	}
*/
	// ------------------------------------------------------------------------------------------------------------
	List<SessionCommission> sessionCommissionList = new ArrayList<SessionCommission>();
	
	public void insertChairman(Commitee[] commission) {
		while(true) {
			int rand = (int)(Math.random() * commiteeList.size());
			System.out.println(rand);
			if(commiteeList.get(rand).getChairman() == true) {
				commission[0] = commiteeList.get(rand);
				return;
			}
		}
	}
	
	public void insertCommiteeMembers(Commitee[] commission) {
		int addedMembers = 0;
		while(true) {
			if(addedMembers == commissionSize-1) {
				return;
			}
			int rand = (int)(Math.random() * commiteeList.size());
			if(commiteeList.get(rand).getChairman() == false) {
				if(!Arrays.asList(commission).contains(commiteeList.get(rand))) {
					commission[++addedMembers] = commiteeList.get(rand);
				}
			}
		}
	}
	
	public void setCommission() {
		Commitee[] newCommission = new Commitee[commissionSize];
		System.out.println("teeb comisjoni " + timeslot);
		if(SessionCommission.getCommission(timeslot.getSession()) == null) {
			insertChairman(newCommission);
			insertCommiteeMembers(newCommission);
			SessionCommission.putCommission(timeslot.getSession(), newCommission);
		}
	}
	
	public Commitee[] getCommission() {
		return SessionCommission.getCommission(timeslot.getSession());
	}
	
	public void setCommission2() {
		Commitee[] newCommission = new Commitee[commissionSize];
		Set<Integer> members = new HashSet<Integer>();
		int max = commiteeList.size();
		int commitee = 0;
		int searched = 0;
		while(true) {
			Random random = new Random();
			commitee = random.nextInt(max - 0);
			System.out.println("otsib esimeest: " + commiteeList.get(commitee));
			if(commiteeList.get(commitee).getChairman()) {
				newCommission[0] = commiteeList.get(commitee);
				members.add(commitee);
				break;
			}
			searched++;
			if(searched >= 100) {
				break;
			}
		}
		for(int i = 1; i < newCommission.length; i++) {
			Random random = new Random();
			commitee = random.nextInt(max - 0);
			if(members.contains(commitee) || commiteeList.get(commitee).getChairman()) {
				i--;
				continue;
			}
			newCommission[i] = commiteeList.get(commitee);
			members.add(commitee);
		}
		commissionArray = newCommission;
	}
	
	public Commitee[] getCommission2() {
		//return commissionArray;
		return commissionArray;
	}
	
	/*
	public void setCommission2() {
		SessionCommission sessionCommission;
		Commitee[] newCommission = new Commitee[commissionSize];
		if(sessionCommissionList.size() == 0) {
			insertChairman(newCommission);
			insertCommiteeMembers(newCommission);
			sessionCommission = new SessionCommission(timeslot.getSession(), newCommission);
			sessionCommissionList.add(sessionCommission);
		} else {
			for(SessionCommission commission: sessionCommissionList) {
				if(commission.getSession() == timeslot.getSession()) {
					return;
				}
			}
		}
		
	}
	*/
	/*public Commitee[] getCommission(){
		return commissionArray;
	}*/
	
	public boolean enoughCommiteeMembers(){
		for(int i = 0; i < commissionSize; i++){
			if(commissionArray[i] == null){
				return false;
			}
		}
		if(currentCommissionMembersList.size() != commissionSize) {
			return false;
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
			if(valueTimeslot == timeslot) {
				return true;
			}
			/*
			int startTime = valueTimeslot.getStartTime().compareTo(timeslot.getStartTime());
			int endTime = valueTimeslot.getEndTime().compareTo(timeslot.getEndTime());
			int date = valueTimeslot.getDate().compareTo(timeslot.getDate());
			if(startTime == 0 && endTime == 0 && date == 0) {
				return true;
			}
			*/
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
			return true;
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
			//System.out.println("komisjoni liige: " + commiteeArray[i].getName() + " defense: " + this);
			if(getCommission2()[i] == null) {
				break;
			}
			if(checkWholeSetTimeslot(getCommission2()[i].getUnavailableTimeslotSet())) {
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
			if(getCommission2()[i] == null) {
				break;
			}
			if(checkWholeSetTimeslot(getCommission2()[i].getPreferredTimeslotSet())) {
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
		System.out.println("Chairmane on komisjonis: " + chairmanCount);
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
			if(supervisorIterator.hasNext()) {
				supervisor = supervisorIterator.next();
			}
			
			/*while(supervisorIterator.hasNext()){
				supervisor = supervisorIterator.next();
				if(supervisor.getRole().equals("Peajuhendaja")){
					break;
				}
				supervisor = null;
			}*/
		}
		System.out.println("Autori peamine juhendaja on: " + supervisor.getName());
		return supervisor;
	}
	
	public boolean isAuthorsNotPreferredTimeslot() {
		if(timeslot == null) {
			return true;
		}
		return checkWholeSetTimeslot(thesisAuthor.getNotPreferredTimeslotSet());
	}
	
	public int isCommissionMembersNotPreferredTimeslot() {
		if(timeslot == null) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++) {
			if(getCommission2()[i] == null) {
				break;
			}
			if(checkWholeSetTimeslot(getCommission2()[i].getNotPreferredTimeslotSet())) {
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
		/*
		while(checkedTagIterator.hasNext()){
			checkedTag = checkedTagIterator.next();
			while(timeslotTagIterator.hasNext()){
				timeslotTag = timeslotTagIterator.next();
				if(checkedTag.equals(timeslotTag)){
					return true;
				}
			}
		}*/
		while(timeslotTagIterator.hasNext()) {
			timeslotTag = timeslotTagIterator.next();
			//System.out.println("timeslotil on tag : " + timeslotTag);
			while(checkedTagIterator.hasNext()) {
				checkedTag = checkedTagIterator.next();
				//if(tagSet.contains(timeslotTag) && timeslotTag != "") {
				if(timeslotTag.equals(checkedTag) && !timeslotTag.equals("") && !checkedTag.equals("")) {
					if(timeslotTag.equals("")) {
						System.out.println("Tühi tag");
					}
					System.out.println("Leiti tag : " + timeslotTag);
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
			return true;
		}
		return checkWholeSetTimeslotTag(thesisAuthor.getNotPreferredTimeslotTagSet());
	}
	
	public boolean isAuthorsUnavailableTimeslotTag(){
		if(timeslot == null){
			return true;
		}
		return checkWholeSetTimeslotTag(thesisAuthor.getUnavailableTimeslotTagSet());
	}
	
	public int isCommissionMembersPreferredTimeslotTag(){
		if(timeslot == null){
			return 0;
		}
		int count = 0;
		for(int i = 0; i < commissionSize; i++){
			if(getCommission2()[i] == null) {
				break;
			}
			if(checkWholeSetTimeslotTag(getCommission2()[i].getPreferredTimeslotTagSet())){
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
			if(getCommission2()[i] == null) {
				break;
			}
			if(checkWholeSetTimeslotTag(getCommission2()[i].getNotPreferredTimeslotTagSet())){
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
			if(getCommission2()[i] == null) {
				break;
			}
			if(checkWholeSetTimeslotTag(getCommission2()[i].getUnavailableTimeslotTagSet())){
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
	
	public boolean overlapsTimeslot(Defense other) {
		return timeslot == other.getTimeslot();
	}
	
	
	public void addAuthorPreferredConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse preferred");
		droolsCommentsAuthor.add(thesisAuthor.getName() + " eelistas " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addAuthorNotPreferredConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse not preferred");
		droolsCommentsAuthor.add(thesisAuthor.getName() + " ei eelistanud " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addAuthorUnavailableConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse unavailable");
		droolsCommentsAuthor.add(thesisAuthor.getName() + " ei sobinud " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addNotUniqueTimeslotConstraint(Timeslot checkedTimeslot, Defense defense1, Defense defense2) {
		System.out.println("Lisatakse mitte unikaalne timeslot");
		droolsCommentsUnique.add(defense1.getThesisTitle() + "jagab oma aega kaitsmisega " + defense2.getThesisTitle() + " _ " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addAuthorUnavailableTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse unavailable tag");
		droolsCommentsAuthor.add(thesisAuthor.getName() + " ei sobinud võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addAuthorNotPreferredTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse not preferred tag");
		droolsCommentsAuthor.add(thesisAuthor.getName() + " ei eelistanud võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addAuthorPreferredTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse preferred tag");
		droolsCommentsAuthor.add(thesisAuthor.getName() + " eelistatud võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate());
	}
	
	public void addSupervisorUnavailableConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse supervisor unavailable");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		while(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			if(supervisor.getUnavailableTimeslotSet().contains(checkedTimeslot)) {
				supervisorComment += supervisor.getName() + " ei sobinud " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addSupervisorPreferredConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse supervisor preferred");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		while(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			if(supervisor.getPreferredTimeslotSet().contains(checkedTimeslot)) {
				supervisorComment += supervisor.getName() + " eelistas " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addSupervisorNotPreferredConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse supervisor not preferred");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		while(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			if(supervisor.getNotPreferredTimeslotSet().contains(checkedTimeslot)) {
				supervisorComment += supervisor.getName() + " ei eelistanud " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addSupervisorUnavailableTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse supervisor unavailable tag");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		while(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			if(supervisor.getUnavailableTimeslotTagSet().contains(checkedTimeslot)) {
				supervisorComment += supervisor.getName() + " ei sobinud võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addSupervisorPreferredTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse supervisor preferred tag");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		while(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			if(supervisor.getPreferredTimeslotTagSet().contains(checkedTimeslot)) {
				supervisorComment += supervisor.getName() + " eelistas võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addSupervisorNotPreferredTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse supervisor not preferred tag");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		while(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			if(supervisor.getNotPreferredTimeslotTagSet().contains(checkedTimeslot)) {
				supervisorComment += supervisor.getName() + " ei eelistanud võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addCommonSupervisorsConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse common supervisors");
		Set<ThesisSupervisor> thesisSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		Iterator<ThesisSupervisor> thesisSupervisorSetIterator = thesisSupervisorSet.iterator();
		String supervisorComment = "";
		if(thesisSupervisorSetIterator.hasNext()) {
			ThesisSupervisor supervisor = thesisSupervisorSetIterator.next();
			supervisorComment = supervisor.getName() + " on grupeeritud " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate();
		}
		droolsCommentsSupervisor.add(supervisorComment);
	}
	
	public void addCommissionUnavailableConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse commission unavailable");
		String commissionComment = "";
		for(Commitee commitee : commissionArray) {
			if(commitee.getUnavailableTimeslotSet().contains(checkedTimeslot)) {
				commissionComment += commitee.getName() + " ei sobinud " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsCommission.add(commissionComment);
	}
	
	public void addCommissionPreferredConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse commission preferred");
		String commissionComment = "";
		for(Commitee commitee : commissionArray) {
			if(commitee.getPreferredTimeslotSet().contains(checkedTimeslot)) {
				commissionComment += commitee.getName() + " eelistab " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsCommission.add(commissionComment);
	}
	
	public void addCommissionNotPreferredConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse commission not preferred");
		String commissionComment = "";
		for(Commitee commitee : commissionArray) {
			if(commitee.getNotPreferredTimeslotSet().contains(checkedTimeslot)) {
				commissionComment += commitee.getName() + " ei eelista " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsCommission.add(commissionComment);
	}
	
	public void addCommissionUnavailableTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse commission unavailable tag");
		String commissionComment = "";
		for(Commitee commitee : commissionArray) {
			if(commitee.getUnavailableTimeslotTagSet().contains(checkedTimeslot)) {
				commissionComment += commitee.getName() + " ei sobinud võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsCommission.add(commissionComment);
	}
	
	public void addCommissionPreferredTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse commission preferred tag");
		String commissionComment = "";
		for(Commitee commitee : commissionArray) {
			if(commitee.getPreferredTimeslotTagSet().contains(checkedTimeslot)) {
				commissionComment += commitee.getName() + " eelistab võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsCommission.add(commissionComment);
	}
	
	public void addCommissionNotPreferredTagConstraint(Timeslot checkedTimeslot) {
		System.out.println("Lisatakse commission not preferred tag");
		String commissionComment = "";
		for(Commitee commitee : commissionArray) {
			if(commitee.getNotPreferredTimeslotTagSet().contains(checkedTimeslot)) {
				commissionComment += commitee.getName() + " ei eelista võtmesõna " + checkedTimeslot.getStartTime() + "-" + checkedTimeslot.getEndTime() + " / " + checkedTimeslot.getDate() + "; ";
			}
		}
		droolsCommentsCommission.add(commissionComment);
	}

	/**
	 * with methods
	 */
	
	public Defense withDefenseType(DefenseType defenseType) {
		this.defenseType = defenseType;
		return this;
	}
}
