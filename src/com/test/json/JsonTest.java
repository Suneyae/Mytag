package com.test.json;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class JsonTest {
	public static void main(String[] args) throws JsonProcessingException, IOException {
		String jsonStr = "{\"parameters\":{\"PI_CAE574\":\"20160908\",\"PI_JSRQ\":\"20160908\",\"Pi_CAE920\":\"301\",\"Pi_YAE601\":\"1\",\"PI_BAE001\":\"511502\",\"Pi_JFDX\":\"1\",\"\":\"pkg_weiyl.getMatchResult\"},\"serviceId\":\"directJdbcService\",\"method\":\"savePointProcedure\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonStr);
		/*	System.out.println(node.toString());
		Iterator it = node.getElements();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			System.out.println(object+",");
		}*/
		
//		mapper.readValue(root, valueType)
		
		
		Object[] inParams = (Object[]) mapper.readValue(node, Object.class);
		Map[] params = (Map[]) null;
		if (inParams != null) {
			params = (Map[]) toTypedArray(inParams, Map.class);
		}
		
	}

	private static <T> T[] toTypedArray(Object source, Class<T> newType) {
		if (source == null) {
			return null;
		}
		Object newArray = Array.newInstance(newType, Array.getLength(source));
		System.arraycopy(source, 0, newArray, 0, Array.getLength(source));
		return (T[]) newArray;
	}
	
	
	public static String getJsonString(Object obj) {
		ObjectMapper om = new ObjectMapper();
		StringWriter sw = new StringWriter();
		try {
			JsonGenerator jg = new JsonFactory().createJsonGenerator(sw);
			om.writeValue(jg, obj);
			jg.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
	
	@Test
	public void testListToJson() throws JsonGenerationException, JsonMappingException, IOException{
		List<Object> list = new ArrayList<Object>();
		Map map = new HashMap();
		map.put("a", "edf");
		map.put("kk", "我是卫永乐");
		list.add(map);
		String jsonStr = getJsonString(list);
		System.out.println("jsonStr:"+jsonStr);
		
		String jsonStr3 = getJsonString(map);
		System.out.println("jsonStr3:"+jsonStr3);
		//第二种方式
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr2 = mapper.writeValueAsString(list);
		System.out.println("jsonStr2:"+jsonStr2);
		
		
		String jsonStr4 = mapper.writeValueAsString(map);
		System.out.println("jsonStr4:"+jsonStr4);
	}
	
}
