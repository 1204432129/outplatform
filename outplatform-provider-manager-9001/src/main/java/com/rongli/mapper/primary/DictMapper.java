package com.rongli.mapper.primary;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rongli.config.redis.RedisCache;

@CacheNamespace(implementation= RedisCache.class,eviction=RedisCache.class)
public interface DictMapper extends BaseMapper {
	
	@Select("SELECT dic_name,func_name FROM t_dic_list;")
	public List<JSONObject> selectDictList();
	
	@Select("SELECT channel_type value, channel_type_desc name FROM t_dic_channel")
	public List<JSONObject> selectChannelList();

	@Select("SELECT card_type, card_type_desc FROM t_dic_cardtype")
	public List<JSONObject> selectCardTypeList();

	@Select("SELECT pay_type value, pay_type_desc name FROM t_dic_paytype")
	public List<JSONObject> selectPayTypeList();

	@Select("SELECT business_id value, business_desc name FROM t_dic_business")
	public List<JSONObject> selectBusinessList();

	@Select("SELECT term_id value, term_id name FROM v_api_total GROUP BY term_id")
	public List<JSONObject> selectTermIdList();
	
}
