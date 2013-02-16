package output;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import cue.CueColor;
import cue.CueFrame;
import cue.Point;

public class PreviewCanvas extends Canvas {
	private static final long serialVersionUID = -4809410127655753581L;
	Preview p;
	int w;
	int h;

  public Dimension getMinimumSize() {
	    return new Dimension(50, 100);  
	  }

	  public Dimension getPreferredSize() {
	    return new Dimension(150, 300);  
	  }

	  public Dimension getMaximumSize() {
	    return new Dimension(200, 400);  
	  }
		  
	public PreviewCanvas(Preview p) {
		this.p = p;
		System.out.println("new previewcanvas");
	}
	
	public int scaleX(int x)
	{
		return (w * (x + 32768))/ 65535;
	}
	public int scaleY(int y)
	{
		return h - ((h * (y + 32768))/ 65535);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		this.h = getSize().height;
		this.w = getSize().width;
		
		CueFrame f = p.getFrame();
		
		Image buffer = createImage(w, h);
		Graphics offscreen = buffer.getGraphics();
		
		this.setBackground(new Color(0,0,0));
		//System.out.println("paint");
		//System.out.println(getSize().width);
		//System.out.println(getSize().height);
		//System.out.println(f.toString());
		
		//g.drawLine(0,0,getSize().width,0);
		//g.drawLine(getSize().width,0,getSize().width,getSize().height);
		//g.drawLine(getSize().width,getSize().height,0,getSize().height);
		//g.drawLine(0,getSize().height,0,0);
		
		if(f.getNumPoints()==0)
			return;
		
		Point lastPoint = f.getPoint(0);
		CueColor lastColor = f.getColor(0);
		
		for(int i=1; i<f.getNumPoints();i++) {
			Point point = f.getPoint(i);
			if(!lastColor.getBlank()) {
				offscreen.setColor(lastColor.getColor());

				//System.out.println(scaleX(lastPoint.getX()));
				//System.out.println(scaleY(lastPoint.getY()));
				offscreen.drawLine(
						scaleX(lastPoint.getX()), 
						scaleY(lastPoint.getY()), 
						scaleX(point.getX()), 
						scaleY(point.getY())
				);
			}
			lastPoint = point;
			lastColor = f.getColor(i);
		}
		g.drawImage(buffer,0,0,this);
	}
	
	//g.drawImage(buffer,0,0,this);
	
}
