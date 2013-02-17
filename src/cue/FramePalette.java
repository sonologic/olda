package cue;

import java.util.Vector;

public class FramePalette implements CueFrame {
	Vector<Point> points = new Vector<Point>();
	Vector<Integer> colors = new Vector<Integer>();
	Vector<Boolean> blank = new Vector<Boolean>();
	Palette p;

	public FramePalette(Palette p) {
		this.p = p;
	}
	
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
		//System.out.println("getColor "+Integer.toString(idx)+" - "+Integer.toString(colors.get(idx)));
		return p.getIndex(colors.get(idx));
	}
	
	public boolean getBlank(int idx) {
		return blank.get(idx);
	}

	@Override
	public void setPoint(int idx, Point p) {
		if(idx >= points.size()) {
			points.setSize(idx+1);
			colors.setSize(idx+1);
			blank.setSize(idx+1);
		}
		points.set(idx,p);
	}

	@Override
	public void setColor(int idx, CueColor c) {
		if(idx >= points.size()) {
			points.setSize(idx+1);
			colors.setSize(idx+1);
			blank.setSize(idx+1);
		}
		colors.set(idx,0);
		//System.out.println("=============");
	}
	
	public void setColorNumber(int idx, int no) {
		if(idx >= points.size()) {
			points.setSize(idx+1);
			colors.setSize(idx+1);
			blank.setSize(idx+1);
		}
		colors.set(idx,no);
	}
	
	public void setBlank(int idx, boolean blanking) {
		if(idx >= points.size()) {
			points.setSize(idx+1);
			colors.setSize(idx+1);
			blank.setSize(idx+1);
		}
		blank.set(idx, blanking);
	}
}
