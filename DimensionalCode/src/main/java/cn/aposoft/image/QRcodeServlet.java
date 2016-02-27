package cn.aposoft.image;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;

/**
 * Servlet implementation class QRcodeServlet
 */
public class QRcodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * 图片宽度和高度最大值
	 */
	private volatile int imgMax = 2000;

	/**
	 * 图片宽度和高度最小值
	 */
	private volatile int imgMin = 100;

	/**
	 * 图片类型， default: type = "png";可选值 png,jpg
	 */
	private volatile String defaultImgType = "png";

	private volatile String defaultContentEncoding = "utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QRcodeServlet() {

	}

	/**
	 * 入参格式：http://www.aposoft.cn/payment/qrcode?width=150&height=150&content={
	 * 使用http urlParamEncoding编码的内容}[&type=[png|jpg]] width:必填
	 * ，范围：最小100，最大：2000；<br/>
	 * height: 必填 ，范围：最小100，最大：2000；<br/>
	 * content: 必填且符合urlparamEncoding 规范<br/>
	 * type:选填，默认为png,可选的值为png或jpg<br/>
	 * 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		type = type == null ? defaultImgType : type.trim();
		if (checkInput(width, height, content, type)) {
			byte[] bytes;
			try {
				bytes = QRCodeUtil.getQrCodeImageBytes(content, type, Integer.parseInt(width), Integer.parseInt(height),
						defaultContentEncoding);
				response.setContentType("image/" + type);
				OutputStream out = response.getOutputStream();
				out.write(bytes);
				out.flush();
			} catch (NumberFormatException | WriterException e) {
				response.setStatus(404);
			}
		} else {
			response.setStatus(404);
		}
	}

	private boolean checkInput(String width, String height, String content, String type) {
		boolean flag = true;
		if (width == null || width.isEmpty() || //
				height == null || height.isEmpty() || //
				content == null || content.isEmpty() || //
				(type != null && !"png".equalsIgnoreCase(type.trim()) && !"jpg".equalsIgnoreCase(type.trim()))) {
			return false;
		} else {

			try {
				int w = Integer.parseInt(width);
				if (w < imgMin || w > imgMax) {
					return false;
				}

				int h = Integer.parseInt(height);
				if (h < imgMin || h > imgMax) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return flag;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String imgMaxStr = config.getInitParameter("imgMax");
			if (imgMaxStr != null && !imgMaxStr.isEmpty()) {
				imgMax = Integer.parseInt(imgMaxStr.trim());
			}
		} catch (Exception e) {
			// log
		}

		try {
			String imgMinStr = config.getInitParameter("imgMin");
			if (imgMinStr != null && !imgMinStr.isEmpty()) {
				imgMin = Integer.parseInt(imgMinStr.trim());
			}
		} catch (Exception e) {
			// log
		}

		try {
			String defaultImgTypeStr = config.getInitParameter("defaultImgType");
			if ("png".equalsIgnoreCase(defaultImgTypeStr.trim()) || "jpg".equalsIgnoreCase(defaultImgTypeStr.trim())) {
				defaultImgType = defaultImgTypeStr;
			}
		} catch (Exception e) {
			// log
		}

		try {
			String defaultContentEncodingStr = config.getInitParameter("defaultContentEncoding");
			if (defaultContentEncodingStr != null && !defaultContentEncodingStr.isEmpty()) {
				Charset charset = Charset.forName(defaultContentEncodingStr.trim());
				defaultContentEncoding = charset.name();
			}
		} catch (Exception e) {
			// log
		}

		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
