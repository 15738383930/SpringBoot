package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dictionary;
import com.example.demo.service.DictionaryService;

/**
 * 公共控制器
 * @author zhouhao
 *
 */
@Controller
public class BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected DictionaryService dictionaryService;

	private static Dictionary dictionary;

	/**
	 * 获取父字典信息下的字典集合
	 * @param name 父字典名称
	 * @return
	 */
	protected List<Dictionary> dictionaryListByParentName(String name) {
		dictionary = dictionaryService.queryByNameAndParentIdIsNull(name);
		if(dictionary != null) {
			//父字典对象的id，即parentId
			Integer parentId = dictionary.getId();
			return dictionaryService.queryByParentIdOrderByCode(parentId);
		} else {
			log.error("查询父字典信息失败，父字典名称：{}",name);
			return new ArrayList<Dictionary>();
		}
	}

    /**
     * 获取request对象参数
     * @param request
     * @return
     */
    public Map<String, Object> getRequestParameter(HttpServletRequest request) {
        // 请求的页数
        String currentPage = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage");
        if ("".equals(currentPage)) {
            currentPage = "1";
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            String paraValue = request.getParameter(paraName);
            if (!StringUtils.isEmpty(paraValue)) {
                map.put(paraName, paraValue);
            }
        }
        map.put("currentPage", currentPage);
        return map;
    }
}
