package oswego.csc365.a4;


import java.io.*;
import java.util.*;


class FLRAF extends RandomAccessFile {
	int blockSize; 
	
	// Constructor
	public FLRAF(int size) throws FileNotFoundException {
		super(new File("output.flraf"), "rw");
		blockSize = size;
	}
	
	
	// Gets word at block number of argument
	public byte[] read(int address) {
		byte[] tmp = new byte[blockSize];
		try {
			seek(address * blockSize);
			super.read(tmp);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return tmp;
	}
	

	// precondition, data already serialized
	// writes serialized data to block number <address>
	public void write(byte[] data, int address) {
		try {
			seek(address * blockSize);
			super.write(data);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}