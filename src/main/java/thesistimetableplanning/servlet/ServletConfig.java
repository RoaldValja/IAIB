package thesistimetableplanning.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfig extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Konfiguratsiooni kirjutamisel");
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
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/webapp/json/planConfig.json"), "UTF-8"));
	    try{
	    	out.write(jsonString);
	    } finally {
	    	out.close();
	    }
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(request.toString());       // Write response body.
	    
	}

}
