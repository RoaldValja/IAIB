package thesistimetableplanning.domain;

import java.util.concurrent.atomic.AtomicLong;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import thesistimetableplanning.common.AbstractPersistable;

@ConstraintConfiguration(constraintPackage = "timetableplanning.solver")
public class TimetableConstraintConfiguration extends AbstractPersistable{

	public static final String COMMISSION_AT_LEAST_THREE_MEMBERS = "Commission at least three members";
	public static final String AUTHOR_PREREQUISITES_DONE = "Author prerequisites done";
	public static final String DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT = "Defense not on authors unavailable timeslot";
	public static final String DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT = "Defense not on commission members unavailable timeslot";
	public static final String DEFENSE_HAS_ONE_CHAIRMAN = "Defense has one chairman";
	
	public static final String DEFENSE_GROUPED_BY_SAME_THESIS_THEME = "Defense grouped by same thesis theme";
	public static final String DEFENSE_AUTHORS_GROUPED_BY_COMMON_SUPERVISOR = "Defense authors grouped by common supervisor";
	public static final String CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH = "Closed defenses at start or end day or at before or after lunch";	
	
	public static final String DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT = "Defense on authors preferred timeslot";
	public static final String DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT = "Defense not on authors not preferred timeslot";
	public static final String DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT = "Defense on commission members preferred timeslot";
	public static final String DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT = "Defense not on commission members not preferred timeslot";
	public static final String DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT = "Defense on authors supervisors preferred timeslot";
	public static final String DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT = "Defense not on authors supervisors not preferred timeslot";
	public static final String DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT = "Defense not on authors supervisors unavailable timeslot";
	
	public static final String DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG = "Defense on authors preferred timeslot tag";
	public static final String DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG = "Defense not on authors not preferred timeslot tag";
	public static final String DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG = "Defense not on authors unavailable timeslot tag";
	public static final String DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG = "Defense on commission members preferred timeslot tag";
	public static final String DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG = "Defense not on commission members not preferred timeslot tag";
	public static final String DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG = "Defense not on commission members unavailable timeslot tag";
	public static final String DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG = "Defense on authors supervisors preferred timeslot tag";
	public static final String DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG = "Defense not on authors supervisors not preferred timeslot tag";
	public static final String DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG = "Defense not on authors supervisors unavailable timeslot tag";
	
	public static final String COMMISSION_MEMBER_DOES_NOT_SWAP_WITH_A_NEW_MEMBER_ON_THE_SAME_DAY = "Commission member does not swap with a new member on the same day";


	@ConstraintWeight(COMMISSION_AT_LEAST_THREE_MEMBERS)
	private HardSoftScore commissionAtLeastThreeMembers = HardSoftScore.ofHard(10);
	@ConstraintWeight(AUTHOR_PREREQUISITES_DONE)
	private HardSoftScore authorPrerequisitesDone = HardSoftScore.ofHard(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT)
	private HardSoftScore defenseNotOnAuthorsUnavailableTimeslot = HardSoftScore.ofHard(10);
	@ConstraintWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT)
	private HardSoftScore defenseNotOnCommissionMembersUnavailableTimeslot = HardSoftScore.ofHard(10);
	@ConstraintWeight(DEFENSE_HAS_ONE_CHAIRMAN)
	private HardSoftScore defenseHasOneChairman = HardSoftScore.ofHard(10);
	
	@ConstraintWeight(DEFENSE_GROUPED_BY_SAME_THESIS_THEME)
	private HardSoftScore defenseGroupedBySameThesisTheme = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_AUTHORS_GROUPED_BY_COMMON_SUPERVISOR)
	private HardSoftScore defenseAuthorsGroupedByCommonSupervisor = HardSoftScore.ofSoft(10);
	@ConstraintWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH)
	private HardSoftScore closedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch = HardSoftScore.ofSoft(10);
	
	@ConstraintWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnAuthorsPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT)
	private HardSoftScore defenseNotOnAuthorsNotPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnCommissionMembersPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT)
	private HardSoftScore defenseNotOnCommissionMembersNotPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT)
	private HardSoftScore defenseNotOnAuthorsSupervisorsNotPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT)
	private HardSoftScore defenseNotOnAuthorsSupervisorsUnavailableTimeslot = HardSoftScore.ofSoft(10);
	
	@ConstraintWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseNotOnAuthorsNotPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG)
	private HardSoftScore defenseNotOnAuthorsUnavailableTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnCommissionMembersPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseNotOnCommissionMembersNotPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG)
	private HardSoftScore defenseNotOnCommissionMembersUnavailableTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_NOT_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG)
	private HardSoftScore defenseNotOnAuthorsSupervisorsUnavailableTimeslotTag = HardSoftScore.ofSoft(10);
	
	@ConstraintWeight(COMMISSION_MEMBER_DOES_NOT_SWAP_WITH_A_NEW_MEMBER_ON_THE_SAME_DAY)
	private HardSoftScore commissionMemberDoesNotSwapWithANewMemberOnTheSameDay = HardSoftScore.ofSoft(10);
	
	public TimetableConstraintConfiguration(){
		
	}
	
	public TimetableConstraintConfiguration(long id){
		super(id);
	}
	
    // ************************************************************************
    // Simple getters and setters
    // ************************************************************************

	public HardSoftScore getCommissionAtLeastThreeMembers(){
		return commissionAtLeastThreeMembers;
	}
	
	public void setCommissionAtLeastThreeMembers(HardSoftScore commissionAtLeastThreeMembers){
		this.commissionAtLeastThreeMembers = commissionAtLeastThreeMembers;
	}
	
	public HardSoftScore getAuthorPrerequisitesDone(){
		return authorPrerequisitesDone;
	}
	
	public void setAuthorPrerequisitesDone(HardSoftScore authorPrerequisitesDone){
		this.authorPrerequisitesDone = authorPrerequisitesDone;
	}

	public HardSoftScore getDefenseNotOnAuthorsUnavailableTimeslot() {
		return defenseNotOnAuthorsUnavailableTimeslot;
	}
	
	public void setDefenseNotOnAuthorsUnavailableTimeslot(HardSoftScore defenseNotOnAuthorsUnavailableTimeslot) {
		this.defenseNotOnAuthorsUnavailableTimeslot = defenseNotOnAuthorsUnavailableTimeslot;
	}

	public HardSoftScore getDefenseNotOnCommissionMembersUnavailableTimeslot() {
		return defenseNotOnCommissionMembersUnavailableTimeslot;
	}
	
	public void setDefenseNotOnCommissionMembersUnavailableTimeslot(HardSoftScore defenseNotOnCommissionMembersUnavailableTimeslot) {
		this.defenseNotOnCommissionMembersUnavailableTimeslot = defenseNotOnCommissionMembersUnavailableTimeslot;
	}
	
	public HardSoftScore getDefenseHasOneChairman(){
		return defenseHasOneChairman;
	}
	
	public void setDefenseHasOneChairman(HardSoftScore defenseHasOneChairman){
		this.defenseHasOneChairman = defenseHasOneChairman;
	}
	

	
	public HardSoftScore getDefenseGroupedBySameThesisTheme(){
		return defenseGroupedBySameThesisTheme;
	}
	
	public void setDefenseGroupedBySameThesisTheme(HardSoftScore defenseGroupedBySameThesisTheme){
		this.defenseGroupedBySameThesisTheme = defenseGroupedBySameThesisTheme;
	}

	public HardSoftScore getDefenseAuthorsGroupedByCommonSupervisor() {
		return defenseAuthorsGroupedByCommonSupervisor;
	}
	
	public void setDefenseAuthorsGroupedByCommonSupervisor(HardSoftScore defenseAuthorsGroupedByCommonSupervisor) {
		this.defenseAuthorsGroupedByCommonSupervisor = defenseAuthorsGroupedByCommonSupervisor;
	}
	
	public HardSoftScore getClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch(){
		return closedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch;
	}
	
	public void setClosedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch(HardSoftScore closedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch){
		this.closedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch = closedDefensesAtStartOrEndDayOrAtBeforeOrAfterLunch;
	}
	
	
	
	public HardSoftScore getDefenseOnAuthorsPreferredTimeslot() {
		return defenseOnAuthorsPreferredTimeslot;
	}
	
	public void setDefenseOnAuthorsPreferredTimeslot(HardSoftScore defenseOnAuthorsPreferredTimeslot) {
		this.defenseOnAuthorsPreferredTimeslot = defenseOnAuthorsPreferredTimeslot;
	}

	public HardSoftScore getDefenseNotOnAuthorsNotPreferredTimeslot() {
		return defenseNotOnAuthorsNotPreferredTimeslot;
	}
	
	public void setDefenseNotOnAuthorsNotPreferredTimeslot(HardSoftScore defenseNotOnAuthorsNotPreferredTimeslot) {
		this.defenseNotOnAuthorsNotPreferredTimeslot = defenseNotOnAuthorsNotPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnCommissionMembersPreferredTimeslot() {
		return defenseOnCommissionMembersPreferredTimeslot;
	}
	
	public void setDefenseOnCommissionMembersPreferredTimeslot(HardSoftScore defenseOnCommissionMembersPreferredTimeslot) {
		this.defenseOnCommissionMembersPreferredTimeslot = defenseOnCommissionMembersPreferredTimeslot;
	}

	public HardSoftScore getDefenseNotOnCommissionMembersNotPreferredTimeslot() {
		return defenseNotOnCommissionMembersNotPreferredTimeslot;
	}
	
	public void setDefenseNotOnCommissionMembersNotPreferredTimeslot(HardSoftScore defenseNotOnCommissionMembersNotPreferredTimeslot) {
		this.defenseNotOnCommissionMembersNotPreferredTimeslot = defenseNotOnCommissionMembersNotPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnAuthorsSupervisorsPreferredTimeslot() {
		return defenseOnAuthorsSupervisorsPreferredTimeslot;
	}
	
	public void setDefenseOnAuthorsSupervisorsPreferredTimeslot(HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslot) {
		this.defenseOnAuthorsSupervisorsPreferredTimeslot = defenseOnAuthorsSupervisorsPreferredTimeslot;
	}

	public HardSoftScore getDefenseNotOnAuthorsSupervisorsNotPreferredTimeslot() {
		return defenseNotOnAuthorsSupervisorsNotPreferredTimeslot;
	}
	
	public void setDefenseNotOnAuthorsSupervisorsNotPreferredTimeslot(HardSoftScore defenseNotOnAuthorsSupervisorsNotPreferredTimeslot) {
		this.defenseNotOnAuthorsSupervisorsNotPreferredTimeslot = defenseNotOnAuthorsSupervisorsNotPreferredTimeslot;
	}

	public HardSoftScore getDefenseNotOnAuthorsSupervisorsUnavailableTimeslot() {
		return defenseNotOnAuthorsSupervisorsUnavailableTimeslot;
	}
	
	public void setDefenseNotOnAuthorsSupervisorsUnavailableTimeslot(HardSoftScore defenseNotOnAuthorsSupervisorsUnavailableTimeslot) {
		this.defenseNotOnAuthorsSupervisorsUnavailableTimeslot = defenseNotOnAuthorsSupervisorsUnavailableTimeslot;
	}
	
	
	
	public HardSoftScore getDefenseOnAuthorsPreferredTimeslotTag(){
		return defenseOnAuthorsPreferredTimeslotTag;
	}
	
	public void setDefenseOnAuthorsPreferredTimeslotTag(HardSoftScore defenseOnAuthorsPreferredTimeslotTag){
		this.defenseOnAuthorsPreferredTimeslotTag = defenseOnAuthorsPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseNotOnAuthorsNotPreferredTimeslotTag(){
		return defenseNotOnAuthorsNotPreferredTimeslotTag;
	}
	
	public void setDefenseNotOnAuthorsNotPreferredTimeslotTag(HardSoftScore defenseNotOnAuthorsNotPreferredTimeslotTag){
		this.defenseNotOnAuthorsNotPreferredTimeslotTag = defenseNotOnAuthorsNotPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseNotOnAuthorsUnavailableTimeslotTag(){
		return defenseNotOnAuthorsUnavailableTimeslotTag;
	}
	
	public void setDefenseNotOnAuthorsUnavailableTimeslotTag(HardSoftScore defenseNotOnAuthorsUnavailableTimeslotTag){
		this.defenseNotOnAuthorsUnavailableTimeslotTag = defenseNotOnAuthorsUnavailableTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnCommissionMembersPreferredTimeslotTag(){
		return defenseOnCommissionMembersPreferredTimeslotTag;
	}
	
	public void setDefenseOnCommissionMembersPreferredTimeslotTag(HardSoftScore defenseOnCommissionMembersPreferredTimeslotTag){
		this.defenseOnCommissionMembersPreferredTimeslotTag = defenseOnCommissionMembersPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseNotOnCommissionMembersNotPreferredTimeslotTag(){
		return defenseNotOnCommissionMembersNotPreferredTimeslotTag;
	}
	
	public void setDefenseNotOnCommissionMembersNotPreferredTimeslotTag(HardSoftScore defenseNotOnCommissionMembersNotPreferredTimeslotTag){
		this.defenseNotOnCommissionMembersNotPreferredTimeslotTag = defenseNotOnCommissionMembersNotPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseNotOnCommissionMembersUnavailableTimeslotTag(){
		return defenseNotOnCommissionMembersUnavailableTimeslotTag;
	}
	
	public void setDefenseNotOnCommissionMembersUnavailableTimeslotTag(HardSoftScore defenseNotOnCommissionMembersUnavailableTimeslotTag){
		this.defenseNotOnCommissionMembersUnavailableTimeslotTag = defenseNotOnCommissionMembersUnavailableTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnAuthorsSupervisorsPreferredTimeslotTag(){
		return defenseOnAuthorsSupervisorsPreferredTimeslotTag;
	}
	
	public void setDefenseOnAuthorsSupervisorsPreferredTimeslotTag(HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslotTag){
		this.defenseOnAuthorsSupervisorsPreferredTimeslotTag = defenseOnAuthorsSupervisorsPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag(){
		return defenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag;
	}
	
	public void setDefenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag(HardSoftScore defenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag){
		this.defenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag = defenseNotOnAuthorsSupervisorsNotPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseNotOnAuthorsSupervisorsUnavailableTimeslotTag(){
		return defenseNotOnAuthorsSupervisorsUnavailableTimeslotTag;
	}
	
	public void setDefenseNotOnAuthorsSupervisorsUnavailableTimeslotTag(HardSoftScore defenseNotOnAuthorsSupervisorsUnavailableTimeslotTag){
		this.defenseNotOnAuthorsSupervisorsUnavailableTimeslotTag = defenseNotOnAuthorsSupervisorsUnavailableTimeslotTag;
	}
	
	public HardSoftScore getCommissionMemberDoesNotSwapWithANewMemberOnTheSameDay(){
		return commissionMemberDoesNotSwapWithANewMemberOnTheSameDay;
	}
	
	public void setCommissionMemberDoesNotSwapWithANewMemberOnTheSameDay(HardSoftScore commissionMemberDoesNotSwapWithANewMemberOnTheSameDay){
		this.commissionMemberDoesNotSwapWithANewMemberOnTheSameDay = commissionMemberDoesNotSwapWithANewMemberOnTheSameDay;
	}
    
}
