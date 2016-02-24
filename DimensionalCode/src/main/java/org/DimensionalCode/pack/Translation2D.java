package org.DimensionalCode.pack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

/**
 * 二维码解析方法
 * 
 * @author admin
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Translation2D {
	/**
	 * 备用方法，两者有点小区别，以后研究。 TODO
	 */
	public void decode2() {
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			String filePath = "f://1.jpg";
			File file = new File(filePath);
			BufferedImage image = ImageIO.read(file);
			;
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map hints = new HashMap();

			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

			// hints可以换成null
			Result result = formatReader.decode(binaryBitmap, hints);

			System.out.println("resultFormat = " + result.getBarcodeFormat());
			System.out.println("resultText = " + result.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取并解析二维码信息
	 * 
	 * @param args
	 */

	public static String[] decode(String imagePath, String encode) {
		String[] contents = new String[3];

		MultiFormatReader formatReader = new MultiFormatReader();

		BufferedImage image;
		try {
			image = ImageIO.read(new File(imagePath));

			// 将图像数据转换为1 bit data
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			// BinaryBitmap是ZXing用来表示1 bit data位图的类，Reader对象将对它进行解析
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

			Map hints = new HashMap();
			hints.put(DecodeHintType.CHARACTER_SET, encode);

			// 对图像进行解码
			Result result = formatReader.decode(binaryBitmap, hints);

			contents[0] = "内容：" + result.getText();
			contents[1] = "编码：" + result.getBarcodeFormat().name();
			contents[2] = "枚举常量的序数：" + result.getBarcodeFormat().ordinal();
			//
			// System.out.println("result = " + result.toString());
			// // 打印二维码的编码方式
			// System.out.println("barcode encoding format :\t "
			// + result.getBarcodeFormat());
			// // 二维码实际内容
			// System.out.println("内容为：" + result.getText());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		return contents;
	}
}
