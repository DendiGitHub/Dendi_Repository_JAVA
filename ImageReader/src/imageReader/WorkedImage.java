package imageReader;

import java.awt.image.BufferedImage;
import java.io.File;

public class WorkedImage {
	
	
	private BufferedImage bufferImage;
	private int height;
	private int width;
	private int[][] grayTable;
	private boolean[][] binaryTable;
	
	public WorkedImage(File imageFile){
		ImageWorker casual = new ImageWorker(imageFile);
		height = casual.getHeight();
		width = casual.getWidth();
		grayTable = casual.getGrayTable();
		binaryTable = casual.getBinaryTable();
	}
	
	public WorkedImage(BufferedImage bufferedImage){
		ImageWorker casual = new ImageWorker(bufferedImage);
		height = casual.getHeight();
		width = casual.getWidth();
		grayTable = casual.getGrayTable();
		binaryTable = casual.getBinaryTable();
	}
	
	
	public WorkedImage(String FileRoute){
		this(new File(FileRoute));
	}


	public BufferedImage getBufferImage() {
		return bufferImage;
	}


	public void setBufferImage(BufferedImage bufferImage) {
		this.bufferImage = bufferImage;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int[][] getGrayTable() {
		return grayTable;
	}


	public void setGrayTable(int[][] grayTable) {
		this.grayTable = grayTable;
	}


	public boolean[][] getBinaryTable() {
		return binaryTable;
	}


	public void setBinaryTable(boolean[][] binaryTable) {
		this.binaryTable = binaryTable;
	}

}
