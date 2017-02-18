package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import gameplay.Schedule;

public class ScheduleTests {
	static Schedule schedule;

	@BeforeClass
	public static void init(){
		schedule = new Schedule();
	}

	@Test
	public void test() {
		ArrayList<Integer> foundInt = new ArrayList<Integer>();
		ArrayList<String> foundBin = new ArrayList<String>();
		
		// Tests that there are no repeat numbers in the schedule
		for (int i : schedule.getDecimal()){
			assertFalse(foundInt.contains(i));
			foundInt.add(i);
		}
		for (String s : schedule.getBinary()){
			assertFalse(foundBin.contains(s));
			foundBin.add(s);
		}
		
		assertEquals(0, schedule.getBinary().size());
		assertEquals(7, schedule.getDecimal().size());
	}

}
