package input.ilda;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import cue.CueFrame;

public class File {
	String filename;
	SectionReader reader;
	Vector<Section> sections = new Vector<Section>();
	
	public File(String filename) throws FileNotFoundException {
		this.filename = filename;
		this.reader = new SectionReader(
						new BufferedInputStream(new FileInputStream(filename))
					  );
	}
	
	public void parse() throws IOException, Exception {
		Section s;
		
		while( (s=reader.readSection()) != null) {
			sections.add(s);
		}
	}
	
	public String toString() {
		String s = new String("ILDA file, "+Integer.toString(sections.size())+" sections:\n\n");
		
		for(int i=0;i<sections.size();i++) {
			s = s.concat(sections.get(i).toString());
		}
			
		return s;
	}
	
	public CueFrame getFrame(int idx) {
		return sections.get(idx).toFrame();
	}
}
