package ui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Vector;

import output.Preview;
import output.PreviewCanvas;
import cue.Cue;

public class CuePreviewGrid extends Panel {
	private static final long serialVersionUID = 1L;
	Vector<Preview> contents = new Vector<Preview>();
	int w;
	int h;

	public CuePreviewGrid(int w, int h) {
		this.w = w;
		this.h = h;
		setLayout(new GridLayout(w,h));
		for(int y=0;y<h;y++) {
			for(int x=0;x<w;x++) {
				Preview p = new Preview();
				((PreviewCanvas)p.getCanvas()).xPos = x*200;
				((PreviewCanvas)p.getCanvas()).yPos = y*200;
				contents.add(p);
				add(p.getCanvas());
			}
		}
	}
	
	public void setCue(int x, int y, Cue cue) {
		contents.get((y*w)+x).setCue(cue);
	}

	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		for(int i=0;i<contents.size();i++) {
			if(contents.get(i).getCue()!=null)
				contents.get(i).getCanvas().repaint();
		}
	}
	
	public void incFrame() {
		for(int i=0;i<contents.size();i++) {
			if(contents.get(i).getCue()!=null)
				contents.get(i).incFrame();
		}		
	}
}
