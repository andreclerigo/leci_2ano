package aula7;

import java.io.*;

public class Teste2 {
	public static void main(String[] args) {
		try(RandomAccessFile img = new RandomAccessFile("C:\\Users\\AndreClerigo\\OneDrive - Universidade de Aveiro\\UA\\2º Ano\\Programacao-III\\aula7\\Figura.bmp","r")) {
			Bitmap.bitmapFileHeader = new BitmapFileHeader(img);
			Bitmap.bitmapInfoHeader = new BitmapInfoHeader(img);
			
			System.out.println(Bitmap.bitmapFileHeader + "\n");
			System.out.println(Bitmap.bitmapInfoHeader + "\n");
			
			byte[] pixelData = new byte[((Bitmap.bitmapInfoHeader.width+3)*Bitmap.bitmapInfoHeader.height)*3];
			int imageSize = 0;
			
			try {
				imageSize = img.read(pixelData);
			} catch(EOFException ex) {
				System.out.println("Figura.bmp was read");
			} finally {
				Bitmap.data = new byte[imageSize];
				System.arraycopy(pixelData,0,Bitmap.data,0,imageSize);
			}
			
			try( RandomAccessFile rawFile = new RandomAccessFile("Figura.raw", "rw")) {
				rawFile.write(Bitmap.data);
				System.out.println("Figura.raw was created");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			try( RandomAccessFile peq = new RandomAccessFile("pequena.bmp", "rw")) {
				BitmapUtils.pequenaImg(peq);
				System.out.println("pequena.bmp was created");
			}
			catch (Exception e) {
					e.printStackTrace();
			}
			
			try( RandomAccessFile flipImg = new RandomAccessFile("flip.bmp", "rw")) {
				BitmapUtils.criaFlipImg(flipImg);
				System.out.println("flip.bmp was created");
			}
			catch (Exception e) {
					e.printStackTrace();
			}
			
			try( RandomAccessFile flipH = new RandomAccessFile("flipH.bmp", "rw")) {
				BitmapUtils.criaFlipH(flipH);
				System.out.println("flipH.bmp was created");
			}
			catch (Exception e) {
					e.printStackTrace();
			}
			
			try( RandomAccessFile flipV = new RandomAccessFile("flipV.bmp", "rw")) {
				BitmapUtils.criaFlipV(flipV);
				System.out.println("flipV.bmp was created");
			}
			catch (Exception e) {
					e.printStackTrace();
			}
		}
		catch(Exception e){
			System.err.print(e);
		}	
	}
}
