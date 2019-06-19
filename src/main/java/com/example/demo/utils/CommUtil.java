package com.example.demo.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 公共工具接口
 * @author zhouhao
 *
 */
public interface CommUtil {

	/**
	 * 基本属性常量
	 * @author zhouhao
	 *
	 */
	public static class Property {

		/**
		 * 数据源的路径
		 */
		public static final String DATASOURCE_URL = "spring.datasource.url";

		/**
		 * 数据源的用户名
		 */
		public static final String DATASOURCE_USERNAME = "spring.datasource.username";

		/**
		 * 数据源的密码
		 */
		public static final String DATASOURCE_PASSWORD = "spring.datasource.password";

		/**
		 * 数据源的驱动名
		 */
		public static final String DATASOURCE_DCN = "spring.datasource.driver-class-name";
		
		/**
		 * 错误请求的URL
		 */
		public static final String ERROR_PATH = "/error";
	}

	/**
	 * 基本公共方法
	 * @author zhouhao
	 *
	 */
	public static class Method {

		/**
		 * 获取配置文件的value
		 * @param fileName 文件名（例：project.properties）
		 * @param key 对象的key
		 * @return
		 */
	    public static String getPropertiesByKey(String fileName, String key) {
	        Properties prop = new Properties();
	        String value = "";
	        try {
	            InputStream in = Method.class.getClassLoader().getResourceAsStream(fileName);
	            prop.load(in);
	            value = prop.getProperty(key);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return value;
	    }
	}

}
