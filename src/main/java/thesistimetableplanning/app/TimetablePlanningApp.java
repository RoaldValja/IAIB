package thesistimetableplanning.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.termination.TerminationConfig;

import thesistimetableplanning.domain.TimetableSolution;
import thesistimetableplanning.json.Reader;
import thesistimetableplanning.json.Writer;

public class TimetablePlanningApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		TimetablePlanningApp.runApp();
	}
	
	public static void runApp() throws FileNotFoundException, IOException, ParseException {
		
		Reader reader = new Reader();
		String configText = reader.readJSONConfig("src/main/webapp/json/planConfig.json");
		String configTime = configText.substring(0, configText.indexOf("-"));
		String configAlgorithm = configText.substring(configTime.indexOf("-")+1);

		//SolverFactory<TimetableSolution> solverFactory = SolverFactory.createFromXmlResource("thesistimetableplanning/solver/DefenseTimetableSolverConfig.xml");
		//Solver<TimetableSolution> solver = solverFactory.buildSolver();
		SolverConfig solverConfig = SolverConfig.createFromXmlResource("thesistimetableplanning/solver/DefenseTimetableSolverConfig.xml");
		solverConfig.withTerminationConfig(new TerminationConfig()
				.withSecondsSpentLimit(Long.parseLong(configTime)));
		SolverFactory<TimetableSolution> solverFactory = SolverFactory.create(solverConfig);
		Solver<TimetableSolution> solver = solverFactory.buildSolver();
		
		TimetableSolution unsolvedTimetable = reader.read("src/main/webapp/json/planData.json");
		
		TimetableSolution solvedTimetable = solver.solve(unsolvedTimetable);
		
		Writer writer = new Writer();
		writer.write(solvedTimetable);
	}
}
