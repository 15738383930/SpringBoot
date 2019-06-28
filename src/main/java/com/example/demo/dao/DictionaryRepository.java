package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Dictionary;

/**
 * 字典信息持久层
 * @author zhouhao
 *
 */
@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
	
	Dictionary findById(Integer id);
	
	/**
	 * 查询父字典信息
	 * @param name 父字典名称
	 * @return
	 */
	Dictionary findByNameAndParentIdIsNull(String name);
	
	/**
	 * 查询父字典下的字典信息集合并按code升序排列
	 * @param parentId 父字典id
	 * @return
	 */
	List<Dictionary> findByParentIdOrderByCode(Integer parentId);
}
