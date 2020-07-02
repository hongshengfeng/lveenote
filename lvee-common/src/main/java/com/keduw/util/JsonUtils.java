package com.keduw.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Json工具类
 *
 * @author hongshengfeng
 * @date 2020.01.23
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 将对象转换成json字符串
     * @param data 转换对象
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
            logger.error("objectToJson err", e);
            return null;
        }
    }

    /**
     * 将json结果集转化为对象
     * @param jsonData 输入json串
     * @param beanType 转换对象的class
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            logger.error("jsonToPojo err", e);
            return null;
        }
    }

    /**
     * 将json数据转换成对象list
     * @param jsonData 输入json串
     * @param beanType 转换对象的class
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
            logger.error("jsonToList err", e);
            return null;
        }
    }
    
}
