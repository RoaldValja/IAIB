package thesistimetableplanning.json;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import thesistimetableplanning.domain.Commitee;
import thesistimetableplanning.domain.Defense;
import thesistimetableplanning.domain.DefenseType;
import thesistimetableplanning.domain.ThesisAuthor;
import thesistimetableplanning.domain.ThesisSupervisor;
import thesistimetableplanning.domain.Timeslot;
import thesistimetableplanning.domain.TimetableConstraintConfiguration;
import thesistimetableplanning.domain.TimetableSolution;
import thesistimetableplanning.json.Reader;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReaderTests {

	private Reader reader;
	private TimetableSolution solution;
	
	Map<String, DefenseType> totalDefenseTypeMap;
	Set<String> totalTimeslotTagSet;
	Map<String, ThesisSupervisor> totalThesisSupervisorMap;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		reader = new Reader();
		solution = new TimetableSolution();
		reader.setSolution(solution);
		reader.readJSON("PlanDataTest3.json");
		totalDefenseTypeMap = new HashMap();
		totalTimeslotTagSet = new HashSet();
		totalThesisSupervisorMap = new HashMap();
		reader.setTotalDefenseTypeMap(totalDefenseTypeMap);
		reader.setTotalThesisSupervisorMap(totalThesisSupervisorMap);
		reader.setTotalTimeslotTagSet(totalTimeslotTagSet);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		reader = null;
		assertNull(reader);
	}
	
	@Test
	public void testTitleCheckThrowIllegalStateException(){
		System.out.println("Running: testTitleCheckThrowIllegalStateException");
		exception.expect(IllegalStateException.class);
		exception.expectMessage("Lahter test1 on vale nimega. Lahtri nimi peab olema test2");
		reader.titleCheck("test1", "test2");
	}
	
	@Test
	public void testGetSolution() {
		System.out.println("Running: testGetSolution");
		TimetableSolution solution = mock(TimetableSolution.class);
		System.out.println(solution);
		reader.setSolution(solution);
		TimetableSolution test = reader.getSolution();
		assertEquals(solution, test);
	}

	@Test
	public void testSeperateCommasSetNoCommas() {
		System.out.println("Running: testSeperateCommasSetNoCommas");
		Set<String> test = reader.seperateCommasSet("test1");
		assertEquals(1, test.size());
	}
	
	/**
	 * countCommas meetodil eeldatakse, et peale koma on tühimärk.
	 * Kas oleks vaja kasutada meetodit, mis eemaldab tühimärgid ja paneb countCommas meetodi
	 * eeldama, et tal on ükskõik kui lisad tühikuid peale komasid või mitte?
	 */
	@Test
	public void testSeperateCommasSetWithCommas() {
		System.out.println("Running: testSeperateCommasSetWithCommas");
		Set<String> test = reader.seperateCommasSet("test1, test2");
		assertEquals(2, test.size());
	}
	
	@Test
	public void testSeperateCommasListNoCommas() {
		System.out.println("Running: testSeperateCommasListNoCommas");
		List<String> test = reader.seperateCommasList("test1");
		assertEquals(1, test.size());
	}
	
	@Test
	public void testSeperateCommasListWithCommas() {
		System.out.println("Running: testSeperateCommasListWithCommas");
		List<String> test = reader.seperateCommasList("test1, test2");
		assertEquals(2, test.size());
	}
	
	@Test
	public void testTimeCheckNull() {
		System.out.println("Running: testTimeCheckNull");
		String test = reader.timeCheck("asd");
		assertNull(test);
	}
	
	@Test
	public void testTimeCheckMissingFrontZero() {
		System.out.println("Running: testTimeCheckMissingFrontZero");
		String test = reader.timeCheck("8:30");
		assertEquals("08:30", test);
	}
	
	@Test
	public void testTimeCheckMissingBackZero() {
		System.out.println("Running: testTimeCheckMissingBackZero");
		String test = reader.timeCheck("08:5");
		assertEquals("08:05", test);
	}
	
	@Test
	public void testTimeCheckWrongHours() {
		System.out.println("Running: testTimeCheckWrongHours");
		String test = reader.timeCheck("24:30");
		assertEquals(null, test);
	}
	
	@Test
	public void testTimeCheckWrongMinutes() {
		System.out.println("Running: testTimeCheckWrongMinutes");
		String test = reader.timeCheck("20:60");
		assertEquals(null, test);
	}
	
	@Test
	public void testTimeCheckCorrect() {
		System.out.println("Running: testTimeCheckCorrect");
		String test = reader.timeCheck("08:30");
		assertEquals("08:30", test);
	}
	
	/**
	 * võibolla on vaja getRowLength meetodit täiendada kontrollides mis row hetkel on 
	 * ja kui on ainult 1 row, siis ta ei tagasta 0 vaid viimase elemendi columni numbri.
	 */
	@Test
	public void testGetRowLengthIsZero() {
		System.out.println("Running: testGetRowLengthIsZero");
		ArrayList<ArrayList<String>> doubleArrayList = new ArrayList<ArrayList<String>>();
		int test = reader.getRowLength(doubleArrayList);
		assertEquals(0, test);
	}
	
	@Test
	public void testGetRowLengthWithMultipleRows() {
		System.out.println("Running: testGetRowLengthWithMultipleRows");
		ArrayList<ArrayList<String>> doubleArrayList = new ArrayList<ArrayList<String>>();
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("name",
	            			  "1", 
	                          "1", 
	                          "test1")); 
		ArrayList<String> list2 = new ArrayList<String>( 
	            Arrays.asList("name",
	            			  "1", 
	                          "2", 
	                          "test2"));
		ArrayList<String> list3 = new ArrayList<String>( 
	            Arrays.asList("name",
	            			  "2", 
	                          "1", 
	                          "test3"));
		doubleArrayList.add(list1);
		doubleArrayList.add(list2);
		doubleArrayList.add(list3);
		int test = reader.getRowLength(doubleArrayList);
		assertEquals(2, test);
	}
	
	@Test
	public void testGetRowLengthWithSingleRow() {
		System.out.println("Running: testGetRowLengthWithSingleRow");
		ArrayList<ArrayList<String>> doubleArrayList = new ArrayList<ArrayList<String>>();
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("name",
	            			  "1", 
	                          "1", 
	                          "test1")); 
		ArrayList<String> list2 = new ArrayList<String>( 
	            Arrays.asList("name",
	            			  "1", 
	                          "2", 
	                          "test2"));
		doubleArrayList.add(list1);
		doubleArrayList.add(list2);
		int test = reader.getRowLength(doubleArrayList);
		assertEquals(2, test);
	}
	
	@Test
	public void testAddToTableListConfigurationTable() {
		System.out.println("Running: testAddToTableListConfigurationTable");
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("tableConfiguration",
	            			  "1", 
	                          "1", 
	                          "Kitsendus"));
		ArrayList<ArrayList<String>> test = reader.getConfigurationTable();
		assertEquals(list1, test.get(0));
	}
	
	@Test
	public void testAddToTableListTimeslotTable() {
		System.out.println("Running: testAddToTableListTimeslotTable");
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("tableTimeslot",
	            			  "1", 
	                          "1", 
	                          "Päev"));
		ArrayList<ArrayList<String>> test = reader.getTimeslotTable();
		assertEquals(list1, test.get(0));
	}
	
	@Test
	public void testAddToTableListAuthorTable() {
		System.out.println("Running: testAddToTableListAuthorTable");
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("tableAuthor",
	            			  "1", 
	                          "1", 
	                          ""));
		ArrayList<ArrayList<String>> test = reader.getAuthorTable();
		assertEquals(list1, test.get(0));
	}
	
	@Test
	public void testAddToTableListSupervisorTable() {
		System.out.println("Running: testAddToTableListSupervisorTable");
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("tableSupervisor",
	            			  "1", 
	                          "1", 
	                          "")); 
		ArrayList<ArrayList<String>> test = reader.getSupervisorTable();
		assertEquals(list1, test.get(0));
	}
	
	@Test
	public void testAddToTableListCommiteeTable() {
		System.out.println("Running: testAddToTableListCommiteeTable");
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("tableCommitee",
	            			  "1", 
	                          "1", 
	                          "")); 
		ArrayList<ArrayList<String>> test = reader.getCommiteeTable();
		assertEquals(list1, test.get(0));
	}
	
	@Test
	public void testAddToTableListDefenseTable() {
		System.out.println("Running: testAddToTableListDefenseTable");
		ArrayList<String> list1 = new ArrayList<String>( 
	            Arrays.asList("tableDefense",
	            			  "1", 
	                          "1", 
	                          "Kood"));
		ArrayList<ArrayList<String>> test = reader.getDefenseTable();
		assertEquals(list1, test.get(0));
	}
	
	/**
	 * here we only test if the method added any data to configurationTable list
	 */
	@Test
	public void testReadJSON() {
		System.out.println("Running: testReadJSON");
		try {
			reader.readJSON("PlanDataTest.json");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		ArrayList<ArrayList<String>> test = reader.getConfigurationTable();
		assertEquals("Kitsendus", test.get(0).get(3));
	}
	
	@Test
	public void testReadJSONFileNotFoundException() {
		System.out.println("Running: testReadJSONFileNotFoundException");
		try {
			reader.readJSON("PlanDataTest.jsona");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			assertEquals("PlanDataTest.jsona (The system cannot find the file specified)", e.getMessage());
		}
	}
	/*
	@Test
	public void testReadConfigurationCommissionThreeMembers() {
		System.out.println("Running: testReadConfigurationCommissionThreeMembers");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getCommissionAtLeastThreeMembers();
		assertEquals(HardSoftScore.ofHard(5), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationAuthorPrerequisitesDone() {
		System.out.println("Running: testReadConfigurationAuthorPrerequisitesDone");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getAuthorPrerequisitesDone();
		assertEquals(HardSoftScore.ofHard(12), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsUnavailableTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsUnavailableTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnAuthorsUnavailableTimeslot();
		assertEquals(HardSoftScore.ofHard(20), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnCommissionMembersUnavailableTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnCommissionMembersUnavailableTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnCommissionMembersUnavailableTimeslot();
		assertEquals(HardSoftScore.ofHard(7), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseHasOneChairman() {
		System.out.println("Running: testReadConfigurationDefenseHasOneChairman");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseHasOneChairman();
		assertEquals(HardSoftScore.ofHard(18), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseGroupedBySameThesisTheme() {
		System.out.println("Running: testReadConfigurationDefenseGroupedBySameThesisTheme");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseGroupedBySameThesisTheme();
		assertEquals(HardSoftScore.ofSoft(10), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseAuthorsGroupedByCommonSupervisor() {
		System.out.println("Running: testReadConfigurationDefenseAuthorsGroupedByCommonSupervisor");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseAuthorsGroupedByCommonSupervisor();
		assertEquals(HardSoftScore.ofSoft(78), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch() {
		System.out.println("Running: testReadConfigurationClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch();
		assertEquals(HardSoftScore.ofSoft(750), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsPreferredTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsPreferredTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseOnAuthorsPreferredTimeslot();
		assertEquals(HardSoftScore.ofSoft(14), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsNotPreferredTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsNotPreferredTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnAuthorsNotPreferredTimeslot();
		assertEquals(HardSoftScore.ofSoft(25), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnCommissionMembersPreferredTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnCommissionMembersPreferredTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseOnCommissionMembersPreferredTimeslot();
		assertEquals(HardSoftScore.ofSoft(15), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnCommissionMembersNotPreferredTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnCommissionMembersNotPreferredTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnCommissionMembersNotPreferredTimeslot();
		assertEquals(HardSoftScore.ofSoft(65), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsSupervisorsPreferredTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsSupervisorsPreferredTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseOnAuthorsSupervisorsPreferredTimeslot();
		assertEquals(HardSoftScore.ofSoft(64), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnAuhtorsSupervisorsNotPreferredTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsSupervisorsNotPreferredTimeslot");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnAuthorsSupervisorsNotPreferredTimeslot();
		assertEquals(HardSoftScore.ofSoft(69), score);
	}
	*/
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsSupervisorsUnavailableTimeslot() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsSupervisorsUnavailableTime");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnAuthorsSupervisorsUnavailableTimeslot();
		assertEquals(HardSoftScore.ofSoft(87), score);
	}
	*/
	@Test
	public void testReadConfigurationDefenseOnAuthorsPreferredTimeslotTag() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsPreferredTimeslotTag");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseOnAuthorsPreferredTimeslotTag();
		assertEquals(HardSoftScore.ofSoft(99), score);
	}
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsNotPreferredTimeslotTag() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsNotPreferredTimeslotTag");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnAuthorsNotPreferredTimeslotTag();
		assertEquals(HardSoftScore.ofSoft(21), score);
	}
	*/
	@Test
	public void testReadConfigurationDefenseOnCommissionMembersPreferredTimeslotTag() {
		System.out.println("Running: testReadConfigurationDefenseOnCommissionMembersPreferredTimeslotTag");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseOnCommissionMembersPreferredTimeslotTag();
		assertEquals(HardSoftScore.ofSoft(99), score);
	}
	/*
	@Test
	public void testReadConfigurationDefenseOnCommissionMembersNotPreferredTimeslotTag() {
		System.out.println("Running: testReadConfigurationDefenseOnCommissionMembersNotPreferredTimeslotTag");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnCommissionMembersNotPreferredTimeslotTag();
		assertEquals(HardSoftScore.ofSoft(99), score);
	}
	*/
	@Test
	public void testReadConfigurationDefenseOnAuthorsSupervisorsPreferredTimeslotTag() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsSupervisorsPreferredTimeslotTag");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseOnAuthorsSupervisorsPreferredTimeslotTag();
		assertEquals(HardSoftScore.ofSoft(59), score);
	}
	/*
	@Test
	public void testReadConfigurationDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag() {
		System.out.println("Running: testReadConfigurationDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag");
		reader.readConfiguration();
		TimetableConstraintConfiguration test = solution.getConstraintConfiguration();
		HardSoftScore score = test.getDefenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag();
		assertEquals(HardSoftScore.ofSoft(46), score);
	}
	*/
	/*
	@Test
	public void testReadTimeslotListDate() {
		System.out.println("Running: testReadTimeslotListDate");
		reader.readTimeslotList();
		Timeslot test = solution.getTimeslotList().get(0);
		LocalDate date = test.getDate();
		LocalDate expected = LocalDate.of(2019, 6, 3);
		assertEquals(expected, date);
	}
	*/
	/*
	@Test
	public void testReadTimeslotListStartTime() {
		System.out.println("Running: testReadTimeslotListStartTime");
		reader.readTimeslotList();
		Timeslot test = solution.getTimeslotList().get(0);
		LocalTime date = test.getStartTime();
		LocalTime expected = LocalTime.of(9, 0);
		assertEquals(expected, date);
	}
	*/
	/*
	@Test
	public void testReadTimeslotListEndTime() {
		System.out.println("Running: testReadTimeslotListEndTime");
		reader.readTimeslotList();
		Timeslot test = solution.getTimeslotList().get(0);
		LocalTime date = test.getEndTime();
		LocalTime expected = LocalTime.of(9, 20);
		assertEquals(expected, date);
	}
	*/
	/*
	@Test
	public void testReadTimeslotListId() {
		System.out.println("Running: testReadTimeslotListId");
		reader.readTimeslotList();
		Timeslot test = solution.getTimeslotList().get(0);
		long id = test.getId();
		long expected = 0;
		assertEquals(expected, id);
	}
	*/
	/*
	@Test
	public void testReadTimeslotListTagSet() {
		System.out.println("Running: testReadTimeslotListTagSet");
		reader.readTimeslotList();
		Timeslot test = solution.getTimeslotList().get(0);
		Set<String> tagSet = test.getTagSet();
		Set<String> expected = new LinkedHashSet<String>();
		expected.add("Esmaspäev");
		assertEquals(expected, tagSet);
	}
	*/
	/*
	@Test
	public void testReadTimeslotListDefenseType() {
		System.out.println("Running: testReadTimeslotListDefenseType");
		reader.readTimeslotList();
		boolean test = false;
		if(totalDefenseTypeMap.size() > 0) {
			test = true;
		}
		assertTrue(test);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListId() {
		System.out.println("Running: testReadSupervisorListId");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(0);
		long id = test.getId();
		long expected = 0;
		assertEquals(expected, id);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListName() {
		System.out.println("Running: testReadSupervisorListName");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(0);
		String name = test.getName();
		String expected = "Riina Maigre";
		assertEquals(expected, name);
	}
	 */
	/*
	@Test
	public void testReadSupervisorListRole() {
		System.out.println("Running: testReadSupervisorListRole");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(0);
		String role = test.getRole();
		String expected = "Peajuhendaja";
		assertEquals(expected, role);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListPreferredTimeslotSet() {
		System.out.println("Running: testReadSupervisorListPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(0);
		Set<Timeslot> timeslotSet = test.getPreferredTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(1);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertTrue(timeslotCheck);
	}
	*/
	
	/**
	 * Testandmetel pole hetkel kellelgi pandud not preferred timeslot
	 * seda vaja parandada, et testida koodi.
	 */
	/*
	@Test
	public void testReadSupervisorListNotPreferredTimeslotSet() {
		System.out.println("Running: testReadSupervisorListNotPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(0);
		Set<Timeslot> timeslotSet = test.getNotPreferredTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(1);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertFalse(timeslotCheck);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListUnavailableTimeslotSet() {
		System.out.println("Running: testReadSupervisorListUnavailableTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(1);
		Set<Timeslot> timeslotSet = test.getUnavailableTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(7);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertTrue(timeslotCheck);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListPreferredTimeslotTagSet() {
		System.out.println("Running: testReadSupervisorListPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(2);
		Set<String> timeslotTagSet = test.getPreferredTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListNotPreferredTimeslotTagSet() {
		System.out.println("Running: testReadSupervisorListNotPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(3);
		Set<String> timeslotTagSet = test.getNotPreferredTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Teisipäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadSupervisorListUnavailableTimeslotTagSet() {
		System.out.println("Running: testReadSupervisorListUnavailableTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		ThesisSupervisor test = solution.getThesisSupervisorList().get(4);
		Set<String> timeslotTagSet = test.getUnavailableTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadAuthorListId() {
		System.out.println("Running: testReadAuthorListId");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		long id = test.getId();
		long expected = 0;
		assertEquals(expected, id);
	}
	*/
	/*
	@Test
	public void testReadAuthorListName() {
		System.out.println("Running: testReadAuthorListName");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		String name = test.getName();
		String expected = "Roald Välja";
		assertEquals(expected, name);
	}
	*/
	/*
	@Test
	public void testReadAuthorListPrerequisites() {
		System.out.println("Running: testReadAuthorListPrerequisites");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		boolean prerequisites = test.getPreconditionsFulfilled();
		assertTrue(prerequisites);
	}
	*/
	/*
	@Test
	public void testReadAuthorListSupervisorSet() {
		System.out.println("Running: testReadAuthorListSupervisorSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		Set<ThesisSupervisor> supervisorSet = test.getThesisSupervisorSet();
		ThesisSupervisor expectedSupervisor = solution.getThesisSupervisorList().get(0);
		Set<ThesisSupervisor> expected = new LinkedHashSet<>();
		expected.add(expectedSupervisor);
		assertEquals(expected, supervisorSet);
	}
	*/
	/*
	@Test
	public void testReadAuthorListPreferredTimeslotSet() {
		System.out.println("Running: testReadAuthorListPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		Set<Timeslot> timeslotSet = test.getPreferredTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(11);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertTrue(timeslotCheck);
	}
	*/
	/**
	 * Testandmetel pole hetkel kellelgi pandud not preferred timeslot
	 * seda vaja parandada, et testida koodi.
	 */
	/*
	@Test
	public void testReadAuthorListNotPreferredTimeslotSet() {
		System.out.println("Running: testReadAuthorListNotPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		Set<Timeslot> timeslotSet = test.getNotPreferredTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(1);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertFalse(timeslotCheck);
	}
	*/
	/*
	@Test
	public void testReadAuthorListUnavailableTimeslotSet() {
		System.out.println("Running: testReadAuthorListUnavailableTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		Set<Timeslot> timeslotSet = test.getUnavailableTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(0);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertTrue(timeslotCheck);
	}
	*/
	/*
	@Test
	public void testReadAuthorListPreferredTimeslotTagSet() {
		System.out.println("Running: testReadAuthorListPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(3);
		Set<String> timeslotTagSet = test.getPreferredTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		tagSet.add("Teisipäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadAuthorListNotPreferredTimeslotTagSet() {
		System.out.println("Running: testReadAuthorListNotPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(0);
		Set<String> timeslotTagSet = test.getNotPreferredTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Teisipäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadAuthorListUnavailableTimeslotTagSet() {
		System.out.println("Running: testReadAuthorListUnavailableTimeslotSet");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		ThesisAuthor test = solution.getThesisAuthorList().get(2);
		Set<String> timeslotTagSet = test.getUnavailableTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListId() {
		System.out.println("Running: testReadCommiteeListId");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		long id = test.getId();
		long expected = 0;
		assertEquals(expected, id);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListName() {
		System.out.println("Running: testReadCommiteeListName");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		String name = test.getName();
		String expected = "Gert Kanter";
		assertEquals(expected, name);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListDegree() {
		System.out.println("Running: testReadCommiteeListDegree");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		String degree = test.getDegree();
		String expected = "Doktor";
		assertEquals(expected, degree);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListChairman() {
		System.out.println("Running: testReadCommiteeListChairman");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		boolean chairman = test.getChairman();
		assertTrue(chairman);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListChairmanType() {
		System.out.println("Running: testReadCommiteeListChairmanType");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		String type = test.getChairmanType();
		String expected = "Esimees";
		assertEquals(expected, type);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListPreferredTimeslotSet() {
		System.out.println("Running: testReadCommiteeListPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(1);
		Set<Timeslot> timeslotSet = test.getPreferredTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(5);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertTrue(timeslotCheck);
	}
	*/
	/**
	 * Testandmetel pole hetkel kellelgi pandud not preferred timeslot
	 * seda vaja parandada, et testida koodi.
	 */
	/*
	@Test
	public void testReadCommiteeListNotPreferredTimeslotSet() {
		System.out.println("Running: testReadCommiteeListNotPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(1);
		Set<Timeslot> timeslotSet = test.getNotPreferredTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(1);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertFalse(timeslotCheck);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListUnavailableTimeslotSet() {
		System.out.println("Running: testReadCommiteeListUnavailableTimeslotSet");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		Set<Timeslot> timeslotSet = test.getUnavailableTimeslotSet();
		Timeslot expected = solution.getTimeslotList().get(0);
		Iterator<Timeslot> iterator = timeslotSet.iterator();
		Timeslot timeslot = null;
		boolean timeslotCheck = false;
		while(iterator.hasNext()) {
			timeslot = iterator.next();
			if(timeslot.equals(expected)) {
				timeslotCheck = true;
			}
		}
		assertTrue(timeslotCheck);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListPreferredTimeslotTagSet() {
		System.out.println("Running: testReadCommiteeListPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		Set<String> timeslotTagSet = test.getPreferredTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListNotPreferredTimeslotTagSet() {
		System.out.println("Running: testReadCommiteeListNotPreferredTimeslotSet");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(0);
		Set<String> timeslotTagSet = test.getNotPreferredTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Teisipäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertTrue(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadCommiteeListUnavailableTimeslotTagSet() {
		System.out.println("Running: testReadCommiteeListUnavailableTimeslotSet");
		reader.readTimeslotList();
		reader.readCommiteeList();
		Commitee test = solution.getCommiteeList().get(1);
		Set<String> timeslotTagSet = test.getUnavailableTimeslotTagSet();
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		boolean timeslotTagCheck = false;
		if(timeslotTagSet.equals(tagSet)) {
			timeslotTagCheck = true;
		}
		assertFalse(timeslotTagCheck);
	}
	*/
	/*
	@Test
	public void testReadDefenseListId() {
		System.out.println("Running: testReadDefenseListId");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		long id = test.getId();
		long expected = 0;
		assertEquals(expected, id);
	}
	*/
	/*
	@Test
	public void testReadDefenseListCode() {
		System.out.println("Running: testReadDefenseListId");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		String code = test.getCode();
		String expected = "D01";
		assertEquals(expected, code);
	}
	*/
	/*
	@Test
	public void testReadDefenseListThesisTitle() {
		System.out.println("Running: testReadDefenseListThesisTitle");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		String title = test.getThesisTitle();
		String expected = "Lõputööde kaitsmiste ajakava koostamine kasutades OptaPlannerit";
		assertEquals(expected, title);
	}
	*/
	/*
	@Test
	public void testReadDefenseListDegree() {
		System.out.println("Running: testReadDefenseListDegree");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		String degree = test.getDegree();
		String expected = "Bakalaureus";
		assertEquals(expected, degree);
	}
	*/
	/*
	@Test
	public void testReadDefenseListThesisTheme() {
		System.out.println("Running: testReadDefenseListThesisTheme");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		String theme = test.getThesisTheme();
		String expected = "";
		assertEquals(expected, theme);
	}
	*/
	/*
	@Test
	public void testReadDefenseListRoomNumber() {
		System.out.println("Running: testReadDefenseListRoomNumber");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		String roomNumber = test.getRoomNumber();
		String expected = "ICT-410";
		assertEquals(expected, roomNumber);
	}
	*/
	/*
	@Test
	public void testReadDefenseListRoomCapacity() {
		System.out.println("Running: testReadDefenseListRoomCapacity");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		int capacity = test.getRoomCapacity();
		int expected = 20;
		assertEquals(expected, capacity);
	}
	*/
	/*
	@Test
	public void testReadDefenseListCommissionSize() {
		System.out.println("Running: testReadDefenseListCommissionSize");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		int size = test.getCommissionSize();
		int expected = 3;
		assertEquals(expected, size);
	}
	*/
	/**
	 * vaja selle üle mõelda
	 */
	/*
	@Test
	public void testReadDefenseListCommiteeList() {
		System.out.println("Running: testReadDefenseListCommiteeList");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readCommiteeList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		List<Commitee> list = test.getCommiteeList();
		List<Commitee> expected = solution.getCommiteeList();
		assertEquals(expected, list);
	}
	*/
	/*
	@Test
	public void testReadDefenseListAuthor() {
		System.out.println("Running: testReadDefenseListAuthor");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		ThesisAuthor author = test.getThesisAuthor();
		ThesisAuthor expected = solution.getThesisAuthorList().get(0);
		assertEquals(expected, author);
	}
	*/
	/*
	@Test
	public void testReadDefenseListDefenseType() {
		System.out.println("Running: testReadDefenseListCommiteeList");
		reader.readTimeslotList();
		reader.readSupervisorList();
		reader.readAuthorList();
		reader.readDefenseList();
		Defense test = solution.getDefenseList().get(0);
		DefenseType type = test.getDefenseType();
		String defenseTypeName = "Lahtine";
		boolean expected = false;
		if(type.getType().equals(defenseTypeName)) {
			expected = true;
		}
		assertTrue(expected);
	}
	*/
}
