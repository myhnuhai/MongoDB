package org.myhnuhai.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.StringWriter;

public class JsonUtil {

	// for Object to json
	private static ObjectMapper objectMapper = new ObjectMapper();
	// for json to Object
	private static ObjectMapper objectMapper2 = new ObjectMapper();
	
	public static String bean2Json(Object o){
		StringWriter sw = new StringWriter();
		try {
			JsonGenerator generator = objectMapper.getJsonFactory().createJsonGenerator(sw);
			objectMapper.writeValue(generator, o);
			sw.close();
			return sw.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T json2Bean(String json,Class<T> cls){
		try {
			objectMapper2.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

			return objectMapper2.readValue(json, cls);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static <T> T json2Bean(String json,
			TypeReference<T> typeReference) {
		try {
			objectMapper2.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS , true);
			return objectMapper2.readValue(json, typeReference);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}


