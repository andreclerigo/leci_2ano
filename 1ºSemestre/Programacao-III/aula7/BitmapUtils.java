package aula7;

import java.io.*;

public class BitmapUtils {
	static int widthImg = Bitmap.data.length/Bitmap.bitmapInfoHeader.height;
	static int noPaddingwidthImg = Bitmap.bitmapInfoHeader.width*3;
	
	public static void pequenaImg(RandomAccessFile peq) throws IOException {
		writeBitmapHeaders(peq, Bitmap.data.length/4 + 54, Bitmap.bitmapInfoHeader.width/2, Bitmap.bitmapInfoHeader.height/2);
		
		for(int j = 0; j < Bitmap.bitmapInfoHeader.height; j+=2) {
			int i;
			for(i = 0; i < Bitmap.bitmapInfoHeader.width*3/2; i+=3) {
				peq.write(Bitmap.data[(j * widthImg) + i*2]);
				peq.write(Bitmap.data[(j * widthImg) + (i*2 + 1)]);
				peq.write(Bitmap.data[(j * widthImg) + (i*2 + 2)]);
			}
			for(int k = 0; k < i%4; k++) {
				peq.write((byte) 0);
			}
		}
	}
	public static void criaFlipImg(RandomAccessFile flip) throws IOException {
		writeBitmapHeaders(flip, Bitmap.bitmapFileHeader.size, Bitmap.bitmapInfoHeader.height, Bitmap.bitmapInfoHeader.width);
		
		for(int j = 0; j < widthImg; j+=3) {
			int bitsLinha = 0;
			for(int i = 0; i < Bitmap.bitmapInfoHeader.width; i++) {
				flip.write(Bitmap.data[(i * widthImg) + j]);
				flip.write(Bitmap.data[(i * widthImg) + j + 1]);
				flip.write(Bitmap.data[(i * widthImg) + j + 2]);
				bitsLinha += 3;
			}
			for(int k = 0; k < bitsLinha%4; k++) {
				flip.write((byte) 0);
			}
		}
	}
	public static void criaFlipH(RandomAccessFile flipH) throws IOException {
		writeBitmapHeaders(flipH);
		
		for(int j = 0; j < Bitmap.bitmapInfoHeader.height; j++) {
			int bitsLinha = 0;
			for(int i = noPaddingwidthImg - 3; i > - 1; i-=3) {
				flipH.write(Bitmap.data[(i * widthImg) + j]);
				flipH.write(Bitmap.data[(i * widthImg) + j + 1]);
				flipH.write(Bitmap.data[(i * widthImg) + j + 2]);
				bitsLinha += 3;
			}
			for(int k = 0; k < bitsLinha%4; k++) {
				flipH.write((byte) 0);
			}
		}
	}
	public static void criaFlipV(RandomAccessFile flipV) throws IOException {
		writeBitmapHeaders(flipV);
		
		for(int j = Bitmap.bitmapInfoHeader.height - 1; j >= 0; j--) {
			int bitsLinha = 0;
			for(int i = 0; i < widthImg; i+=3) {
				flipV.write(Bitmap.data[(i * widthImg) + j]);
				flipV.write(Bitmap.data[(i * widthImg) + j + 1]);
				flipV.write(Bitmap.data[(i * widthImg) + j + 2]);
				bitsLinha += 3;
			}
			for(int k = 0; k < bitsLinha%4; k++) {
				flipV.write((byte) 0);
			}
		}
	}
	public static void criaCopia(RandomAccessFile copia) throws IOException {
		writeBitmapHeaders(copia);
		copia.write(Bitmap.data);
	}
	public static void writeBitmapHeaders(RandomAccessFile flip) throws IOException{
		writeBitmapHeaders(flip,Bitmap.bitmapFileHeader.size,Bitmap.bitmapInfoHeader.width,Bitmap.bitmapInfoHeader.height);
	}
	public static void writeBitmapHeaders(RandomAccessFile img, int i, int j, int k) throws IOException{
		img.writeShort(Short.reverseBytes(Bitmap.bitmapFileHeader.type));
		img.writeInt(Integer.reverseBytes(i));
		img.writeShort(Short.reverseBytes(Bitmap.bitmapFileHeader.reserved1));
		img.writeShort(Short.reverseBytes(Bitmap.bitmapFileHeader.reserved2));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapFileHeader.offBits));
		
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.size));
		img.writeInt(Integer.reverseBytes(j));
		img.writeInt(Integer.reverseBytes((-1)*k));
		img.writeShort(Short.reverseBytes(Bitmap.bitmapInfoHeader.planes));
		img.writeShort(Short.reverseBytes(Bitmap.bitmapInfoHeader.bitCount));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.compression));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.sizeImage));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.xPelsPerMeter));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.yPelsPerMeter));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.clrUsed));
		img.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.clrImportant));
	}
}
