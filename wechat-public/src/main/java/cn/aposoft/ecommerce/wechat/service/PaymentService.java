package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.WechatCloseResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.enums.SignTypeEnum;
import cn.aposoft.ecommerce.wechat.params.*;
import java.util.List;

/**
 * @author code
 * @Title: PaymentService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19上午10:13
 */
public interface PaymentService extends AutoCloseable{

    /**
     * 实现支付订单的发送及返回值的返回
     * {@link https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1}
     * <p>
     * 应用场景
     * <p>
     * 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、
     * APP等不同场景生成交易串调起支付。
     *
     *
     * <p>
     * URL地址：https://api.mch.weixin.qq.com/pay/unifiedorder
     * <p>
     * 不需要证书 * @param order 待支付订单交易信息
     *
     * @return 订单预支付处理结果
     * @author
     */
    WeChatPayResData pay(OrderParams orderParams) throws Exception;


    /**
     * 该接口提供所有微信支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。
     * {@link https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_2}
     * 需要调用查询接口的情况：
     *
     * <p>
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * <p>
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * <p>
     * ◆调用被扫支付API，返回USERPAYING的状态；
     * <p>
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     *
     * <p>
     * 接口连接 : https://api.mch.weixin.qq.com/pay/orderquery
     * <p>
     * 不需要证书
     *
     * @param params 订单查询条件参数对象
     * @return 订单查询结果响应对象
     * @author Yujinshui
     */
    WechatPayQueryResData query(OrderQueryParams orderQueryParams) throws Exception;


    /**
     * 关闭订单请求的实现
     * <p>
     * <p>
     * 以下情况需要调用关单接口：商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，
     * 系统退出不再受理，避免用户继续，请调用关单接口。 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     * {@link https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_3}
     * <p>
     * 接口链接：https://api.mch.weixin.qq.com/pay/closeorder
     * <p>
     * 不需要证书
     *
     * @param params
     * @return 关闭订单请求的返回结果
     * @author codejiayou
     * params)
     */
    WechatCloseResData closeOrder(CloseOrderParams params) throws Exception;


    /**
     * 生成退款信息并发送请求到微信退款服务器
     * {@link https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_4}
     * <p>
     * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，
     * 按照退款规则将支付款按原路退到买家帐号上。
     * <p>
     * 注意：
     * <p>
     * 1、交易时间超过半年的订单无法提交退款；
     * <p>
     * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。
     * 总退款金额不能超过用户实际支付金额。
     * <p>
     * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
     * <p>
     * 需要双向认证证书
     *
     * @param refund 退款请求信息
     * @return 退款结果响应信息
     * @author Yujinshui
     */
    WeChatRefundResData refund(RefundParams refund) throws Exception;

    /**
     * 退款查询服务接口:
     * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
     * {@link https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_5}
     * <p>
     * 接口地址: https://api.mch.weixin.qq.com/pay/refundquery
     * <p>
     * 不需要证书
     *
     * @param params 退款查询参数对象
     * @return 退款查询返回结果
     * @author codejiayou
     */
    WechatRefundQueryResData refundQuery(RefundQueryParams params) throws Exception;

    /**
     * 下载对账单
     * {@link https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_6}
     * 商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。
     * <p>
     * 注意：
     * <p>
     * 1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致，bill_type为REVOKED；
     * <p>
     * 2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取；
     * <p>
     * 3、对账单中涉及金额的字段单位为“元”。
     * <p>
     * 接口链接 : https://api.mch.weixin.qq.com/pay/downloadbill
     * <p>
     * 不需要证书
     *
     * @param params 对账单查询参数
     * @return 下载的对账单响应结果
     * @author codejiayou
     */
    List<WechatDownloadBillResData> downloadBill(DownloadBillParams params) throws Exception;

    /**
     * 从微信端接收的xml数据
     * @param xml
     * @param signType 签名类型
     * @return
     */
    boolean verifySign(String xml, SignTypeEnum signType);

    void close() throws Exception;
}
