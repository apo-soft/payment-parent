/**
 * 
 */
package cn.aposoft.image;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * @author Jann Liu
 *
 */
public class QRCodeUtilTest {

	@Test
	public void createPicture() {
		try {
			final String text = "http://www.aposoft.cn";
			byte[] bytes = QRCodeUtil.getQrCodeImageBytes(text, 200, 200);
			assertNotNull(bytes);
			assertTrue(bytes.length > 0);
			InputStream input = new ByteArrayInputStream(bytes);
			BufferedImage image = ImageIO.read(input);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			assertEquals(text, result.getText());
		} catch (WriterException | IOException | NotFoundException e) {
			e.printStackTrace();
		}
	}
}
