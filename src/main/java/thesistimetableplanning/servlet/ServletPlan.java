package thesistimetableplanning.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.json.*;

import org.apache.commons.lang3.SystemUtils;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import thesistimetableplanning.app.TimetablePlanningApp;
import thesistimetableplanning.domain.TimetableSolution;
import thesistimetableplanning.json.Reader;
import thesistimetableplanning.json.Writer;

public class ServletPlan extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("JSON kirjutamisel");
		//System.out.println(request.getAttributeNames());
		//request.getParameter("cmd");
		
		
		
		//System.out.println(request.toString());
		StringBuffer sb = new StringBuffer();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	    } finally {
	        reader.close();
	    }
	    //System.out.println(sb.toString());
	    
	    String jsonString = sb.toString();
	    /*
	    JsonObject body = Json.createReader(new StringReader(jsonString)).readObject();
	    System.out.println(body);
	    
	    try(FileWriter fw = new FileWriter("src/main/webapp/planData.json"); 
	    		JsonWriter jsonWriter = Json.createWriter(fw)){
	    	jsonWriter.writeObject(body);
	    }
	    */
	    
	   // JSONObject json = new JSONObject(jsonString);
	    
	    jsonString = jsonString.replaceAll("\\\\", "");	
	    jsonString = jsonString.substring(1, jsonString.length()-1);
/*	    JSONParser parser = new JSONParser();
	    JSONObject json = new JSONObject();*/
	    
	//	json = (JSONObject) parser.parse(jsonString);
	    
	    
	    //System.out.println(jsonString);
	    
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/webapp/json/planData.json"), "UTF-8"));
	    try{
	    	out.write(jsonString);
	    } finally {
	    	out.close();
	    }
	    /*
		try(FileWriter file = new FileWriter("src/main/webapp/planData.json")){
			file.write(jsonString);
			file.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		*/
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(request.toString());       // Write response body.
	    
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try(FileWriter file = new FileWriter("src/main/webapp/ready.txt")){
			file.write("o");
			file.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		String text = "Planeerimisel";
		System.out.println("Planeerimisel");
		if(SystemUtils.IS_OS_WINDOWS || SystemUtils.IS_OS_WINDOWS_10 || SystemUtils.IS_OS_WINDOWS_8 || SystemUtils.IS_OS_WINDOWS_7 || SystemUtils.IS_OS_WINDOWS_XP) {
			System.out.println("On windowsi OS");
			ProcessBuilder processBuilder = new ProcessBuilder("start.bat");
			processBuilder.redirectErrorStream();
			processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
			processBuilder.start();
			
			
		}
		if(SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX) {
			System.out.println("On linux OS");
			Runtime.getRuntime().exec("sh start.sh");
		}
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(text);       // Write response body.
	}
	
	private void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }
	
	private void runProcess(String command) throws Exception {
		System.out.println("runprocess kestab: " + command);
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }
}
