package cn.aposoft.payment.alipay2;

/**
 * 支付宝订单查询
 * <p>
 * {@link http://doc.open.alipay.com/doc2/detail.htm?spm=0.0.0.0.6xOHXX&treeId=26&articleId=103261&docType=1}
 * 
 * method=alipay.trade.query,<br>
 * app_id=2014072300007148,<br>
 * charset=utf-8,<br>
 * sign_type=RSA,<br>
 * sign=
 * MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL4HgSt9hfOpv9MSwgUvfpgOH7WkC7WrTr84m29b0VfnZtK
 * +9jv/YPXYr+22DrxfWJkdPiXJvSjifxPudlqjX21l6/8k79i/
 * 4HRCz8DBcdw5jqROfpoq0l3vYfPVqJGwSqaPhtM1Bb4hAD2yLlN2ukfCbshSntUEFd4ozocLolW/
 * AgMBAAECgYBVHTNj8WMQElYTCnHQtMc1AA5/4yxDgKlSyN4F8NBBWSoa9uF/WhFpzFZwWH0dLm+
 * WlRyC/Gs3ZsuYd9SXIFna9mv49+cEfObSzJhvW5DXOVCi+c4Ap3cTsXZiAj8DMsoCb9OjRHNl/
 * BqzN0kl0Wm1diZvXl9YgSRqbzpXzoj4oQJBAOYLSk87XFYodvwr4aL3KFjZZZhHj1Jpp/
 * q61SNgB03aXqZu9m+hk1X4mTGn4rhA7Cl2ZuL+OoxxnJFDw0cbMRcCQQDTeGgx0VUC+
 * O3zAtzMmocjE7WuesRC3IjhU30of4GGjQzIXvKOQCCuUF2DHvIkrB/k2E75n8+
 * TI9matbLS11mZAkEAtSek7/oF/89Dy9dei2/o9PbVu3J22eZcIuVoHMBtYBCbwqLVLBloJiZrtR/
 * JOWHe19Pmt9COGLULH5XmPKOcJwJAUZnP0xFs1XXLFA/Rtd4XMXDklYxn+
 * UjyRMibrintiEcbXKJOxJd4ROtb+kHRvFbzA7J4XxjM14Fo8asVcwiIWQJAVco+
 * 9qQzZ7JZzFzk0KTWhQlfbcRByLX25XIPbIes2lmY2uM895yrY/8kbGx2JgD/VGITWwth+
 * uuutXUQ9K6HIw==,<br>
 * timestamp=2014-07-24 03:07:50,<br>
 * biz_content={<br>
 * "out_trade_no": "201503022001"<br>
 * }
 * 
 * @author Yujinshui
 *
 */
public interface Ali2OrderQuery {

	public String getMethod();
	public String getOut_trade_no();
	
}
