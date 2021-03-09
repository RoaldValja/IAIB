package thesistimetableplanning;

import java.util.ArrayList;
import java.util.List;

import thesistimetableplanning.domain.Commitee;
import thesistimetableplanning.domain.Defense;
import thesistimetableplanning.domain.Timeslot;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		List<Commitee> commiteeList = new ArrayList();
		Commitee c1 = new Commitee();
		c1.isChairman();
		c1.setName("Roald");
		Commitee c2 = new Commitee();
		c2.setName("Ralf");
		Commitee c3 = new Commitee();
		c3.setName("Allan");
		Commitee c4 = new Commitee();
		c4.setName("Karl");
		Commitee c5 = new Commitee();
		c5.setName("Margus");
		Commitee c6 = new Commitee();
		c6.setName("Oleg");
		Commitee c7 = new Commitee();
		c7.isChairman();
		c7.setName("Mari");
		commiteeList.add(c1);
		commiteeList.add(c2);
		commiteeList.add(c3);
		commiteeList.add(c4);
		commiteeList.add(c5);
		commiteeList.add(c6);
		commiteeList.add(c7);
		Timeslot timeslot1 = new Timeslot();
		timeslot1.setSession(1);
		Timeslot timeslot2 = new Timeslot();
		timeslot2.setSession(2);
		Defense defense = new Defense();
		defense.setCommissionSize(3);
		defense.setCommiteeList(commiteeList);
		defense.setTimeslot(timeslot1);
		defense.setCommission3();
		Defense defense2 = new Defense();
		defense2.setCommissionSize(3);
		defense2.setCommiteeList(commiteeList);
		defense2.setTimeslot(timeslot2);
		defense2.setCommission3();
		System.out.println("esimese kaitsmise komisjon:");
		Commitee[] commiteeArray = defense.getCommission3();
		for(Commitee commitee: commiteeArray) {
			System.out.println(commitee.getName());
		}
		System.out.println("teise kaitsmise komisjon:");
		commiteeArray = defense2.getCommission3();
		for(Commitee commitee: commiteeArray) {
			System.out.println(commitee.getName());
		}
	}

}
