package thesistimetableplanning.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class TimetableConstraintConfigurationTests {

	TimetableConstraintConfiguration timetableConstraintConfiguration;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting it up!");
		timetableConstraintConfiguration = new TimetableConstraintConfiguration();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		timetableConstraintConfiguration = null;
		assertNull(timetableConstraintConfiguration);
	}

	@Test
	public void testGetCommissionAtLeastThreeMembers() {
		System.out.println("Running: testGetCommissionAtLeastThreeMembers");
		timetableConstraintConfiguration.setCommissionAtLeastThreeMembers(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getCommissionAtLeastThreeMembers();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetAuthorPrerequisitesDone() {
		System.out.println("Running: testGetAuthorPrerequisitesDone");
		timetableConstraintConfiguration.setAuthorPrerequisitesDone(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getAuthorPrerequisitesDone();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnAuthorsUnavailableTimeslot() {
		System.out.println("Running: testGetDefenseOnAuthorsUnavailableTimeslot");
		timetableConstraintConfiguration.setDefenseOnAuthorsUnavailableTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsUnavailableTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnCommissionMembersUnavailableTimeslot() {
		System.out.println("Running: testGetDefenseOnCommissionMembersUnavailableTimeslot");
		timetableConstraintConfiguration.setDefenseOnCommissionMembersUnavailableTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnCommissionMembersUnavailableTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseHasOneChairman() {
		System.out.println("Running: testGetDefenseHasOneChairman");
		timetableConstraintConfiguration.setDefenseHasOneChairman(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseHasOneChairman();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	
	
	@Test
	public void testGetDefenseGroupedBySameThesisTheme() {
		System.out.println("Running: testGetDefenseGroupedBySameThesisTheme");
		timetableConstraintConfiguration.setDefenseGroupedBySameThesisTheme(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseGroupedBySameThesisTheme();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseAuthorsGroupedByCommonSupervisor() {
		System.out.println("Running: testGetDefenseAuthorsGroupedByCommonSupervisor");
		timetableConstraintConfiguration.setDefenseAuthorsGroupedByCommonSupervisor(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseAuthorsGroupedByCommonSupervisor();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch() {
		System.out.println("Running: testGetClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch");
		timetableConstraintConfiguration.setClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	
	
	@Test
	public void testGetDefenseOnAuthorsPreferredTimeslot() {
		System.out.println("Running: testGetDefenseOnAuthorsPreferredTimeslot");
		timetableConstraintConfiguration.setDefenseOnAuthorsPreferredTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsPreferredTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnAuthorsNotPreferredTimeslot() {
		System.out.println("Running: testGetDefenseOnAuthorsNotPreferredTimeslot");
		timetableConstraintConfiguration.setDefenseOnAuthorsNotPreferredTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsNotPreferredTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnCommissionMembersPreferredTimeslot() {
		System.out.println("Running: testGetDefenseOnCommissionMembersPreferredTimeslot");
		timetableConstraintConfiguration.setDefenseOnCommissionMembersPreferredTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnCommissionMembersPreferredTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnCommissionMembersNotPreferredTimeslot() {
		System.out.println("Running: testGetDefenseOnCommissionMembersNotPreferredTimeslot");
		timetableConstraintConfiguration.setDefenseOnCommissionMembersNotPreferredTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnCommissionMembersNotPreferredTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnAuthorsSupervisorsPreferredTimeslot() {
		System.out.println("Running: testGetDefenseOnAuthorsSupervisorsPreferredTimeslot");
		timetableConstraintConfiguration.setDefenseOnAuthorsSupervisorsPreferredTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsSupervisorsPreferredTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnAuthorsSupervisorsNotPreferredTimeslot() {
		System.out.println("Running: testGetDefenseOnAuthorsSupervisorsNotPreferredTimeslot");
		timetableConstraintConfiguration.setDefenseOnAuthorsSupervisorsNotPreferredTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsSupervisorsNotPreferredTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnAuthorsSupervisorsUnavailableTimeslot() {
		System.out.println("Running: testGetDefenseOnAuthorsSupervisorsUnavailableTimeslot");
		timetableConstraintConfiguration.setDefenseOnAuthorsSupervisorsUnavailableTimeslot(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsSupervisorsUnavailableTimeslot();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	
	
	@Test
	public void testGetDefenseOnAuthorsPreferredTimeslotTag() {
		System.out.println("Running: testGetDefenseOnAuthorsPreferredTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnAuthorsPreferredTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsPreferredTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnAuthorsNotPreferredTimeslotTag() {
		System.out.println("Running: testGetDefenseOnAuthorsNotPreferredTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnAuthorsNotPreferredTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsNotPreferredTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnAuthorsUnavailableTimeslotTag() {
		System.out.println("Running: testGetDefenseOnAuthorsUnavailableTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnAuthorsUnavailableTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsUnavailableTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}

	@Test
	public void testGetDefenseOnCommissionMembersPreferredTimeslotTag() {
		System.out.println("Running: testGetDefenseOnCommissionMembersPreferredTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnCommissionMembersPreferredTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnCommissionMembersPreferredTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnCommissionMembersNotPreferredTimeslotTag() {
		System.out.println("Running: testGetDefenseOnCommissionMembersNotPreferredTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnCommissionMembersNotPreferredTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnCommissionMembersNotPreferredTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnCommissionMembersUnavailableTimeslotTag() {
		System.out.println("Running: testGetDefenseOnCommissionMembersUnavailableTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnCommissionMembersUnavailableTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnCommissionMembersUnavailableTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnAuthorsSupervisorsPreferredTimeslotTag() {
		System.out.println("Running: testGetDefenseOnAuthorsSupervisorsPreferredTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnAuthorsSupervisorsPreferredTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsSupervisorsPreferredTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag() {
		System.out.println("Running: testGetDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
	@Test
	public void testGetDefenseOnAuthorsSupervisorsUnavailableTimeslotTag() {
		System.out.println("Running: testGetDefenseOnAuthorsSupervisorsUnavailableTimeslotTag");
		timetableConstraintConfiguration.setDefenseOnAuthorsSupervisorsUnavailableTimeslotTag(HardSoftScore.ofHard(10));
		HardSoftScore constraintScore = timetableConstraintConfiguration.getDefenseOnAuthorsSupervisorsUnavailableTimeslotTag();
		assertEquals(constraintScore, HardSoftScore.ofHard(10));
	}
	
}
