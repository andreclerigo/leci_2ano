package aula7;

import java.io.*;

public class BitmapFileHeader {
	public short type,reserved1,reserved2;
	public int size,offBits;
	
	public BitmapFileHeader(RandomAccessFile imagem) {
		try {
			type = Short.reverseBytes(imagem.readShort());
			reserved1 = Short.reverseBytes(imagem.readShort());
			reserved2 = Short.reverseBytes(imagem.readShort());
			size = Integer.reverseBytes(imagem.readInt());
			offBits = Integer.reverseBytes(imagem.readInt());
			
		} catch(IOException e) {
			System.err.print(e);
		}
	}

	@Override
	public String toString() {
		return "BitmapFileHeader {type= " + type + ", r1= " + reserved1 + ", r2= " + reserved2 + ", size= " + size + ", offBits= " + offBits + "}";
	}
}
