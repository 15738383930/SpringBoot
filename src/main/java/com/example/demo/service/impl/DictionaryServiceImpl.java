package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DictionaryRepository;
import com.example.demo.entity.Dictionary;
import com.example.demo.service.DictionaryService;

/**
 * 字典信息业务实现层
 * @author zhouhao
 *
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
	
	@Autowired
	private DictionaryRepository dictionaryDao;
	
	@Override
	public Dictionary queryByNameAndParentIdIsNull(String name) {
		return dictionaryDao.findByNameAndParentIdIsNull(name);
	}

	@Override
	public List<Dictionary> queryByParentIdOrderByCode(Integer parentId) {
		return dictionaryDao.findByParentIdOrderByCode(parentId);
	}

}
