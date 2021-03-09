package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeslotTests {

	private Timeslot timeslot;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		timeslot = new Timeslot();
		timeslot.setDate(LocalDate.of(2020, 04, 12));
		timeslot.setStartTime(LocalTime.of(10, 00));
		timeslot.setEndTime(LocalTime.of(10, 20));
		Set<String> tagSet = new LinkedHashSet<>();
		tagSet.add("Esmaspäev");
		timeslot.setTagSet(tagSet);
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		timeslot = null;
		assertNull(timeslot);
	}
	
	@Test
	public void testSetAndGetDate() {
		System.out.println("Running: testSetAndGetDate");
		LocalDate date = LocalDate.of(2015, 10, 22);
		timeslot.setDate(date);
		LocalDate returnedDate = timeslot.getDate();
		assertEquals(returnedDate, date);
	}
	
	@Test
	public void testSetAndGetStartTime() {
		System.out.println("Running: testSetAndGetStartTime");
		LocalTime time = LocalTime.of(8, 00);
		timeslot.setStartTime(time);
		LocalTime returnedTime = timeslot.getStartTime();
		assertEquals(returnedTime, time);
	}
	
	@Test
	public void testSetAndGetEndTime() {
		System.out.println("Running: testSetAndGetEndTime");
		LocalTime time = LocalTime.of(12, 40);
		timeslot.setEndTime(time);
		LocalTime returnedTime = timeslot.getEndTime();
		assertEquals(returnedTime, time);
	}
	
	@Test
	public void testSetAndGetSession() {
		System.out.println("Running: testSetAndGetSession");
		timeslot.setSession(1);
		int returnedSession = timeslot.getSession();
		assertEquals(returnedSession, 1);
	}
	
	@Test
	public void testSetAndGetTagSet() {
		System.out.println("Running: testSetAndGetTagSet");
		Set<String> newTagSet = new LinkedHashSet<>();
		newTagSet.add("Esmaspäev");
		timeslot.setTagSet(newTagSet);
		Set<String> timeslotTagSet = timeslot.getTagSet();
		assertEquals(timeslotTagSet, newTagSet);
	}
	
	@Test
	public void testSetAndGetDurationInMinutes() {
		System.out.println("Running: testSetAndGetDurationInMinutes");
		timeslot.setDurationInMinutes();
		int duration = timeslot.getDurationInMinutes();
		assertEquals(duration, 20);
	}

}
