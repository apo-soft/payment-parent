/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author Jann Liu
 *
 */
public class HttpConnectionClientTest {

	/**
	 * 测试http get,post
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CloseableHttpClient client = HttpClients.createDefault();
		// String json =
		// "{\"methodCode\":\"V016\",\"param\":{\"endTime\":\"1452006000000\","
		// + "\"startTime\":\"1451926800000\",\"vehiclePlateColor\":\"1\","
		// + "\"vehiclePlateNo\":\"黑AB1109\"},\"userCode\":\"2200\"}";
		// 测试结果正确
		String json = "{\"methodCode\":\"V016\",\"param\":{"
				+ "\"bean\":{\"startTime\":\"1451926800000\",\"vehiclePlateColor\":\"1\",\"vehiclePlateNo\":\"黑AB1109\",\"endTime\":\"1452006000000\"}},\"userCode\":\"1400\"}";
		String urlbase = "http://192.168.110.99:8680/TestServlet";

		String finalUrl = urlbase + json;
		try {
			System.out.println("begin:");
			// HttpGet get = new HttpGet(finalUrl);
			HttpPost post = createHttpPost(urlbase, "jsonParam", json);
			CloseableHttpResponse resp = client.execute(post);
			String result = EntityUtils.toString(resp.getEntity(), "UTF-8");
			System.out.println(result);

			client.close();
			System.out.println("end");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static HttpPost createHttpPost(String urlBase, String key, String value) {
		System.out.println(urlBase + "\r\n" + key + "\r\n" + value);

		// 定义POST请求
		HttpPost httpPost = new HttpPost(urlBase);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();

		parameters.add(new BasicNameValuePair(key, value));

		try {
			StringEntity postEntity;
			postEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
			httpPost.setEntity(postEntity);
			return httpPost;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

	}
}
