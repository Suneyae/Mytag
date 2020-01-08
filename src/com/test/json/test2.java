package com.test.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class test2 {
	public static ObjectMapper objectMapper = new ObjectMapper();
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "{\"parameters\":{\"PI_CAE574\":\"20160908\",\"PI_JSRQ\":\"20160908\",\"Pi_CAE920\":\"301\",\"Pi_YAE601\":\"1\",\"PI_BAE001\":\"511502\",\"Pi_JFDX\":\"1\",\"\":\"pkg_weiyl.getMatchResult\"},\"serviceId\":\"directJdbcService\",\"method\":\"savePointProcedure\"}";
		
		JavaType javaType = getCollectionType(ArrayList.class, JsonArrayToList.class);
		List<JsonArrayToList> list = objectMapper.readValue(jsonStr, javaType);
		for (JsonArrayToList jatl : list) {
			System.out.println(jatl.toString());
		}
	}

	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}

class JsonArrayToList {
    @JsonProperty("id")
    private String id;

    @JsonProperty("values")
    private List<Integer> values;

    @Override
    public String toString() {
        return "JsonArrayToList{" +
                "id='" + id + '\'' +
                ", values=" + values +
                '}';
    }
}
