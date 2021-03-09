package thesistimetableplanning.domain;

import java.util.HashMap;

public final class SessionCommission {

	private static HashMap<Integer, Commitee[]> commissions = new HashMap<Integer, Commitee[]>();
	//private int session;
	//private Commitee[] commissionArray;
	
	/*
	public SessionCommission(int session, Commitee[] commissionArray) {
		//this.session = session;
		//this.commissionArray = commissionArray;
		commissions.put(session, commissionArray);
	}
	*/
	/*
	public int getSession() {
		return session;
	}
	*/
	/*
	public Commitee[] getCommissionArray() {
		return commissionArray;
	}
	*/
	
	public static void putCommission(int session, Commitee[] commissionArray) {
		commissions.put(session, commissionArray);
	}
	
	public static Commitee[] getCommission(int session) {
		return commissions.get(session);
	}
	
	public static int getCommissionMapSize() {
		return commissions.size();
	}
	
	public static void clearCommissionMap() {
		commissions.clear();
	}
	
	public static Commitee getCommissionChairman(int session) {
		Commitee[] commissionArray = commissions.get(session);
		for(Commitee commitee: commissionArray) {
			if(commitee.getChairman()) {
				return commitee;
			}
		}
		return null;
	}
	
}
