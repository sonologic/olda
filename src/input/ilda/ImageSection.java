package input.ilda;

import java.io.IOException;
import java.util.Vector;

import cue.ColorRGB;
import cue.CueFrame;
import cue.FrameRGB;
import cue.Point;

public class ImageSection extends Section {
	public static final int IMAGE_2D = 2;
	public static final int IMAGE_3D = 3;
	
	private int type = IMAGE_3D;
	
	String name;
	String company;
	int frameNo = -1;
	int totalFrames = -1;
	int scannerHead = -1;
	
	Vector<Point> points = new Vector<Point>();
	Vector<Integer> status = new Vector<Integer>();
	
	public ImageSection(int type) {
		this.type = type;
	}
	
	public void setPoint(int idx, Point p) {
		points.set(idx, p);
	}
	
	public void setStatus(int idx, int statusCode) {
		status.set(idx, statusCode);
	}
	
	public Point getPoint(int idx) {
		return points.get(idx);
	}
	
	public int getStatus(int idx) {
		return status.get(idx);
	}

	@Override
	public void read(SectionReader r) throws IOException, Exception {
		this.name = r.readString(8);
		this.company = r.readString(8);
		int numPoints = r.readU16();
		//System.out.println(Integer.toHexString(numPoints));
		frameNo = r.readU16();
		totalFrames = r.readU16();
		scannerHead = r.readU8();
		r.readU8(); // reserved byte
		//System.out.println(numPoints);
		//numPoints=10;
		for(int i=0;i<numPoints;i++) {
			Point p = new Point();
			p.setX(r.readS16());
			p.setY(r.readS16());
			if(type == IMAGE_3D)
				p.setZ(r.readS16());
			points.add(p);
			status.add(r.readU16());
		}
	}
	
	public CueFrame toFrame() {
		CueFrame f = new FrameRGB();
		
		for(int i=0; i<points.size(); i++) {
			f.setPoint(i, points.get(i));
			if( (status.get(i)&0x4000) == 0x4000)
				f.setColor(i, new ColorRGB(128,128,128,true));
			else
				f.setColor(i, new ColorRGB(255,255,255,false));
		}
		
		return f;
	}
	
	public String toString() {
		String s = new String();

		if(type == IMAGE_2D)
			s = s.concat("ILDA 2D IMAGE\n");
		else
			s = s.concat("ILDA 3D IMAGE\n");
		s = s.concat("- name: ").concat(name).concat("\n");
		s = s.concat("- company: ").concat(company).concat("\n");
		s = s.concat("- points: ").concat(new Integer(points.size()).toString()).concat("\n");
		s = s.concat("- frameno: ").concat(new Integer(frameNo).toString()).concat("\n");
		s = s.concat("- frames: ").concat(new Integer(totalFrames).toString()).concat("\n");
		s = s.concat("- head: ").concat(new Integer(scannerHead).toString()).concat("\n");
		
		s = s.concat("- points: ").concat("\n");
		for(int i=0;i<points.size();i++) {
			s = s.concat("(");
			s = s.concat(new Integer(points.get(i).getX()).toString());
			s = s.concat(",");
			s = s.concat(new Integer(points.get(i).getY()).toString());
			if(type == IMAGE_3D) {
				s = s.concat(",");
				s = s.concat(new Integer(points.get(i).getZ()).toString());
			}
			s = s.concat(") ");
		}
		s = s.concat("\n");
		
		return s;
	}
}
