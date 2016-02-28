/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author Jann Liu
 *
 */
public class NotificationClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CloseableHttpClient client = HttpClients.createDefault();
		final String url = "http://localhost:8080/payment/notificationCon";
		HttpPost post = new HttpPost(url);
		;
		String content;
		try (InputStream input = NotificationClientTest.class.getClassLoader()
				.getResourceAsStream("wechat-notification.txt");) {

			content = IOUtils.toString(input);
			System.out.println(content);
			System.out.println("111/////////////////////////////////////////////");
			HttpEntity entity = new StringEntity(content,"UTF-8");
			post.setEntity(entity);
			try {
				CloseableHttpResponse resp = client.execute(post);
				System.out.println(resp.getStatusLine());
				System.out.println("222/////////////////////////////////////////////");
				for (Header header : resp.getAllHeaders()) {
					System.out.println(header.getName() + ":" + header.getValue());
				}
				System.out.println("333/////////////////////////////////////////////");
				System.out.println(EntityUtils.toString(resp.getEntity(), "UTF-8"));
				System.out.println("444/////////////////////////////////////////////");
				EntityUtils.consume(resp.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (IOException e) {
					// this will not handle
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
