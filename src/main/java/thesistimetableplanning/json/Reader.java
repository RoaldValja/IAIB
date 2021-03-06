package thesistimetableplanning.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import thesistimetableplanning.domain.Commitee;
import thesistimetableplanning.domain.Defense;
import thesistimetableplanning.domain.DefenseType;
import thesistimetableplanning.domain.ThesisAuthor;
import thesistimetableplanning.domain.ThesisSupervisor;
import thesistimetableplanning.domain.Timeslot;
import thesistimetableplanning.domain.TimetableConstraintConfiguration;
import thesistimetableplanning.domain.TimetableSolution;

public class Reader {
	ArrayList<ArrayList<String>> tableConfigurationDataList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> tableTimeslotDataList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> tableAuthorDataList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> tableSupervisorDataList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> tableCommiteeDataList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> tableDefenseDataList = new ArrayList<ArrayList<String>>();
	
	private TimetableSolution solution;
	private DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
	private DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	private Map<String, DefenseType> totalDefenseTypeMap;
	private Set<String> totalTimeslotTagSet;
	private Map<String, ThesisSupervisor> totalThesisSupervisorMap;

	private List<Commitee> commiteesList = new ArrayList<Commitee>();
	private List<Commitee[]> commiteeArrays = new ArrayList<Commitee[]>();
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
	}
	
	public void setSolution(TimetableSolution solution){
		this.solution = solution;
	}
	
	public TimetableSolution getSolution(){
		return solution;
	}
	
	public Map<String, DefenseType> getTotalDefenseTypeMap() {
		return totalDefenseTypeMap;
	}

	public void setTotalDefenseTypeMap(Map<String, DefenseType> totalDefenseTypeMap) {
		this.totalDefenseTypeMap = totalDefenseTypeMap;
	}

	public Set<String> getTotalTimeslotTagSet() {
		return totalTimeslotTagSet;
	}

	public void setTotalTimeslotTagSet(Set<String> totalTimeslotTagSet) {
		this.totalTimeslotTagSet = totalTimeslotTagSet;
	}

	public Map<String, ThesisSupervisor> getTotalThesisSupervisorMap() {
		return totalThesisSupervisorMap;
	}

	public void setTotalThesisSupervisorMap(Map<String, ThesisSupervisor> totalThesisSupervisorMap) {
		this.totalThesisSupervisorMap = totalThesisSupervisorMap;
	}

	public TimetableSolution read(String fileName) throws FileNotFoundException, IOException, ParseException{
		solution = new TimetableSolution();
		readJSON(fileName);
		totalDefenseTypeMap = new HashMap<>();
		totalTimeslotTagSet = new HashSet<>();
		totalThesisSupervisorMap = new HashMap<>();
		readConfiguration();
		
		readTimeslotList();
		
		readSupervisorList();
		
		readAuthorList();
		
		readCommiteeList();
		
		Commitee[] e = new Commitee[3];
		e[1] = commiteesList.get(0);
		e[1] = commiteesList.get(1);
		e[1] = commiteesList.get(2);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(0);
		e[1] = commiteesList.get(1);
		e[1] = commiteesList.get(3);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(0);
		e[1] = commiteesList.get(1);
		e[1] = commiteesList.get(4);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(0);
		e[1] = commiteesList.get(2);
		e[1] = commiteesList.get(3);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(0);
		e[1] = commiteesList.get(2);
		e[1] = commiteesList.get(4);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(0);
		e[1] = commiteesList.get(3);
		e[1] = commiteesList.get(4);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(1);
		e[1] = commiteesList.get(2);
		e[1] = commiteesList.get(3);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(1);
		e[1] = commiteesList.get(2);
		e[1] = commiteesList.get(4);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(1);
		e[1] = commiteesList.get(3);
		e[1] = commiteesList.get(4);
		commiteeArrays.add(e);
		e[1] = commiteesList.get(2);
		e[1] = commiteesList.get(3);
		e[1] = commiteesList.get(4);
		commiteeArrays.add(e);
		
		readDefenseList();
		return solution;
		
	}
	
	public void titleCheck(String input, String answer){
		if(!input.equals(answer)){
			throw new IllegalStateException("Lahter " + input
					+ " on vale nimega. Lahtri nimi peab olema " + answer);
		}
	}
	
	public Set<String> seperateCommasSet(String timeTag){
		Set<String> timeTagSet = new LinkedHashSet<>();
		int countCommas = StringUtils.countMatches(timeTag, ",");
		if(countCommas == 0){
			timeTagSet.add(timeTag);
		} else {
			for(int j = 0; j < countCommas; j++){
				String getTag = timeTag.substring(0, timeTag.indexOf(","));
				String leftover = timeTag.substring(timeTag.indexOf(",")+2);
				timeTag = leftover;
				timeTagSet.add(getTag);
				if(j+1 == countCommas){
					timeTagSet.add(leftover);
				}
			}
		}
		return timeTagSet;
	}
	
	public List<String> seperateCommasList(String timeTag){
		List<String> timeTagList = new ArrayList<>();
		int countCommas = StringUtils.countMatches(timeTag, ",");
		if(countCommas == 0){
			timeTagList.add(timeTag);
		} else {
			for(int j = 0; j < countCommas; j++){
				String getTag = timeTag.substring(0, timeTag.indexOf(","));
				String leftover = timeTag.substring(timeTag.indexOf(",")+1);
				timeTag = leftover;
				timeTagList.add(getTag);
				if(j+1 == countCommas){
					timeTagList.add(leftover);
				}
			}
		}
		return timeTagList;
	}
	
	
	public String timeCheck(String time){
		int timeLength = time.length();
		String newTime = "";
		if(timeLength == 4 && time.contains(":")){
			if(time.indexOf(":") == 1) {
				newTime = "0" + time;
			} else if(time.indexOf(":") == 2) {
				newTime = time.substring(0, 3) + "0" + time.substring(3);
			}	
		} else if(timeLength == 5 && time.contains(":")){
			newTime = time;
		} else {
			return null;
		}
		int hours = Integer.parseInt(newTime.substring(0, 2));
		int minutes = Integer.parseInt(newTime.substring(3));
		if(hours >= 0 && hours <= 23) {
			if(minutes >= 0 && minutes <= 59) {
				return newTime;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public int getRowLength(ArrayList<ArrayList<String>> dataList){
		int rowLength = 0;
		int previousColumn = 0;
		for(int o = 1; o < dataList.size(); o++){
			int column = Integer.parseInt(dataList.get(o).get(2));
			int row = Integer.parseInt(dataList.get(o).get(1));
			if(column == 1 && row == 2){
				rowLength = previousColumn;
				break;
			}
			if(o == dataList.size()-1 && row == 1) {
				rowLength = column;
				break;
			}
			previousColumn = column;
		}
		return rowLength;
	}
	/**
	 * õ vahetada �
	 * ü vahetada �
	 * ä vahetada �
	 * ö vahetada �
	 * Õ vahetada �
	 * Ü vahetada �
	 * Ä vahetada �
	 * Ö vahetada �
	 * @param input
	 * @return
	 */
	public String fixDottedLetters(String input) {
		input = input.replaceAll("õ", "�");
		input = input.replaceAll("ü", "�");
		input = input.replaceAll("ä", "�");
		input = input.replaceAll("ö", "�");
		input = input.replaceAll("Õ", "�");
		input = input.replaceAll("Ü", "�");
		input = input.replaceAll("Ä", "�");
		input = input.replaceAll("Ö", "�");
		return input;
	}
	
	public void formatTime(int lowerLimit, int upperLimit, ArrayList<ArrayList<String>> dataList, List<LocalTime> startTimeList, List<LocalTime> endTimeList) {
		for(int k = lowerLimit; k < upperLimit; k++){
			String time = dataList.get(upperLimit+k).get(3);
			String startTimeString = timeCheck(time.substring(0, time.indexOf("-")));
			String endTimeString = timeCheck(time.substring(time.indexOf("-")+1));
			LocalTime startTime = LocalTime.parse(startTimeString, TIME_FORMATTER);
			LocalTime endTime = LocalTime.parse(endTimeString, TIME_FORMATTER);
			startTimeList.add(startTime);
			endTimeList.add(endTime);
		}
	}
	
	public void setTimeslotPreferences(int lowerLimit, int upperLimit, ArrayList<ArrayList<String>> dataList, int loopIndex,
			List<LocalDate> dayList, List<LocalTime> startTimeList, List<LocalTime> endTimeList,
			Set<Timeslot> preferredTimeslotSet, Set<Timeslot> notPreferredTimeslotSet, Set<Timeslot> unavailableTimeslotSet) {
		for(int l = lowerLimit; l < upperLimit; l++){
			String preference = fixDottedLetters(dataList.get(loopIndex+l).get(3));
			LocalDate preferredDay = dayList.get(l-lowerLimit);
			LocalTime preferredStartTime = startTimeList.get(l-lowerLimit);
			LocalTime preferredEndTime = endTimeList.get(l-lowerLimit);
			for(int o = 0; o < solution.getTimeslotList().size(); o++){
				Timeslot preferredTimeslot = solution.getTimeslotList().get(o);
				if(preferredTimeslot.getDate().isEqual(preferredDay) 
						&& preferredTimeslot.getStartTime().equals(preferredStartTime)
						&& preferredTimeslot.getEndTime().equals(preferredEndTime)){
					if(preference.equals("Eelistab")){
						preferredTimeslotSet.add(preferredTimeslot);
					} else if(preference.equals("Ei eelista")){
						notPreferredTimeslotSet.add(preferredTimeslot);
					} else if(preference.equals("Ei sobi")){
						unavailableTimeslotSet.add(preferredTimeslot);
					}
				}	
			}
		}
	}
	
	public void readConfiguration(){
		ArrayList<ArrayList<String>> configurationDataList = tableConfigurationDataList;
		TimetableConstraintConfiguration constraintConfiguration = new TimetableConstraintConfiguration();
		constraintConfiguration.setId(0L);
		String constraint = fixDottedLetters(configurationDataList.get(0).get(3));
		String weight = fixDottedLetters(configurationDataList.get(1).get(3));
		String description = fixDottedLetters(configurationDataList.get(2).get(3));
		String type = fixDottedLetters(configurationDataList.get(3).get(3));

		titleCheck(constraint, "Kitsendus");
		titleCheck(weight, "Kaal");
		titleCheck(description, "Kirjeldus");
		titleCheck(type, "T��p");
		
		for(int i = 4; i < configurationDataList.size(); i += 4){
			
			String constraintName = fixDottedLetters(configurationDataList.get(i).get(3));
			
			int constraintWeight = Integer.parseInt(configurationDataList.get(i+1).get(3));
			
			switch (constraintName) {
				case "Defense not on authors unavailable timeslot":
					constraintConfiguration.setDefenseNotOnAuthorsUnavailableTimeslot(HardSoftScore.ofHard(constraintWeight));
					break;
				case "Defense not on commission members unavailable timeslot":
					constraintConfiguration.setDefenseNotOnCommissionMembersUnavailableTimeslot(HardSoftScore.ofHard(constraintWeight));
					break;
				case "Defense timeslot only for single author":
					constraintConfiguration.setDefenseTimeslotOnlyForSingleAuthor(HardSoftScore.ofHard(constraintWeight));
					break;
				case "Defense authors grouped by common supervisor":
					constraintConfiguration.setDefenseAuthorsGroupedByCommonSupervisor(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense on authors preferred timeslot":
					constraintConfiguration.setDefenseOnAuthorsPreferredTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors not preferred timeslot":
					constraintConfiguration.setDefenseNotOnAuthorsNotPreferredTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense on commission members preferred timeslot":
					constraintConfiguration.setDefenseOnCommissionMembersPreferredTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on commission members not preferred timeslot":
					constraintConfiguration.setDefenseNotOnCommissionMembersNotPreferredTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense on authors supervisors preferred timeslot":
					constraintConfiguration.setDefenseOnAuthorsSupervisorsPreferredTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors supervisors not preferred timeslot":
					constraintConfiguration.setDefenseNotOnAuthorsSupervisorsNotPreferredTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors supervisors unavailable timeslot":
					constraintConfiguration.setDefenseNotOnAuthorsSupervisorsUnavailableTimeslot(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense on authors preferred timeslot tag":
					constraintConfiguration.setDefenseOnAuthorsPreferredTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors not preferred timeslot tag":
					constraintConfiguration.setDefenseNotOnAuthorsNotPreferredTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors unavailable timeslot tag":
					constraintConfiguration.setDefenseNotOnAuthorsUnavailableTimeslotTag(HardSoftScore.ofHard(constraintWeight));
					break;
				case "Defense on commission members preferred timeslot tag":
					constraintConfiguration.setDefenseOnCommissionMembersPreferredTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on commission members not preferred timeslot tag":
					constraintConfiguration.setDefenseNotOnCommissionMembersNotPreferredTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on commission members unavailable timeslot tag":
					constraintConfiguration.setDefenseNotOnCommissionMembersUnavailableTimeslotTag(HardSoftScore.ofHard(constraintWeight));
					break;
				case "Defense on authors supervisors preferred timeslot tag":
					constraintConfiguration.setDefenseOnAuthorsSupervisorsPreferredTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors supervisors not preferred timeslot tag":
					constraintConfiguration.setDefenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense not on authors supervisors unavailable timeslot tag":
					constraintConfiguration.setDefenseNotOnAuthorsSupervisorsUnavailableTimeslotTag(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Commission member does not swap with a new member in the same session":
					constraintConfiguration.setCommissionMemberDoesNotSwapWithANewMemberInTheSameSession(HardSoftScore.ofSoft(constraintWeight));
					break;
				case "Defense timeslots grouped by common session and have no holes between them":
					constraintConfiguration.setDefenseTimeslotsGroupedByCommonSessionAndHaveNoHolesBetweenThem(HardSoftScore.ofSoft(constraintWeight));
					break;
			}
		}
		solution.setConstraintConfiguration(constraintConfiguration);
	}
	
	public void readTimeslotList(){
		ArrayList<ArrayList<String>> timeslotDataList = tableTimeslotDataList;
		List<Timeslot> timeslotList = new ArrayList<>();
		List<DefenseType> defenseTypeList = new ArrayList<>();
		
		long id = 0L;
		long defenseTypeId = 0L;
		String timeslotDay = fixDottedLetters(timeslotDataList.get(0).get(3));
		String timeslotStart = fixDottedLetters(timeslotDataList.get(1).get(3));
		String timeslotEnd = fixDottedLetters(timeslotDataList.get(2).get(3));
		String timeslotDefenseType = fixDottedLetters(timeslotDataList.get(3).get(3));
		String timeslotSession = fixDottedLetters(timeslotDataList.get(4).get(3));
		String timeslotTags = fixDottedLetters(timeslotDataList.get(5).get(3));
		
		titleCheck(timeslotDay, "P�ev");
		titleCheck(timeslotStart, "Algus");
		titleCheck(timeslotEnd, "L�pp");
		titleCheck(timeslotDefenseType, "Kaitsmise t��p");
		titleCheck(timeslotSession, "Sessioon");
		titleCheck(timeslotTags, "V�tmes�nad");
		
		for(int i = 6; i < timeslotDataList.size(); i += 6){
			Timeslot timeslot = new Timeslot();
			timeslot.setId(id++);
			String startTimeString = timeCheck(timeslotDataList.get(i+1).get(3));
			String endTimeString = timeCheck(timeslotDataList.get(i+2).get(3));
			
			LocalDate day = LocalDate.parse(timeslotDataList.get(i).get(3), DAY_FORMATTER);
			
			LocalTime startTime = LocalTime.parse(startTimeString, TIME_FORMATTER);
			LocalTime endTime = LocalTime.parse(endTimeString, TIME_FORMATTER);
			
			if (startTime.compareTo(endTime) >= 0) {
                throw new IllegalStateException(": The startTime (" + startTime
                        + ") must be less than the endTime (" + endTime + ").");
            }
			String defenseTypeName = fixDottedLetters(timeslotDataList.get(i+3).get(3));
			
			timeslot.setDate(day);
			timeslot.setStartTime(startTime);
			timeslot.setEndTime(endTime);
			DefenseType defenseType = totalDefenseTypeMap.get(defenseTypeName);
			if(defenseType == null){
				defenseType = new DefenseType(defenseTypeId);
				defenseTypeId++;
				defenseType.setCompatibleTimeslotSet(new LinkedHashSet<>());
				defenseType.setType(defenseTypeName);
				totalDefenseTypeMap.put(defenseTypeName, defenseType);
				defenseTypeList.add(defenseType);
			}
			int session = Integer.parseInt(timeslotDataList.get(i+4).get(3));
			timeslot.setSession(session);
			String timeTag = fixDottedLetters(timeslotDataList.get(i+5).get(3));
			
			timeslot.setTagSet(seperateCommasSet(timeTag));
			defenseType.getCompatibleTimeslotSet().add(timeslot);
			totalTimeslotTagSet.addAll(timeslot.getTagSet());
			timeslotList.add(timeslot);
		}
		solution.setTimeslotList(timeslotList);
		solution.setDefenseTypeList(defenseTypeList);
	}
	
	public void readSupervisorList(){
		ArrayList<ArrayList<String>> supervisorDataList = tableSupervisorDataList;
		int rowLength = getRowLength(supervisorDataList);
		Set<String> timeSetString = new LinkedHashSet<>();
		List<ThesisSupervisor> supervisorList = new ArrayList<>();
		
		List<LocalDate> dayList = new ArrayList<>();
		List<LocalTime> startTimeList = new ArrayList<>();
		List<LocalTime> endTimeList = new ArrayList<>();
		
		long id = 0L;
		
		for(int i = 0; i < supervisorDataList.size(); i+=rowLength){
			String name = fixDottedLetters(supervisorDataList.get(i).get(3));
			String role = fixDottedLetters(supervisorDataList.get(i+1).get(3));
			String preferred = fixDottedLetters(supervisorDataList.get(i+2).get(3));
			String notPreferred = fixDottedLetters(supervisorDataList.get(i+3).get(3));
			String unavailable = fixDottedLetters(supervisorDataList.get(i+4).get(3));
			
			if(i == 0){
				for(int j = 5; j < rowLength; j++){
					LocalDate day = LocalDate.parse(supervisorDataList.get(j).get(3), DAY_FORMATTER);
					dayList.add(day);
				}
			}
			if(i == rowLength){
				titleCheck(name, "Nimi");
				titleCheck(role, "Roll");
				titleCheck(preferred, "Eelistatud m�rks�nad");
				titleCheck(notPreferred, "Mitte-eelistatud m�rks�nad");
				titleCheck(unavailable, "Sobimatud m�rks�nad");
				formatTime(5, rowLength, supervisorDataList, startTimeList, endTimeList);
			}
			if(i > rowLength){
				ThesisSupervisor thesisSupervisor = new ThesisSupervisor();
				thesisSupervisor.setId(id++);
				thesisSupervisor.setName(name);
				thesisSupervisor.setRole(role);
				Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
				Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
				Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
				setTimeslotPreferences(5, rowLength, supervisorDataList, i, dayList, startTimeList, endTimeList,
						preferredTimeslotSet, notPreferredTimeslotSet, unavailableTimeslotSet);
				thesisSupervisor.setPreferredTimeslotSet(preferredTimeslotSet);
				thesisSupervisor.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
				thesisSupervisor.setUnavailableTimeslotSet(unavailableTimeslotSet);
				thesisSupervisor.setPreferredTimeslotTagSet(seperateCommasSet(preferred));
				thesisSupervisor.setNotPreferredTimeslotTagSet(seperateCommasSet(notPreferred));
				thesisSupervisor.setUnavailableTimeslotTagSet(seperateCommasSet(unavailable));
				supervisorList.add(thesisSupervisor);
			}
		}
		solution.setThesisSupervisorList(supervisorList);
	}
	
	public void readAuthorList(){
		ArrayList<ArrayList<String>> authorDataList = tableAuthorDataList;
		int rowLength = getRowLength(authorDataList);
		List<LocalDate> dayList = new ArrayList<>();
		List<LocalTime> startTimeList = new ArrayList<>();
		List<LocalTime> endTimeList = new ArrayList<>();
		Set<String> timeSetString = new LinkedHashSet<>();
		List<ThesisAuthor> authorList = new ArrayList<>();
		long id = 0L;
		
		for(int i = 0; i < authorDataList.size(); i+=rowLength){
			String name = fixDottedLetters(authorDataList.get(i).get(3));
			String prerequisite = fixDottedLetters(authorDataList.get(i+1).get(3));
			
			Set<ThesisSupervisor> supervisorsSet = new LinkedHashSet<>();
			List<String> thesisSupervisorNameList = new ArrayList<>();
			String supervisorNames = fixDottedLetters(authorDataList.get(i+2).get(3));
			String preferred = fixDottedLetters(authorDataList.get(i+3).get(3));
			String notPreferred = fixDottedLetters(authorDataList.get(i+4).get(3));
			String unavailable = fixDottedLetters(authorDataList.get(i+5).get(3));
			
			thesisSupervisorNameList = seperateCommasList(supervisorNames);
			
			if(i == 0){
				for(int j = 6; j < rowLength; j++){
					LocalDate day = LocalDate.parse(authorDataList.get(j).get(3), DAY_FORMATTER);
					dayList.add(day);
				}
			}
			
			if(i == rowLength){
				titleCheck(name, "Nimi");
				titleCheck(prerequisite, "Eeldused on t�idetud");
				titleCheck(supervisorNames, "Juhendajad");
				titleCheck(preferred, "Eelistatud m�rks�nad");
				titleCheck(notPreferred, "Mitte-eelistatud m�rks�nad");
				titleCheck(unavailable, "Sobimatud m�rks�nad");
				formatTime(6, rowLength, authorDataList, startTimeList, endTimeList);
			}
			if(i > rowLength){
				ThesisAuthor thesisAuthor = new ThesisAuthor();
				thesisAuthor.setId(id++);
				thesisAuthor.setName(name);
				if(prerequisite.equals("Jah")){
					thesisAuthor.hasPreconditionsFulfilled();
				}
				for(int o = 0; o < solution.getThesisSupervisorList().size(); o++){
					ThesisSupervisor thesisSupervisor = solution.getThesisSupervisorList().get(o);
					for(int k = 0; k < thesisSupervisorNameList.size(); k++){
						if(thesisSupervisorNameList.get(k).equals(thesisSupervisor.getName())){
							supervisorsSet.add(thesisSupervisor);
						}
					}
				}
				Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
				Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
				Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
				thesisAuthor.setThesisSupervisorSet(supervisorsSet);
				setTimeslotPreferences(6, rowLength, authorDataList, i, dayList, startTimeList, endTimeList,
						preferredTimeslotSet, notPreferredTimeslotSet, unavailableTimeslotSet);
				thesisAuthor.setPreferredTimeslotSet(preferredTimeslotSet);
				thesisAuthor.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
				thesisAuthor.setUnavailableTimeslotSet(unavailableTimeslotSet);

				thesisAuthor.setPreferredTimeslotTagSet(seperateCommasSet(preferred));
				thesisAuthor.setNotPreferredTimeslotTagSet(seperateCommasSet(notPreferred));
				thesisAuthor.setUnavailableTimeslotTagSet(seperateCommasSet(unavailable));
				authorList.add(thesisAuthor);
			}
			
		}
		solution.setThesisAuthorList(authorList);
	}
	
	public void readCommiteeList(){
		ArrayList<ArrayList<String>> commiteeDataList = tableCommiteeDataList;
		int rowLength = getRowLength(commiteeDataList);
		List<LocalDate> dayList = new ArrayList<>();
		List<LocalTime> startTimeList = new ArrayList<>();
		List<LocalTime> endTimeList = new ArrayList<>();
		Set<String> timeSetString = new LinkedHashSet<>();
		List<Commitee> commiteeList = new ArrayList<>();
		long id = 0L;
		
		for(int i = 0; i < commiteeDataList.size(); i+=rowLength){
			String name = fixDottedLetters(commiteeDataList.get(i).get(3));
			String degree = fixDottedLetters(commiteeDataList.get(i+1).get(3));
			String chairman = fixDottedLetters(commiteeDataList.get(i+2).get(3));
			String preferred = fixDottedLetters(commiteeDataList.get(i+3).get(3));
			String notPreferred = fixDottedLetters(commiteeDataList.get(i+4).get(3));
			String unavailable = fixDottedLetters(commiteeDataList.get(i+5).get(3));
			
			if(i == 0){
				for(int j = 6; j < rowLength; j++){
					LocalDate day = LocalDate.parse(commiteeDataList.get(j).get(3), DAY_FORMATTER);
					dayList.add(day);
				}
			}
			if(i == rowLength){
				titleCheck(name, "Nimi");
				titleCheck(degree, "Kraad");
				titleCheck(chairman, "Esimees");
				titleCheck(preferred, "Eelistatud m�rks�nad");
				titleCheck(notPreferred, "Mitte-eelistatud m�rks�nad");
				titleCheck(unavailable, "Sobimatud m�rks�nad");
				formatTime(6, rowLength, commiteeDataList, startTimeList, endTimeList);
			}
			if(i > rowLength){
				Commitee commitee = new Commitee();
				commitee.setId(id++);
				commitee.setName(name);
				commitee.setDegree(degree);
				if(chairman.equals("Esimees") || chairman.equals("Aseesimees")){
					commitee.isChairman();
					commitee.setChairmanType(chairman);
				} else if(chairman.equals("Ei")){
					commitee.setChairmanType(chairman);
				}
				Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
				Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
				Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
				setTimeslotPreferences(6, rowLength, commiteeDataList, i, dayList, startTimeList, endTimeList,
						preferredTimeslotSet, notPreferredTimeslotSet, unavailableTimeslotSet);
				commitee.setPreferredTimeslotSet(preferredTimeslotSet);
				commitee.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
				commitee.setUnavailableTimeslotSet(unavailableTimeslotSet);
				commitee.setPreferredTimeslotTagSet(seperateCommasSet(preferred));
				commitee.setNotPreferredTimeslotTagSet(seperateCommasSet(notPreferred));
				commitee.setUnavailableTimeslotTagSet(seperateCommasSet(unavailable));
				commiteeList.add(commitee);
				commiteesList.add(commitee);
			}
		}
		solution.setCommiteeList(commiteeList);
	}
	
	public void readDefenseList(){
		ArrayList<ArrayList<String>> defenseDataList = tableDefenseDataList;
		int rowLength = getRowLength(defenseDataList);
		List<Defense> defenseList = new ArrayList<>();
		long id = 0L;
		
		for(int i = 0; i < defenseDataList.size(); i+=rowLength){
			String title = fixDottedLetters(defenseDataList.get(i).get(3));
			String code = fixDottedLetters(defenseDataList.get(i+1).get(3));
			String defenseTypeName = fixDottedLetters(defenseDataList.get(i+2).get(3));
			String degree = fixDottedLetters(defenseDataList.get(i+3).get(3));
			String defenseAuthorName = fixDottedLetters(defenseDataList.get(i+4).get(3));
			String thesisTheme = fixDottedLetters(defenseDataList.get(i+5).get(3));
			String roomNumber = fixDottedLetters(defenseDataList.get(i+6).get(3));
			
			String roomCapacityName = "";
			String commissionSizeName = "";
			int roomCapacity = 0;
			int commissionSize = 0;
			if(i == 0){
				roomCapacityName = fixDottedLetters(defenseDataList.get(i+7).get(3));
				commissionSizeName = fixDottedLetters(defenseDataList.get(i+8).get(3));
				
				titleCheck(code, "Kood");
				titleCheck(title, "L�put�� pealkiri");
				titleCheck(defenseTypeName, "Kaitsmise t��p");
				titleCheck(degree, "L�put�� kraad");
				titleCheck(defenseAuthorName, "L�put�� autor");
				titleCheck(thesisTheme, "Sarnane l�put�� teema");
				titleCheck(roomNumber, "Ruumi nr");
				titleCheck(roomCapacityName, "Ruumi maht");
				titleCheck(commissionSizeName, "Komisjoni suurus");
			}
			
			if(i >= rowLength){
				roomCapacity = Integer.parseInt(defenseDataList.get(i+7).get(3));
				commissionSize = Integer.parseInt(defenseDataList.get(i+8).get(3));
				Defense defense = new Defense();
				
				defense.setId(id++);
				defense.setCode(code);
				defense.setThesisTitle(title);
				defense.setDegree(degree);
				defense.setThesisTheme(thesisTheme);
				defense.setRoomNumber(roomNumber);
				defense.setRoomCapacity(roomCapacity);
				defense.setCommissionSize(commissionSize);
				defense.setCommiteeList(solution.getCommiteeList());
				
				for(int k = 0; k < solution.getDefenseTypeList().size(); k++){
					DefenseType defenseType = solution.getDefenseTypeList().get(k);
					if(defenseType.getType().equals(defenseTypeName)){
						defense.setDefenseType(defenseType);
					}
				}
				
				for(int o = 0; o < solution.getThesisAuthorList().size(); o++){
					ThesisAuthor thesisAuthor = solution.getThesisAuthorList().get(o);
					if(thesisAuthor.getName().equals(defenseAuthorName)){
						defense.setThesisAuthor(thesisAuthor);
					}
				}
				defenseList.add(defense);
			}
		}
		solution.setDefenseList(defenseList);
	}
	
	public void readJSON() throws FileNotFoundException,
    IOException, ParseException{
		readJSON("PlanData.json");
	}
	
	public void readJSON(String fileName) throws FileNotFoundException,
    IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(
				new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8")));
        JSONArray jsonArray2 = (JSONArray) jsonObject.get("table");
        for (Object o : jsonArray2) {
        	JSONObject table = (JSONObject) o;
        	String strTableName = (String) table.get("name");
        	JSONArray tableSlots = (JSONArray) table.get("tableSlot");
        	for (Object o2 : tableSlots) {
        		ArrayList<String> tableDataSlotList = new ArrayList<String>();
        		JSONObject tableData = (JSONObject) o2;
        		String strTableRow = (String) tableData.get("row");
        		String strTableColumn = (String) tableData.get("column");
        		String strTableData = (String) tableData.get("data");
        		tableDataSlotList.add(strTableName);
        		tableDataSlotList.add(strTableRow);
        		tableDataSlotList.add(strTableColumn);
        		tableDataSlotList.add(strTableData);
        		addToTableList(tableDataSlotList);
        	}
        }
	}
	
	public String readJSONConfig(String fileName) throws FileNotFoundException,
    IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(
				new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8")));
        String hours = (String) jsonObject.get("hours");
        String minutes = (String) jsonObject.get("minutes");
        String seconds = (String) jsonObject.get("seconds");
        String algorithm = (String) jsonObject.get("algorithm");
        int time = Integer.parseInt(hours)*3600 + Integer.parseInt(minutes)*60 + Integer.parseInt(seconds);
        
        String output = time + "-" + algorithm;
        return output;
	}
	
	public void addToTableList(ArrayList<String> list){
		if(list.get(0).equals("tableConfiguration")){
			tableConfigurationDataList.add(list);
		} else if(list.get(0).equals("tableTimeslot")){
			tableTimeslotDataList.add(list);
		} else if(list.get(0).equals("tableAuthor")){
			tableAuthorDataList.add(list);
		} else if(list.get(0).equals("tableSupervisor")){
			tableSupervisorDataList.add(list);
		} else if(list.get(0).equals("tableCommitee")){
			tableCommiteeDataList.add(list);
		} else if(list.get(0).equals("tableDefense")){
			tableDefenseDataList.add(list);
		}
	}
	
	public ArrayList<ArrayList<String>> getConfigurationTable(){
		return tableConfigurationDataList;
	}
	
	public ArrayList<ArrayList<String>> getTimeslotTable(){
		return tableTimeslotDataList;
	}
	
	public ArrayList<ArrayList<String>> getAuthorTable(){
		return tableAuthorDataList;
	}
	
	public ArrayList<ArrayList<String>> getSupervisorTable(){
		return tableSupervisorDataList;
	}
	
	public ArrayList<ArrayList<String>> getCommiteeTable(){
		return tableCommiteeDataList;
	}
	
	public ArrayList<ArrayList<String>> getDefenseTable(){
		return tableDefenseDataList;
	}
}
