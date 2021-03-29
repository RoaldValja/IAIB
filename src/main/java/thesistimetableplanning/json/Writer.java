package thesistimetableplanning.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
		for(Defense defense : defenses) {
			getDate(defense);
			getStartTime(defense);
			getEndTime(defense);
			getDefenseType(defense);
			getDefenseDegree(defense);
			getDefenseTitle(defense);
			getDefenseAuthor(defense);
			getDefenseAuthorsSupervisors(defense);
			getDefenseCommitee(defense);
			getDefenseSimilarTheme(defense);
			getDefenseRoomNumber(defense);
		}
	}
	
	public JSONObject getDate(Defense defense) {
		JSONObject date = new JSONObject();
		date.put("date", defense.getTimeslot().getDate());
		return date;
	}
	
	public JSONObject getStartTime(Defense defense) {
		JSONObject startTime = new JSONObject();
		startTime.put("start time", defense.getTimeslot().getStartTime());
		return startTime;
	}
	
	public JSONObject getEndTime(Defense defense) {
		JSONObject endTime = new JSONObject();
		endTime.put("end time", defense.getTimeslot().getEndTime());
		return endTime;
	}
	
	public JSONObject getDefenseType(Defense defense) {
		JSONObject defenseType = new JSONObject();
		defenseType.put("defense type", defense.getTimeslot().getDefenseType().getType());
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
		String supervisorNames = "";
		for(ThesisSupervisor supervisor : supervisors) {
			supervisorNames += supervisor.getName() + ", ";
		}
		supervisorNames = supervisorNames.substring(0, -2);
		defenseAuthorsSupervisors.put("defense authors supervisors", supervisorNames);
		return defenseAuthorsSupervisors;
	}
	
	public JSONObject getDefenseCommitee(Defense defense) {
		return null;
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
