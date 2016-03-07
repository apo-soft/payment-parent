package cn.aposoft.ecommerce.payment.wechat.dao;

import cn.aposoft.ecommerce.payment.wechat.bean.OrderBill;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderBillMapper {
    int countByExample(OrderBillExample example);

    int deleteByExample(OrderBillExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderBill record);

    int insertSelective(OrderBill record);

    List<OrderBill> selectByExample(OrderBillExample example);

    OrderBill selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderBill record, @Param("example") OrderBillExample example);

    int updateByExample(@Param("record") OrderBill record, @Param("example") OrderBillExample example);

    int updateByPrimaryKeySelective(OrderBill record);

    int updateByPrimaryKey(OrderBill record);
}