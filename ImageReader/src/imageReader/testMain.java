package imageReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class testMain {
	public static void main(String[] args) {

		System.out.println(ImageCompare.compare(new WorkedImage(
				"database\\database3.jpg"), new WorkedImage(
				"database\\test6.jpg")));
		
		
//		WorkedImage image1 = new WorkedImage("database\\database2.jpg");
//		int height = image1.getHeight();
//		int width = image1.getWidth();
//		int[][] grayTable = image1.getGrayTable();
//		BufferedImage binaryImage = new BufferedImage(width, height,
//				BufferedImage.TYPE_INT_RGB);
//
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				binaryImage.setRGB(j, i, grayTable[j][i]);
//			}
//		}
//
//		try {
//			String dir = "testResult\\database2.jpg";
//			ImageIO.write(binaryImage, "jpg", new File(dir));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
