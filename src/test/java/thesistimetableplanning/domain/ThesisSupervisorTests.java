package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThesisSupervisorTests {

	private ThesisSupervisor thesisSupervisor;
	private Timeslot timeslot;
	private Set<String> timeslotTagSet;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up");
		thesisSupervisor = new ThesisSupervisor();
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
		thesisSupervisor = null;
		assertNull(thesisSupervisor);
	}

	@Test
	public void testGetName() {
		System.out.println("Running: testGetName");
		thesisSupervisor.setName("Riina Maigre");
		String supervisorName = thesisSupervisor.getName();
		assertEquals(supervisorName, "Riina Maigre");
	}

	@Test
	public void testGetRole() {
		System.out.println("Running: testGetRole");
		thesisSupervisor.setRole("Juhendaja");
		String supervisorRole = thesisSupervisor.getRole();
		assertEquals(supervisorRole, "Juhendaja");
	}
	
	@Test
	public void testGetPreferredTimeslotTagSet(){
		System.out.println("Running: testGetPreferredTimeslotTagSet");
		thesisSupervisor.setPreferredTimeslotTagSet(timeslotTagSet);
		Set<String> authorPreferredTimeslotTagSet = thesisSupervisor.getPreferredTimeslotTagSet();
		assertEquals(authorPreferredTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotTagSet(){
		System.out.println("Running: testGetNotPreferredTimeslotTagSet");
		thesisSupervisor.setNotPreferredTimeslotTagSet(timeslotTagSet);
		Set<String> authorNotPreferredTimeslotTagSet = thesisSupervisor.getNotPreferredTimeslotTagSet();
		assertEquals(authorNotPreferredTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotTagSet(){
		System.out.println("Running: testGetUnavailableTimeslotTagSet");
		thesisSupervisor.setUnavailableTimeslotTagSet(timeslotTagSet);
		Set<String> authorUnavailableTimeslotTagSet = thesisSupervisor.getUnavailableTimeslotTagSet();
		assertEquals(authorUnavailableTimeslotTagSet, timeslotTagSet);
	}
	
	@Test
	public void testGetPreferredTimeslotSet(){
		System.out.println("Running: testGetPreferredTimeslotSet");
		Set<Timeslot> preferredTimeslotSet = new LinkedHashSet<>();
		preferredTimeslotSet.add(timeslot);
		thesisSupervisor.setPreferredTimeslotSet(preferredTimeslotSet);
		Set<Timeslot> authorPreferredTimeslotSet = thesisSupervisor.getPreferredTimeslotSet();
		assertEquals(authorPreferredTimeslotSet, preferredTimeslotSet);
	}
	
	@Test
	public void testGetNotPreferredTimeslotSet(){
		System.out.println("Running: testGetNotPreferredTimeslotSet");
		Set<Timeslot> notPreferredTimeslotSet = new LinkedHashSet<>();
		notPreferredTimeslotSet.add(timeslot);
		thesisSupervisor.setNotPreferredTimeslotSet(notPreferredTimeslotSet);
		Set<Timeslot> authorNotPreferredTimeslotSet = thesisSupervisor.getNotPreferredTimeslotSet();
		assertEquals(authorNotPreferredTimeslotSet, notPreferredTimeslotSet);
	}
	
	@Test
	public void testGetUnavailableTimeslotSet(){
		System.out.println("Running: testGetUnavailableTimeslotSet");
		Set<Timeslot> unavailableTimeslotSet = new LinkedHashSet<>();
		unavailableTimeslotSet.add(timeslot);
		thesisSupervisor.setUnavailableTimeslotSet(unavailableTimeslotSet);
		Set<Timeslot> authorUnavailableTimeslotSet = thesisSupervisor.getUnavailableTimeslotSet();
		assertEquals(authorUnavailableTimeslotSet, unavailableTimeslotSet);
	}
}
