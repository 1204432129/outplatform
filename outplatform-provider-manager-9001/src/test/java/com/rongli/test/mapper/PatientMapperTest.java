package com.rongli.test.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.rongli.entities.params.Patient;
import com.rongli.mapper.primary.PatientMapper;
import com.rongli.mapper.primary.ReportMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //servlet环境，随机端口)
public class PatientMapperTest {

	@Autowired
	private PatientMapper patientMapper;
	
	@Autowired
	private ReportMapper reportMapper;
	
	@Test
	public void test1() {
		//List<JSONObject> patientList = patientMapper.selectListByNameAndTermId("%测%", "%%");
		//System.out.println(patientList.get(0).toJSONString());
		List<JSONObject> list = patientMapper.selectPatientList("测","","","","d", "2020-11-01 00:00:00", "2020-11-30 00:00:00");
		System.out.println(list.get(0).toJSONString());
		System.out.println(list.size());
	}
	
	@Test
	public void test2() {
		List<String> businessIdList = new ArrayList<String>();
		businessIdList.add("0");
		businessIdList.add("1");
		businessIdList.add("2");
		businessIdList.add("3");
		businessIdList.add("4");
		businessIdList.add("5");
		List<String> payTypeList = new ArrayList<String>();
		payTypeList.add("2");
		payTypeList.add("3");
		List<JSONObject> list = reportMapper.selectCountAndSumByDateAndBusinessAndChannel(businessIdList, "", payTypeList, "0", "d", "2020-10-01 00:00:00", "2020-11-30 00:00:00");
		for (JSONObject obj : list) {
			System.out.println(obj.toJSONString());
		}
	}
	
	@Test
	public void test3() {
		List<String> channelTypeList = new ArrayList<String>();
		channelTypeList.add("1");
		channelTypeList.add("2");
		List<String> payTypeList = new ArrayList<String>();
		payTypeList.add("2");
		payTypeList.add("3");
		List<JSONObject> list = reportMapper.selectCountAndSumByDateAndChannelAndPayType(channelTypeList, payTypeList, "0", "2020-10-01 00:00:00", "2020-11-30 00:00:00");
		for (JSONObject obj : list) {
			System.out.println(obj.toJSONString());
		}
	}
}
