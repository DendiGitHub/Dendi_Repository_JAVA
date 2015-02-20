package imageReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*	Author :Dendi
 * 	Email  :CoderDendi@163.com
 * 	Data   :2015.01.23
 */

public class ImageWorker {
	
//	to be determined;
	static int STANDARD_HEIGHT = 100;
	static int STANDARD_WIDTH = 100;
	
	private BufferedImage bufferImage;
//	private int height;
//	private int width;
	private int[][] grayTable;
	private boolean[][] binaryTable;

	public boolean[][] getBinaryTable() {
		return binaryTable;
	}

	public void setBinaryTable(boolean[][] binaryTable) {
		this.binaryTable = binaryTable;
	}

	public ImageWorker(File imageFile) {
		try {
			bufferImage = ImageIO.read(imageFile);
			bufferImage = standard(bufferImage);
//			height = bufferImage.getHeight();
//			width = bufferImage.getWidth();
			grayTable = initGrayTable();
			binaryTable = initBinaryTable();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImageWorker(BufferedImage bufferImage) {
			this.bufferImage = bufferImage;
			bufferImage = standard(bufferImage);
			grayTable = initGrayTable();
			binaryTable = initBinaryTable();
			
			

	}
	
	public void getBinary(String fileName) {
		imageOut(binary(getGrayTable()), fileName);
	}

	// 灰度化
	public int[][] initGrayTable() {
		int width = bufferImage.getWidth();
		int height = bufferImage.getHeight();
		int[][] grayTable = new int[width][height];
		int rgb, r, g, b, grayPixel;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rgb = bufferImage.getRGB(j, i);
				r = (rgb >> 16) & 0xFF;
				g = (rgb >> 8) & 0xFF;
				b = (rgb >> 0) & 0xFF;
				// toBeDetermined
				 grayPixel = (int) ((b * 29 + g * 150 + r * 77 + 128) >> 8);
				// grayPixel = (int) (r+g*16+b*16*16);
//				System.out.println("("+j+","+i+") = "+grayPixel);
//				grayPixel = (int) (r * 16 * 16 + g * 16);
				grayTable[j][i] = grayPixel;
			}
		}

		return grayTable;
	}
	
	private boolean[][] initBinaryTable(){
		int width = bufferImage.getWidth();
		int height = bufferImage.getHeight();
		boolean[][] binaryTable = new boolean[width][height];
		int threshold = 0;
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				threshold = threshold + grayTable[i][j];
			}
		}
		threshold = threshold / (height*height);
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				if(grayTable[i][j]>threshold){
					binaryTable[i][j] = true;
					
//					grayTable[i][j] |= 0x00FFFF;
				}else{
					binaryTable[i][j] = false;
					
//					grayTable[i][j] &= 0xFF0000;
				}
			}
		}
		return binaryTable;
	}
	

	// getThreshold
	private int getThreshold(int[][] grayTable) {
		int threshold = 0;
		// to be determined
		// int num = 0;
		// for(int i=0;i<width;i++){
		// for(int j=0;j<height;j++){
		// num+=grayTable[i][j];
		// }
		// }
		//
		// threshold = num/(height*width);

		// to be determined

		threshold = 30;

		return threshold;
	}

	// 二值化
	public BufferedImage binary(int[][] grayTable) {
		int width = bufferImage.getWidth();
		int height = bufferImage.getHeight();
		int threshold = getThreshold(grayTable);
		BufferedImage binaryImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_BINARY);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (grayTable[j][i] > threshold) {
					grayTable[j][i] |= 0x00FFFF;
				} else {
					grayTable[j][i] &= 0xFF0000;
				}
				binaryImage.setRGB(j, i, grayTable[j][i]);
			}
		}
		// try {
		// ImageIO.write(binaryImage, "jpg", new File("binaryImage.jpg"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		return binaryImage;
	}

	public void imageOut(BufferedImage binaryImage, String fileName) {
		try {
			String dir = "result//" + fileName;
			ImageIO.write(binaryImage, "jpg", new File(dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public BufferedImage standard(BufferedImage primitiveImage){
		BufferedImage result = new BufferedImage(STANDARD_WIDTH, STANDARD_HEIGHT,
				BufferedImage.TYPE_BYTE_GRAY);
		int width = primitiveImage.getWidth();
		int height = primitiveImage.getHeight();
		
		int currentRGB;
		for(int i=0;i<STANDARD_WIDTH;i++){
			for(int j=0;j<STANDARD_HEIGHT;j++){
				currentRGB = getRGB(bufferImage,width,height,i,j);
//				System.out.println(i+","+j+" = "+currentRGB);
				result.setRGB(i, j, currentRGB);
			}
		}
		
		return result;
	}
	
	public int getRGB(BufferedImage bufferImage,int width,int height
		,int x,int y){
//		double a = width*x/STANDARD_WIDTH;
//		double b = height*y/STANDARD_HEIGHT;
//		int x_ = (int) (a / 1);
//		int y_ = (int) (b/1);
//		double dx = a - x_;
//		double dy = b-y_;
//		System.out.println("x = "+ x_ + "----y = "+y);
//		System.out.println("dx = " +dx+"_____dy = "+dy);
//		//to be determined
//		double rgb = ((2-dx-dy)*bufferImage.getRGB(x_, y_) + (1+dy-dx)*bufferImage.getRGB(x_, y_+1)
//				+(1+dx-dy)*bufferImage.getRGB(x_+1, y_)+(dx+dy)*bufferImage.getRGB(x_+1, y_+1));
//		rgb = rgb / 4;
		int rgb = bufferImage.getRGB(width*x/STANDARD_WIDTH, y*height/STANDARD_HEIGHT);
		return (int)rgb;
	}
	

	public BufferedImage getBufferImage() {
		return bufferImage;
	}

	public void setBufferImage(BufferedImage bufferImage) {
		this.bufferImage = bufferImage;
	}

	public int getHeight() {
		return STANDARD_HEIGHT;
	}


	public int getWidth() {
		return STANDARD_WIDTH;
	}


	public void setGrayTable(int[][] grayTable) {
		this.grayTable = grayTable;
	}
	
	public int[][] getGrayTable() {
		return grayTable;
	}

}
