import static org.junit.Assert.*;

import org.junit.Test;

import jdk.Exported;

public class TestBowling {
	
	BowlingGame game = new BowlingGame();
	
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/	
	
	/*
	 * 1. Frame
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
	public void testFrame_InvalidFirstThrow_Exception() throws BowlingException {
		Frame testFrame = new Frame(11,4);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSecondThrow_Exception() throws BowlingException {
		Frame testFrame = new Frame(2,11);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSumOfThrows_5_6_Exception() throws BowlingException {
		Frame testFrame = new Frame(5,6);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSumOfThrows_10_1_Exception() throws BowlingException {
		Frame testFrame = new Frame(10,1);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_NegativeFirstThrowValue_Exception() throws BowlingException {
		Frame testFrame = new Frame(-1,5);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_NegativeSecondThrowValue_Exception() throws BowlingException {
		Frame testFrame = new Frame(2,-10);
	}
	
	
	/*
	 * 2. Frame Score
	 */
	
	@Test
	public void testFrame_score_InitialSetup_Frame_2_4_output_6() throws BowlingException {
		Frame testFrame = new Frame(2,4);
		assertEquals(6, testFrame.score());
	}
	
	@Test
	public void testFrame_score_InitialSetup_Frame_7_1_output_8() throws BowlingException {
		Frame testFrame = new Frame(7,1);
		assertEquals(8, testFrame.score());
	}
	
	
	/*
	 * 3. Game
	 */
	
	@Test
	public void testGame_add3Frames_returnSecondFrameFirstThrow() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(0,4));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(2,8));
		assertEquals(1, game.getExistingFrameByNr(1).getFirstThrow());
	}
	
	@Test
	public void testGame_add10Frames_returnFourthFrameSecondThrow() throws BowlingException {
		BowlingGame game = new BowlingGame();
		for (int i=0; i<10; i++) {
			game.addFrame(new Frame(0,i));
		}
		assertEquals(3, game.getExistingFrameByNr(3).getSecondThrow());
	}
	
	
	/*
	 * 4. Game Score
	 */
	
	@Test
	public void testGame_score_10Frames_Score_81() throws BowlingException {
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(81, game.score());
	}
	
	@Test
	public void testGame_score_1Frame_Score_10() throws BowlingException {
		game.addFrame(new Frame(5,5));
		assertEquals(10, game.score());
	}
	
	@Test
	public void testGame_score_10Frames_Score_0() throws BowlingException {
		for (int i=0; i<10; i++) {
			game.addFrame(new Frame(0,0));
		}
		assertEquals(0, game.score());
	}
	
	
	/*
	 * Strike
	 */
	
	@Test
	public void testGame_strike_FirstThrow10() throws BowlingException {
		Frame strikeFrame = new Frame(10,0);
		assertEquals(true, strikeFrame.isStrike());
	}
	
	@Test
	public void testGame_NoStrike_FirstThrow9() throws BowlingException {
		Frame strikeFrame = new Frame(9,1);
		assertEquals(false, strikeFrame.isStrike());
	}
	
	@Test
	public void testGame_1Strike_Sum_94() {
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		
		assertEquals(94, game.score());
		fail();
	}

}
