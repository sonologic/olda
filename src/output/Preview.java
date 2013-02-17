package output;

import java.awt.Canvas;

import cue.Cue;
import cue.CueFrame;

public class Preview implements FrameRenderer {
	Cue cue = null;
	PreviewCanvas canvas = null;
	int currentFrame = 0;
	
	public Preview() {
		cue = null;
		canvas = new PreviewCanvas(this);
	}
	
	public Preview(Cue c) {
		cue = c;
		canvas = new PreviewCanvas(this);
	}

	public void setCue(Cue c) {
		this.cue = c;
	}

	public CueFrame getCurrentFrame() {
		return this.cue.getFrame(currentFrame);
	}
	@Override
	public CueFrame getFrame(int idx) {
		return this.cue.getFrame(idx);
	}
	
	public Cue getCue() {
		return this.cue;
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public void setCurrentFrame(int idx) {
		currentFrame=idx;
	}
	
	public void incFrame() {
		currentFrame++;
		if(!(currentFrame<cue.size()))
				currentFrame=0;
	}

}
