package org.DimensionalCode.create;

import java.awt.Color;
import java.util.Random;

import org.DimensionalCode.pack.MatrixToImageWriterEx;
import org.DimensionalCode.pack.MatrixToLogoImageConfig;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;

public class CreateDimensionalCode {

	private static Random ran = new Random();
	static int dom = ran.nextInt(10);

	// 424个汉字,1273个字母
	public static String getCont() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("hello,艾俪雅");
		return buffer.toString();
	}

	/**
	 * 1852个大写字母 <br>
	 * 3057个数字 <br>
	 * 424个汉字 <br>
	 * <br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int width = 2000;
		int height = width;
		// 二维码内容
		String content = getCont();
		// logo边框颜色
		Color c = Color.red;
		// 显示logo大小，数字越大，logo越小(2:无法正常解析，3以上可以)
		int size = 4;
		// 图像路径
		String imagePath = "f:/logo" + dom + ".jpg";
		// logo路径
		String logoPath = "";
		// 生成的图片格式
		String format = "jpg";
		// 编码方式
		BarcodeFormat bf = BarcodeFormat.QR_CODE;// QR_CODE;
		try {
			BitMatrix matrix = MatrixToImageWriterEx.createQRCode(content, width, height, bf);
			MatrixToLogoImageConfig logoConfig = new MatrixToLogoImageConfig(c, size);
			MatrixToImageWriterEx.writeToFile(matrix, format, imagePath, logoPath, logoConfig);
			System.out.println("生成二维码完成！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
