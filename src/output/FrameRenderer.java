package output;

import cue.Cue;
import cue.CueFrame;

public interface FrameRenderer {
	public void setCue(Cue c);
	public CueFrame getFrame(int idx);
}
