package thesistimetableplanning.drools;

import static org.junit.Assert.*;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.test.impl.score.buildin.hardsoft.HardSoftScoreVerifier;

import thesistimetableplanning.domain.Commitee;
import thesistimetableplanning.domain.Defense;
import thesistimetableplanning.domain.DefenseType;
import thesistimetableplanning.domain.ThesisAuthor;
import thesistimetableplanning.domain.ThesisSupervisor;
import thesistimetableplanning.domain.Timeslot;
import thesistimetableplanning.domain.TimetableConstraintConfiguration;
import thesistimetableplanning.domain.TimetableSolution;

public class TimetablePlanningScoreHardConstraintTests {
/*
	private HardSoftScoreVerifier<TimetableSolution> scoreVerifier = new HardSoftScoreVerifier<>(
			SolverFactory.createFromXmlResource("timetableplanning/solver/defenseTimetableSolverConfig.xml", getClass().getClassLoader()));
*/
	private HardSoftScoreVerifier<TimetableSolution> scoreVerifier = new HardSoftScoreVerifier<>(
			SolverFactory.createFromXmlResource("thesistimetableplanning/solver/DefenseTimetableSolverTabuSearchConfig.xml"));

	private Commitee commitee1, commitee2, commitee3, commitee4;
	private Timeslot timeslot1, timeslot2;
	private ThesisAuthor author1;
	private ThesisSupervisor supervisor1;
	private Defense defense;
	private DefenseType defenseType1;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Running: setUp");
		
		defenseType1 = new DefenseType(0L, "type1");
		defense = new Defense(1L).withDefenseType(defenseType1);
		
		timeslot1 = new Timeslot(1L);
		timeslot2 = new Timeslot(2L);
		
		timeslot1.setDate(LocalDate.of(2019, 11, 11));
		timeslot2.setDate(LocalDate.of(2019, 11, 12));
		timeslot1.setStartTime(LocalTime.of(10, 0));
		timeslot1.setEndTime(LocalTime.of(10, 20));
		timeslot2.setStartTime(LocalTime.of(10, 30));
		timeslot2.setEndTime(LocalTime.of(10, 40));
		
		timeslot1.setTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		timeslot2.setTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		
		defense.setTimeslot(timeslot1);
		
		supervisor1 = new ThesisSupervisor(1L);
		supervisor1.setRole("Peajuhendaja");
		supervisor1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		supervisor1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		supervisor1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		supervisor1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		supervisor1.setUnavailableTimeslotSet(new LinkedHashSet<>(Collections.EMPTY_SET));
		supervisor1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		
		author1 = new ThesisAuthor(1L);
		author1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		author1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		author1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		author1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		author1.setUnavailableTimeslotSet(Collections.emptySet());
		author1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1)));
		
		defense.setThesisAuthor(author1);

		commitee1 = new Commitee(1L);
		commitee2 = new Commitee(2L);
		commitee3 = new Commitee(3L);
		commitee4 = new Commitee(4L);
		
		commitee1.isChairman();
		
		commitee1.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		commitee2.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		commitee3.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		commitee4.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		commitee1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		commitee2.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		commitee3.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		commitee4.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		commitee1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee2.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee3.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee4.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee1.setPreferredTimeslotSet(new LinkedHashSet<>(Collections.emptySet()));
		commitee2.setPreferredTimeslotSet(new LinkedHashSet<>(Collections.emptySet()));
		commitee3.setPreferredTimeslotSet(new LinkedHashSet<>(Collections.emptySet()));
		commitee4.setPreferredTimeslotSet(new LinkedHashSet<>(Collections.emptySet()));
		commitee1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee2.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee3.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee4.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		commitee2.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		commitee3.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		commitee4.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		
		defense.setCommissionSize(3);
		defense.setCommiteeList(Arrays.asList(commitee1, commitee2, commitee3));
		defense.setCommission2();
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		commitee1 = null;
		commitee2 = null;
		commitee3 = null;
		commitee4 = null;
		timeslot1 = null;
		timeslot2 = null;
		author1 = null;
		supervisor1 = null;
		defense = null;
		defenseType1 = null;
	}
	// seda Drools'i meetodit pole enam
	/*
	@Test
	public void testCommissionAtLeastThreeMembers() {
		System.out.println("Running: testCommissionAtLeastThreeMembers");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertHardWeight(COMMISSION_AT_LEAST_THREE_MEMBERS, 0, solution);
		
		defense.setCommiteeList(Arrays.asList(commitee1, commitee2));
		defense.setCommission2();
		
		scoreVerifier.assertHardWeight(COMMISSION_AT_LEAST_THREE_MEMBERS, -10, solution);
		
		defense.setCommiteeList(Arrays.asList(commitee1, commitee2, commitee3, commitee4));
		defense.setCommission2();
		
		scoreVerifier.assertHardWeight(COMMISSION_AT_LEAST_THREE_MEMBERS, 0, solution);
	}
*/
	// seda Drools'i meetodit pole enam
	/*
	@Test
	public void testAuthorPrerequisitesDone() {
		System.out.println("Running: testAuthorPrerequisitesDone");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense))
				.withTimeslotList(Collections.emptyList())
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertHardWeight(AUTHOR_PREREQUISITES_DONE, -10, solution);
		
		author1.hasPreconditionsFulfilled();
		
		scoreVerifier.assertHardWeight(AUTHOR_PREREQUISITES_DONE, 0, solution);
	}
	*/
	@Test
	public void testAuthorUnavailableTimeslot() {
		System.out.println("Running: testAuthorUnavailableTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT, 0, solution);
		
		author1.setUnavailableTimeslotSet(new LinkedHashSet(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT, -10, solution);
		
		author1.setUnavailableTimeslotSet(new LinkedHashSet(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT, 0, solution);
		
		author1.setUnavailableTimeslotSet(new LinkedHashSet(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT, -10, solution);
		
		//timeslot2.setDate(LocalDate.of(2019, 11, 11));
		
		//scoreVerifier.assertHardWeight(DEFENSE_ON_AUTHORS_UNAVAILABLE_TIMESLOT, -10, solution);
	}

	@Test
	public void testCommissionMemberUnavailableTimeslot() {
		System.out.println("Running: testCommissionMemberUnavailableTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT, 0, solution);
		
		commitee2.setUnavailableTimeslotSet(Collections.emptySet());
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT, 0, solution);
		
		commitee2.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT, -10, solution);
		
		commitee1.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT, -20, solution);
		
		commitee3.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT, -30, solution);
		
		commitee1.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertHardWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT, -30, solution);
	}
	// seda Drools'i meetodit pole enam
	/*
	@Test
	public void testHasOneChairman() {
		System.out.println("Running: testHasOneChairman");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1));
		
		scoreVerifier.assertHardWeight(DEFENSE_HAS_ONE_CHAIRMAN, 0, solution);
		
		defense.setCommiteeList(Arrays.asList(commitee2, commitee3, commitee4));
		defense.setCommission();
		
		scoreVerifier.assertHardWeight(DEFENSE_HAS_ONE_CHAIRMAN, -10, solution);
		
		defense.setCommiteeList(Arrays.asList(commitee1, commitee2, commitee4));
		commitee4.isChairman();
		defense.setCommission();
		
		scoreVerifier.assertHardWeight(DEFENSE_HAS_ONE_CHAIRMAN, -10, solution);
		
		defense.setCommiteeList(Arrays.asList(commitee1, commitee2));
		defense.setCommission();
		
		scoreVerifier.assertHardWeight(DEFENSE_HAS_ONE_CHAIRMAN, 0, solution);
	}
	*/
	

}
