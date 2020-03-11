package com.cyq.test;

import java.util.Date;

import org.junit.Test;

import com.cyq.utils.DateUtils;

public class DateUtilsTest {
	
	@SuppressWarnings({ "static-access", "unused" })
	@Test
	public void dateTest() {
		
		String dt1="2020-02-05";
		String dt2="2020-03-05";
		
		DateUtils utils= new DateUtils();
		String dateByInitMonth = utils.getDateByInitMonth(dt1);
		String getDateByFullMonth=utils.getDateByFullMonth(dt2);
		String sql = "select * from t_order where create_time>='"+dateByInitMonth+"' and create_time<='"+getDateByFullMonth+"' ";
		System.out.println(sql);
	}
	
}
