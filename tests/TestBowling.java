import static org.junit.Assert.*;

import org.junit.Test;

import jdk.Exported;

public class TestBowling {
	
	
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/	
	
	@Test
	public void testFrame_InitialSetup_Frame_2_4_output_firstThrow2() throws BowlingException {
		Frame testFrame = new Frame(2,4);
		assertEquals(2, testFrame.getFirstThrow());
	}
	
	@Test
	public void testFrame_InitialSetup_Frame_2_4_output_SecondThrow4() throws BowlingException {
		Frame testFrame = new Frame(2,4);
		assertEquals(4, testFrame.getSecondThrow());
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidFirdtThrow_Exception() throws BowlingException {
		Frame testFrame = new Frame(11,4);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSecondThrow_Exception() throws BowlingException {
		Frame testFrame = new Frame(2,11);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSumOfThrows_Exception() throws BowlingException {
		Frame testFrame = new Frame(11,4);
	}
	
	
	@Test
	public void testFrame_score_InitialSetup_Frame_2_4_output_6() throws BowlingException {
		Frame testFrame = new Frame(2,4);
		assertEquals(6, testFrame.score());
	}
	
	@Test
	public void testFrame_score_InitialSetup_Frame_2_4_output_6() throws BowlingException {
		Frame testFrame = new Frame(2,4);
		assertEquals(6, testFrame.score());
	}

}
