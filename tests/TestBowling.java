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
	public void testFrame_InvalidFirdtThrow_Exception() throws BowlingException {
		Frame testFrame = new Frame(11,4);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSecondThrow_Exception() throws BowlingException {
		Frame testFrame = new Frame(2,11);
	}
	
	@Test(expected=BowlingException.class)
	public void testFrame_InvalidSumOfThrows_Exception() throws BowlingException {
		Frame testFrame = new Frame(5,6);
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
		System.out.println(game.getFrames().size());
		assertEquals(1, game.getExistingFrameByNr(1).getFirstThrow());
	}
	
	/*
	@Test
	public void testGame_add10Frames_returnFourthFrameSecondThrow() throws BowlingException {
		BowlingGame game = new BowlingGame();
		for (int i=0; i<10; i++) {
			game.addFrame(new Frame(0,i));
		}
		assertEquals(3, game.getExistingFrameByNr(3).getSecondThrow());
	}
*/
}
