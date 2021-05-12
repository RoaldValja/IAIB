package thesistimetableplanning.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import thesistimetableplanning.domain.TimetableSolution;
import thesistimetableplanning.json.Reader;
import thesistimetableplanning.json.Writer;

public class TimetablePlanningApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		TimetablePlanningApp.runApp();
	}
	
	public static void runApp() throws FileNotFoundException, IOException, ParseException {
		SolverFactory<TimetableSolution> solverFactory = SolverFactory.createFromXmlResource("thesistimetableplanning/solver/DefenseTimetableSolverConfig.xml");
		Solver<TimetableSolution> solver = solverFactory.buildSolver();
		
		Reader reader = new Reader();
		TimetableSolution unsolvedTimetable = reader.read("planData.json");
		
		TimetableSolution solvedTimetable = solver.solve(unsolvedTimetable);
/*		
		System.out.println(solvedTimetable.getScore());
		System.out.println(solvedTimetable.getDefenseList().get(0).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(0).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(0).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(0).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(0).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(0).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(1).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(1).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(1).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(1).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(1).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(1).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(2).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(2).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(2).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(2).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(2).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(2).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(3).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(3).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(3).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(3).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(3).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(3).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(4).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(4).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(4).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(4).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(4).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(4).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(5).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(5).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(5).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(5).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(5).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(5).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(6).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(6).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(6).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(6).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(6).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(6).getDefenseType().getType());
		System.out.println(solvedTimetable.getDefenseList().get(7).getCode());
		System.out.println(solvedTimetable.getDefenseList().get(7).getTimeslot());
		System.out.println(solvedTimetable.getDefenseList().get(7).getTimeslot().getDate());
		System.out.println(solvedTimetable.getDefenseList().get(7).getTimeslot().getStartTime() + " - " + solvedTimetable.getDefenseList().get(0).getTimeslot().getEndTime());
		System.out.println(solvedTimetable.getDefenseList().get(7).getThesisAuthor().getName());
		System.out.println(solvedTimetable.getDefenseList().get(7).getDefenseType().getType());
*/
		Writer writer = new Writer();
		writer.write(solvedTimetable);
		//System.out.println("\n solver solving \n"
		//		+ toDisplayString(solvedTimetable));
		
	}
}
