package com.test.json;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class test3 {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		String json = "[{\"foo\": \"bar\"},{\"foo\": \"biz\"}]";
		String json = "{\"parameters\":{\"PI_CAE574\":\"20160908\",\"PI_JSRQ\":\"20160908\",\"Pi_CAE920\":\"301\",\"Pi_YAE601\":\"1\",\"PI_BAE001\":\"511502\",\"Pi_JFDX\":\"1\",\"\":\"pkg_weiyl.getMatchResult\"},\"serviceId\":\"directJdbcService\",\"method\":\"savePointProcedure\"}";
		

		
		
		JsonFactory f = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp = f.createJsonParser(json);
		// advance stream to START_ARRAY first:
		jp.nextToken();
		// and then each time, advance to opening START_OBJECT
		jp.nextTextValue();
//		jp.nextTextValue();
//		while (jp.nextToken() == JsonToken.START_OBJECT) {
		while (jp.nextToken() == JsonToken.START_OBJECT) {
//		while (jp.nextTextValue() == JsonToken.START_OBJECT) {
//			Foo foobar = mapper.readValue(jp, Foo.class);
			Map foobar = mapper.readValue(jp, Map.class);
			System.out.println("-------:" +foobar);
		}
	}
}

class Foo {
	public String foo;
}