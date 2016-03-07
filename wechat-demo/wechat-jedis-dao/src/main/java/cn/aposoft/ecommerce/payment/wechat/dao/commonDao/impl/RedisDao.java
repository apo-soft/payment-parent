package cn.aposoft.ecommerce.payment.wechat.dao.commonDao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import cn.aposoft.ecommerce.payment.wechat.dao.commonDao.IRedisDao;

public class RedisDao<M extends Serializable> implements IRedisDao<M>{
	
	@Autowired
	protected RedisTemplate<String, Serializable> redisTemplate;

	//protected ValueOperations<String, Serializable> simpleOps;

	/*public RedisDao(RedisTemplate<String, Serializable> template) {
		this.redisTemplate = template;
		simpleOps = redisTemplate.opsForValue();
	}*/

}
