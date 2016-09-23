public class Frame {
	private int firstThrow;
	private int secondThrow;
	Frame subsequentFrame;
	
	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if (firstThrow < 0 || secondThrow < 0) {
			throw new BowlingException();
		} else if (firstThrow + secondThrow > 10) {
			throw new BowlingException();
		}
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//returns the score of a single frame
	public int score() {
		int score = firstThrow + secondThrow;
		
		/*
		 *  check if there is a subsequent frame
		 *   for the case of a strike or spare frame and calculate score for these cases
		 *  otherwise do nothing
		 */
		if (subsequentFrame != null && this.isStrike()) {					
			score += subsequentFrame.getFirstThrow() + subsequentFrame.getSecondThrow();
		} else if (subsequentFrame != null && this.isSpare()) {
			score += subsequentFrame.getFirstThrow();
		}
		
		return score; 
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if (firstThrow == 10) {
			return true;
		} else {
			return false;
		}
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare() {
		if ( ! this.isStrike() && this.score() == 10) {
			return true;
		} else {		
			return false;
		}
	}
	
	public void setSubsequentFrame(Frame subsequentFrame) {
		this.subsequentFrame = subsequentFrame;
	}
}
