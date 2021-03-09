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
	

	@ConstraintWeight(COMMISSION_AT_LEAST_THREE_MEMBERS)
	private HardSoftScore commissionAtLeastThreeMembers = HardSoftScore.ofHard(10);
	@ConstraintWeight(AUTHOR_PREREQUISITES_DONE)
	private HardSoftScore authorPrerequisitesDone = HardSoftScore.ofHard(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_UNAVAILABLE_TIMESLOT)
	private HardSoftScore defenseOnAuthorsUnavailableTimeslot = HardSoftScore.ofHard(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT)
	private HardSoftScore defenseOnCommissionMembersUnavailableTimeslot = HardSoftScore.ofHard(10);
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
	@ConstraintWeight(DEFENSE_ON_AUTHORS_NOT_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnAuthorsNotPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnCommissionMembersPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnCommissionMembersNotPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT)
	private HardSoftScore defenseOnAuthorsSupervisorsNotPreferredTimeslot = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT)
	private HardSoftScore defenseOnAuthorsSupervisorsUnavailableTimeslot = HardSoftScore.ofSoft(10);
	
	@ConstraintWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_NOT_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsNotPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_UNAVAILABLE_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsUnavailableTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnCommissionMembersPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_NOT_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnCommissionMembersNotPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_UNAVAILABLE_TIMESLOT_TAG)
	private HardSoftScore defenseOnCommissionMembersUnavailableTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_NOT_PREFERRED_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsSupervisorsNotPreferredTimeslotTag = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_UNAVAILABLE_TIMESLOT_TAG)
	private HardSoftScore defenseOnAuthorsSupervisorsUnavailableTimeslotTag = HardSoftScore.ofSoft(10);
	
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

	public HardSoftScore getDefenseOnAuthorsUnavailableTimeslot() {
		return defenseOnAuthorsUnavailableTimeslot;
	}
	
	public void setDefenseOnAuthorsUnavailableTimeslot(HardSoftScore defenseOnAuthorsUnavailableTimeslot) {
		this.defenseOnAuthorsUnavailableTimeslot = defenseOnAuthorsUnavailableTimeslot;
	}

	public HardSoftScore getDefenseOnCommissionMembersUnavailableTimeslot() {
		return defenseOnCommissionMembersUnavailableTimeslot;
	}
	
	public void setDefenseOnCommissionMembersUnavailableTimeslot(HardSoftScore defenseOnCommissionMembersUnavailableTimeslot) {
		this.defenseOnCommissionMembersUnavailableTimeslot = defenseOnCommissionMembersUnavailableTimeslot;
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

	public HardSoftScore getDefenseOnAuthorsNotPreferredTimeslot() {
		return defenseOnAuthorsNotPreferredTimeslot;
	}
	
	public void setDefenseOnAuthorsNotPreferredTimeslot(HardSoftScore defenseOnAuthorsNotPreferredTimeslot) {
		this.defenseOnAuthorsNotPreferredTimeslot = defenseOnAuthorsNotPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnCommissionMembersPreferredTimeslot() {
		return defenseOnCommissionMembersPreferredTimeslot;
	}
	
	public void setDefenseOnCommissionMembersPreferredTimeslot(HardSoftScore defenseOnCommissionMembersPreferredTimeslot) {
		this.defenseOnCommissionMembersPreferredTimeslot = defenseOnCommissionMembersPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnCommissionMembersNotPreferredTimeslot() {
		return defenseOnCommissionMembersNotPreferredTimeslot;
	}
	
	public void setDefenseOnCommissionMembersNotPreferredTimeslot(HardSoftScore defenseOnCommissionMembersNotPreferredTimeslot) {
		this.defenseOnCommissionMembersNotPreferredTimeslot = defenseOnCommissionMembersNotPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnAuthorsSupervisorsPreferredTimeslot() {
		return defenseOnAuthorsSupervisorsPreferredTimeslot;
	}
	
	public void setDefenseOnAuthorsSupervisorsPreferredTimeslot(HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslot) {
		this.defenseOnAuthorsSupervisorsPreferredTimeslot = defenseOnAuthorsSupervisorsPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnAuthorsSupervisorsNotPreferredTimeslot() {
		return defenseOnAuthorsSupervisorsNotPreferredTimeslot;
	}
	
	public void setDefenseOnAuthorsSupervisorsNotPreferredTimeslot(HardSoftScore defenseOnAuthorsSupervisorsNotPreferredTimeslot) {
		this.defenseOnAuthorsSupervisorsNotPreferredTimeslot = defenseOnAuthorsSupervisorsNotPreferredTimeslot;
	}

	public HardSoftScore getDefenseOnAuthorsSupervisorsUnavailableTimeslot() {
		return defenseOnAuthorsSupervisorsUnavailableTimeslot;
	}
	
	public void setDefenseOnAuthorsSupervisorsUnavailableTimeslot(HardSoftScore defenseOnAuthorsSupervisorsUnavailableTimeslot) {
		this.defenseOnAuthorsSupervisorsUnavailableTimeslot = defenseOnAuthorsSupervisorsUnavailableTimeslot;
	}
	
	
	
	public HardSoftScore getDefenseOnAuthorsPreferredTimeslotTag(){
		return defenseOnAuthorsPreferredTimeslotTag;
	}
	
	public void setDefenseOnAuthorsPreferredTimeslotTag(HardSoftScore defenseOnAuthorsPreferredTimeslotTag){
		this.defenseOnAuthorsPreferredTimeslotTag = defenseOnAuthorsPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnAuthorsNotPreferredTimeslotTag(){
		return defenseOnAuthorsNotPreferredTimeslotTag;
	}
	
	public void setDefenseOnAuthorsNotPreferredTimeslotTag(HardSoftScore defenseOnAuthorsNotPreferredTimeslotTag){
		this.defenseOnAuthorsNotPreferredTimeslotTag = defenseOnAuthorsNotPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnAuthorsUnavailableTimeslotTag(){
		return defenseOnAuthorsUnavailableTimeslotTag;
	}
	
	public void setDefenseOnAuthorsUnavailableTimeslotTag(HardSoftScore defenseOnAuthorsUnavailableTimeslotTag){
		this.defenseOnAuthorsUnavailableTimeslotTag = defenseOnAuthorsUnavailableTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnCommissionMembersPreferredTimeslotTag(){
		return defenseOnCommissionMembersPreferredTimeslotTag;
	}
	
	public void setDefenseOnCommissionMembersPreferredTimeslotTag(HardSoftScore defenseOnCommissionMembersPreferredTimeslotTag){
		this.defenseOnCommissionMembersPreferredTimeslotTag = defenseOnCommissionMembersPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnCommissionMembersNotPreferredTimeslotTag(){
		return defenseOnCommissionMembersNotPreferredTimeslotTag;
	}
	
	public void setDefenseOnCommissionMembersNotPreferredTimeslotTag(HardSoftScore defenseOnCommissionMembersNotPreferredTimeslotTag){
		this.defenseOnCommissionMembersNotPreferredTimeslotTag = defenseOnCommissionMembersNotPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnCommissionMembersUnavailableTimeslotTag(){
		return defenseOnCommissionMembersUnavailableTimeslotTag;
	}
	
	public void setDefenseOnCommissionMembersUnavailableTimeslotTag(HardSoftScore defenseOnCommissionMembersUnavailableTimeslotTag){
		this.defenseOnCommissionMembersUnavailableTimeslotTag = defenseOnCommissionMembersUnavailableTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnAuthorsSupervisorsPreferredTimeslotTag(){
		return defenseOnAuthorsSupervisorsPreferredTimeslotTag;
	}
	
	public void setDefenseOnAuthorsSupervisorsPreferredTimeslotTag(HardSoftScore defenseOnAuthorsSupervisorsPreferredTimeslotTag){
		this.defenseOnAuthorsSupervisorsPreferredTimeslotTag = defenseOnAuthorsSupervisorsPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag(){
		return defenseOnAuthorsSupervisorsNotPreferredTimeslotTag;
	}
	
	public void setDefenseOnAuthorsSupervisorsNotPreferredTimeslotTag(HardSoftScore defenseOnAuthorsSupervisorsNotPreferredTimeslotTag){
		this.defenseOnAuthorsSupervisorsNotPreferredTimeslotTag = defenseOnAuthorsSupervisorsNotPreferredTimeslotTag;
	}
	
	public HardSoftScore getDefenseOnAuthorsSupervisorsUnavailableTimeslotTag(){
		return defenseOnAuthorsSupervisorsUnavailableTimeslotTag;
	}
	
	public void setDefenseOnAuthorsSupervisorsUnavailableTimeslotTag(HardSoftScore defenseOnAuthorsSupervisorsUnavailableTimeslotTag){
		this.defenseOnAuthorsSupervisorsUnavailableTimeslotTag = defenseOnAuthorsSupervisorsUnavailableTimeslotTag;
	}
    
}
