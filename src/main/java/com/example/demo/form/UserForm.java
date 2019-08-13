package com.example.demo.form;

import javax.validation.constraints.*;

import com.example.demo.interfaces.Age;
import com.example.demo.interfaces.Sex;
import com.example.demo.utils.CommUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 人物封装对象
 * @Author zhou
 * @Date  2019/8/8 10:31
 */
@Data
public class UserForm {

	/**
	 * 修改时触发校验
	 */
	public interface Update{}

	/**
	 * 添加时触发校验
	 */
	public interface Add{}

	@Null(groups= {Add.class})
	@NotNull(groups= {Update.class})
    private Integer id;

	/**
	 * 人物昵称
	 * （两种情况）
	 * 1. 2-5个中文
	 * 2. 4-20个英文（包含单词间的空格）
	 */
	@Pattern(regexp = "^[a-zA-Z]{4,20}$|^[\\u4e00-\\u9fa5]{2,5}$", message = "人物昵称由【2-5个中文】或【4-20个英文】组成", groups = {Add.class})
	private String name;

	/**
	 * 人物类型
	 * 0-10（详情请查阅数据库）
	 */
	@NotNull(message = "请选择人物类型", groups= {Add.class})
	@Max(value = CommUtil.Property.CHARACTER_TYPE_MAX, message = "请选择正确的人物类型", groups = {Add.class})
	private Integer type;

	/**
	 * 人物年龄
	 * 不超过120岁
	 */
	@Age(groups = {Add.class})
	private Integer age;

	/**
	 * 人物性别
	 * 男、女、未知
	 */
	@Sex(groups = {Add.class})
	private String sex;

	/**
	 * 幸运日
	 */
	@NotNull(message = "请选择幸运日", groups= {Add.class})
	private Date luckyDay;

	/**
	 * 人物肖像（URL）
	 */
	private String portrait;

	/**
	 * 人物肖像
	 */
	private MultipartFile portraitFile;

	private final static UserForm userForm = new UserForm();

	public UserForm() {}
}
