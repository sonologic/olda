package cue;

import java.awt.Color;
import java.util.Vector;

public class FrameRGB implements CueFrame {
	Vector<Point> points = new Vector<Point>();
	Vector<CueColor> colors = new Vector<CueColor>();

	@Override
	public int getNumPoints() {
		return points.size();
	}

	@Override
	public Point getPoint(int idx) {
		return points.get(idx);
	}

	@Override
	public CueColor getColor(int idx) {
		return colors.get(idx);
	}

	@Override
	public void setPoint(int idx, Point p) {
		if(idx >= points.size()) {
			points.setSize(idx+1);
			colors.setSize(idx+1);
		}
		points.set(idx,p);
	}

	@Override
	public void setColor(int idx, CueColor c) {
		if(idx >= points.size()) {
			points.setSize(idx+1);
			colors.setSize(idx+1);
		}
		colors.set(idx,c);
	}

}
