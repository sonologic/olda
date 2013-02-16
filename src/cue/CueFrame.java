package cue;

public interface CueFrame {
	int getNumPoints();
	Point getPoint(int idx);
	CueColor getColor(int idx);
	void setPoint(int idx, Point p);
	void setColor(int idx, CueColor c);
	public String toString();
}
