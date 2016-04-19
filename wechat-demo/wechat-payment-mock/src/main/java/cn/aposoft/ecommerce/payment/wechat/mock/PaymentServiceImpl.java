/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.mock;

import java.io.Closeable;
import java.io.IOException;

import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.CloseOrderResponse;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.DownloadBillResponse;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.OrderQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.PaymentService;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;

/**
 * 模拟微信支付服务的测试对象
 * 
 * @author LiuJian
 *
 */
public class PaymentServiceImpl implements PaymentService, Closeable {
	// protected
	// 避免外部访问当构建服务实例
	PaymentServiceImpl() {

	}

	/**
	 * 关闭资源方法 do nothing
	 */
	@Override
	public void close() throws IOException {
	}

	/**
	 * 简单返回订单预付款resp信息. 根据mock需要,TODO待补充
	 * 
	 * <pre>
	 * {@code return_code result_code , code_url}
	 * </pre>
	 */
	@Override
	public PayResponse preparePay(Order order) {
		PayResponse resp = new PayResponse();
		resp.setResult_code("SUCCESS");
		resp.setReturn_code("SUCCESS");
		resp.setCode_url("weixin://wxpay/s/An4baqw");
		return resp;
	}

	@Override
	public RefundResponse refund(Refund refund) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderQueryResponse query(OrderQuery params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CloseOrderResponse closeOrder(CloseOrder params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefundQueryResponse refundQuery(RefundQuery params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DownloadBillResponse downloadBill(DownloadBill params) {
		// TODO Auto-generated method stub
		return null;
	}

}
