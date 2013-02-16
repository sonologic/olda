package cue;

import java.util.Vector;

public class Palette {
	Vector<ColorRGB> colors = new Vector<ColorRGB>();
	
	public Palette(int size) {
		for(int i=0;i<size;i++)
			colors.add(new ColorRGB(0,0,0));
	}
	
	public void setIndex(int idx, CueColor c) {
		colors.elementAt(idx).setR(c.getR());
		colors.elementAt(idx).setG(c.getG());
		colors.elementAt(idx).setB(c.getB());
	}
	
	public CueColor getIndex(int idx) {
		return colors.elementAt(idx);
	}
}
