package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Dictionary;

/**
 * 字典信息业务接口
 * @author zhouhao
 *
 */
public interface DictionaryService {
	
	/**
	 * 查询父字典信息
	 * @param name 父字典名称
	 * @return
	 */
	Dictionary queryByNameAndParentIdIsNull(String name);
	
	/**
	 * 查询父字典下的字典信息集合并按code升序排列
	 * @param parentId 父字典id
	 * @return
	 */
	List<Dictionary> queryByParentIdOrderByCode(Integer parentId);
}
