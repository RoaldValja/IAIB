package thesistimetableplanning.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import thesistimetableplanning.app.TimetablePlanningApp;
import thesistimetableplanning.domain.TimetableSolution;
import thesistimetableplanning.json.Reader;
import thesistimetableplanning.json.Writer;

public class ServletHello extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	/*	PrintWriter out = response.getWriter();
		out.println("<h1>Hello World</h1>");*/
/*		
		request.setAttribute("servletAttribute", 100);
		
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
		*/
		
		try(FileWriter file = new FileWriter("src/main/webapp/ready.txt")){
			file.write("o");
			file.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		String text = "Planeerimisel";
	/*
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
/*
		TimetablePlanningApp app = new TimetablePlanningApp();
		try {
			app.runApp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*
		String separator = File.separator;
		try {
			//runProcess("javac -cp src src/main/java/thesistimetableplanning/app/TimetablePlanningApp.java");
			//runProcess("javac -cp src src"+separator+"main"+separator+"java"+separator+"thesistimetableplanning"+separator+"app"+separator+"TimetablePlanningApp.java");
			runProcess("java -cp src src"+separator+"main"+separator+"java"+separator+"thesistimetableplanning"+separator+"app"+separator+"TimetablePlanningApp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		System.out.println("java koodis");
		System.out.println("praegune kaust: " + System.getProperty("user.dir"));
		/*
		String command = "cmd /c gradlew run";
		try {
			Runtime.getRuntime().exec(command);
		} catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
		ProcessBuilder processBuilder = new ProcessBuilder("start.bat");
		processBuilder.start();
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
