package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class UserForm {

	//修改时触发校验
	public interface Update{}
	
	//添加时触发校验
	public interface Add{}

	@Null(groups= {Add.class})
	@NotNull(groups= {Update.class})
    private Integer id;

	//人物姓名
	@Value("${zh.interface.name}")
	private String name;

	//人物类型（详情请查阅数据库）
	private String type;

	//人物年龄
	private Integer age;

	//人物性别
	private String sex;

	//幸运日
	private Date luckyDay;

	//人物肖像（URL）
	private String portrait;

	// 人物肖像
	private MultipartFile portraitFile;

	private final static UserForm userForm = new UserForm();

	public UserForm() {}

	public static UserForm getUserForm(){
		return userForm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getLuckyDay() {
		return luckyDay;
	}

	public void setLuckyDay(Date luckyDay) {
		this.luckyDay = luckyDay;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
