import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	// Returns the game score
	public int score(){
		int sum = 0;
		for (int i=0; i < frames.size(); i++) {
			sum += frames.get(i).score();
			
			/*
			 *  check if there is a subsequent frame
			 *   for the case of a strike or spare frame and calculate score for these cases
			 *  otherwise do nothing
			 */
			Frame subsequentFrame;
			if (i + 1 < frames.size()) {
				subsequentFrame = frames.get(i + 1);
				
				if (frames.get(i).isStrike()) {					
					sum += subsequentFrame.getFirstThrow() + subsequentFrame.getSecondThrow();
				} else if (frames.get(i).isSpare()) {
					sum += subsequentFrame.getFirstThrow();
				}
			}
		}
		return sum;
	}
	
	// frame number zero-based
	public Frame getExistingFrameByNr(int frameNr) throws BowlingException {
		if (frameNr <= frames.size()) {
			return frames.get(frameNr);
		} else {
			throw new BowlingException();
		}
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
}
