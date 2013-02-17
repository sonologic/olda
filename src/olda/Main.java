/**
 * 
 */
package olda;

import input.ilda.File;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import output.Preview;
import ui.CuePreviewGrid;
import cue.Cue;

/**
 * @author gmc
 *
 */
public class Main extends Panel {
	Preview viewer;
	File f;
	Cue cue;
	CuePreviewGrid grid;
	
	public Dimension preferredSize() {
		return new Dimension(200, 100);
	}
	
	public Cue loadFile(String filename) throws IOException, Exception {
		File f = new File(filename);
		f.parse();
		return f.toCue();
	}
	
	public void init() throws IOException, Exception {
		setLayout(new BorderLayout());
		
		//f = new File("/home/gmc/Downloads/Horse.ILD");
		//f = new File("/home/gmc/Downloads/Boxer.ILD");
		//f = new File("/home/gmc/Downloads/ilddolf.ild");
		  /*inflating: BARNEY19.ILD            
		  inflating: CanGoose.ild            
		  inflating: CanadaFlag.ild          
		  inflating: HIPHOP18.ILD            
		  inflating: Ladylegs.ild*/    
		//f = new File("/home/gmc/Downloads/BARNEY19.ILD");
		//f = new File("/home/gmc/Downloads/HIPHOP18.ILD");
		//f = new File("/home/gmc/Downloads/Ladylegs.ild");
		//f = new File("/home/gmc/Downloads/CanGoose.ild");
		//f = new File("/home/gmc/Downloads/CanadaFlag.ild");
		
		grid = new CuePreviewGrid(4,4);
		grid.setCue(0, 0, loadFile("/home/gmc/Downloads/Horse.ILD"));
		grid.setCue(1, 0, loadFile("/home/gmc/Downloads/BARNEY19.ILD"));
		grid.setCue(2, 0, loadFile("/home/gmc/Downloads/Boxer.ILD"));
		grid.setCue(3, 0, loadFile("/home/gmc/Downloads/HIPHOP18.ILD"));
		grid.setCue(0, 1, loadFile("/home/gmc/Downloads/ilddolf.ild"));
		grid.setCue(1, 1, loadFile("/home/gmc/Downloads/Ladylegs.ild"));
		grid.setCue(2, 1, loadFile("/home/gmc/Downloads/CanGoose.ild"));
		grid.setCue(3, 1, loadFile("/home/gmc/Downloads/CanadaFlag.ild"));
		
		//f.parse();
		//System.out.println(f.toString());
		//cue = f.toCue();
		
		//viewer = new Preview(cue);
		
		//add("South", new Button("exit"));
		add("North", grid);
		//setSize(200,200);
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		Main main = new Main();
		
		Frame frame = new Frame("test");
		
        frame.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        } );
		
		main.init();
		
		frame.add("Center", main);
		
		frame.setVisible(true);
		
		//int frameNo = 0;
		while(true) {
			//System.out.println("iter");
			//main.viewer.setFrame(main.cue.getFrame(frameNo));
			main.repaint();
			main.grid.repaint();
			Thread.sleep(25);
			//frameNo=frameNo+1;
			//if(main.cue.getFrame(frameNo).getNumPoints()==0)
			//	frameNo=0;
			main.grid.incFrame();
		}
	}

}
