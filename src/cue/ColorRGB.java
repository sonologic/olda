package cue;

import java.awt.Color;

public class ColorRGB implements CueColor {
	public int r;
	public int g;
	public int b;
	boolean blank;
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 */
	public ColorRGB(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.blank = false;
	}
	
	public ColorRGB(int r, int g, int b, boolean blank) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.blank = blank;
	}
	
	
	public void setRGB(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}
	/**
	 * @return the g
	 */
	public int getG() {
		return g;
	}
	/**
	 * @param g the g to set
	 */
	public void setG(int g) {
		this.g = g;
	}
	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	@Override
	public boolean getBlank() {
		return this.blank;
	}

	@Override
	public void setBlank(Boolean blank) {
		this.blank = blank;
	}

	@Override
	public void setRGBblank(int r, int g, int b, Boolean blank) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.blank = blank;
	}
	
	public Color getColor() {
		return new Color(this.r, this.g, this.b);
	}
}
