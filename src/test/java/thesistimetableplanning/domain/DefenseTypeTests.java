package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefenseTypeTests {

	private DefenseType defenseType;
	private Timeslot timeslot;
	private Set<Timeslot> compatibleTimeslotSet;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		defenseType = new DefenseType();
		timeslot = new Timeslot();
		compatibleTimeslotSet = new LinkedHashSet<>();
		compatibleTimeslotSet.add(timeslot);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		defenseType = null;
		assertNull(defenseType);
	}

	@Test
	public void testGetType() {
		System.out.println("Running testGetType");
		defenseType.setType("Lahtine");
		String defenseTypeType = defenseType.getType();
		assertEquals(defenseTypeType, "Lahtine");
	}
	
	@Test
	public void testGetCompatibleTimeslotSet() {
		System.out.println("Running testGetCompatibleTimeslotSet");
		defenseType.setCompatibleTimeslotSet(compatibleTimeslotSet);
		Set<Timeslot> defenseTypeCompatibleTimeslotSet = defenseType.getCompatibleTimeslotSet();
		assertEquals(defenseTypeCompatibleTimeslotSet, compatibleTimeslotSet);
	}

}
