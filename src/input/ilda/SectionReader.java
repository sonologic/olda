package input.ilda;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class SectionReader {	
	int formatCode = -1;
	DataInputStream r;
	
	private class EndOfStreamException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6551211224781640306L;
	}
	
	public SectionReader(BufferedInputStream r) {
		this.r = new DataInputStream(r);
	}
	
	public int readU32() throws IOException, EndOfStreamException {
		return r.readInt();
		/*int value = 0;
		
		for(int i=3;i>=0;i--) {
			int c = r.read();
			if(c == -1)
				throw new EndOfStreamException();
			value = value + (c << (i*8));
		}
		
		return value;*/
	}
	
	public int readU16() throws IOException, EndOfStreamException {
		return r.readUnsignedShort();
		/*int value = 0;
		
		//System.out.println("readU16");
		for(int i=1;i>=0;i--) {
			int c = r.read();
			if(c == -1)
				throw new EndOfStreamException();
			value = value + (c << (i*8));		}
		
		return value;*/
	}

	public short readS16() throws IOException, EndOfStreamException {
		return r.readShort();
		/*
		byte[] a = new byte[2];
		
		r.r
		
		short value = 0;
		
		System.out.println("readU16");
		for(byte i=1;i>=0;i--) {
			int c = r.read();
			if(c == -1)
				throw new EndOfStreamException();
			byte b = (byte)(c & 0xff);
			System.out.println(Integer.toHexString(c));
			value = (short) (value | (b << (i*8)));
			System.out.println(Integer.toHexString(value));
		}
		
		//return value-32768;
		//if((value & 0x8000) == 0x8000) {
		//	value = ((~value)&0xffff) + 1;
		//}
		System.out.println(value);
		
		return value;*/
	}	
	
	public int readU8() throws IOException, EndOfStreamException {
		return r.readUnsignedByte();
		/*int c = r.read();
		
		if(c==-1)
			throw new EndOfStreamException();
		
		return c;*/
	}

	public String readString(int len) throws IOException, Exception {
		byte[] chars = new byte[len];

		if(r.read(chars, 0, len) != len)
			throw new Exception("Premature EOF reading string");
		
		return new String(chars);
	}
		
	public Section readSection() throws IOException, Exception {	
		// read ILDA magic
		try {
			int magic = readU32();
			
			//System.out.println(Integer.toHexString(magic));
			if(magic != 0x494c4441)
				throw new Exception("ILDA magic not found");
			
			// read type
			int formatCode = readU32();
			
			//System.out.println(formatCode);
			
			Section s = Section.sectionFactory(formatCode);
			s.read(this);
			
			return s;
		} catch(EOFException e) {
			return null;
		}
	}
}
