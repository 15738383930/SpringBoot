package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 人物对象
 * @author zhouhao
 *
 */
@Entity
// 表名
@Table(name="user")
// 编译后自动加载Getter,Setter,equals,hashCode,toString方法
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	//人物姓名
    private String name;

    //人物类型（详情请查阅数据库）
    private String type;

    //人物年龄
    private Integer age;

    //人物性别
    private String sex;

    //幸运日
	@Temporal(TemporalType.DATE)
    private Date luckyDay;

    //人物肖像（URL）
    private String portrait;

    // JPA要求实体必须有一个空的构造函数
    public User() {}

}