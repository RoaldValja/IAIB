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
	}
	
	List<LocalDate> dateList = new ArrayList<>();
	List<LocalTime> startTimeList = new ArrayList<>();
	List<LocalTime> endTimeList = new ArrayList<>();
	List<String> typeList = new ArrayList<>();
	List<String> titleList = new ArrayList<>();
	List<ThesisAuthor> authorList = new ArrayList<>();
	List<Set<ThesisSupervisor>> authorsSupervisorsList = new ArrayList<>();
	List<Commitee[]> commiteeList = new ArrayList<>();
	List<String> roomNumberList = new ArrayList<>();
	List<String> commentsAuthorList = new ArrayList<>();
	List<String> commentsSupervisorList = new ArrayList<>();
	List<String> commentsCommissionList = new ArrayList<>();
	
	JSONArray defenseDateList = new JSONArray();
	JSONArray defenseStartTimeList = new JSONArray();
	JSONArray defenseEndTimeList = new JSONArray();
	JSONArray defenseTypeList = new JSONArray();
	JSONArray defenseTitleList = new JSONArray();
	JSONArray defenseAuthorList = new JSONArray();
	JSONArray defenseAuthorsSupervisorsList = new JSONArray();
	JSONArray defenseCommiteeList = new JSONArray();
	JSONArray defenseRoomNumberList = new JSONArray();
	JSONArray defenseCommentsAuthorList = new JSONArray();
	JSONArray defenseCommentsSupervisorList = new JSONArray();
	JSONArray defenseCommentsCommissionList = new JSONArray();
	
	List<Defense> defenses;
	
	public void write(TimetableSolution solution) throws IOException {
		defenses = solution.getDefenseList();
		Collections.sort(defenses, (d1, d2) -> {
			if(d1.getTimeslot() == null || d2.getTimeslot() == null) {
				return -1;
			}
			LocalDateTime d2DateTime = LocalDateTime.of(d2.getTimeslot().getDate(), d2.getTimeslot().getStartTime());
			LocalDateTime d1DateTime = LocalDateTime.of(d1.getTimeslot().getDate(), d1.getTimeslot().getStartTime());
			return d1DateTime.compareTo(d2DateTime);
		});
		
		int amountOfDefenses = defenses.size();
		JSONObject table = new JSONObject();
		for(Defense defense : defenses) {
			defenseDateList.add(getDate(defense));
			defenseStartTimeList.add(getStartTime(defense));
			defenseEndTimeList.add(getEndTime(defense));
			defenseTypeList.add(getDefenseType(defense));
			defenseTitleList.add(getDefenseTitle(defense));
			defenseAuthorList.add(getDefenseAuthor(defense));
			defenseAuthorsSupervisorsList.add(getDefenseAuthorsSupervisors(defense));
			defenseCommiteeList.add(getDefenseCommitee(defense));
			defenseRoomNumberList.add(getDefenseRoomNumber(defense));
			defenseCommentsAuthorList.add(getDefenseCommentsAuthor(defense));
			defenseCommentsSupervisorList.add(getDefenseCommentsSupervisor(defense));
			defenseCommentsCommissionList.add(getDefenseCommentsCommission(defense));
		}
		table.put("dateList", defenseDateList);
		table.put("startTimeList", defenseStartTimeList);
		table.put("endTimeList", defenseEndTimeList);
		table.put("defenseTypeList", defenseTypeList);
		table.put("defenseTitleList", defenseTitleList);
		table.put("defenseAuthorList", defenseAuthorList);
		table.put("defenseAuthorsSupervisorsList", defenseAuthorsSupervisorsList);
		table.put("defenseCommiteeList", defenseCommiteeList);
		table.put("defenseRoomNumberList", defenseRoomNumberList);
		table.put("defenseCommentsAuthorList", defenseCommentsAuthorList);
		table.put("defenseCommentsSupervisorList", defenseCommentsSupervisorList);
		table.put("defenseCommentsCommissionList", defenseCommentsCommissionList);
		System.out.println("enne json kirjutamist");
		try(FileWriter file = new FileWriter("veebiliides/json/plannedData.json")){
			file.write(table.toJSONString());
		} catch (IOException e){
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/webapp/json/plannedData.json"), "UTF-8"));
	    try{
	    	out.write(table.toJSONString());
	    } finally {
	    	out.close();
	    }
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
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			if(comment.contains(time)) {
				comments += comment + "; ";
			}
		}
		if(comments.length() > 0) {
			comments = comments.substring(0, comments.length() - 2);
		}
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
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			if(comment.contains(time)) {
				comments += comment + "; ";
			}
		}
		if(comments.length() > 0) {
			comments = comments.substring(0, comments.length() - 4);
		}
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
			time = thisTimeslot.getStartTime() + "-" + thisTimeslot.getEndTime() + " / " + thisTimeslot.getDate();
			if(comment.contains(time)) {
				comments += comment + "; ";
			}
		}
		if(comments.length() > 0) {
			comments = comments.substring(0, comments.length() - 4);
		}
		defenseComments.put("defense comments commission", comments);
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
