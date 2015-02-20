package imageReader;

public class ImageCompare {
	
	
	public static double compare(WorkedImage leftImage, WorkedImage rightImage) {
		double result = 0;
		int height = Math.min(leftImage.getHeight(), rightImage.getHeight());
		int width = Math.min(leftImage.getWidth(), rightImage.getWidth());
		boolean[][] leftBinaryTable = leftImage.getBinaryTable();
		boolean[][] rightBinaryTable = rightImage.getBinaryTable();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (leftBinaryTable[i][j] == rightBinaryTable[i][j]) {
					result = result + 1;
				}
			}
		}
		result = result / (height * width);

		return result;
	}
}
