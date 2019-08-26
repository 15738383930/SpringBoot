package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.utils.RedisUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	// redis中存储的过期时间60s
    private static int ExpireTime = 60;   
    
    public DemoApplicationTests() {
		System.out.println("Redis数据库正在初始化。。。");
	}

    @Resource
    private RedisUtil redisUtil;
    
	@Test
	public void contextLoads() {
        Logger logger = LoggerFactory.getLogger(getClass());     
        logger.error("error ...哈哈");
        logger.warn("warn ...嗯嗯");
        logger.debug("debug ...");
        logger.info("info ...");
        logger.trace("trace ...");
	}
	
	@Test
	public void a() {
		final String key = "username";
		System.out.println("Redis数据库初始化成功。");
		System.out.println("Redis正在进行存储：" + key);
		if (redisUtil.set(key, 2645244266l)) {
			System.out.println(key + "存储成功！");
		}
		if (redisUtil.hasKey(key)) {
			System.out.println(key + "的值是：" + redisUtil.get(key));
		} else {
			System.out.println(key + "不存在！");
		}
	}
}
