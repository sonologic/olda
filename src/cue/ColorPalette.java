package cue;

public class ColorPalette implements CueColor {
	Palette p;
	int idx;
	
	public ColorPalette(Palette p, int idx) {
		this.p = p;
		this.idx = idx;
	}
	
	@Override
	public int getR() {
		return p.getIndex(this.idx).getR();
	}

	@Override
	public int getG() {
		return p.getIndex(this.idx).getG();
	}

	@Override
	public int getB() {
		return p.getIndex(this.idx).getB();
	}

	@Override
	public void setR(int r) {
		this.p.getIndex(this.idx).setR(r);
	}

	@Override
	public void setG(int g) {
		this.p.getIndex(this.idx).setG(g);
	}

	@Override
	public void setB(int b) {
		this.p.getIndex(this.idx).setB(b);
	}

	@Override
	public void setRGB(int r, int g, int b) {
		CueColor c = this.p.getIndex(this.idx);
		c.setRGB(r,g,b);
	}

	@Override
	public boolean getBlank() {
		return this.p.getIndex(this.idx).getBlank();
	}

	@Override
	public void setBlank(Boolean blank) {
		this.p.getIndex(this.idx).setBlank(blank);
	}

	@Override
	public void setRGBblank(int r, int g, int b, Boolean blank) {
		this.p.getIndex(this.idx).setRGBblank(r,g,b,blank);
	}

}
