package aula7;

import java.io.*;

public class BitmapInfoHeader {
	int size; //40 bytes
	int width, height;
	short planes,bitCount;
	int compression, sizeImage, xPelsPerMeter, yPelsPerMeter, clrUsed, clrImportant;
	
	public BitmapInfoHeader(RandomAccessFile imagem) {
		try {
			size = Integer.reverseBytes(imagem.readInt());
			width = Integer.reverseBytes(imagem.readInt());
			height = Integer.reverseBytes(imagem.readInt());
			compression = Integer.reverseBytes(imagem.readInt());
			sizeImage = Integer.reverseBytes(imagem.readInt());
			xPelsPerMeter = Integer.reverseBytes(imagem.readInt());
			yPelsPerMeter = Integer.reverseBytes(imagem.readInt());
			clrUsed = Integer.reverseBytes(imagem.readInt());
			clrImportant = Integer.reverseBytes(imagem.readInt());
			planes = Short.reverseBytes(imagem.readShort());
			bitCount = Short.reverseBytes(imagem.readShort());
			
		} catch(IOException e) {
			System.err.print(e);
		}
	}

	@Override
	public String toString() {
		return "BitmapInfoHeader {size= " + size + ", largura= " + width + ", altura= " + height + ", compression= "+ compression 
										  + ", imageSize= " + sizeImage + ", xPix=" + xPelsPerMeter + ", yPix=" + yPelsPerMeter 
										  + ", cor=" + clrUsed + ", clrImportant=" + clrImportant + ", planes=" + planes 
										  + ", bitCount=" + bitCount + "}";
	}
}
