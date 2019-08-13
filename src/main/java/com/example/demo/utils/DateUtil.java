package com.example.demo.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * 日期工具类
 * @author zhouhao
 *
 */
public class DateUtil {

	/**
	 * 获取格式化后的日期(yyyy-MM-dd)
	 * @param date 要格式化的日期
	 * @return
	 */
	public static String getDateStr(Date date){
		return new SimpleDateFormat(CommUtil.Property.DATE_FORMAT_DEFAULT).format(date);
	}

	/**
	 * 获取格式化后的日期
	 * @param date 要格式化的日期
	 * @param format 格式
	 * @return
	 */
	public static String getDateStr(Date date, String format){
		if(StringUtils.isEmpty(format)){
			return getDateStr(date);
		}
		return new SimpleDateFormat(format).format(date);
	}
}
