package oracle02;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.inf.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})


public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Resource
	private UserService userService = null;
	
	@Test
	public void test1() {
		User user = userService.findUserById(1);
		System.out.println(user.getUser_name());
		System.out.println(user.getLogin_name());
		System.out.println(user.getPassword());
	}
	
}
