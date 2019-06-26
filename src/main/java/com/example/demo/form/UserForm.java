package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class UserForm {

	//修改时触发校验
	public interface Update{}
	
	//添加时触发校验
	public interface Add{}

	@Null(groups= {Add.class})
	@NotNull(groups= {Update.class})
    private Integer id;

	//@Size(min=3,max=12)
	//用户名：以字母开头，可带数字、下划线、. 等字符 长度3到12
	@Pattern(regexp="^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){2,11}$")
    private String userName;

    @Size(min=8,max=16)
    private String passWord;

    @Range(min=1,max=120)
    private Integer age;
    
    @Email
    private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
