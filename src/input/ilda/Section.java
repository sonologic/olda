package input.ilda;

import java.io.IOException;

import cue.CueFrame;

public abstract class Section {
	public static final int ILDA_3D = 0;
	public static final int ILDA_2D = 1;
	public static final int ILDA_PALETTE = 2;
	public static final int ILDA_RGB = 3;
	
	public static Section sectionFactory(int formatCode) throws Exception {
		switch(formatCode) {
			case ILDA_3D:
				return new ImageSection(ImageSection.IMAGE_3D);
			case ILDA_2D:
				return new ImageSection(ImageSection.IMAGE_2D);
			default:
				throw new Exception("Unknown ILDA format code");
		}
	}
	
	public abstract void read(SectionReader r) throws IOException, Exception;
	
	public abstract CueFrame toFrame();
	public abstract String toString();
}
