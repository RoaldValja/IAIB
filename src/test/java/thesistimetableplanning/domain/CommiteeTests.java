package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommiteeTests {

	private Commitee commitee;
	private Timeslot timeslot;
	private Set<String> timeslotTagSet;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		commitee = new Commitee();
		timeslot = new Timeslot();
		String tag1 = "Esmaspäev";
		String tag2 = "Teisipäev";
		timeslotTagSet = new LinkedHashSet<>();
		timeslotTagSet.add(tag1);
		timeslotTagSet.add(tag2);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		commitee = null;
		assertNull(commitee);
	}

	@Test
	public void testGetName() {
		System.out.println("Running: testGetName");
		commitee.setName("Gert Kanter");
		String commiteeName = commitee.getName();
		assertEquals(commiteeName, "Gert Kanter");
	}
	
	@Test
	public void testChairmanBooleanTrue(){
		System.out.println("Running: testChairmanBooleanTrue");
		commitee.isChairman();
		boolean chairman = commitee.getChairman();
		assertTrue(chairman);
	}
	
	@Test
	public void testChairmanBooleanFalse(){
		System.out.println("Running: testChairmanBooleanFalse");
		boolean chairman = commitee.getChairman();
		assertFalse(chairman);
	}
	
	@Test
	public void testChairmanType(){
		System.out.println("Running: testChairmanType");
		commitee.setChairmanType("Esimees");
		String chairmanType = commitee.getChairmanType();
		assertEquals(chairmanType, "Esimees");
	}
	
	@Test
	public void testGetPreferredTimeslotTagSet(){
		System.out.println("Running: testGetPreferredTimeslotTagSet");
		commitee.setPreferredTimeslotTagSet(timeslotTagSet);
		Set<String> authorPreferredTimeslotTagSet = commitee.getPreferredTimeslotTagSet();
		assertEquals(authorPreferredTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotTagSet(){
		System.out.println("Running: testGetNotPreferredTimeslotTagSet");
		commitee.setNotPreferredTimeslotTagSet(timeslotTagSet);
		Set<String> authorNotPreferredTimeslotTagSet = commitee.getNotPreferredTimeslotTagSet();
		assertEquals(authorNotPreferredTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotTagSet(){
		System.out.println("Running: testGetUnavailableTimeslotTagSet");
		commitee.setUnavailableTimeslotTagSet(timeslotTagSet);
		Set<String> authorUnavailableTimeslotTagSet = commitee.getUnavailableTimeslotTagSet();
		assertEquals(authorUnavailableTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetPreferredTimeslotSet(){
		System.out.println("Running: testGetPreferredTimeslotSet");
		Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
		preferredTimeslotSet.add(timeslot);
		commitee.setPreferredTimeslotSet(preferredTimeslotSet);
		Set<Timeslot> authorPreferredTimeslotSet = commitee.getPreferredTimeslotSet();
		assertEquals(authorPreferredTimeslotSet, preferredTimeslotSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotSet(){
		System.out.println("Running: testGetNotPreferredTimeslotSet");
		Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
		notPreferredTimeslotSet.add(timeslot);
		commitee.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		Set<Timeslot> authorNotPreferredTimeslotSet = commitee.getNotPreferredTimeslotSet();
		assertEquals(authorNotPreferredTimeslotSet, notPreferredTimeslotSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotSet(){
		System.out.println("Running: testGetUnavailableTimeslotSet");
		Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
		unavailableTimeslotSet.add(timeslot);
		commitee.setUnavailableTimeslotSet(unavailableTimeslotSet);
		Set<Timeslot> authorUnavailableTimeslotSet = commitee.getUnavailableTimeslotSet();
		assertEquals(authorUnavailableTimeslotSet, unavailableTimeslotSet);
	}

}
