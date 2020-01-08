package com.test.javaAPI.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * 参见：http://www.yiibai.com/jackson/jackson_first_application.html
 * 关于json解析之jackson类库的使用demo
 * 
 * @author Wei
 * @time 2016年10月2日 下午4:21:09
 */
public class JacksonTester {
	public static void main(String args[]) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
		jsonString = UtilJackson.jsonStr;
		jsonString = "{\"serviceId\": \"directJdbcService\", \"method\": \"savePointProcedure\"}";
		// map json to student
		try {
			MyService student = mapper.readValue(jsonString, MyService.class);
			System.out.println(student);

			mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(student);
			System.out.println(jsonString);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Student {
	private String name;
	private int age;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Student [ name: " + name + ", age: " + age + " ]";
	}
}

class MyService {

	private String serviceId;
	private String method;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
