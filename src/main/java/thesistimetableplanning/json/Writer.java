package thesistimetableplanning.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import thesistimetableplanning.domain.Commitee;
import thesistimetableplanning.domain.Defense;
import thesistimetableplanning.domain.ThesisSupervisor;
import thesistimetableplanning.domain.TimetableSolution;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
	}
	
	public void write(TimetableSolution solution) {
		List<Defense> defenses = solution.getDefenseList();
		int amountOfDefenses = defenses.size();
		JSONObject table = new JSONObject();
		JSONArray dateList = new JSONArray();
		JSONArray startTimeList = new JSONArray();
		JSONArray endTimeList = new JSONArray();
		JSONArray defenseTypeList = new JSONArray();
		JSONArray defenseDegreeList = new JSONArray();
		JSONArray defenseTitleList = new JSONArray();
		JSONArray defenseAuthorList = new JSONArray();
		JSONArray defenseAuthorsSupervisorsList = new JSONArray();
		JSONArray defenseCommiteeList = new JSONArray();
		JSONArray defenseSimilarThemeList = new JSONArray();
		JSONArray defenseRoomNumberList = new JSONArray();
		for(Defense defense : defenses) {
			dateList.add(getDate(defense));
			startTimeList.add(getStartTime(defense));
			endTimeList.add(getEndTime(defense));
			defenseTypeList.add(getDefenseType(defense));
			defenseDegreeList.add(getDefenseDegree(defense));
			defenseTitleList.add(getDefenseTitle(defense));
			defenseAuthorList.add(getDefenseAuthor(defense));
			defenseAuthorsSupervisorsList.add(getDefenseAuthorsSupervisors(defense));
			defenseCommiteeList.add(getDefenseCommitee(defense));
			defenseSimilarThemeList.add(getDefenseSimilarTheme(defense));
			defenseRoomNumberList.add(getDefenseRoomNumber(defense));
		}
		table.put("dateList", dateList);
		table.put("startTimeList", startTimeList);
		table.put("endTimeList", endTimeList);
		table.put("defenseTypeList", defenseTypeList);
		table.put("defenseDegreeList", defenseDegreeList);
		table.put("defenseTitleList", defenseTitleList);
		table.put("defenseAuthorList", defenseAuthorList);
		table.put("defenseAuthorsSupervisorsList", defenseAuthorsSupervisorsList);
		table.put("defenseCommiteeList", defenseCommiteeList);
		table.put("defenseSimilarThemeList", defenseSimilarThemeList);
		table.put("defenseRoomNumberList", defenseRoomNumberList);
		try(FileWriter file = new FileWriter("plannedData.json")){
			file.write(table.toJSONString());
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public JSONObject getDate(Defense defense) {
		JSONObject date = new JSONObject();
		date.put("date", defense.getTimeslot().getDate().toString());
		return date;
	}
	
	public JSONObject getStartTime(Defense defense) {
		JSONObject startTime = new JSONObject();
		startTime.put("start time", defense.getTimeslot().getStartTime().toString());
		return startTime;
	}
	
	public JSONObject getEndTime(Defense defense) {
		JSONObject endTime = new JSONObject();
		endTime.put("end time", defense.getTimeslot().getEndTime().toString());
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
		for(Commitee commiteeMember : commiteeArray) {
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
