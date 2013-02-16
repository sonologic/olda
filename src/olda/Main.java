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
import java.io.IOException;

import output.Preview;

/**
 * @author gmc
 *
 */
public class Main extends Panel {
	Preview viewer;
	File f;
	
	public Dimension preferredSize() {
		return new Dimension(200, 100);
	}
	
	public void init() throws IOException, Exception {
		setLayout(new BorderLayout());
		
		//f = new File("/home/gmc/Downloads/Horse.ILD");
		//f = new File("/home/gmc/Downloads/Boxer.ILD");
		f = new File("/home/gmc/Downloads/ilddolf.ild");
		f.parse();
		System.out.println(f.toString());
		
		viewer = new Preview(f.getFrame(6));
		
		add("South", new Button("exit"));
		add("North", viewer.getCanvas());		
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
		
		int frameNo = 0;
		while(true) {
			main.viewer.setFrame(main.f.getFrame(frameNo));
			//main.repaint();
			main.viewer.getCanvas().repaint();
			Thread.sleep(25);
			frameNo=frameNo+1;
			if(main.f.getFrame(frameNo).getNumPoints()==0)
				frameNo=0;
		}
	}

}
