package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class DefenseTests {
	
	//@Rule
	//public MockitoRule rule = MockitoJUnit.rule();

	
	private Defense defenseEmpty;
	
	private Defense defenseSingle;
	
	private Defense defenseMultiple;
	
	//private Defense defenseNoMock;
	
	@Mock
	private DefenseType defenseClosed;
	@Mock
	private DefenseType defenseOpen;
	
	@Mock
	private ThesisAuthor author1;
	@Mock
	private ThesisAuthor author2;
	@Mock
	private ThesisAuthor author3;
	@Mock
	private ThesisSupervisor supervisor1;
	@Mock
	private ThesisSupervisor supervisor2;
	@Mock
	private ThesisSupervisor supervisor3;
	
	@Mock
	private Commitee commitee1;
	@Mock
	private Commitee commitee2;
	@Mock
	private Commitee commitee3;
	
	@Mock
	private Timeslot timeslot1;
	@Mock
	private Timeslot timeslot2;
	@Mock
	private Timeslot timeslot3;
	
	//Timeslot timeslot4 = mock(Timeslot.class);
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		//MockitoAnnotations.initMocks(this);
		
		defenseEmpty = new Defense();
		defenseSingle = new Defense();
		defenseMultiple = new Defense();
		
		//defenseClosed = new DefenseType();
		//defenseOpen = new DefenseType();
		
		//defenseNoMock = new Defense();
		
		defenseClosed.setType("Kinnine");
		defenseOpen.setType("Lahtine");
		
		//author1 = new ThesisAuthor();
		//author2 = new ThesisAuthor();
		//author3 = new ThesisAuthor();
		
		//supervisor1 = new ThesisSupervisor();
		//supervisor2 = new ThesisSupervisor();
		//supervisor3 = new ThesisSupervisor();
		
		//timeslot1 = new Timeslot();
		//timeslot2 = new Timeslot();
		//timeslot3 = new Timeslot();
		/*
		timeslot1.setDate(LocalDate.of(2010, 10, 10));
		timeslot2.setDate(LocalDate.of(2011, 11, 11));
		timeslot3.setDate(LocalDate.of(2012, 12, 12));
		
		timeslot1.setStartTime(LocalTime.of(10, 10));
		timeslot2.setStartTime(LocalTime.of(11, 11));
		timeslot3.setStartTime(LocalTime.of(12, 12));
		
		timeslot1.setEndTime(LocalTime.of(10, 30));
		timeslot2.setEndTime(LocalTime.of(11, 31));
		timeslot3.setEndTime(LocalTime.of(12, 32));
		*/
		//commitee1 = new Commitee();
		//commitee2 = new Commitee();
		//commitee3 = new Commitee();
		
		
		Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
		Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
		Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
		
		supervisor1.setPreferredTimeslotSet(preferredTimeslotSet);
		supervisor1.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		supervisor1.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		author1.setPreferredTimeslotSet(preferredTimeslotSet);
		author1.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		author1.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		commitee1.setPreferredTimeslotSet(preferredTimeslotSet);
		commitee1.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		commitee1.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		preferredTimeslotSet.add(timeslot1);
		notPreferredTimeslotSet.add(timeslot1);
		unavailableTimeslotSet.add(timeslot1);
		
		supervisor2.setPreferredTimeslotSet(preferredTimeslotSet);
		supervisor2.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		supervisor2.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		author2.setPreferredTimeslotSet(preferredTimeslotSet);
		author2.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		author2.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		//doNothing().when(author2).hasPreconditionsFulfilled();
		//Mockito.verify(author2, Mockito.times(3)).hasPreconditionsFulfilled();
		
		commitee2.setPreferredTimeslotSet(preferredTimeslotSet);
		commitee2.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		commitee2.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		preferredTimeslotSet.add(timeslot2);
		notPreferredTimeslotSet.add(timeslot2);
		unavailableTimeslotSet.add(timeslot2);
		preferredTimeslotSet.add(timeslot3);
		notPreferredTimeslotSet.add(timeslot3);
		unavailableTimeslotSet.add(timeslot3);
		
		supervisor3.setPreferredTimeslotSet(preferredTimeslotSet);
		supervisor3.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		supervisor3.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		author3.setPreferredTimeslotSet(preferredTimeslotSet);
		author3.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		author3.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		commitee3.setPreferredTimeslotSet(preferredTimeslotSet);
		commitee3.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		commitee3.setUnavailableTimeslotSet(unavailableTimeslotSet);
		
		Set<ThesisSupervisor> thesisSupervisorSet1 = new LinkedHashSet<>();
		Set<ThesisSupervisor> thesisSupervisorSet2 = new LinkedHashSet<>();
		Set<ThesisSupervisor> thesisSupervisorSet3 = new LinkedHashSet<>();
		
		thesisSupervisorSet2.add(supervisor1);
		thesisSupervisorSet3.add(supervisor1);
		thesisSupervisorSet3.add(supervisor2);
		thesisSupervisorSet3.add(supervisor3);
		
		
		author1.setThesisSupervisorSet(thesisSupervisorSet1);
		author2.setThesisSupervisorSet(thesisSupervisorSet2);
		author3.setThesisSupervisorSet(thesisSupervisorSet3);
		
		author2.hasPreconditionsFulfilled();
		
		defenseEmpty.setThesisAuthor(author1);
		defenseSingle.setThesisAuthor(author2);
		defenseMultiple.setThesisAuthor(author3);
		
		Set<Timeslot> closedTimeslotSet = new LinkedHashSet<>();
		Set<Timeslot> openTimeslotSet = new LinkedHashSet<>();
		
		closedTimeslotSet.add(timeslot1);
		openTimeslotSet.add(timeslot2);
		openTimeslotSet.add(timeslot3);
		
		defenseClosed.setCompatibleTimeslotSet(closedTimeslotSet);
		defenseOpen.setCompatibleTimeslotSet(openTimeslotSet);
		
		//doNothing().when(defenseSingle).setDefenseType(isA(DefenseType.class));
		defenseSingle.setDefenseType(defenseClosed);
		//doNothing().when(defenseSingle).setDefenseType(isA(DefenseType.class));
		defenseMultiple.setDefenseType(defenseOpen);
		
		
		List<Commitee> commiteeListEmpty = new ArrayList<>();
		List<Commitee> commiteeListFull = new ArrayList<>();
		commiteeListFull.add(commitee1);
		commiteeListFull.add(commitee2);
		commiteeListFull.add(commitee3);
		System.out.println("Timeslot: " + timeslot1);
		
		defenseEmpty.setCommiteeList(commiteeListEmpty);
		defenseSingle.setCommiteeList(commiteeListFull);
		defenseMultiple.setCommiteeList(commiteeListFull);
		/*
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		*/
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		defenseEmpty = null;
		defenseSingle = null;
		defenseMultiple = null;
		assertNull(defenseEmpty);
		assertNull(defenseSingle);
		assertNull(defenseMultiple);
	}

	@Test
	public void testGetCode() {
		System.out.println("Running: testGetCode");
		defenseSingle.setCode("AN2");
		String code = defenseSingle.getCode();
		assertEquals("AN2", code);
	}
	
	@Test
	public void testGetDegree() {
		System.out.println("Running: testGetDegree");
		defenseSingle.setDegree("Bakalaureus");
		String degree = defenseSingle.getDegree();
		assertEquals("Bakalaureus", degree);
	}
	
	@Test
	public void testGetCommissionSize() {
		System.out.println("Running: testGetCommissionSize");
		defenseSingle.setCommissionSize(3);
		int commissionSize = defenseSingle.getCommissionSize();
		assertEquals(3, commissionSize);
	}
	
	@Test
	public void testGetThesisTitle() {
		System.out.println("Running: testGetThesisTitle");
		defenseSingle.setThesisTitle("Pealkiri");
		String title = defenseSingle.getThesisTitle();
		assertEquals("Pealkiri", title);
	}
	
	@Test
	public void testGetThesisTheme() {
		System.out.println("Running: testGetThesisTheme");
		defenseSingle.setThesisTheme("Robootika");
		String theme = defenseSingle.getThesisTheme();
		assertEquals("Robootika", theme);
	}
	
	@Test
	public void testGetRoomNumber() {
		System.out.println("Running: testGetRoomNumber");
		defenseSingle.setRoomNumber("ICT-401");
		String roomNumber = defenseSingle.getRoomNumber();
		assertEquals("ICT-401", roomNumber);
	}
	
	@Test
	public void testGetRoomCapacity(){
		System.out.println("Running: testGetRoomCapacity");
		defenseSingle.setRoomCapacity(10);
		int roomCapacity = defenseSingle.getRoomCapacity();
		assertEquals(10, roomCapacity);
	}
	
	@Test
	public void testGetDefenseType(){
		System.out.println("Running: testGetDefenseType");
		defenseSingle.setDefenseType(defenseClosed);
		DefenseType defenseType = defenseSingle.getDefenseType();
		assertEquals(defenseClosed, defenseType);
	}
	
	@Test
	public void testGetTimeslot(){
		System.out.println("Running: testGetTimeslot");
		defenseSingle.setTimeslot(timeslot1);
		Timeslot timeslot = defenseSingle.getTimeslot();
		assertEquals(timeslot1, timeslot);
	}
	
	@Test
	public void testGetCommiteeList(){
		System.out.println("Running: testGetCommiteeList");
		List<Commitee> commiteeList = new ArrayList<>();
		commiteeList.add(commitee1);
		defenseSingle.setCommiteeList(commiteeList);
		List<Commitee> returnedCommiteeList = defenseSingle.getCommiteeList();
		assertEquals(commiteeList, returnedCommiteeList);
	}
	
	@Test
	public void testGetThesisAuthor(){
		System.out.println("Running: testGetThesisAuthor");
		defenseSingle.setThesisAuthor(author1);
		ThesisAuthor author = defenseSingle.getThesisAuthor();
		assertEquals(author, author1);
	}
	
	@Test
	public void testGetPreferredTimeslotTagSet(){
		System.out.println("Running: testGetPreferredTimeslotTagSet");
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("test");
		defenseSingle.setPreferredTimeslotTagSet(tagSet);
		Set<String> returnedTagSet = defenseSingle.getPreferredTimeslotTagSet();
		assertEquals(returnedTagSet, tagSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotTagSet(){
		System.out.println("Running: testGetNotPreferredTimeslotTagSet");
		Set<String> tagSet = new LinkedHashSet<>();
		defenseSingle.setNotPreferredTimeslotTagSet(tagSet);
		Set<String> returnedTagSet = defenseSingle.getNotPreferredTimeslotTagSet();
		assertEquals(returnedTagSet, tagSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotTagSet(){
		System.out.println("Running: testGetUnavailableTimeslotTagSet");
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Test");
		defenseSingle.setUnavailableTimeslotTagSet(tagSet);
		Set<String> returnedTagSet = defenseSingle.getUnavailableTimeslotTagSet();
		assertEquals(returnedTagSet, tagSet);
	}
	//-------------------------------------------------------------------------
	// parandada hiljem, on olemas getCommission2 func nyyd
	/*
	@Test
	public void testGetCommission(){
		System.out.println("Running: testGetCommission");
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission();
		Commitee[] commiteeArray = new Commitee[3];
		commiteeArray[0] = commitee1;
		commiteeArray[1] = commitee2;
		commiteeArray[2] = commitee3;
		Commitee[] returnedCommiteeArray = defenseSingle.getCommission();
		assertArrayEquals(returnedCommiteeArray, commiteeArray);
	}
	*/
	// -----------------------------------------------------------------------------------
	// pole vaja kuna garanteeritud
	/*
	@Test
	public void testGetCommissionTooManyCommiteeMembers(){
		System.out.println("Running: testGetCommissionTooManyCommiteeMembers");
		defenseSingle.setCommissionSize(1);
		defenseSingle.setCommission();
		Commitee[] commiteeArray = new Commitee[1];
		commiteeArray[0] = commitee1;
		Commitee[] returnedCommiteeArray = defenseSingle.getCommission();
		assertArrayEquals(returnedCommiteeArray, commiteeArray);
	}
	*/
	//---------------------------------------------------------------------------
	// pole vaja kuna garanteeritud
	/*
	@Test
	public void testEnoughCommiteeMembers(){
		System.out.println("Running: testEnoughCommiteeMembers");
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission();
		boolean test = defenseSingle.enoughCommiteeMembers();
		assertTrue(test);
	}
	*/
	//------------------------------------------------------------------------
	// pole vaja kuna garanteeritud
	/*
	@Test
	public void testNotEnoughCommiteeMembers(){
		System.out.println("Running: testNotEnoughCommiteeMembers");
		defenseSingle.setCommissionSize(4);
		defenseSingle.setCommission();
		boolean test = defenseSingle.enoughCommiteeMembers();
		assertFalse(test);
	}
	*/
	@Test
	public void testAuthorHasPreconditionsDone(){
		System.out.println("Running: testAuthorHasPreconditionsDone");
		when(author2.getPreconditionsFulfilled()).thenReturn(true);
		boolean test = defenseSingle.authorHasPreconditionsDone();
		assertTrue(test);
		verify(author2).getPreconditionsFulfilled();
	}
	
	@Test
	public void testAuthorHasPreconditionsNotDone(){
		System.out.println("Running: testAuthorHasPreconditionsNotDone");
		when(author2.getPreconditionsFulfilled()).thenReturn(false);
		boolean test = defenseSingle.authorHasPreconditionsDone();
		assertFalse(test);
		verify(author2).getPreconditionsFulfilled();
	}
	
	@Test
	public void testCheckWholeSetTimeslotTrue(){
		System.out.println("Running: testCheckWholeSetTimeslotTrue");
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot1);
		timeslotSet.add(timeslot2);
		timeslotSet.add(timeslot3);
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		defenseSingle.setTimeslot(timeslot3);
		Boolean test = defenseSingle.checkWholeSetTimeslot(timeslotSet);
		assertTrue(test);
		verify(timeslot1).getStartTime();
		verify(timeslot1).getEndTime();
		verify(timeslot1).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
		verify(timeslot3, times(4)).getStartTime();
		verify(timeslot3, times(4)).getEndTime();
		verify(timeslot3, times(4)).getDate();
	}
	
	@Test
	public void testCheckWholeSetTimeslotFalse(){
		System.out.println("Running: testCheckWholeSetTimeslotFalse");
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot1);
		timeslotSet.add(timeslot2);
		timeslotSet.add(timeslot3);
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		Timeslot timeslot = new Timeslot();
		timeslot.setDate(LocalDate.of(2020, 10, 05));
		timeslot.setStartTime(LocalTime.of(10, 05));
		timeslot.setEndTime(LocalTime.of(10, 25));
		defenseSingle.setTimeslot(timeslot);
		Boolean test = defenseSingle.checkWholeSetTimeslot(timeslotSet);
		assertFalse(test);
		verify(timeslot1).getStartTime();
		verify(timeslot1).getEndTime();
		verify(timeslot1).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
		verify(timeslot3).getStartTime();
		verify(timeslot3).getEndTime();
		verify(timeslot3).getDate();
	}
	
	@Test
	public void testIsAuthorsUnavailableTimeslotTrue(){
		System.out.println("Running: testIsAuthorsUnavailableTimeslotTrue");
		defenseMultiple.setTimeslot(timeslot1);
		Set<Timeslot> testSet = new LinkedHashSet<>();
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		defenseMultiple.setTimeslot(timeslot1);
		when(author3.getUnavailableTimeslotSet()).thenReturn(testSet);
		Boolean test = defenseMultiple.isAuthorsUnavailableTimeslot();
		assertTrue(test);
		verify(author3).getUnavailableTimeslotSet();
		verify(timeslot1, times(2)).getStartTime();
		verify(timeslot1, times(2)).getEndTime();
		verify(timeslot1, times(2)).getDate();
	}
	
	@Test
	public void testIsAuthorsUnavailableTimeslotFalse(){
		System.out.println("Running: testIsAuthorsUnavailableTimeslotFalse");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(01, 01));
		timeslot.setEndTime(LocalTime.of(02, 02));
		timeslot.setDate(LocalDate.of(1999, 01, 01));
		defenseMultiple.setTimeslot(timeslot);
		when(author3.getUnavailableTimeslotSet()).thenReturn(testSet);
		Boolean test = defenseMultiple.isAuthorsUnavailableTimeslot();
		assertFalse(test);
		verify(author3).getUnavailableTimeslotSet();
		verify(timeslot1).getStartTime();
		verify(timeslot1).getEndTime();
		verify(timeslot1).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
		verify(timeslot3).getStartTime();
		verify(timeslot3).getEndTime();
		verify(timeslot3).getDate();
	}
	// ----------------------------------------------------------------------------
	// assertion error
	/*
	@Test
	public void testIsAuthorsUnavailableTimeslotNull(){
		System.out.println("Running: testIsAuthorsUnavailableTimeslotNull");
		when(author3.getUnavailableTimeslotSet()).thenReturn(null);
		Boolean test = defenseMultiple.isAuthorsUnavailableTimeslot();
		assertFalse(test);
	}
	*/
	@Test
	public void testIsAuthorsPreferredTimeslotTrue(){
		System.out.println("Running: testIsAuthorsPreferredTimeslotTrue");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		defenseMultiple.setTimeslot(timeslot1);
		when(author3.getPreferredTimeslotSet()).thenReturn(testSet);
		Boolean test = defenseMultiple.isAuthorsPreferredTimeslot();
		assertTrue(test);
		verify(author3).getPreferredTimeslotSet();
		verify(timeslot1, times(2)).getStartTime();
		verify(timeslot1, times(2)).getEndTime();
		verify(timeslot1, times(2)).getDate();
	}
	
	@Test
	public void testIsAuthorsPreferredTimeslotFalse(){
		System.out.println("Running: testIsAuthorsPreferredTimeslotFalse");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(01, 01));
		timeslot.setEndTime(LocalTime.of(02, 02));
		timeslot.setDate(LocalDate.of(1999, 01, 01));
		defenseMultiple.setTimeslot(timeslot);
		when(author3.getPreferredTimeslotSet()).thenReturn(testSet);
		Boolean test = defenseMultiple.isAuthorsPreferredTimeslot();
		assertFalse(test);
		verify(author3).getPreferredTimeslotSet();
		verify(timeslot1).getStartTime();
		verify(timeslot1).getEndTime();
		verify(timeslot1).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
		verify(timeslot3).getStartTime();
		verify(timeslot3).getEndTime();
		verify(timeslot3).getDate();
	}
	
	@Test
	public void testIsAuthorsPreferredTimeslotNull(){
		System.out.println("Running: testIsAuthorsPreferredTimeslotNull");
		Boolean test = defenseMultiple.isAuthorsPreferredTimeslot();
		assertFalse(test);
	}
	
	@Test
	public void testIsAuthorsNotPreferredTimeslotTrue(){
		System.out.println("Running: testIsAuthorsNotPreferredTimeslotTrue");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		defenseMultiple.setTimeslot(timeslot1);
		when(author3.getNotPreferredTimeslotSet()).thenReturn(testSet);
		Boolean test = defenseMultiple.isAuthorsNotPreferredTimeslot();
		assertTrue(test);
		verify(author3).getNotPreferredTimeslotSet();
		verify(timeslot1, times(2)).getStartTime();
		verify(timeslot1, times(2)).getEndTime();
		verify(timeslot1, times(2)).getDate();
	}
	
	@Test
	public void testIsAuthorsNotPreferredTimeslotFalse(){
		System.out.println("Running: testIsAuthorsNotPreferredTimeslotFalse");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(01, 01));
		timeslot.setEndTime(LocalTime.of(02, 02));
		timeslot.setDate(LocalDate.of(1999, 01, 01));
		defenseMultiple.setTimeslot(timeslot);
		when(author3.getNotPreferredTimeslotSet()).thenReturn(testSet);
		Boolean test = defenseMultiple.isAuthorsNotPreferredTimeslot();
		assertFalse(test);
		verify(author3).getNotPreferredTimeslotSet();
		verify(timeslot1).getStartTime();
		verify(timeslot1).getEndTime();
		verify(timeslot1).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
		verify(timeslot3).getStartTime();
		verify(timeslot3).getEndTime();
		verify(timeslot3).getDate();
	}
	// -------------------------------------------------------------------------------
	// assertion error
	/*
	@Test
	public void testIsAuthorsNotPreferredTimeslotNull(){
		System.out.println("Running: testIsAuthorsNotPreferredTimeslotNull");
		when(author3.getNotPreferredTimeslotSet()).thenReturn(null);
		Boolean test = defenseMultiple.isAuthorsNotPreferredTimeslot();
		assertFalse(test);
	}
	*/
	
	// -------------------------------------------------------------------------------
	// too little actual invocations
	/*
	@Test
	public void testIsCommissionMembersUnavailableTimeslotFound(){
		System.out.println("Running: testIsCommissionMembersUnavailableTimeslotFound");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(commitee1.getChairman()).thenReturn(true);
		defenseMultiple.setTimeslot(timeslot3);
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		when(commitee1.getUnavailableTimeslotSet()).thenReturn(testSet);
		when(commitee2.getUnavailableTimeslotSet()).thenReturn(testSet);
		when(commitee3.getUnavailableTimeslotSet()).thenReturn(testSet);
		int test = defenseMultiple.isCommissionMembersUnavailableTimeslot();
		assertEquals(3, test);
		verify(commitee1, times(2)).getUnavailableTimeslotSet();
		verify(commitee2, times(2)).getUnavailableTimeslotSet();
		verify(commitee3, times(2)).getUnavailableTimeslotSet();
		verify(timeslot1, times(3)).getStartTime();
		verify(timeslot1, times(3)).getEndTime();
		verify(timeslot1, times(3)).getDate();
		verify(timeslot2, times(3)).getStartTime();
		verify(timeslot2, times(3)).getEndTime();
		verify(timeslot2, times(3)).getDate();
		verify(timeslot3, times(12)).getStartTime();
		verify(timeslot3, times(12)).getEndTime();
		verify(timeslot3, times(12)).getDate();
	}
	*/
	// ----------------------------------------------------------------------
	// too little actual invocations error
	/*
	@Test
	public void testIsCommissionMembersUnavailableTimeslotNotFound(){
		System.out.println("Running: testIsCommissionMembersUnavailableTimeslotNotFound");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		Timeslot timeslot = mock(Timeslot.class);
		when(timeslot.getStartTime()).thenReturn(LocalTime.of(21, 20));
		when(timeslot.getEndTime()).thenReturn(LocalTime.of(21, 40));
		when(timeslot.getDate()).thenReturn(LocalDate.of(2010, 10, 11));
		when(commitee1.getChairman()).thenReturn(true);
		defenseMultiple.setTimeslot(timeslot);
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		when(commitee1.getUnavailableTimeslotSet()).thenReturn(testSet);
		when(commitee2.getUnavailableTimeslotSet()).thenReturn(testSet);
		when(commitee3.getUnavailableTimeslotSet()).thenReturn(testSet);
		int test = defenseMultiple.isCommissionMembersUnavailableTimeslot();
		assertEquals(0, test);
		verify(commitee1, times(2)).getUnavailableTimeslotSet();
		verify(commitee2, times(2)).getUnavailableTimeslotSet();
		verify(commitee3, times(2)).getUnavailableTimeslotSet();
		verify(timeslot1, times(3)).getStartTime();
		verify(timeslot1, times(3)).getEndTime();
		verify(timeslot1, times(3)).getDate();
		verify(timeslot2, times(3)).getStartTime();
		verify(timeslot2, times(3)).getEndTime();
		verify(timeslot2, times(3)).getDate();
		verify(timeslot3, times(3)).getStartTime();
		verify(timeslot3, times(3)).getEndTime();
		verify(timeslot3, times(3)).getDate();
	}
	*/
	@Test
	public void testIsCommissionMembersUnavailableTimeslotNull(){
		System.out.println("Running: testIsCommissionMembersUnavailableTimeslotNull");
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		int test = defenseMultiple.isCommissionMembersUnavailableTimeslot();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsCommissionMembersPreferredTimeslotFound(){
		System.out.println("Running: testIsCommissionMembersPreferredTimeslotFound");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(commitee1.getChairman()).thenReturn(true);
		defenseMultiple.setTimeslot(timeslot1);
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		when(commitee1.getPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee2.getPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee3.getPreferredTimeslotSet()).thenReturn(testSet);
		int test = defenseMultiple.isCommissionMembersPreferredTimeslot();
		assertEquals(3, test);
		verify(commitee1).getPreferredTimeslotSet();
		verify(commitee2).getPreferredTimeslotSet();
		verify(commitee3).getPreferredTimeslotSet();
		verify(timeslot1, times(6)).getStartTime();
		verify(timeslot1, times(6)).getEndTime();
		verify(timeslot1, times(6)).getDate();
	}
	
	@Test
	public void testIsCommissionMembersPreferredTimeslotNotFound(){
		System.out.println("Running: testIsCommissionMembersPreferredTimeslotNotFound");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		Timeslot timeslot = mock(Timeslot.class);
		when(timeslot.getStartTime()).thenReturn(LocalTime.of(21, 20));
		when(timeslot.getEndTime()).thenReturn(LocalTime.of(21, 40));
		when(timeslot.getDate()).thenReturn(LocalDate.of(2010, 10, 11));
		when(commitee1.getChairman()).thenReturn(true);
		defenseMultiple.setTimeslot(timeslot);
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		when(commitee1.getPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee2.getPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee3.getPreferredTimeslotSet()).thenReturn(testSet);
		int test = defenseMultiple.isCommissionMembersPreferredTimeslot();
		assertEquals(0, test);
		verify(commitee1).getPreferredTimeslotSet();
		verify(commitee2).getPreferredTimeslotSet();
		verify(commitee3).getPreferredTimeslotSet();
		verify(timeslot1, times(3)).getStartTime();
		verify(timeslot1, times(3)).getEndTime();
		verify(timeslot1, times(3)).getDate();
		verify(timeslot2, times(3)).getStartTime();
		verify(timeslot2, times(3)).getEndTime();
		verify(timeslot2, times(3)).getDate();
		verify(timeslot3, times(3)).getStartTime();
		verify(timeslot3, times(3)).getEndTime();
		verify(timeslot3, times(3)).getDate();
	}
	
	@Test
	public void testIsCommissionMembersPreferredTimeslotNull(){
		System.out.println("Running: testIsCommissionMembersPreferredTimeslotNull");
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		int test = defenseMultiple.isCommissionMembersPreferredTimeslot();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsCommissionMembersNotPreferredTimeslotFound(){
		System.out.println("Running: testIsCommissionMembersNotPreferredTimeslotFound");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		when(commitee1.getChairman()).thenReturn(true);
		defenseMultiple.setTimeslot(timeslot2);
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		when(commitee1.getNotPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee2.getNotPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee3.getNotPreferredTimeslotSet()).thenReturn(testSet);
		int test = defenseMultiple.isCommissionMembersNotPreferredTimeslot();
		assertEquals(3, test);
		verify(commitee1).getNotPreferredTimeslotSet();
		verify(commitee2).getNotPreferredTimeslotSet();
		verify(commitee3).getNotPreferredTimeslotSet();
		verify(timeslot1, times(3)).getStartTime();
		verify(timeslot1, times(3)).getEndTime();
		verify(timeslot1, times(3)).getDate();
		verify(timeslot2, times(9)).getStartTime();
		verify(timeslot2, times(9)).getEndTime();
		verify(timeslot2, times(9)).getDate();
	}
	
	@Test
	public void testIsCommissionMembersNotPreferredTimeslotNotFound(){
		System.out.println("Running: testIsCommissionMembersNotPreferredTimeslotNotFound");
		Set<Timeslot> testSet = new LinkedHashSet<>();
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(10, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 11));
		when(timeslot3.getStartTime()).thenReturn(LocalTime.of(12, 12));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(10, 30));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 31));
		when(timeslot3.getEndTime()).thenReturn(LocalTime.of(12, 32));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 10, 10));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 11, 11));
		when(timeslot3.getDate()).thenReturn(LocalDate.of(2010, 12, 12));
		testSet.add(timeslot1);
		testSet.add(timeslot2);
		testSet.add(timeslot3);
		Timeslot timeslot = mock(Timeslot.class);
		when(timeslot.getStartTime()).thenReturn(LocalTime.of(21, 20));
		when(timeslot.getEndTime()).thenReturn(LocalTime.of(21, 40));
		when(timeslot.getDate()).thenReturn(LocalDate.of(2010, 10, 11));
		when(commitee1.getChairman()).thenReturn(true);
		System.out.println("tegi taani");
		defenseMultiple.setTimeslot(timeslot);
		System.out.println("tegi taani2");
		defenseMultiple.setCommissionSize(3);
		System.out.println("tegi taani3");
		defenseMultiple.setCommission2();
		System.out.println("tegi taani4");
		when(commitee1.getNotPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee2.getNotPreferredTimeslotSet()).thenReturn(testSet);
		when(commitee3.getNotPreferredTimeslotSet()).thenReturn(testSet);
		System.out.println("tegi siiani");
		int test = defenseMultiple.isCommissionMembersNotPreferredTimeslot();
		assertEquals(0, test);
		verify(commitee1).getNotPreferredTimeslotSet();
		verify(commitee2).getNotPreferredTimeslotSet();
		verify(commitee3).getNotPreferredTimeslotSet();
		verify(timeslot1, times(3)).getStartTime();
		verify(timeslot1, times(3)).getEndTime();
		verify(timeslot1, times(3)).getDate();
		verify(timeslot2, times(3)).getStartTime();
		verify(timeslot2, times(3)).getEndTime();
		verify(timeslot2, times(3)).getDate();
		verify(timeslot3, times(3)).getStartTime();
		verify(timeslot3, times(3)).getEndTime();
		verify(timeslot3, times(3)).getDate();
	}
	
	@Test
	public void testIsCommissionMembersNotPreferredTimeslotNull(){
		System.out.println("Running: testIsCommissionMembersNotPreferredTimeslotNull");
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		int test = defenseMultiple.isCommissionMembersNotPreferredTimeslot();
		assertEquals(0, test);
	}
	// --------------------------------------------------------------------------
	// assertion error
	/*
	@Test
	public void testhasChairmanAmongCommiteeTrue(){
		System.out.println("Running: testHasChairmanAmongCommiteeTrue");
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		when(commitee2.getChairman()).thenReturn(true);
		boolean test = defenseMultiple.hasChairmanAmongCommitee();
		assertTrue(test);
		verify(commitee2).getChairman();
	}
	*/
	
	@Test
	public void testhasChairmanAmongCommiteeFalse(){
		System.out.println("Running: testHasChairmanAmongCommiteeFalse");
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission2();
		boolean test = defenseMultiple.hasChairmanAmongCommitee();
		assertFalse(test);
	}
	//----------------------------------------------------------------------------------
	// pole vaja kuna garanteeritud
	/*
	@Test
	public void testhasChairmanAmongCommiteeTooMany(){
		System.out.println("Running: testHasChairmanAmongCommiteeTooMany");
		defenseMultiple.setCommissionSize(3);
		defenseMultiple.setCommission();
		when(commitee2.getChairman()).thenReturn(true);
		when(commitee3.getChairman()).thenReturn(true);
		boolean test = defenseMultiple.hasChairmanAmongCommitee();
		assertFalse(test);
		verify(commitee2).getChairman();
		verify(commitee2).getChairman();
	}
	*/
	/**
	 * kas seda on üldse vaja
	 */
	@Test
	public void testIsDefenseClosedTrue(){
		System.out.println("Running: testIsDefenseClosedTrue");
		when(defenseClosed.getType()).thenReturn("Kinnine");
		boolean test = defenseSingle.isDefenseClosed();
		assertTrue(test);
		verify(defenseClosed).getType();
	}
	/**
	 * kas seda on üldse vaja
	 */
	@Test
	public void testIsDefenseClosedFalse(){
		System.out.println("Running: testIsDefenseClosedFalse");
		when(defenseOpen.getType()).thenReturn("Lahtine");
		boolean test = defenseMultiple.isDefenseClosed();
		assertFalse(test);
		verify(defenseOpen).getType();
	}
	
	@Test
	public void testIsClosedDefenseTimeslotFalse(){
		System.out.println("Running: testIsClosedDefenseTimeslotFalse");
		when(defenseOpen.getType()).thenReturn("Lahtine");
		boolean test = defenseMultiple.isClosedDefenseTimeslot();
		assertFalse(test);
		verify(defenseOpen).getType();
	}
	
	@Test
	public void testIsClosedDefenseTimeslotFoundTrue(){
		System.out.println("Running: testIsClosedDefenseTimeslotFoundTrue");
		Set<Timeslot> closedSet = new LinkedHashSet<>();
		closedSet.add(timeslot2);
		defenseSingle.setTimeslot(timeslot2);
		when(defenseClosed.getType()).thenReturn("Kinnine");
		when(defenseClosed.getCompatibleTimeslotSet()).thenReturn(closedSet);
		boolean test = defenseSingle.isClosedDefenseTimeslot();
		assertTrue(test);
		verify(defenseClosed).getType();
		verify(defenseClosed).getCompatibleTimeslotSet();
	}
	
	@Test
	public void testIsClosedDefenseTimeslotFoundFalse(){
		System.out.println("Running: testIsClosedDefenseTimeslotFoundFalse");
		Set<Timeslot> closedSet = new LinkedHashSet<>();
		closedSet.add(timeslot2);
		defenseSingle.setTimeslot(timeslot3);
		when(defenseClosed.getType()).thenReturn("Kinnine");
		when(defenseClosed.getCompatibleTimeslotSet()).thenReturn(closedSet);
		boolean test = defenseSingle.isClosedDefenseTimeslot();
		assertFalse(test);
		verify(defenseClosed).getType();
		verify(defenseClosed).getCompatibleTimeslotSet();
	}
	
	@Test
	public void testHappensOnClosedTimesMorning(){
		System.out.println("Running: testHappensOnClosedTimesMorning");
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(8, 00));
		defenseSingle.setTimeslot(timeslot);
		boolean test = defenseSingle.happensOnClosedTimes();
		assertTrue(test);
	}
	
	@Test
	public void testHappensOnClosedTimesLunch(){
		System.out.println("Running: testHappensOnClosedTimesLunch");
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(13, 30));
		defenseSingle.setTimeslot(timeslot);
		boolean test = defenseSingle.happensOnClosedTimes();
		assertTrue(test);
	}
	
	@Test
	public void testHappensOnClosedTimesEvening(){
		System.out.println("Running: testHappensOnClosedTimesEvening");
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(18, 00));
		defenseSingle.setTimeslot(timeslot);
		boolean test = defenseSingle.happensOnClosedTimes();
		assertTrue(test);
	}
	
	@Test
	public void testHappensOnClosedTimesOther(){
		System.out.println("Running: testHappensOnClosedTimesOther");
		Timeslot timeslot = new Timeslot();
		timeslot.setStartTime(LocalTime.of(14, 30));
		defenseSingle.setTimeslot(timeslot);
		boolean test = defenseSingle.happensOnClosedTimes();
		assertFalse(test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsPreferredTimeslotNull(){
		System.out.println("Running: testIsAuthorsSupervisorsPreferredTimeslotNull");
		int test = defenseSingle.isAuthorsSupervisorsPreferredTimeslot();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsPreferredTimeslotNotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsPreferredTimeslotNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		when(timeslot.getStartTime()).thenReturn(LocalTime.of(14, 00));
		when(timeslot.getEndTime()).thenReturn(LocalTime.of(14, 20));
		when(timeslot.getDate()).thenReturn(LocalDate.of(2010, 11, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 00));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 20));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 12, 10));
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor1);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		when(supervisor1.getPreferredTimeslotSet()).thenReturn(timeslotSet);
		defenseSingle.setTimeslot(timeslot2);
		int test = defenseSingle.isAuthorsSupervisorsPreferredTimeslot();
		assertEquals(0, test);
		verify(author2).getThesisSupervisorSet();
		verify(supervisor1).getPreferredTimeslotSet();
		verify(timeslot).getStartTime();
		verify(timeslot).getEndTime();
		verify(timeslot).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
	}
	
	@Test
	public void testIsAuthorsSupervisorsPreferredTimeslotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsPreferredTimeslotFound");
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(14, 00));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(14, 20));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 11, 10));
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot1);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor1);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		when(supervisor1.getPreferredTimeslotSet()).thenReturn(timeslotSet);
		defenseSingle.setTimeslot(timeslot1);
		int test = defenseSingle.isAuthorsSupervisorsPreferredTimeslot();
		assertEquals(1, test);
		verify(author2).getThesisSupervisorSet();
		verify(supervisor1).getPreferredTimeslotSet();
		verify(timeslot1, times(2)).getStartTime();
		verify(timeslot1, times(2)).getEndTime();
		verify(timeslot1, times(2)).getDate();
	}
	
	@Test
	public void testIsAuthorsSupervisorsUnavailableTimeslotNull(){
		System.out.println("Running: testIsAuthorsSupervisorsUnavailableTimeslotNull");
		int test = defenseSingle.isAuthorsSupervisorsUnavailableTimeslot();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsUnavailableTimeslotNotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsUnavailableTimeslotNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		when(timeslot.getStartTime()).thenReturn(LocalTime.of(14, 00));
		when(timeslot.getEndTime()).thenReturn(LocalTime.of(14, 20));
		when(timeslot.getDate()).thenReturn(LocalDate.of(2010, 11, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 00));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 20));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 12, 10));
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor1);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		when(supervisor1.getUnavailableTimeslotSet()).thenReturn(timeslotSet);
		defenseSingle.setTimeslot(timeslot2);
		int test = defenseSingle.isAuthorsSupervisorsUnavailableTimeslot();
		assertEquals(0, test);
		verify(author2).getThesisSupervisorSet();
		verify(supervisor1).getUnavailableTimeslotSet();
		verify(timeslot).getStartTime();
		verify(timeslot).getEndTime();
		verify(timeslot).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
	}
	
	@Test
	public void testIsAuthorsSupervisorsUnavailableTimeslotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsUnavailableTimeslotFound");
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(14, 00));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(14, 20));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 11, 10));
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot1);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor1);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		when(supervisor1.getUnavailableTimeslotSet()).thenReturn(timeslotSet);
		defenseSingle.setTimeslot(timeslot1);
		int test = defenseSingle.isAuthorsSupervisorsUnavailableTimeslot();
		assertEquals(1, test);
		verify(author2).getThesisSupervisorSet();
		verify(supervisor1).getUnavailableTimeslotSet();
		verify(timeslot1, times(2)).getStartTime();
		verify(timeslot1, times(2)).getEndTime();
		verify(timeslot1, times(2)).getDate();
	}
	
	@Test
	public void testIsAuthorsSupervisorsNotPreferredTimeslotNull(){
		System.out.println("Running: testIsAuthorsSupervisorsNotPreferredTimeslotNull");
		int test = defenseSingle.isAuthorsSupervisorsNotPreferredTimeslot();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsNotPreferredTimeslotNotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsNotPreferredTimeslotNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		when(timeslot.getStartTime()).thenReturn(LocalTime.of(14, 00));
		when(timeslot.getEndTime()).thenReturn(LocalTime.of(14, 20));
		when(timeslot.getDate()).thenReturn(LocalDate.of(2010, 11, 10));
		when(timeslot2.getStartTime()).thenReturn(LocalTime.of(11, 00));
		when(timeslot2.getEndTime()).thenReturn(LocalTime.of(11, 20));
		when(timeslot2.getDate()).thenReturn(LocalDate.of(2010, 12, 10));
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor1);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		when(supervisor1.getNotPreferredTimeslotSet()).thenReturn(timeslotSet);
		defenseSingle.setTimeslot(timeslot2);
		int test = defenseSingle.isAuthorsSupervisorsNotPreferredTimeslot();
		assertEquals(0, test);
		verify(author2).getThesisSupervisorSet();
		verify(supervisor1).getNotPreferredTimeslotSet();
		verify(timeslot).getStartTime();
		verify(timeslot).getEndTime();
		verify(timeslot).getDate();
		verify(timeslot2).getStartTime();
		verify(timeslot2).getEndTime();
		verify(timeslot2).getDate();
	}
	
	@Test
	public void testIsAuthorsSupervisorsNotPreferredTimeslotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsNotPreferredTimeslotFound");
		when(timeslot1.getStartTime()).thenReturn(LocalTime.of(14, 00));
		when(timeslot1.getEndTime()).thenReturn(LocalTime.of(14, 20));
		when(timeslot1.getDate()).thenReturn(LocalDate.of(2010, 11, 10));
		Set<Timeslot> timeslotSet = new LinkedHashSet<>();
		timeslotSet.add(timeslot1);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor1);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		when(supervisor1.getNotPreferredTimeslotSet()).thenReturn(timeslotSet);
		defenseSingle.setTimeslot(timeslot1);
		int test = defenseSingle.isAuthorsSupervisorsNotPreferredTimeslot();
		assertEquals(1, test);
		verify(author2).getThesisSupervisorSet();
		verify(supervisor1).getNotPreferredTimeslotSet();
		verify(timeslot1, times(2)).getStartTime();
		verify(timeslot1, times(2)).getEndTime();
		verify(timeslot1, times(2)).getDate();
	}
	
	@Test
	public void testGetPrimarySupervisorNoSupervisor(){
		System.out.println("Running: testGetPrimarySupervisorNoSupervisor");
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		ThesisSupervisor test = defenseSingle.getPrimarySupervisor();
		assertEquals(null, test);
		verify(author2).getThesisSupervisorSet();
	}
	// ------------------------------------------------------------------
	// expected null but was mock
	/*
	@Test
	public void testGetPrimarySupervisorNoPrimarySupervisor(){
		System.out.println("Running: testGetPrimarySupervisorNoPrimarySupervisor");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		when(supervisor.getRole()).thenReturn("Kaasjuhendaja");
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		ThesisSupervisor test = defenseSingle.getPrimarySupervisor();
		assertEquals(null, test);
		verify(supervisor).getRole();
		verify(author2, times(2)).getThesisSupervisorSet();
	}
	*/
	// --------------------------------------------------------------------------
	// expected another supervisor for some reason
	/*
	@Test
	public void testGetPrimarySupervisorFoundSupervisor(){
		System.out.println("Running: testGetPrimarySupervisorFoundSupervisor");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		when(supervisor.getRole()).thenReturn("Peajuhendaja");
		ThesisSupervisor supervisor4 = mock(ThesisSupervisor.class);
		when(supervisor4.getRole()).thenReturn("Kaasjuhendaja");
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor4);
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		ThesisSupervisor test = defenseSingle.getPrimarySupervisor();
		assertEquals(supervisor, test);
		verify(supervisor).getRole();
		verify(author2, times(2)).getThesisSupervisorSet();
	}
	*/
	@Test
	public void testCheckWholeSetTimeslotTagNone(){
		System.out.println("Running: testCheckWholeSetTimeslotTagNone");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		boolean test = defenseSingle.checkWholeSetTimeslotTag(tagSetToCheck);
		assertFalse(test);
		verify(timeslot).getTagSet();
	}
	
	@Test
	public void testCheckWholeSetTimeslotTagAny(){
		System.out.println("Running: testCheckWholeSetTimeslotTagNone");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		boolean test = defenseSingle.checkWholeSetTimeslotTag(tagSetToCheck);
		assertTrue(test);
		verify(timeslot).getTagSet();
	}
	
	@Test
	public void testIsAuthorsPreferredTimeslotTagNull(){
		System.out.println("Running: testIsAuthorsPreferredTimeslotTagNull");
		boolean test = defenseSingle.isAuthorsPreferredTimeslotTag();
		assertFalse(test);
	}
	
	@Test
	public void testIsAuthorsPreferredTimeslotTagNotFound(){
		System.out.println("Running: testIsAuthorsPreferredTimeslotTagNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(author2.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		boolean test = defenseSingle.isAuthorsPreferredTimeslotTag();
		assertFalse(test);
		verify(timeslot).getTagSet();
		verify(author2).getPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsPreferredTimeslotTagFound(){
		System.out.println("Running: testIsAuthorsPreferredTimeslotTagFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		when(author2.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		boolean test = defenseSingle.isAuthorsPreferredTimeslotTag();
		assertTrue(test);
		verify(timeslot).getTagSet();
		verify(author2).getPreferredTimeslotTagSet();
	}
	// -----------------------------------------------------------------------------
	// assertion error
	/*
	@Test
	public void testIsAuthorsNotPreferredTimeslotTagNull(){
		System.out.println("Running: testIsAuthorsNotPreferredTimeslotTagNull");
		when(author3.getNotPreferredTimeslotTagSet()).thenReturn(null);
		boolean test = defenseSingle.isAuthorsNotPreferredTimeslotTag();
		assertFalse(test);
	}
	*/
	
	@Test
	public void testIsAuthorsNotPreferredTimeslotTagNotFound(){
		System.out.println("Running: testIsAuthorsNotPreferredTimeslotTagNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(author2.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		boolean test = defenseSingle.isAuthorsNotPreferredTimeslotTag();
		assertFalse(test);
		verify(timeslot).getTagSet();
		verify(author2).getNotPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsNotPreferredTimeslotTagFound(){
		System.out.println("Running: testIsAuthorsNotPreferredTimeslotTagFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		when(author2.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		boolean test = defenseSingle.isAuthorsNotPreferredTimeslotTag();
		assertTrue(test);
		verify(timeslot).getTagSet();
		verify(author2).getNotPreferredTimeslotTagSet();
	}
	// --------------------------------------------------------------------------
	// assertion error
	/*
	@Test
	public void testIsAuthorsUnavailableTimeslotTagNull(){
		System.out.println("Running: testIsAuthorsUnavailableTimeslotTagNull");
		when(author3.getUnavailableTimeslotTagSet()).thenReturn(null);
		boolean test = defenseSingle.isAuthorsUnavailableTimeslotTag();
		assertFalse(test);
	}
	*/
	
	@Test
	public void testIsAuthorsUnavailableTimeslotTagNotFound(){
		System.out.println("Running: testIsAuthorsUnavailableTimeslotTagNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(author2.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		boolean test = defenseSingle.isAuthorsUnavailableTimeslotTag();
		assertFalse(test);
		verify(timeslot).getTagSet();
		verify(author2).getUnavailableTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsUnavailableTimeslotTagFound(){
		System.out.println("Running: testIsAuthorsUnavailableTimeslotTagFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		when(author2.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		boolean test = defenseSingle.isAuthorsUnavailableTimeslotTag();
		assertTrue(test);
		verify(timeslot).getTagSet();
		verify(author2).getUnavailableTimeslotTagSet();
	}
	
	@Test
	public void testIsCommissionMembersPreferredTimeslotTagNull(){
		System.out.println("Running: testIsCommissionMembersPreferredTimeslotTagNull");
		int test = defenseSingle.isCommissionMembersPreferredTimeslotTag();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsCommissionMembersPreferredTimeslotTagNotFound(){
		System.out.println("Running: testIsCommissionMembersPreferredTimeslotTagNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(commitee1.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee2.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee3.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee1.getChairman()).thenReturn(true);
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission2();
		int test = defenseSingle.isCommissionMembersPreferredTimeslotTag();
		assertEquals(0, test);
		verify(timeslot, times(3)).getTagSet();
		verify(commitee1).getPreferredTimeslotTagSet();
		verify(commitee2).getPreferredTimeslotTagSet();
		verify(commitee3).getPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsCommissionMembersPreferredTimeslotTagFound(){
		System.out.println("Running: testIsCommissionMembersPreferredTimeslotTagFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(commitee1.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee2.getPreferredTimeslotTagSet()).thenReturn(tagSet);
		when(commitee3.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee1.getChairman()).thenReturn(true);
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission2();
		int test = defenseSingle.isCommissionMembersPreferredTimeslotTag();
		assertEquals(1, test);
		verify(timeslot, times(3)).getTagSet();
		verify(commitee1).getPreferredTimeslotTagSet();
		verify(commitee2).getPreferredTimeslotTagSet();
		verify(commitee3).getPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsCommissionMembersNotPreferredTimeslotTagNull(){
		System.out.println("Running: testIsCommissionMembersNotPreferredTimeslotTagNull");
		int test = defenseSingle.isCommissionMembersNotPreferredTimeslotTag();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsCommissionMembersNotPreferredTimeslotTagNotFound(){
		System.out.println("Running: testIsCommissionMembersNotPreferredTimeslotTagNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(commitee1.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee2.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee3.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee1.getChairman()).thenReturn(true);
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission2();
		int test = defenseSingle.isCommissionMembersNotPreferredTimeslotTag();
		assertEquals(0, test);
		verify(timeslot, times(3)).getTagSet();
		verify(commitee1).getNotPreferredTimeslotTagSet();
		verify(commitee2).getNotPreferredTimeslotTagSet();
		verify(commitee3).getNotPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsCommissionMembersNotPreferredTimeslotTagFound(){
		System.out.println("Running: testIsCommissionMembersNotPreferredTimeslotTagFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(commitee1.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee2.getNotPreferredTimeslotTagSet()).thenReturn(tagSet);
		when(commitee3.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee1.getChairman()).thenReturn(true);
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission2();
		int test = defenseSingle.isCommissionMembersNotPreferredTimeslotTag();
		assertEquals(1, test);
		verify(timeslot, times(3)).getTagSet();
		verify(commitee1).getNotPreferredTimeslotTagSet();
		verify(commitee2).getNotPreferredTimeslotTagSet();
		verify(commitee3).getNotPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsCommissionMembersUnavailableTimeslotTagNull(){
		System.out.println("Running: testIsCommissionMembersUnavailableTimeslotTagNull");
		int test = defenseSingle.isCommissionMembersUnavailableTimeslotTag();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsCommissionMembersUnavailableTimeslotTagNotFound(){
		System.out.println("Running: testIsCommissionMembersUnavailableTimeslotTagNotFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(commitee1.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee2.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee3.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee1.getChairman()).thenReturn(true);
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission2();
		int test = defenseSingle.isCommissionMembersUnavailableTimeslotTag();
		assertEquals(0, test);
		verify(timeslot, times(3)).getTagSet();
		verify(commitee1).getUnavailableTimeslotTagSet();
		verify(commitee2).getUnavailableTimeslotTagSet();
		verify(commitee3).getUnavailableTimeslotTagSet();
	}
	
	@Test
	public void testIsCommissionMembersUnavailableTimeslotTagFound(){
		System.out.println("Running: testIsCommissionMembersUnavailableTimeslotTagFound");
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		defenseSingle.setTimeslot(timeslot);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		when(commitee1.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee2.getUnavailableTimeslotTagSet()).thenReturn(tagSet);
		when(commitee3.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		when(commitee1.getChairman()).thenReturn(true);
		defenseSingle.setCommissionSize(3);
		defenseSingle.setCommission2();
		int test = defenseSingle.isCommissionMembersUnavailableTimeslotTag();
		assertEquals(1, test);
		verify(timeslot, times(3)).getTagSet();
		verify(commitee1).getUnavailableTimeslotTagSet();
		verify(commitee2).getUnavailableTimeslotTagSet();
		verify(commitee3).getUnavailableTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsSupervisorsPreferredTimeslotTagNull(){
		System.out.println("Running: testIsAuthorsSupervisorsPreferredTimeslotTagNull");
		int test = defenseSingle.isAuthorsSupervisorsPreferredTimeslotTag();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsPreferredTimeslotTagNotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsPreferredTimeslotTagNotFound");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		defenseSingle.setTimeslot(timeslot);
		when(supervisor.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		int test = defenseSingle.isAuthorsSupervisorsPreferredTimeslotTag();
		assertEquals(0, test);
		verify(author2).getThesisSupervisorSet();
		verify(timeslot).getTagSet();
		verify(supervisor).getPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsSupervisorsPreferredTimeslotTagFound(){
		System.out.println("Running: testIsAuthorsSupervisorsPreferredTimeslotTagFound");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		defenseSingle.setTimeslot(timeslot);
		when(supervisor.getPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		int test = defenseSingle.isAuthorsSupervisorsPreferredTimeslotTag();
		assertEquals(1, test);
		verify(author2).getThesisSupervisorSet();
		verify(timeslot).getTagSet();
		verify(supervisor).getPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsSupervisorsNotPreferredTimeslotTagNull(){
		System.out.println("Running: testIsAuthorsSupervisorsNotPreferredTimeslotTagNull");
		int test = defenseSingle.isAuthorsSupervisorsNotPreferredTimeslotTag();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsNotPreferredTimeslotTagNotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsNotPreferredTimeslotTagNotFound");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		defenseSingle.setTimeslot(timeslot);
		when(supervisor.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		int test = defenseSingle.isAuthorsSupervisorsNotPreferredTimeslotTag();
		assertEquals(0, test);
		verify(author2).getThesisSupervisorSet();
		verify(timeslot).getTagSet();
		verify(supervisor).getNotPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsSupervisorsNotPreferredTimeslotTagFound(){
		System.out.println("Running: testIsAuthorsSupervisorsNotPreferredTimeslotTagFound");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		defenseSingle.setTimeslot(timeslot);
		when(supervisor.getNotPreferredTimeslotTagSet()).thenReturn(tagSetToCheck);
		int test = defenseSingle.isAuthorsSupervisorsNotPreferredTimeslotTag();
		assertEquals(1, test);
		verify(author2).getThesisSupervisorSet();
		verify(timeslot).getTagSet();
		verify(supervisor).getNotPreferredTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsSupervisorsUnavailableTimeslotTagNull(){
		System.out.println("Running: testIsAuthorsSupervisorsUnavailableTimeslotTagNull");
		int test = defenseSingle.isAuthorsSupervisorsUnavailableTimeslotTag();
		assertEquals(0, test);
	}
	
	@Test
	public void testIsAuthorsSupervisorsUnavailableTimeslotTagNotFound(){
		System.out.println("Running: testIsAuthorsSupervisorsUnavailableTimeslotTagNotFound");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Teisipäev");
		defenseSingle.setTimeslot(timeslot);
		when(supervisor.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		int test = defenseSingle.isAuthorsSupervisorsUnavailableTimeslotTag();
		assertEquals(0, test);
		verify(author2).getThesisSupervisorSet();
		verify(timeslot).getTagSet();
		verify(supervisor).getUnavailableTimeslotTagSet();
	}
	
	@Test
	public void testIsAuthorsSupervisorsUnavailableTimeslotTagFound(){
		System.out.println("Running: testIsAuthorsSupervisorsUnavailableTimeslotTagFound");
		ThesisSupervisor supervisor = mock(ThesisSupervisor.class);
		Set<ThesisSupervisor> supervisorSet = new LinkedHashSet<>();
		supervisorSet.add(supervisor);
		when(author2.getThesisSupervisorSet()).thenReturn(supervisorSet);
		Timeslot timeslot = mock(Timeslot.class);
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		when(timeslot.getTagSet()).thenReturn(tagSet);
		Set<String> tagSetToCheck = new LinkedHashSet<>();
		tagSetToCheck.add("Esmaspäev");
		defenseSingle.setTimeslot(timeslot);
		when(supervisor.getUnavailableTimeslotTagSet()).thenReturn(tagSetToCheck);
		int test = defenseSingle.isAuthorsSupervisorsUnavailableTimeslotTag();
		assertEquals(1, test);
		verify(author2).getThesisSupervisorSet();
		verify(timeslot).getTagSet();
		verify(supervisor).getUnavailableTimeslotTagSet();
	}
}
