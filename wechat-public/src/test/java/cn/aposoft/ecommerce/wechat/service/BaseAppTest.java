package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.config.WechatPubPropertiesConfig;
import org.junit.Before;

/**
 * @author code
 * @Title: BaseAppTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:57
 */
public class BaseAppTest {

    public static BaseWechatConfig config = new WechatPubPropertiesConfig();

    @Before
    public void config(){

    }
}
