package com.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.log.entity.RightObject;

/**
 * 操作员权限相关 模仿：SecurityInfo.java
 * 
 * @author Wei 下午02:45:48 2016-8-30
 */
public class OperRight {
	/**
	 * @param OperID
	 * @return
	 */
	public List getMenus(String OperID) {
		// Connection conn = DBConnUtil.getConnBySpring();
		JdbcTemplate jdbcTemplate = DBConnUtil.getJdbcTemplate();
		// jdbcTemplate.execute("");
		List<RightObject> menus = new ArrayList();
		String querySql = "select distinct B.RIGHTID,B.RIGHTLEVEL,B.SORTNO,B.BUSSFUNCID,B.url from FW_RIGHT B left join FW_OPERATOR2RIGHT A on INSTR(A.RIGHTID,B.RIGHTID)=1 and A.AUTHTYPE = '1' where A.OPERID = ? ";
		System.out.println("querysql:" + querySql);
		List list = new ArrayList<Object>();
		list = jdbcTemplate.queryForList(querySql, OperID);

		String sRight = "";
		String sParent = "";
		int endIndex = 0;

		for (int i = 0; i < list.size(); i++) {
			RightObject mo = new RightObject();
			Map map2 = (Map) list.get(i);
			sRight = (String) map2.get("RIGHTID");
			sParent = "";
			endIndex = 0;
			/**
			 * 如果rightid的长度大于2，那么说明不是根节点，
			 */
			if (sRight.length() > 2) {
				endIndex = sRight.length() - 2;
				sParent = sRight.substring(0, endIndex);
			} else {
				sParent = "0";
			}
			mo.setRightID((String) map2.get("RIGHTID"));
			mo.setBussFuncID((String) map2.get("BUSSFUNCID"));
			mo.setParentID(sParent);
			mo.setUrl((String) map2.get("URL"));
			menus.add(mo);
		}

		return menus;
	}

	/**
	 * 可以获取到具体权限
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		// List list = new OperRight().getMenus("10006116");//我自己
//		List list = new OperRight().getMenus("10001661");// 只有几个结果
//		Pub.printN("----------" + list);
//	}

	/**
	 * 根据操作id获取权限list
	 * 
	 * @param OperID
	 * @return
	 */
	public List getMenusOfWyl(String OperID) {
		// Connection conn = DBConnUtil.getConnBySpring();
		JdbcTemplate jdbcTemplate = DBConnUtil.getJdbcTemplate();
		// jdbcTemplate.execute("");
		List<RightObject> menus = new ArrayList();
		String querySql = "select distinct B.RIGHTID,B.RIGHTLEVEL,B.SORTNO,B.BUSSFUNCID,B.url from FW_RIGHT B left join FW_OPERATOR2RIGHT A on INSTR(A.RIGHTID,B.RIGHTID)=1  and RIGHTTYPE  in ('1','3') and A.AUTHTYPE = '1' and B.AAE100 ='1' where A.OPERID = ? ";
		//打印查询语句
		System.out
				.println("com.util.OperRight.getMenusOfWyl(String OperID),querysql:"
						+ querySql);
		List list = new ArrayList<Object>();
		list = jdbcTemplate.queryForList(querySql, OperID);
		for(int i=0;i<list.size();i++){
			Map map = (Map)list.get(i);
			System.out.println("map:"+map);
		}
		return null;
	}
	public static void main(String[] args) {
		new OperRight().getMenusOfWyl("10001661");
	}
}
