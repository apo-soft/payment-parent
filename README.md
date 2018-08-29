# payment-parent
支付项目
子项:支付宝支付项目 V1.0
完成支付宝项目的多个业务接口,目前在开发中

子项:微信支付项目 V1.0
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
3. 因为微信服务器的每次请求响应时间大概为0.5s~~1.5s,处于性能考虑,在本系统中放开了单一client<-->server的最大连接数到200,因此,在单一实例上,本服务器能够同时并发完成的最大https请求数为200个,退款走独立的client,因此最大退款请求数为200个且独立计算.有需要修改配置的请在cn.aposoft.ecommerce.payment.wechat.util.SingletonHttpClientUtil中将对应的值修改为期望值.
4. 在PayService接口继承了Closeable接口,在销毁PayService对象时,应主动调用close()方法,或在spring的bean配置时添加destroy-method=close


####Update 记录

2018-08-29

新增`wechat-public`，**<font color=blue>微信公众号服务商版</font>**支付模块。

当前提供6个基本方法:

1. 统一下单  https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1
2. 查询订单  https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_2
3. 关闭订单  https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_3
4. 申请退款  https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_4
5. 查询退款 https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_5
6. 下载对账单 https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_6

http资源关闭采用1.8方式的自动关闭方式操作，参见单元测试中的`cn.aposoft.ecommerce.wechat.service.PaymentServiceTest#payTest()`方法


