package cn.aposoft.ecommerce.payment.alipay;

import java.util.List;

/**
 * 分账说明
 * 
 * @author Yujinshui
 *
 */
public class RoyaltyInfo {
	/**
	 * 分账类型
	 */
	private String royalty_type;
	/**
	 * 分账明细的信息，可以描述多条分账指令。Json格式，其它说明详见下面的“分账明细说明”。
	 */
	private List<RoyaltyDetailInfos> royalty_detail_infos;

	/**
	 * 分账类型
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:32:08
	 */
	public String getRoyalty_type() {
		return royalty_type;
	}

	/**
	 * 分账类型
	 * 
	 * @param royalty_type
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:32:12
	 */
	public void setRoyalty_type(String royalty_type) {
		this.royalty_type = royalty_type;
	}

	/**
	 * 分账明细的信息，可以描述多条分账指令。<br>
	 * Json格式，其它说明详见下面的“分账明细说明”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:31:54
	 */
	public List<RoyaltyDetailInfos> getRoyalty_detail_infos() {
		return royalty_detail_infos;
	}

	/**
	 * 分账明细的信息，可以描述多条分账指令。<br>
	 * Json格式，其它说明详见下面的“分账明细说明”。
	 * 
	 * @param royalty_detail_infos
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:31:58
	 */
	public void setRoyalty_detail_infos(List<RoyaltyDetailInfos> royalty_detail_infos) {
		this.royalty_detail_infos = royalty_detail_infos;
	}

}

/**
 * 分账明细的信息，可以描述多条分账指令。Json格式，其它说明详见下面的“分账明细说明”。
 * 
 * @author Yujinshui
 *
 */
class RoyaltyDetailInfos {

	/**
	 * 分账序列号*
	 * <p>
	 */
	private String serial_no;
	/**
	 * 分账关联号
	 * <p>
	 */

	private String out_relation_id;
	/**
	 * 转出账号类型
	 * <p>
	 */

	private String trans_out_type;
	/**
	 * 出账支付宝用户号
	 * <p>
	 */

	private String trans_out;
	/**
	 * 转入账号类型
	 * <p>
	 * 
	 */
	private String trans_in_type;
	/**
	 * 入账账号*
	 * <p>
	 * 
	 */
	private String trans_in;
	/**
	 * 分账批次号
	 * <p>
	 * 
	 */
	private String batch_no;
	/**
	 * 分账金额*
	 * <p>
	 * 
	 */
	private String amount;
	/**
	 * 分账描述
	 * <p>
	 * 
	 */
	private String desc;

	/**
	 * 分账序列号*
	 * <p>
	 */
	public String getSerial_no() {
		return serial_no;
	}

	/**
	 * 分账序列号*
	 * <p>
	 */
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	/**
	 * 分账关联号
	 * <p>
	 */
	public String getOut_relation_id() {
		return out_relation_id;
	}

	/**
	 * 分账关联号
	 * <p>
	 */
	public void setOut_relation_id(String out_relation_id) {
		this.out_relation_id = out_relation_id;
	}

	/**
	 * 转出账号类型
	 * <p>
	 */
	public String getTrans_out_type() {
		return trans_out_type;
	}

	/**
	 * 转出账号类型
	 * <p>
	 */
	public void setTrans_out_type(String trans_out_type) {
		this.trans_out_type = trans_out_type;
	}

	/**
	 * 出账支付宝用户号
	 * <p>
	 */
	public String getTrans_out() {
		return trans_out;
	}

	/**
	 * 出账支付宝用户号
	 * <p>
	 */
	public void setTrans_out(String trans_out) {
		this.trans_out = trans_out;
	}

	/**
	 * 转入账号类型
	 * <p>
	 * 
	 */
	public String getTrans_in_type() {
		return trans_in_type;
	}

	/**
	 * 转入账号类型
	 * <p>
	 * 
	 */
	public void setTrans_in_type(String trans_in_type) {
		this.trans_in_type = trans_in_type;
	}

	/**
	 * 入账账号*
	 * <p>
	 * 
	 */
	public String getTrans_in() {
		return trans_in;
	}

	/**
	 * 入账账号*
	 * <p>
	 * 
	 */
	public void setTrans_in(String trans_in) {
		this.trans_in = trans_in;
	}

	/**
	 * 分账批次号
	 * <p>
	 * 
	 */
	public String getBatch_no() {
		return batch_no;
	}

	/**
	 * 分账批次号
	 * <p>
	 * 
	 */
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	/**
	 * 分账金额*
	 * <p>
	 * 
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 分账金额*
	 * <p>
	 * 
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * 分账描述
	 * <p>
	 * 
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 分账描述
	 * <p>
	 * 
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

}