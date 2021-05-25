package thesistimetableplanning.drools;

import static org.junit.Assert.*;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT;

import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG;
import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG;

import static thesistimetableplanning.domain.TimetableConstraintConfiguration.DEFENSE_AUTHORS_GROUPED_BY_COMMON_SUPERVISOR;

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

public class TimetablePlanningScoreSoftConstraintTests {

	private HardSoftScoreVerifier<TimetableSolution> scoreVerifier = new HardSoftScoreVerifier<>(
			SolverFactory.createFromXmlResource("thesistimetableplanning/solver/DefenseTimetableSolverTabuSearchConfig.xml"));

	private Commitee commitee1, commitee2, commitee3, commitee4;
	private Timeslot timeslot1, timeslot2;
	private ThesisAuthor author1, author2;
	private ThesisSupervisor supervisor1, supervisor2;
	private Defense defense1, defense2;
	private DefenseType defenseType1, defenseType2;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Running: setUp");
		
		defenseType1 = new DefenseType(0L, "Kinnine");
		defenseType2 = new DefenseType(1L, "Lahtine");
		defense1 = new Defense(1L).withDefenseType(defenseType1);
		defense2 = new Defense(2L).withDefenseType(defenseType2);
		
		timeslot1 = new Timeslot(1L);
		timeslot2 = new Timeslot(2L);
		timeslot1.setDate(LocalDate.of(2019, 11, 11));
		timeslot2.setDate(LocalDate.of(2019, 11, 12));
		timeslot1.setStartTime(LocalTime.of(10, 0));
		timeslot1.setEndTime(LocalTime.of(10, 20));
		timeslot2.setStartTime(LocalTime.of(10, 30));
		timeslot2.setEndTime(LocalTime.of(10, 40));
		timeslot1.setTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		timeslot2.setTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev", "Teisipäev")));
		
		defenseType1.setCompatibleTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		defenseType2.setCompatibleTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		defense1.setTimeslot(timeslot1);
		defense2.setTimeslot(timeslot2);
		
		supervisor1 = new ThesisSupervisor(1L);
		supervisor1.setRole("Peajuhendaja");
		supervisor1.setNotPreferredTimeslotSet(Collections.emptySet());
		supervisor1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		supervisor1.setPreferredTimeslotSet(Collections.emptySet());
		supervisor1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		supervisor1.setUnavailableTimeslotSet(Collections.emptySet());
		supervisor1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		
		supervisor2 = new ThesisSupervisor(2L);
		supervisor2.setRole("Kaasjuhendaja");
		supervisor2.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		supervisor2.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		supervisor2.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		supervisor2.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		supervisor2.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		supervisor2.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		
		author1 = new ThesisAuthor(1L);
		author1.setPreferredTimeslotSet(Collections.emptySet());
		author1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		author1.setNotPreferredTimeslotSet(Collections.emptySet());
		author1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		author1.setUnavailableTimeslotSet(Collections.emptySet());
		author1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1)));
		
		author2 = new ThesisAuthor(2L);
		author2.setPreferredTimeslotSet(Collections.emptySet());
		author2.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		author2.setNotPreferredTimeslotSet(Collections.emptySet());
		author2.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		author2.setUnavailableTimeslotSet(Collections.emptySet());
		author2.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		author2.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor2)));
		
		defense1.setThesisAuthor(author1);
		defense2.setThesisAuthor(author2);

		commitee1 = new Commitee(1L);
		commitee2 = new Commitee(2L);
		commitee3 = new Commitee(3L);
		commitee4 = new Commitee(4L);
		
		commitee1.isChairman();
		
		commitee1.setUnavailableTimeslotSet(Collections.emptySet());
		commitee2.setUnavailableTimeslotSet(Collections.emptySet());
		commitee3.setUnavailableTimeslotSet(Collections.emptySet());
		commitee4.setUnavailableTimeslotSet(Collections.emptySet());
		commitee1.setNotPreferredTimeslotSet(Collections.emptySet());
		commitee2.setNotPreferredTimeslotSet(Collections.emptySet());
		commitee3.setNotPreferredTimeslotSet(Collections.emptySet());
		commitee4.setNotPreferredTimeslotSet(Collections.emptySet());
		commitee1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee2.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee3.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee4.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		commitee1.setPreferredTimeslotSet(Collections.emptySet());
		commitee2.setPreferredTimeslotSet(Collections.emptySet());
		commitee3.setPreferredTimeslotSet(Collections.emptySet());
		commitee4.setPreferredTimeslotSet(Collections.emptySet());
		commitee1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee2.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee3.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee4.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		commitee1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		commitee2.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		commitee3.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		commitee4.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Kolmapäev")));
		
		defense1.setCommissionSize(3);
		defense1.setCommiteeList(Arrays.asList(commitee1, commitee2, commitee3));
		defense1.setCommission2();
		
		defense2.setCommissionSize(3);
		defense2.setCommiteeList(Arrays.asList(commitee1, commitee2, commitee3));
		defense2.setCommission2();
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
		defense1 = null;
		defenseType1 = null;
	}

	@Test
	public void testDefenseOnAuthorsNotPreferredTimeslot() {
		System.out.println("Running: testDefenseOnAuthorsNotPreferredTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT, 0, solution);
		
		author1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT, 0, solution);
		
		author1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT, -10, solution);
		
		author1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2, timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT, -10, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsPreferredTimeslot() {
		System.out.println("Running: testDefenseOnAuthorsPreferredTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT, 0, solution);
		
		author1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT, 0, solution);
		
		author1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT, 10, solution);
		
		author1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT, 10, solution);
	}
	
	@Test
	public void testDefenseOnCommissionMembersNotPreferredTimeslot() {
		System.out.println("Running: testDefenseOnCommissionMembersNotPreferredTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT, 0, solution);
		
		commitee1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT, 0, solution);
		
		commitee1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT, -10, solution);
		
		commitee2.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT, -20, solution);
		
		commitee3.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT, -30, solution);
		
		commitee3.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT, -30, solution);
	}
	
	@Test
	public void testDefenseOnCommissionMembersPreferredTimeslot() {
		System.out.println("Running: testDefenseOnCommissionMembersPreferredTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT, 0, solution);
		
		commitee1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT, 0, solution);
		
		commitee1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT, 10, solution);
		
		commitee2.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT, 20, solution);
		
		commitee3.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT, 30, solution);
		
		commitee3.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT, 30, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsSupervisorsNotPreferredTimeslot() {
		System.out.println("Running: testDefenseOnAuthorsSupervisorsNotPreferredTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT, 0, solution);
		
		supervisor1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT, 0, solution);
		
		supervisor1.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT, -10, solution);
		
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1, supervisor2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT, -10, solution);
		
		supervisor2.setNotPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT, -20, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsSupervisorsPreferredTimeslot() {
		System.out.println("Running: testDefenseOnAuthorsSupervisorsPreferredTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT, 0, solution);
		
		supervisor1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT, 0, solution);
		
		supervisor1.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT, 10, solution);
		
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1, supervisor2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT, 10, solution);
		
		supervisor2.setPreferredTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT, 20, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsSupervisorsUnavailableTimeslot() {
		System.out.println("Running: testDefenseOnAuthorsSupervisorsUnavailableTimeslot");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT, 0, solution);
		
		supervisor1.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT, 0, solution);
		
		supervisor1.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT, -10, solution);
		
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1, supervisor2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT, -10, solution);
		
		supervisor2.setUnavailableTimeslotSet(new LinkedHashSet<>(Arrays.asList(timeslot1, timeslot2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT, -20, solution);
	}

	@Test
	public void testDefenseOnAuthorsNotPreferredTimeslotTag() {
		System.out.println("Running: testDefenseOnAuthorsNotPreferredTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG, -10, solution);
		
		author1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG, 0, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG, 0, solution);
		
		author1.setNotPreferredTimeslotTagSet(Collections.emptySet());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG, 0, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsPreferredTimeslotTag() {
		System.out.println("Running: testDefenseOnAuthorsPreferredTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG, 0, solution);
		
		author1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG, 10, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG, 10, solution);
		
		author1.setPreferredTimeslotTagSet(Collections.emptySet());
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG, 0, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsUnavailableTimeslotTag() {
		System.out.println("Running: testDefenseOnAuthorsUnavailableTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		author1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		author1.setUnavailableTimeslotTagSet(Collections.emptySet());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
	}
	
	@Test
	public void testDefenseOnCommissionMembersNotPreferredTimeslotTag() {
		System.out.println("Running: testDefenseOnCommissionMembersNotPreferredTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG, -30, solution);
		
		commitee1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG, -20, solution);
		
		commitee2.setNotPreferredTimeslotTagSet(Collections.emptySet());

		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG, -10, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG, -10, solution);
	}
	
	@Test
	public void testDefenseOnCommissionMembersPreferredTimeslotTag() {
		System.out.println("Running: testDefenseOnCommissionMembersPreferredTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG, 0, solution);
		
		commitee1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG, 10, solution);
		
		commitee2.setPreferredTimeslotTagSet(Collections.emptySet());

		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG, 10, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG, 10, solution);
	}
	
	@Test
	public void testDefenseOnCommissionMembersUnavailableTimeslotTag() {
		System.out.println("Running: testDefenseOnCommissionMembersUnavailableTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Arrays.asList(commitee1, commitee2, commitee3))
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		commitee1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		commitee2.setUnavailableTimeslotTagSet(Collections.emptySet());

		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag() {
		System.out.println("Running: testDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG, -10, solution);
		
		supervisor1.setNotPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Teisipäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG, 0, solution);
		
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1, supervisor2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG, -10, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG, -10, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsSupervisorsPreferredTimeslotTag() {
		System.out.println("Running: testDefenseOnAuthorsSupervisorsPreferredTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG, 0, solution);
		
		supervisor1.setPreferredTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG, 10, solution);
		
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1, supervisor2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG, 10, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG, 10, solution);
	}
	
	@Test
	public void testDefenseOnAuthorsSupervisorsUnavailableTimeslotTag() {
		System.out.println("Running: testDefenseOnAuthorsSupervisorsUnavailableTimeslotTag");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Collections.singletonList(defenseType1))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG, 0, solution);
		
		supervisor1.setUnavailableTimeslotTagSet(new LinkedHashSet<>(Arrays.asList("Esmaspäev")));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG, -10, solution);
		
		author1.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1, supervisor2)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG, -10, solution);
		
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG, -10, solution);
	}
	// seda Drools'i meetodit pole enam olemas
	/*
	@Test
	public void testClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch() {
		System.out.println("Running: testClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Arrays.asList(defenseType1, defenseType2))
				.withDefenseList(Arrays.asList(defense1))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Collections.emptyList())
				.withThesisSupervisorList(Collections.emptyList());
		
		System.out.println("Siin ma kontrollin kas kaitsmise timeslot on sama mis kinnise kaitsmise tüübi sees");
		System.out.println(defense1.getDefenseType().getType());
		System.out.println(defense1.getTimeslot());
		System.out.println(defense1.getDefenseType().getCompatibleTimeslotSet());
		
		scoreVerifier.assertSoftWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH, -10, solution);
		
		defense1.setDefenseType(defenseType2);
		
		scoreVerifier.assertSoftWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH, -10, solution);
		
		defense1.setDefenseType(defenseType1);
		defense1.setTimeslot(timeslot2);
		
		scoreVerifier.assertSoftWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH, 0, solution);
		
		timeslot2.setStartTime(LocalTime.of(8, 30));
		timeslot2.setEndTime(LocalTime.of(8, 40));
		
		scoreVerifier.assertSoftWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH, 0, solution);
		
		defense1.setDefenseType(defenseType2);
		defense1.setTimeslot(timeslot1);
		timeslot2.setStartTime(LocalTime.of(17, 30));
		timeslot2.setEndTime(LocalTime.of(17, 40));
		
		scoreVerifier.assertSoftWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH, -10, solution);
	}
	*/
	/*
	DEFENSE_GROUPED_BY_SAME_THESIS_THEME = "Defense grouped by same thesis theme";
	public static final String DEFENSE_AUTHORS_GROUPED_BY_COMMON_SUPERVISOR 
	*/
	@Test
	public void testDefenseAuthorsGroupedByCommonSupervisor() {
		System.out.println("Running: testDefenseAuthorsGroupedByCommonSupervisor");
		
		TimetableSolution solution = new TimetableSolution(1L)
				.withConstraintConfiguration(new TimetableConstraintConfiguration(1L))
				.withDefenseTypeList(Arrays.asList(defenseType1, defenseType2))
				.withDefenseList(Arrays.asList(defense1, defense2))
				.withTimeslotList(Arrays.asList(timeslot1, timeslot2))
				.withCommiteeList(Collections.emptyList())
				.withThesisAuthorList(Arrays.asList(author1, author2))
				.withThesisSupervisorList(Arrays.asList(supervisor1, supervisor2));
		
		supervisor2.setRole("Peajuhendaja");

		scoreVerifier.assertSoftWeight(DEFENSE_AUTHORS_GROUPED_BY_COMMON_SUPERVISOR, 0, solution);
		
		author2.setThesisSupervisorSet(new LinkedHashSet<>(Arrays.asList(supervisor1)));
		
		scoreVerifier.assertSoftWeight(DEFENSE_AUTHORS_GROUPED_BY_COMMON_SUPERVISOR, 20, solution);
		
	}
	
	@Test
	public void testDefenseGroupedBySameThesisTheme() {
		System.out.println("Running: testDefenseGroupedBySameThesisTheme");
		
	}
	
}
