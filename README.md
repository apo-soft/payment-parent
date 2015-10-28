# payment-parent
支付项目
子项:微信支付项目 V1.1
系统主要由 cn.aposoft.ecommerce.payment.wechat.PaymentService接口的具体实现来完成微信支付相关的主要功能.
当前提供6个基本方法:
    1. 统一下单  https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
    2. 查询订单  https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2
    3. 关闭订单  https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3
    4. 申请退款  https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4
    5. 查询退款 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5
    6. 下载对账单 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_6

使用说明:
1. 调用本工具包:需要根据示例配置wechatpay.properties内部相关的配置项,并放到classpath下面
2. 所有服务调用的入参都采用接口形式,因此在调用本服务包时,需要独立实现请求接口,也可以直接拷贝使用测试包中对应的默认对象.