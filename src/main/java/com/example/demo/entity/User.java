package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 用户对象
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

	@Column()
    private String name;

	@Column
    private String type;
	@Column
    private Integer age;

	@Column
    private String sex;
    
    // JPA要求实体必须有一个空的构造函数
    public User() {}

}