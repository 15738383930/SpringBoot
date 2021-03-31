package com.example.demo;

import javax.annotation.Resource;

import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

	@Test
	public void b() {
		User u = new User();
		User u2 = new User();

		u.setType(2);
		u.setSex(null);
		u.setId(1);

		u2.setAge(12);
		u2.setName("haha");
		u2.setId(1);
		u2.setPortrait("ahah");
		u2.setSex("男");
		u2.setType(1);
		BeanUtils.copyProperties(u, u2);
		System.out.println(u2);
	}

	//~  非
	@Test
	public void test3(){
		int a=3;//转二进制：0000...00000011
		int b=~a;
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));//结果为11111111 11111111 11111111 11111100   所有为-4
		//总结：a对应的位为1，则b对应地位为0；否则为1
	}

	//^  异或
	@Test
	public void test4(){
		int a=3;//转二进制：      0000...00000011
		int b=4;//把1转二进制：0000...00000100
		System.out.println(b^a);//结果为 0111   所有为7
		//总结：a与b对应位相同，则结果对应位为0；否则为1
	}

	//>>
	@Test
	public void test5(){
		int a=3;//转二进制：      0000...00000011
		int b=a>>1;
		System.out.println(b);//结果为 0000...00000001   所以为1
		//总结：右移运算符， a >> 1,a二进制减少一位，相当于num除以2
	}

	//<<
	@Test
	public void test6(){
		int a=3;//转二进制：      0000...00000011
		int b=a<<1;
		System.out.println(b);//结果为 0110   所有为6
		//总结：左移运算符，a << 1,a 二进制增加一位，相当于num乘以2
	}
}
