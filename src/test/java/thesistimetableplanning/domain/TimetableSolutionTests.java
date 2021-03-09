package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class TimetableSolutionTests {

	private TimetableSolution timetableSolution;
	private ThesisAuthor thesisAuthor;
	private ThesisSupervisor thesisSupervisor;
	private Commitee commitee;
	private Defense defense;
	private DefenseType defenseType;
	private TimetableConstraintConfiguration timetableConstraintConfiguration;
	private Timeslot timeslot;
	private List<ThesisAuthor> thesisAuthorList;
	private List<ThesisSupervisor> thesisSupervisorList;
	private List<Commitee> commiteeList;
	private List<Defense> defenseList;
	private List<DefenseType> defenseTypeList;
	private List<Timeslot> timeslotList;
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		timetableSolution = new TimetableSolution();
		thesisAuthor = new ThesisAuthor();
		thesisSupervisor = new ThesisSupervisor();
		commitee = new Commitee();
		defense = new Defense();
		defenseType = new DefenseType();
		timetableConstraintConfiguration = new TimetableConstraintConfiguration();
		timeslot = new Timeslot();
		
		thesisAuthorList = new ArrayList<>();
		thesisSupervisorList = new ArrayList<>();
		commiteeList = new ArrayList<>();
		defenseList = new ArrayList<>();
		defenseTypeList = new ArrayList<>();
		timeslotList = new ArrayList<>();
		
		thesisAuthorList.add(thesisAuthor);
		thesisSupervisorList.add(thesisSupervisor);
		commiteeList.add(commitee);
		defenseList.add(defense);
		defenseTypeList.add(defenseType);
		timeslotList.add(timeslot);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		timetableSolution = null;
		assertNull(timetableSolution);
	}

	@Test
	public void testGetThesisAuthorList() {
		System.out.println("Running: testGetThesisAuthorList");
		timetableSolution.setThesisAuthorList(thesisAuthorList);
		List<ThesisAuthor> solutionThesisAuthorList = timetableSolution.getThesisAuthorList();
		assertEquals(solutionThesisAuthorList, thesisAuthorList);
	}
	
	@Test
	public void testGetThesisSupervisorList() {
		System.out.println("Running: testGetThesisSupervisorList");
		timetableSolution.setThesisSupervisorList(thesisSupervisorList);
		List<ThesisSupervisor> solutionThesisSupervisorList = timetableSolution.getThesisSupervisorList();
		assertEquals(solutionThesisSupervisorList, thesisSupervisorList);
	}
	
	@Test
	public void testGetCommiteeList() {
		System.out.println("Running: testGetCommiteeList");
		timetableSolution.setCommiteeList(commiteeList);
		List<Commitee> solutionCommiteeList = timetableSolution.getCommiteeList();
		assertEquals(solutionCommiteeList, commiteeList);
	}
	
	@Test
	public void testGetDefenseList() {
		System.out.println("Running: testGetDefenseList");
		timetableSolution.setDefenseList(defenseList);
		List<Defense> solutionDefenseList = timetableSolution.getDefenseList();
		assertEquals(solutionDefenseList, defenseList);
	}
	
	@Test
	public void testGetDefenseTypeList() {
		System.out.println("Running: testGetDefenseTypeList");
		timetableSolution.setDefenseTypeList(defenseTypeList);
		List<DefenseType> solutionDefenseTypeList = timetableSolution.getDefenseTypeList();
		assertEquals(solutionDefenseTypeList, defenseTypeList);
	}
	
	@Test
	public void testGetTimeslotList() {
		System.out.println("Running: testGetTimeslotList");
		timetableSolution.setTimeslotList(timeslotList);
		List<Timeslot> solutionTimeslotList = timetableSolution.getTimeslotList();
		assertEquals(solutionTimeslotList, timeslotList);
	}
	
	@Test
	public void testGetTimetableConstraintConfiguration() {
		System.out.println("Running: testGetTimetableConstraintConfiguration");
		timetableSolution.setConstraintConfiguration(timetableConstraintConfiguration);
		TimetableConstraintConfiguration solutionTimetableConstraintConfiguration = timetableSolution.getConstraintConfiguration();
		assertEquals(solutionTimetableConstraintConfiguration, timetableConstraintConfiguration);
	}
	
	@Test
	public void testGetScore(){
		System.out.println("Running: testGetScore");
		timetableSolution.setScore(HardSoftScore.of(40, 120));
		HardSoftScore solutionScore = timetableSolution.getScore();
		assertEquals(solutionScore, HardSoftScore.of(40, 120));
	}

}
