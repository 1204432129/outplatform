package com.rongli.mapper.primary;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rongli.config.redis.RedisCache;

@CacheNamespace(implementation= RedisCache.class,eviction=RedisCache.class)
public interface ReportMapper extends BaseMapper {
	
	/*
	 * 业务汇总统计：表数据，折线图
	 */
	public List<JSONObject> selectCountAndSumByDateAndBusinessAndChannel(List<String> businessIdList, String channelType, List<String> payTypeList, String tradeResult, String datetype, String startDate, String endDate);
	
	/*
	 * 业务汇总统计：饼状图
	 */
	public List<JSONObject> selectCountAndSumByBusinessId(List<String> businessIdList, String channelType, List<String> payTypeList, String tradeResult, String datetype, String startDate, String endDate);

	/*
	 * 业务汇总统计：统计成功与失败
	 */
	public List<JSONObject> selectCountAndSumByBusinessIdAndTradeResult(List<String> businessIdList, String channelType, List<String> payTypeList, String datetype, String startDate, String endDate);

	/*
	 * 渠道报表
	 */
	public List<JSONObject> selectCountAndSumByDateAndChannelAndPayType(List<String> channelTypeList, List<String> payTypeList, String tradeResult, String startDate, String endDate);
	
	/*
	 * 渠道报表：统计成功与失败
	 */
	public List<JSONObject> selectCountAndSumByChannelAndTradeResult(List<String> channelTypeList, List<String> payTypeList, String startDate, String endDate);
	
	/*
	 * 终端报表
	 */
	public List<JSONObject> selectCountAndSumByDateAndTermIdAndPayType(List<String> termIdList, List<String> payTypeList, String tradeResult, String startDate, String endDate);
	
	/*
	 * 终端报表：统计成功与失败
	 */
	public List<JSONObject> selectCountAndSumByTermIdAndTradeResult(List<String> termIdList, List<String> payTypeList, String startDate, String endDate);
}
