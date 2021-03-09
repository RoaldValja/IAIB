package thesistimetableplanning.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Writer {

	public static void main(String[] args) {
		System.out.println("hello");
	/*
		Writer writer = new Writer();
		writer.writeJSON();
	*/
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
