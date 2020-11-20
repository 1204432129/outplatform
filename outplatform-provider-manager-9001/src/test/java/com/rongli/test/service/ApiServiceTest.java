package com.rongli.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.rongli.service.ApiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //servlet环境，随机端口)
public class ApiServiceTest {

	@Autowired
	public ApiService apiService;
	
	@Test
	public void test1() {
		JSONObject obj = (JSONObject) apiService.selectPatientList(1, 10, "测", "", "","", "", "d", "2020-11-01", "2020-11-30", false);
		System.out.println(obj.toJSONString());
	}
	
	@Test
	public void test2() {
		JSONObject obj = (JSONObject) apiService.selectPayList(1, 10, "1", "", "","", "", "", "", "", "", "", "", "d", "2020-11-01", "2020-11-30", false);
		System.out.println(obj.toJSONString());
	}
	
	@Test
	public void test3() {
		JSONObject obj = (JSONObject) apiService.payConsole("y", "2020", "2020");
		System.out.println(obj.toJSONString());
	}
	
	@Test
	public void test4() {
		JSONObject obj = (JSONObject) apiService.selectDeptAndDockerList();
		System.out.println(obj.toJSONString());
	}
	
	@Test
	public void test5() {
		JSONObject obj = (JSONObject) apiService.registerConsole(null, null, "y", "2020", "2020");
		System.out.println(obj.toJSONString());
	}
	
	@Test
	public void test6() {
		List<String> businessIdList = new ArrayList<String>();
		businessIdList.add("0");
		businessIdList.add("1");
		businessIdList.add("2");
		businessIdList.add("3");
		businessIdList.add("4");
		businessIdList.add("5");
		List<String> channelTypeList = new ArrayList<String>();
		channelTypeList.add("1");
		channelTypeList.add("2");
		List<JSONObject> list = (List<JSONObject>) apiService.totalConsole(businessIdList, channelTypeList, "0", "d", "2020-10-01 00:00:00", "2020-11-30 00:00:00");
		for (JSONObject obj : list) {
			System.out.println(obj.toJSONString());
		}
	}
}
