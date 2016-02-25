/**
 * 
 */
package cn.aposoft.image;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @author Jann Liu
 *
 */
public class QRCodeUtil {

	/**
	 * 
	 * 返回二维码,默认为UTF-8字符集
	 * 
	 * @param content
	 *            待转换的字符串
	 * @param format
	 *            输出图像格式
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param charset
	 *            字符集格式
	 * @return 二维码图像的byte[] 表示形式
	 * @throws WriterException
	 */
	public static byte[] getQrCodeImageBytes(String content, String format, int width, int height, String charset)
			throws WriterException {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, charset);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
		} catch (IOException e) {
			// this will not happen
		} // 输出图像
		return stream.toByteArray();
	}

	/**
	 * 返回二维码,默认为UTF-8字符集
	 * 
	 * @param content
	 *            待转换的字符串
	 * @param format
	 *            输出图像格式 png,jpg
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @return 二维码图像的byte[] 表示形式
	 * @throws WriterException
	 */
	public static byte[] getQrCodeImageBytes(String content, String format, int width, int height)
			throws WriterException {
		return getQrCodeImageBytes(content, format, width, height, "UTF-8");
	}

	/**
	 * 返回二维码,默认为UTF-8字符集,图片格式为png
	 * 
	 * @param content
	 *            待转换的字符串
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @return 二维码图像的byte[] 表示形式
	 * @throws WriterException
	 */
	public static byte[] getQrCodeImageBytes(String content, int width, int height) throws WriterException {
		return getQrCodeImageBytes(content, "png", width, height, "UTF-8");
	}
}
