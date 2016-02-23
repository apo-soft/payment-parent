/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author Jann Liu
 *
 */
public class HttpClientTest {

	public static void main(String[] args) {

		CloseableHttpClient client = HttpClients.createDefault();

		HttpHead request = new HttpHead("http://apps.gghypt.net/download/1_3_3/hyggpt.apk");
		// HttpGet request = new
		// HttpGet("http://apps.gghypt.net/download/1_3_3/hyggpt.apk");
		CloseableHttpResponse response;
		try {
			
			
			response = client.execute(request);

			Header[] headers = response.getAllHeaders();

			for (Header header : headers) {
				System.out.println(header.getName() + ":" + header.getValue());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
