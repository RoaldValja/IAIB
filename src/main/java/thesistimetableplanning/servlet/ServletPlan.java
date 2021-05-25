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
	    
	    String jsonString = sb.toString();
	    jsonString = jsonString.replaceAll("\\\\", "");	
	    jsonString = jsonString.substring(1, jsonString.length()-1);
	    
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/webapp/json/planData.json"), "UTF-8"));
	    try{
	    	out.write(jsonString);
	    } finally {
	    	out.close();
	    }
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(request.toString());    
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
		} else if(SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX) {
			System.out.println("On linux OS");
			Runtime.getRuntime().exec("sh start.sh");
		}
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(text);
	}
	
	private void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }
}
