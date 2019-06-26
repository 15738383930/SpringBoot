package com.example.demo.config;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 切面配置
 * @author zhouhao
 *
 */
@Configuration
@Aspect
public class AOPConfig {
	
	private static final Logger log = LoggerFactory.getLogger(AOPConfig.class);

	@Around("@within(org.springframework.stereotype.Controller)")
	public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = null;
		try {
			//方法执行前，切入要执行的模块
			args = pjp.getArgs();
			System.out.println("AOP（方法执行前切入）——请求的参数"+Arrays.asList(args));
			long start = System.currentTimeMillis();

			//继续执行方法
			Object o = pjp.proceed();
			long end = System.currentTimeMillis();
			long logTime = end - start;
			System.out.println("方法执行结果"+o);
			System.out.println("方法用时" +(logTime/1000.00)+ "秒");
			return o;
		} catch (Exception e) {
			log.info("系统异常！【异常方法】:{}/n【异常代码】:{}/n【异常信息】:{}/n【请求的参数】:{}", pjp.getTarget().getClass().getName() + pjp.getSignature().getName(), e.getClass().getName(), e.getMessage(), Arrays.asList(args));
			throw e;
		}
	}
}
