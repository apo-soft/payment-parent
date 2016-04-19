package cn.aposoft.ecommerce.payment.wechat.dao;

import cn.aposoft.ecommerce.payment.wechat.bean.OrderPayment;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPaymentMapper {
    int countByExample(OrderPaymentExample example);

    int deleteByExample(OrderPaymentExample example);

    int deleteByPrimaryKey(Integer paymentId);

    int insert(OrderPayment record);

    int insertSelective(OrderPayment record);

    List<OrderPayment> selectByExample(OrderPaymentExample example);

    OrderPayment selectByPrimaryKey(Integer paymentId);

    int updateByExampleSelective(@Param("record") OrderPayment record, @Param("example") OrderPaymentExample example);

    int updateByExample(@Param("record") OrderPayment record, @Param("example") OrderPaymentExample example);

    int updateByPrimaryKeySelective(OrderPayment record);

    int updateByPrimaryKey(OrderPayment record);
}