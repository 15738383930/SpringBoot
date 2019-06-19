package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.utils.CommUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Beetl模板Controller
 * @author zhouhao
 *
 */
//@Controller
@RequestMapping("/error")
public class ErrorController extends AbstractErrorController {

	Log log = LogFactory.getLog(ErrorController.class);
	
	@Autowired
	ObjectMapper objectMapper;
	
	public ErrorController() {
		super((ErrorAttributes) new DefaultErrorAttributes());
	}
	
	@RequestMapping(CommUtil.Property.ERROR_PATH)
	public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
		Throwable cause = getCause(request);
		//状态码
		int status = (int) model.get("status");
		//错误信息
		String message =  (String) model.get("message");
		//友好提示
		String errorMessage =  (String) model.get("cause");
		//后台打印日志信息方便排错
		log.info(status+","+message, cause);
		response.setStatus(status);
		if(!isJsonRequest(request)) {
			ModelAndView view = new ModelAndView("/error.btl");
			view.addAllObjects(model);
			view.addObject("errorMessage", errorMessage);
			view.addObject("status", status);
			view.addObject("cause", cause);
			return view;
		} else {
			Map error = new HashMap();
			error.put("success", false);
			error.put("errorMessage", errorMessage);
			error.put("message", message);
			//writeJson(response,error);
			return null;
		}
	}
	
	protected String getErrorMessage(Throwable ex) {
		return "服务器错误，请联系管理员";
	}
	
	protected Throwable getCause(HttpServletRequest request) {
		Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
		if(error != null) {
			// MVC有可能会封装异常成ServletException，需要调用getCause获取真正的异常
			while (error instanceof ServletException && error.getCause() != null) {
				error = ((ServletException) error).getCause();
			}
		}
		return error;
	}
	
	protected boolean isJsonRequest(HttpServletRequest request) {
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if(requestUri != null && requestUri.endsWith(".json")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
