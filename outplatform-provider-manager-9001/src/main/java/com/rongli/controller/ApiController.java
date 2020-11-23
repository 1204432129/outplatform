package com.rongli.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rongli.service.ApiService;

@RestController
@RequestMapping("/trade")
public class ApiController {

	@Autowired
	private ApiService apiService;

	/**
	 * 用户注册详情
	 * @return
	 */
	@RequiresPermissions("selectPatientList")
	@RequestMapping("/selectPatientList")
	public Object selectPatientList(Integer page, Integer limit,
			String name, String termId, String patientId, String cardType, String tradeResult,
			String datetype, String startDate, String endDate, Boolean isExport) {
		return apiService.selectPatientList(page, limit,
				name, termId, patientId, cardType, tradeResult,
				datetype, startDate, endDate, isExport);
	}

	/**
	 * 缴费详情
	 * @return
	 */
	@RequiresPermissions("selectPayList")
	@RequestMapping("/selectPayList")
	public Object selectPayList(Integer page, Integer limit,
			String name, String termId, String orderId, String billId, String transactionNo, String bankCardNo, String totalFee,
			String channelType, String payType, String cardType, String tradeResult,
			String datetype, String startDate, String endDate, Boolean isExport) {
		return apiService.selectPayList(page, limit,
				name, termId, orderId, billId, transactionNo, bankCardNo, totalFee,
				channelType, payType, cardType, tradeResult,
				datetype, startDate, endDate, isExport);
	}
	
	/**
	 * 充值详情
	 * @return
	 */
	@RequiresPermissions("selectRechargeList")
	@RequestMapping("/selectRechargeList")
	public Object selectRechargeList(Integer page, Integer limit,
			String name, String termId, String orderId, String transactionNo, String bankCardNo, String amount,
			String channelType, String payType, String tradeResult,
			String datetype, String startDate, String endDate, Boolean isExport) {
		return apiService.selectRechargeList(page, limit,
				name, termId, orderId, transactionNo, bankCardNo, amount,
				channelType, payType, tradeResult,
				datetype, startDate, endDate, isExport);
	}
	
	/**
	 * 挂号详情
	 * @return
	 */
	@RequiresPermissions("selectRegisterList")
	@RequestMapping("/selectRegisterList")
	public Object selectRegisterList(Integer page, Integer limit,
			String name, String termId, String orderId, String hospOrderId, String transactionNo, String bankCardNo, String totalFee,
			String departmentId, String doctorId,
			String channelType, String payType, String cardType, String tradeResult,
			String datetype, String startDate, String endDate, Boolean isExport) {
		return apiService.selectRegisterList(page, limit,
				name, termId, orderId, hospOrderId, transactionNo, bankCardNo, totalFee,
				departmentId, doctorId,
				channelType, payType, cardType, tradeResult,
				datetype, startDate, endDate, isExport);
	}
	
	/**
	 * 缴费统计
	 * @param datetype
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequiresPermissions("payConsole")
	@RequestMapping("/payConsole")
	public Object payConsole(String datetype, String startDate, String endDate) {
		return apiService.payConsole(datetype, startDate, endDate);
	}
	
	/**
	 * 充值统计
	 * @param datetype
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequiresPermissions("rechargeConsole")
	@RequestMapping("/rechargeConsole")
	public Object rechargeConsole(String datetype, String startDate, String endDate) {
		return apiService.rechargeConsole(datetype, startDate, endDate);
	}
	

	/**
	 * 挂号统计
	 * @param departmentId
	 * @param doctorId
	 * @param datetype
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequiresPermissions("registerConsole")
	@RequestMapping("/registerConsole")
	public Object registerConsole(String departmentId, String doctorId, String datetype, String startDate, String endDate) {
		return apiService.registerConsole(departmentId, doctorId, datetype, startDate, endDate);
	}
	
	/**
	 * 获取科室和医生列表
	 * @return
	 */
	@RequiresPermissions("selectDeptAndDockerList")
	@RequestMapping("/selectDeptAndDockerList")
	public Object selectDeptAndDockerList() {
		return apiService.selectDeptAndDockerList();
	}
	
	/**
	 * 获取业务列表
	 * @return
	 */
	@RequiresPermissions("selectBusinessList")
	@RequestMapping("/selectBusinessList")
	public Object selectBusinessList() {
		return apiService.selectBusinessList();
	}
	
	/**
	 * 获取渠道列表
	 * @return
	 */
	@RequiresPermissions("selectChannelList")
	@RequestMapping("/selectChannelList")
	public Object selectChannelList() {
		return apiService.selectChannelList();
	}
	
	/**
	 * 获取支付类型列表
	 * @return
	 */
	@RequiresPermissions("selectPayTypeList")
	@RequestMapping("/selectPayTypeList")
	public Object selectPayTypeList() {
		return apiService.selectPayTypeList();
	}
	
	/**
	 * 获取终端列表
	 * @return
	 */
	@RequiresPermissions("selectTermIdList")
	@RequestMapping("/selectTermIdList")
	public Object selectTermIdList() {
		return apiService.selectTermIdList();
	}
	
	/**
	 * 统计汇总
	 * @return
	 */
	@RequiresPermissions("totalConsole")
	@RequestMapping("/totalConsole")
	public Object totalConsole(String businessIds, String channelType, String payTypes, String tradeResult, String datetype, String startDate, String endDate) {
		String[] businessIdList;
		if(!StringUtils.isEmpty(businessIds)) {
			businessIdList = businessIds.split(",");
		}else {
			businessIdList = new String[0];
		}
		String[] payTypeList;
		if(!StringUtils.isEmpty(payTypes)) {
			payTypeList = payTypes.split(",");
		}else {
			payTypeList = new String[0];
		}
		return apiService.totalConsole(Arrays.asList(businessIdList), channelType, Arrays.asList(payTypeList), tradeResult, datetype, startDate, endDate);
	}
	
	/**
	 * 渠道报表
	 * @return
	 */
	@RequiresPermissions("channelConsole")
	@RequestMapping("/channelConsole")
	public Object channelConsole(String channelTypes, String payTypes, String tradeResult, String startDate, String endDate) {
		String[] channelTypeList;
		if(!StringUtils.isEmpty(channelTypes)) {
			channelTypeList = channelTypes.split(",");
		}else {
			channelTypeList = new String[0];
		}
		String[] payTypeList;
		if(!StringUtils.isEmpty(payTypes)) {
			payTypeList = payTypes.split(",");
		}else {
			payTypeList = new String[0];
		}
		return apiService.channelConsole(Arrays.asList(channelTypeList), Arrays.asList(payTypeList), tradeResult, startDate, endDate);
	}
	
	/**
	 * 终端报表
	 * @return
	 */
	@RequiresPermissions("terminalConsole")
	@RequestMapping("/terminalConsole")
	public Object terminalConsole(String termIds, String payTypes, String tradeResult, String startDate, String endDate) {
		String[] termIdList;
		if(!StringUtils.isEmpty(termIds)) {
			termIdList = termIds.split(",");
		}else {
			termIdList = new String[0];
		}
		String[] payTypeList;
		if(!StringUtils.isEmpty(payTypes)) {
			payTypeList = payTypes.split(",");
		}else {
			payTypeList = new String[0];
		}
		return apiService.terminalConsole(Arrays.asList(termIdList), Arrays.asList(payTypeList), tradeResult, startDate, endDate);
	}
}
