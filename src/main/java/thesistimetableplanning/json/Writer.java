package thesistimetableplanning.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import thesistimetableplanning.domain.Commitee;
import thesistimetableplanning.domain.Defense;
import thesistimetableplanning.domain.ThesisAuthor;
import thesistimetableplanning.domain.ThesisSupervisor;
import thesistimetableplanning.domain.Timeslot;
import thesistimetableplanning.domain.TimetableSolution;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Writer {

	public static void main(String[] args) {
		System.out.println("hello");
	/*
		Writer writer = new Writer();
		writer.writeJSON();
	*/
		// Parses the first date
        LocalDate dt1 = LocalDate.parse("2018-11-27");
        // Parses the second date
        LocalDate dt2 = LocalDate.parse("2018-11-27");
 
        // Checks
        System.out.println(dt1.isBefore(dt2));
	}
	List<LocalDate> dateList = new ArrayList<>();
	List<LocalTime> startTimeList = new ArrayList<>();
	List<LocalTime> endTimeList = new ArrayList<>();
	List<String> typeList = new ArrayList<>();
	List<String> degreeList = new ArrayList<>();
	List<String> titleList = new ArrayList<>();
	List<ThesisAuthor> authorList = new ArrayList<>();
	List<Set<ThesisSupervisor>> authorsSupervisorsList = new ArrayList<>();
	List<Commitee[]> commiteeList = new ArrayList<>();
	List<String> similarThemeList = new ArrayList<>();
	List<String> roomNumberList = new ArrayList<>();
	List<String> commentsAuthorList = new ArrayList<>();
	List<String> commentsSupervisorList = new ArrayList<>();
	List<String> commentsCommissionList = new ArrayList<>();
	List<String> commentsUniqueList = new ArrayList<>();
	
	JSONArray defenseDateList = new JSONArray();
	JSONArray defenseStartTimeList = new JSONArray();
	JSONArray defenseEndTimeList = new JSONArray();
	JSONArray defenseTypeList = new JSONArray();
	JSONArray defenseDegreeList = new JSONArray();
	JSONArray defenseTitleList = new JSONArray();
	JSONArray defenseAuthorList = new JSONArray();
	JSONArray defenseAuthorsSupervisorsList = new JSONArray();
	JSONArray defenseCommiteeList = new JSONArray();
	JSONArray defenseSimilarThemeList = new JSONArray();
	JSONArray defenseRoomNumberList = new JSONArray();
	JSONArray defenseCommentsAuthorList = new JSONArray();
	JSONArray defenseCommentsSupervisorList = new JSONArray();
	JSONArray defenseCommentsCommissionList = new JSONArray();
	JSONArray defenseCommentsUniqueList = new JSONArray();
	
	List<Defense> defenses;
	
	public void write(TimetableSolution solution) throws IOException {
		defenses = solution.getDefenseList();
		System.out.println("Lahenduse id on: " + solution + " - " + defenses.size());
		System.out.println("Lahendusi on : " + solution.getTotalSolutions() + " - lahenduse nr on - " + solution.getSolutionNr());
		/*
		for(Defense defense : defenses) {
			if(defense.getTimeslot() == null) {
				System.out.println("timeslot puudu");
				continue;
			}
			System.out.println(defense.getThesisTitle() + " id: " + defense.getId() + " - " + defense.getTimeslot() + " - " + defense.getTimeslot().getDate() + "/" + defense.getTimeslot().getStartTime() + ":" + defense.getTimeslot().getEndTime());
		}
		*/
		System.out.println("enne sorteerimist");
		
		Collections.sort(defenses, (d1, d2) -> {
			if(d1.getTimeslot() == null || d2.getTimeslot() == null) {
				return -1;
			}
			LocalDateTime d2DateTime = LocalDateTime.of(d2.getTimeslot().getDate(), d2.getTimeslot().getStartTime());
			LocalDateTime d1DateTime = LocalDateTime.of(d1.getTimeslot().getDate(), d1.getTimeslot().getStartTime());
			return d1DateTime.compareTo(d2DateTime);
		});
		
		System.out.println("peale sorteerimist");
		System.out.println("Score: " + solution.getScore());
		int amountOfDefenses = defenses.size();
		JSONObject table = new JSONObject();
		System.out.println("kaitsmisi on: " + defenses.size());
		//int k = 0;
		/*
		for(Defense defense : defenses) {
			k++;
			System.out.println(k + " kaitsmine: " + defense.getThesisTitle());
		}*/
		for(Defense defense : defenses) {/*
			dateList.add(defense.getTimeslot().getDate());
			startTimeList.add(defense.getTimeslot().getStartTime());
			endTimeList.add(defense.getTimeslot().getEndTime());
			typeList.add(defense.getDefenseType().getType());
			degreeList.add(defense.getDegree());
			titleList.add(defense.getThesisTitle());
			authorList.add(defense.getThesisAuthor());
			authorsSupervisorsList.add(defense.getThesisAuthor().getThesisSupervisorSet());
			commiteeList.add(defense.getCommission2());
			similarThemeList.add(defense.getThesisTheme());
			roomNumberList.add(defense.getRoomNumber());
			*/
		//	k++;
		//	System.out.println(k + " paneb tabeli: " + defense.getThesisTitle() + " timeslot: " + defense.getTimeslot());
			defenseDateList.add(getDate(defense));
			defenseStartTimeList.add(getStartTime(defense));
			defenseEndTimeList.add(getEndTime(defense));
			defenseTypeList.add(getDefenseType(defense));
			defenseDegreeList.add(getDefenseDegree(defense));
			defenseTitleList.add(getDefenseTitle(defense));
			defenseAuthorList.add(getDefenseAuthor(defense));
			defenseAuthorsSupervisorsList.add(getDefenseAuthorsSupervisors(defense));
			defenseCommiteeList.add(getDefenseCommitee(defense));
			defenseSimilarThemeList.add(getDefenseSimilarTheme(defense));
			defenseRoomNumberList.add(getDefenseRoomNumber(defense));
			defenseCommentsAuthorList.add(getDefenseCommentsAuthor(defense));
			defenseCommentsSupervisorList.add(getDefenseCommentsSupervisor(defense));
			defenseCommentsCommissionList.add(getDefenseCommentsCommission(defense));
			defenseCommentsUniqueList.add(getDefenseCommentsUnique(defense));
		}
		System.out.println("Tabelid pandud");
		/*
		Collections.sort(startTimeList);
		for(int i = 0; i < startTimeList.size(); i++) {
			System.out.println(startTimeList.get(i));
		}
		LocalDate leftDate = LocalDate.of(9000, 12, 12);
		LocalTime leftTime = LocalTime.of(23, 59);
		LocalDateTime leftDateTime = LocalDateTime.of(leftDate, leftTime);
		LocalDateTime rightDateTime;
		int listIndex = 0;
		
		List<LocalDate> newDateList = new ArrayList<>();
		List<LocalTime> newStartTimeList = new ArrayList<>();
		List<LocalTime> newEndTimeList = new ArrayList<>();
		List<String> newTypeList = new ArrayList<>();
		List<String> newDegreeList = new ArrayList<>();
		List<String> newTitleList = new ArrayList<>();
		List<ThesisAuthor> newAuthorList = new ArrayList<>();
		List<Set<ThesisSupervisor>> newAuthorsSupervisorsList = new ArrayList<>();
		List<Commitee[]> newCommiteeList = new ArrayList<>();
		List<String> newSimilarThemeList = new ArrayList<>();
		List<String> newRoomNumberList = new ArrayList<>();
		
		for(int i = 0; i < amountOfDefenses; i++) {
			for(int j = 0; j < amountOfDefenses; j++) {
				rightDateTime = LocalDateTime.of(dateList.get(j), startTimeList.get(j));
				System.out.println(rightDateTime.toString());
				
				if(rightDateTime.isBefore(leftDateTime)) {
					listIndex = j;
				}
			}
			newDateList.add(dateList.get(listIndex));
			newStartTimeList.add(startTimeList.get(listIndex));
			newEndTimeList.add(endTimeList.get(listIndex));
			newTypeList.add(typeList.get(listIndex));
			newDegreeList.add(degreeList.get(listIndex));
			newTitleList.add(titleList.get(listIndex));
			newAuthorList.add(authorList.get(listIndex));
			newAuthorsSupervisorsList.add(authorsSupervisorsList.get(listIndex));
			newCommiteeList.add(commiteeList.get(listIndex));
			newSimilarThemeList.add(similarThemeList.get(listIndex));
			newRoomNumberList.add(roomNumberList.get(listIndex));
			dateList.set(listIndex, LocalDate.of(9000, 12, 12));
			startTimeList.set(listIndex, LocalTime.of(23, 59));
		}
		
		defenseDateList = newDefenseDateList;
		defenseStartTimeList = newDefenseStartTimeList;
		defenseEndTimeList = newDefenseEndTimeList;
		defenseTypeList = newDefenseTypeList;
		defenseDegreeList = newDefenseDegreeList;
		defenseTitleList = newDefenseTitleList;
		defenseAuthorList = newDefenseAuthorList;
		defenseAuthorsSupervisorsList = newDefenseAuthorsSupervisorsList;
		defenseCommiteeList = newDefenseCommiteeList;
		defenseSimilarThemeList = newDefenseSimilarThemeList;
		defenseRoomNumberList = newDefenseRoomNumberList;
		
		
		for(int i = 0; i < dateList.size(); i++) {
			System.out.println(newDateList.get(i) + " " + newStartTimeList.get(i) + " " + newEndTimeList.get(i));
		}
		*/
		table.put("dateList", defenseDateList);
		table.put("startTimeList", defenseStartTimeList);
		table.put("endTimeList", defenseEndTimeList);
		table.put("defenseTypeList", defenseTypeList);
		table.put("defenseDegreeList", defenseDegreeList);
		table.put("defenseTitleList", defenseTitleList);
		table.put("defenseAuthorList", defenseAuthorList);
		table.put("defenseAuthorsSupervisorsList", defenseAuthorsSupervisorsList);
		table.put("defenseCommiteeList", defenseCommiteeList);
		table.put("defenseSimilarThemeList", defenseSimilarThemeList);
		table.put("defenseRoomNumberList", defenseRoomNumberList);
		table.put("defenseCommentsAuthorList", defenseCommentsAuthorList);
		table.put("defenseCommentsSupervisorList", defenseCommentsSupervisorList);
		table.put("defenseCommentsCommissionList", defenseCommentsCommissionList);
		table.put("defenseCommentsUniqueList", defenseCommentsUniqueList);
		System.out.println("enne json kirjutamist");
		try(FileWriter file = new FileWriter("veebiliides/json/plannedData.json")){
			file.write(table.toJSONString());
		} catch (IOException e){
			e.printStackTrace();
		}
		/*
		try(FileWriter file = new FileWriter("src/main/webapp/json/plannedData.json")){
			file.write(table.toJSONString());
		} catch (IOException e){
			e.printStackTrace();
		}
		*/
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/webapp/json/plannedData.json"), "UTF-8"));
	    try{
	    	out.write(table.toJSONString());
	    } finally {
	    	out.close();
	    }

		System.out.println("peale json kirjutamist");
		try(FileWriter file = new FileWriter("src/main/webapp/ready.txt")){
			file.write("x");
			file.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public JSONObject getDate(Defense defense) {
		JSONObject date = new JSONObject();
		if(defense.getTimeslot() == null) {
			date.put("date", "null");
		} else {
			date.put("date", defense.getTimeslot().getDate().toString());
		}
		return date;
	}
	
	public JSONObject getStartTime(Defense defense) {
		JSONObject startTime = new JSONObject();
		if(defense.getTimeslot() == null) {
			startTime.put("start time", "null");
		} else {
			startTime.put("start time", defense.getTimeslot().getStartTime().toString());
		}
		return startTime;
	}
	
	public JSONObject getEndTime(Defense defense) {
		JSONObject endTime = new JSONObject();
		if(defense.getTimeslot() == null) {
			endTime.put("end time", "null");
		} else {
			endTime.put("end time", defense.getTimeslot().getEndTime().toString());
		}
		return endTime;
	}
	
	public JSONObject getDefenseType(Defense defense) {
		JSONObject defenseType = new JSONObject();
		defenseType.put("defense type", defense.getDefenseType().getType());
		return defenseType;
	}
	
	public JSONObject getDefenseDegree(Defense defense) {
		JSONObject defenseDegree = new JSONObject();
		defenseDegree.put("defense degree", defense.getDegree());
		return defenseDegree;
	}
	
	public JSONObject getDefenseTitle(Defense defense) {
		JSONObject defenseTitle = new JSONObject();
		defenseTitle.put("defense title", defense.getThesisTitle());
		return defenseTitle;
	}
	
	public JSONObject getDefenseAuthor(Defense defense) {
		JSONObject defenseAuthor = new JSONObject();
		defenseAuthor.put("defense author", defense.getThesisAuthor().getName());
		return defenseAuthor;
	}
	
	public JSONObject getDefenseAuthorsSupervisors(Defense defense) {
		JSONObject defenseAuthorsSupervisors = new JSONObject();
		Set<ThesisSupervisor> supervisors = defense.getThesisAuthor().getThesisSupervisorSet();
		//System.out.println("supervisorid on: " + supervisors);
		String supervisorNames = "";
		for(ThesisSupervisor supervisor : supervisors) {
			supervisorNames += supervisor.getName() + ", ";
		}
		supervisorNames = supervisorNames.substring(0, supervisorNames.length() - 2);
		defenseAuthorsSupervisors.put("defense authors supervisors", supervisorNames);
		return defenseAuthorsSupervisors;
	}
	
	public JSONObject getDefenseCommitee(Defense defense) {
		JSONObject defenseCommitee = new JSONObject();
		Commitee[] commiteeArray = defense.getCommission2();
		String commiteeNames = "";
		//System.out.println("commiteearrays on: " + commiteeArray);
		if(commiteeArray == null) {
			defenseCommitee.put("defense commitee members", "null");
			return defenseCommitee;
		}
		for(Commitee commiteeMember : commiteeArray) {
			//System.out.println("CommiteeMember: " + commiteeMember);
			commiteeNames += commiteeMember.getName() + ", ";
		}
		commiteeNames = commiteeNames.substring(0, commiteeNames.length() - 2);
		defenseCommitee.put("defense commitee members", commiteeNames);
		return defenseCommitee;
	}
	
	public JSONObject getDefenseSimilarTheme(Defense defense) {
		JSONObject defenseSimilarTheme = new JSONObject();
		defenseSimilarTheme.put("defense similar theme", defense.getThesisTheme());
		return defenseSimilarTheme;
	}
	
	public JSONObject getDefenseRoomNumber(Defense defense) {
		JSONObject defenseRoomNumber = new JSONObject();
		defenseRoomNumber.put("defense room number", defense.getRoomNumber());
		return defenseRoomNumber;
	}
	
	public JSONObject getDefenseCommentsAuthor(Defense defense) {
		JSONObject defenseComments = new JSONObject();
		Set<String> commentsSet = defense.getDroolsCommentsAuthorList();
		String comments = "";
		Timeslot thisTimeslot = defense.getTimeslot();
		if(thisTimeslot == null) {
			defenseComments.put("defense comments author", "null");
		}
		String time = "";
		for(String comment : commentsSet) {
			//System.out.println("CommiteeMember: " + commiteeMember);
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			//System.out.println(time);
			//System.out.println(comment);
			if(comment.contains(time)) {
				comments += comment + "; ";
			}
		}
		//comments = comments.substring(0, comments.length() - 2);
		defenseComments.put("defense comments author", comments);
		return defenseComments;
	}
	
	public JSONObject getDefenseCommentsSupervisor(Defense defense) {
		JSONObject defenseComments = new JSONObject();
		Set<String> commentsSet = defense.getDroolsCommentsSupervisorList();
		String comments = "";
		Timeslot thisTimeslot = defense.getTimeslot();
		if(thisTimeslot == null) {
			defenseComments.put("defense comments supervisor", "null");
		}
		String time = "";
		for(String comment : commentsSet) {
			//System.out.println("CommiteeMember: " + commiteeMember);
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			//System.out.println(time);
			//System.out.println(comment);
			if(comment.contains(time)) {
				comments += comment + "; ";
			}
		}
		//comments = comments.substring(0, comments.length() - 2);
		defenseComments.put("defense comments supervisor", comments);
		return defenseComments;
	}
	
	public JSONObject getDefenseCommentsCommission(Defense defense) {
		JSONObject defenseComments = new JSONObject();
		Set<String> commentsSet = defense.getDroolsCommentsCommissionList();
		String comments = "";
		Timeslot thisTimeslot = defense.getTimeslot();
		if(thisTimeslot == null) {
			defenseComments.put("defense comments commission", "null");
		}
		String time = "";
		for(String comment : commentsSet) {
			//System.out.println("CommiteeMember: " + commiteeMember);
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			//System.out.println(time);
			//System.out.println(comment);
			if(comment.contains(time)) {
				comments += comment + "; ";
			}
		}
		//comments = comments.substring(0, comments.length() - 2);
		defenseComments.put("defense comments commission", comments);
		return defenseComments;
	}
	
	public JSONObject getDefenseCommentsUnique(Defense defense) {
		JSONObject defenseComments = new JSONObject();
		Set<String> commentsSet = defense.getDroolsCommentsUniqueList();
		String comments = "";
		Timeslot thisTimeslot = defense.getTimeslot();
		if(thisTimeslot == null) {
			defenseComments.put("defense comments unique", "null");
		}
		String time = "";
		for(String comment : commentsSet) {
			//System.out.println("Comment: " + comment);
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			if(comment.contains(defense.getThesisTitle())) {
				for(int i = 0; i < defenses.size(); i++) {
					if(defenses.get(i).getThesisTitle() != defense.getThesisTitle() && comment.contains(defenses.get(i).getThesisTitle())){
						String newTime = defenses.get(i).getTimeslot().getStartTime() + "-" + defenses.get(i).getTimeslot().getEndTime() + " / " + defenses.get(i).getTimeslot().getDate();
						if(comment.contains(time) && time == newTime) {
							comments += comment + "; ";
						}
					}
				}
			}
		}
		//comments = comments.substring(0, comments.length() - 2);
		defenseComments.put("defense comments unique", comments);
		return defenseComments;
	}
	
	public void writeJSON(){
		JSONObject obj2 = new JSONObject();
		JSONObject obj = new JSONObject();
		JSONArray tableList = new JSONArray();
		JSONArray tableList2 = new JSONArray();
		Map<String, String> tableSlot = new HashMap(){{
			put("row", "1");
			put("column", "1");
			put("data", "Kitsendus");
		}};
		tableList.add(tableSlot);
		obj.put("name", "tableConfiguration");
		obj.put("tableSlot", tableList);
		tableList2.add(obj);
		obj2.put("table", tableList2);
		System.out.println(obj2);
		
		try(FileWriter file = new FileWriter("plannedData.json")){
			file.write(obj2.toJSONString());
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
