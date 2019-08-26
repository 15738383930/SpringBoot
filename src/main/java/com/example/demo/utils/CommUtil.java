package com.example.demo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
		public static final String ERROR_PATH = "/error.html";
		
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

		/**
		 * 返回消息-查询-查询失败
		 */
		public static final String RESULT_QUERY_ERROR_MSG = "查询失败，请刷新后再试。";

		/**
		 * 返回消息-编辑-成功
		 */
		public static final String RESULT_EDIT_SUCCESS_MSG = "操作成功";
		/**
		 * 返回消息-编辑-失败
		 */
		public static final String RESULT_EDIT_ERROR_MSG = "操作失败，请稍后再试。";

		/**
		 * HashMap默认值大小 （参考阿里开发规范）
		 */
		public static final int HASH_MAP_DEFAULT_SIZE = 16;
		
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

		/**
		 * 上传图片
		 * @param oldImgUrl 旧图片路径
		 * @param newImgFile 新图片文件
		 * @return
		 * @throws IOException
		 */
		public static String uploadImage(String oldImgUrl, MultipartFile newImgFile) throws IOException {
			// 新图片名称(随机数加上扩展名)
			String newFileName = null;
			if(newImgFile != null) {
				// 图片的原始名称
				String originalFilename = newImgFile.getOriginalFilename();
				if (originalFilename != null && originalFilename.length() > 0) {
					// 删除旧图片
					removeImage(oldImgUrl);
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
					newImgFile.transferTo(new File(picPath + newFileName));
				}
			}
			return newFileName;
		}

		/**
		 * 删除图片文件
		 * @param imgUrl
		 */
		public static void removeImage(String imgUrl) {
			if(!StringUtils.isEmpty(imgUrl)) {
				String filePath = CommUtil.Method.getPropertiesByKey(CommUtil.Property.PROBJECT_PROPERTIES, CommUtil.Property.IMAGE_UPLOAD_URL) + imgUrl;
				File f = new File(filePath);
				if (f.exists()) {
					f.delete();
				}
			}
		}

		/**
		 * 对BeanUtils.copyProperties复制数据是非空的处理
		 * @param source
		 * @return
		 */
		private static String[] getNullPropertyNames(Object source) {
			final BeanWrapper src = new BeanWrapperImpl(source);
			java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

			Set<String> emptyNames = new HashSet<String>();
			for(java.beans.PropertyDescriptor pd : pds) {
				Object srcValue = src.getPropertyValue(pd.getName());
				if (srcValue == null) {
					emptyNames.add(pd.getName());
				}
			}
			String[] result = new String[emptyNames.size()];
			return emptyNames.toArray(result);
		}

		/**
		 * BeanUtils.copyProperties的非空版本
		 * 			（如果src中有属性为null时，target对应的属性不会被更新）
		 * @param src 我
		 * @param target 目标
		 */
		public static void copyPropertiesIgnoreNull(Object src, Object target){
			BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
		}
	}

}
