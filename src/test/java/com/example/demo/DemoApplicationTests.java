package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
        Logger logger = LoggerFactory.getLogger(getClass());     
        logger.error("error ...哈哈");
        logger.warn("warn ...嗯嗯");
        logger.debug("debug ...");
        logger.info("info ...");
        logger.trace("trace ...");
	}
}
