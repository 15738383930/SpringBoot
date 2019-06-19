package com.example.demo.config;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * 切面配置
 * @author zhouhao
 *
 */
@Configuration
@Aspect
public class AOPConfig {

	@Around("@within(org.springframework.stereotype.Controller)")
	public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
		try {
			//方法执行前，切入要执行的模块
			Object[] args = pjp.getArgs();
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
			throw e;
		}
	}
}
