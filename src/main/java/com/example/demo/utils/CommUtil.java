package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

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
	class Property {

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
		
		/**
		 * 父字典名称-人物类型
		 */
		public static final String DICTIONARY_PARENT_NAME_CHARACTER_TYPE = "人物类型";

		/**
		 * 人物类型-最大值
		 */
		public static final int CHARACTER_TYPE_MAX = 10;

		/**
		 * 年龄-最大值（默认）
		 */
		public static final int AGE_MAX_DEFAULT = 120;

		/**
		 * 人物昵称中文-最小长度
		 */
		/*public static final int NAME_CN_MIN_LEN = 2;

		*//**
		 * 人物昵称中文-最大长度
		 *//*
		public static final int NAME_CN_MAX_LEN = 5;

		*//**
		 * 人物昵称英文-最小长度
		 *//*
		public static final int NAME_EN_MIN_LEN = 4;

		*//**
		 * 人物昵称英文-最大长度
		 *//*
		public static final int NAME_EN_MAX_LEN = 20;*/

		/**
		 * 性别-男
		 */
		public static final String SEX_MAN = "男";

		/**
		 * 性别-女
		 */
		public static final String SEX_WOMAN = "女";

		/**
		 * 性别-未知
		 */
		public static final String SEX_UNKNOWN = "未知";

		/**
		 * 项目配置文件
		 */
		public static final String PROBJECT_PROPERTIES = "project.properties";

		/**
		 * 上传图片的URL
		 */
		public static final String IMAGE_UPLOAD_URL = "imageUploadUrl";

		/**
		 * 日期格式化（yyyy-MM-dd HH:mm:ss）
		 */
		public static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

		/**
		 * 日期格式化（yyyy-MM-dd） 【默认】
		 */
		public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";

		/**
		 * 日期格式化（yyyy-MM）
		 */
		public static final String DATE_FORMAT_MONTH = "yyyy-MM";

		/**
		 * 日期格式化（yyyy）
		 */
		public static final String DATE_FORMAT_YEAR = "yyyy";
		
	}

	/**
	 * 基本公共方法
	 * @author zhouhao
	 *
	 */
	class Method {

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
	            InputStream in = CommUtil.Method.class.getClassLoader().getResourceAsStream(fileName);
	            prop.load(in);
	            value = prop.getProperty(key);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return value;
	    }

		/**
		 * 上传图片
		 * @param image
		 * @return
		 * @throws IOException
		 */
	    public static String uploadImage(MultipartFile image) throws IOException {
			// 新图片名称(随机数加上扩展名)
			String newFileName = null;
			if(image != null) {
				// 图片的原始名称
				String originalFilename = image.getOriginalFilename();
				if (originalFilename != null && originalFilename.length() > 0) {
					// 每月创建图片文件夹
					final String dateStr = DateUtil.getDateStr(new Date(), Property.DATE_FORMAT_MONTH);
					// 储存图片的物理路径
					String picPath = CommUtil.Method.getPropertiesByKey(CommUtil.Property.PROBJECT_PROPERTIES, CommUtil.Property.IMAGE_UPLOAD_URL);
					newFileName = dateStr + "/" + UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
					// 新图片
					File newFile = new File(picPath + dateStr + "/");
					// 创建文件夹
					if(!newFile.exists()){
						newFile.mkdirs();
					}
					// 将内存中的数据写入磁盘
					image.transferTo(new File(picPath + newFileName));
				}
			}
			return newFileName;
		}
	}

}
