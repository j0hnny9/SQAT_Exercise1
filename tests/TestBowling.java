import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {
	
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testFrame_InitialSetup_Frame_2_4_output_firstThrow2() {
		Frame testFrame = new Frame(2,4);
		assertEquals(2, testFrame.getFirstThrow());
	}
	
	@Test
	public void testFrame_InitialSetup_Frame_2_4_output_SecondThrow4() {
		Frame testFrame = new Frame(2,4);
		assertEquals(2, testFrame.getSecondThrow()());
	}
	

}
