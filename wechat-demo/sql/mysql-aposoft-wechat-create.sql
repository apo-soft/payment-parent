/**
    author :    Jann Liu
    date:       2016/3/6
    desc:       创建aposhop 订单表信息
    modified: 
           2016/3/7 完成...修改
*/
drop schema IF  EXISTS aposhop;
create schema aposhop;
use aposhop;

-- 创建订单信息表
drop table IF  EXISTS apo_order_bill;
drop table IF  EXISTS apo_order_payment;
create table apo_order_bill(
    order_id int unsigned auto_increment primary key COMMENT '订单id',
    order_no varchar(20) unique key not null COMMENT '订单编号',
    order_desc varchar (200) null COMMENT '订单说明',
    order_amount decimal(18,2) not null COMMENT '订单应付金额',
    order_paid_amount decimal(18,2) not null COMMENT '订单实付金额',
    order_state TINYINT(1)  not null COMMENT '订单状态',
    create_time datetime not null COMMENT '创建时间',
    update_time datetime not null COMMENT  '修改时间',
    closed_time datetime null COMMENT '完成时间'
) engine innodb
COMMENT '订单信息';

create table apo_order_payment(
    payment_id int unsigned auto_increment primary key COMMENT '支付记录ID',
    order_id int unsigned not null COMMENT '订单id',
    order_no varchar(20) not null  COMMENT '订单编号',
    payment_type TINYINT(1) unsigned not null COMMENT '支付方式',
    pay_amount decimal(18,2) not null COMMENT '支付金额',
    pay_state TINYINT(1) unsigned not null COMMENT '支付状态:[0:未通知微信,1:已生成预付款单,2:支付完成,3:已过期]',
    create_time datetime not null COMMENT '创建时间',
    update_time datetime not null COMMENT  '修改时间',
    pay_time datetime null COMMENT '支付完成时间',
    third_party_order_no varchar(50) null COMMENT '第三方订单号'
)
engine innodb
COMMENT '订单信息';




-- 
