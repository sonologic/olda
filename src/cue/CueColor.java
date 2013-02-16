package cue;

import java.awt.Color;

public interface CueColor {
	public int getR();
	public int getG();
	public int getB();
	public boolean getBlank();
	public void setR(int r);
	public void setG(int g);
	public void setB(int b);
	public void setBlank(Boolean blank);
	public void setRGB(int r, int g, int b);
	public void setRGBblank(int r, int g, int b, Boolean blank);
	public Color getColor();
}
