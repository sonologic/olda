package output;

import java.awt.Canvas;

import cue.CueFrame;

public class Preview implements FrameRenderer {
	CueFrame f = null;
	PreviewCanvas c = null;
	
	public Preview(CueFrame f) {
		this.f = f;
		c = new PreviewCanvas(this);
	}
	
	@Override
	public void setFrame(CueFrame f) {
		this.f = f;
	}

	@Override
	public CueFrame getFrame() {
		return this.f;
	}
	
	public Canvas getCanvas() {
		return this.c;
	}

}
