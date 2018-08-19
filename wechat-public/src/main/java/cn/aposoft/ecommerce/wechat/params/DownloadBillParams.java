package cn.aposoft.ecommerce.wechat.params;

import java.io.Serializable;

/**
 * 下载对账单对外接口请求param
 * @author code
 * @Title: DownloadBillParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午5:50
 */
public interface DownloadBillParams extends Serializable {
    public String getBill_date();
    public String getBill_type();
}
