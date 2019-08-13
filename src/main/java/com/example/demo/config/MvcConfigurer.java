package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import com.example.demo.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SpringMVC配置
 * @Author zhou
 * @Date  2019/8/5 17:11
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 增加一个拦截器，检查会话，URL以admin开头的都使用此拦截器
		registry.addInterceptor(new SessionHandlerInterCeptor()).addPathPatterns("/admin/**");
	}
	
	/**
	 * 跨域访问配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 允许所有跨域访问
		//registry.addMapping("/**");
		
		// 仅允许来自https://www.baidu.com的跨域访问，且限定访问路径为/api、 方法是POST或GET。
		registry.addMapping("/api/**")
			// 进行跨域访问的请求URL
			.allowedOrigins("https://www.baidu.com")
			// 请求方式，多个以逗号分隔
			.allowedMethods("POST", "GET");
	}
	
	/**
	 * 日期格式初始化
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new CustomDateConveter());
	}
	
	/**
	 * URI到视图的映射
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 请求index.html，返回index.btl视图。
		registry.addViewController("/index.html").setViewName("/index.btl");
		// 所有以.do结尾的请求将重定向到index.html请求
		registry.addRedirectViewController("/**/*.do", "/index.html");
	}

	/**
	 * 拦截器初始化
	 * @author zhouhao
	 *
	 */
	class SessionHandlerInterCeptor implements HandlerInterceptor {
		
		/**
		 * 请求开始前的拦截器（登录拦截器）
		 * @param request
		 * @param response
		 * @param handler
		 * @throws Exception
		 */
		@Override
		public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
			User user = (User) request.getSession().getAttribute("user");
			if(user == null) {
				response.sendRedirect("/login.html");
			}
			return true;
		}
		
		/**
		 * 请求结束后的拦截器
		 * @param request
		 * @param response
		 * @param handler
		 * @throws Exception
		 */
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			// Controller方法处理完毕后，调用此方法
		}
		
		/**
		 * 页面渲染结束后的拦截器
		 */
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
			// 页面渲染完毕后调用此方法，通常用来清除某些资源，类似Java语法的finally
		}
	}

	/**
	 * 日期转换器
	 * @Author zhou
	 * @Date  2019/8/6 16:06
	 */
	class CustomDateConveter implements Converter<String, Date> {

		@Override
		public Date convert(String source) {
			if(!StringUtils.isEmpty(source)){
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regExt1 = "^\\d{4}-\\d{2}-\\d{2}$";
				String regExt2 = "^\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}$";

				try {
					if(source.matches(regExt1)) {
						return sdfDate.parse(source);
					} else if (source.matches(regExt2)) {
                        return sdfTime.parse(source);
                    } else {
						throw new RuntimeException("日期格式错误");
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}
			//失败返回null
			return null;
		}

	}

	//其他更多全局定制接口
}
