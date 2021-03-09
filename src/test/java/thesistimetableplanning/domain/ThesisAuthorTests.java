package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThesisAuthorTests {

	private ThesisAuthor thesisAuthor;
	private ThesisSupervisor thesisSupervisor;
	private Timeslot timeslot;
	private Set<String> timeslotTagSet;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		thesisAuthor = new ThesisAuthor();
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
		thesisAuthor = null;
		assertNull(thesisAuthor);
	}

	@Test
	public void testGetName() {
		System.out.println("Running: testGetName");
		String name = "Roald Välja";
		thesisAuthor.setName(name);
		String authorName = thesisAuthor.getName();
		assertEquals(authorName, "Roald Välja");
	}
	
	@Test
	public void testPreconditionsNotFulfilled() {
		System.out.println("Running: testPreconditionsNotFulfilled");
		boolean condition = thesisAuthor.getPreconditionsFulfilled();
		assertFalse(condition);
	}
	
	@Test
	public void testPreconditionsFulfilled() {
		System.out.println("Running: testPreconditionsFulfilled");
		thesisAuthor.hasPreconditionsFulfilled();
		boolean condition = thesisAuthor.getPreconditionsFulfilled();
		assertTrue(condition);
	}
	
	@Test
	public void testGetSupervisorSet() {
		System.out.println("Running: testGetSupervisorSet");
		thesisSupervisor = new ThesisSupervisor();
		thesisSupervisor.setName("Riina Maigre");
		Set<ThesisSupervisor> thesisSupervisorSet = new LinkedHashSet<>();
		thesisSupervisorSet.add(thesisSupervisor);
		thesisAuthor.setThesisSupervisorSet(thesisSupervisorSet);
		Set<ThesisSupervisor> authorSupervisorSet = thesisAuthor.getThesisSupervisorSet();
		assertEquals(authorSupervisorSet, thesisSupervisorSet);
	}
	
	@Test
	public void testGetPreferredTimeslotTagSet(){
		System.out.println("Running: testGetPreferredTimeslotTagSet");
		thesisAuthor.setPreferredTimeslotTagSet(timeslotTagSet);
		Set<String> authorPreferredTimeslotTagSet = thesisAuthor.getPreferredTimeslotTagSet();
		assertEquals(authorPreferredTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotTagSet(){
		System.out.println("Running: testGetNotPreferredTimeslotTagSet");
		thesisAuthor.setNotPreferredTimeslotTagSet(timeslotTagSet);
		Set<String> authorNotPreferredTimeslotTagSet = thesisAuthor.getNotPreferredTimeslotTagSet();
		assertEquals(authorNotPreferredTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotTagSet(){
		System.out.println("Running: testGetUnavailableTimeslotTagSet");
		thesisAuthor.setUnavailableTimeslotTagSet(timeslotTagSet);
		Set<String> authorUnavailableTimeslotTagSet = thesisAuthor.getUnavailableTimeslotTagSet();
		assertEquals(authorUnavailableTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetPreferredTimeslotSet(){
		System.out.println("Running: testGetPreferredTimeslotSet");
		Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
		preferredTimeslotSet.add(timeslot);
		thesisAuthor.setPreferredTimeslotSet(preferredTimeslotSet);
		Set<Timeslot> authorPreferredTimeslotSet = thesisAuthor.getPreferredTimeslotSet();
		assertEquals(authorPreferredTimeslotSet, preferredTimeslotSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotSet(){
		System.out.println("Running: testGetNotPreferredTimeslotSet");
		Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
		notPreferredTimeslotSet.add(timeslot);
		thesisAuthor.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		Set<Timeslot> authorNotPreferredTimeslotSet = thesisAuthor.getNotPreferredTimeslotSet();
		assertEquals(authorNotPreferredTimeslotSet, notPreferredTimeslotSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotSet(){
		System.out.println("Running: testGetUnavailableTimeslotSet");
		Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
		unavailableTimeslotSet.add(timeslot);
		thesisAuthor.setUnavailableTimeslotSet(unavailableTimeslotSet);
		Set<Timeslot> authorUnavailableTimeslotSet = thesisAuthor.getUnavailableTimeslotSet();
		assertEquals(authorUnavailableTimeslotSet, unavailableTimeslotSet);
	}
	
	@Test
	public void testwithTimeslotPreferredTagSet(){
		System.out.println("Running: testWithTimeslotPreferredTagSet");
		//thesisAuthor = new ThesisAuthor.withTimeslotPreferredTagSet(timeslotTagSet);
		
	}

}
