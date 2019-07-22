package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 字典信息对象
 * @author zhouhao
 *
 */
@Entity
@Data
public class Dictionary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	/**
	 * 字典code
	 */
    private Integer code;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 父字典id （若为空，则该字典的id为父字典id）
     */
	@Column(name="parent_id")
    private Integer parentId;

    /**
     * JPA要求实体必须有一个空的构造函数
     */
    public Dictionary() {}

}