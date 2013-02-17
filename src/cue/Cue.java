package cue;

import java.util.Vector;

public class Cue {
	Vector<CueFrame> frames = new Vector<CueFrame>();
	
	public void addFrame(CueFrame f) {
		frames.add(f);
	}
	
	public int size() {
		return frames.size();
	}
	
	public CueFrame getFrame(int idx) {
		return frames.get(idx);
	}
	
	
}
