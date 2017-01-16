import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hjwang.model.User;
import com.hjwang.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);

	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	@Test
	public void testAll() {
		
		List<User> list = userService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
	//@Test
	public void testAdd() {
	
		User user = new User();
		user.setId("0000");
		user.setName("aaaa");
		user.setAge(1234);
		user.setAddress("ABCD");
		int i = userService.insert(user);
		logger.info(JSON.toJSONStringWithDateFormat("add "+i, "yyyy-MM-dd HH:mm:ss"));
	}
	
	//@Test
	public void testUpdate() {
		
		User user = new User();
		user.setId("0000");
		user.setName("bbbb");
		user.setAge(1234);
		user.setAddress("ABCD");
		int i = userService.update(user);
		logger.info(JSON.toJSONStringWithDateFormat("update " +i, "yyyy-MM-dd HH:mm:ss"));
	}
	
	//@Test
	public void testDelete() {
		
		User user = new User();
		user.setId("0000");
		user.setName("bbbb");
		user.setAge(1234);
		user.setAddress("ABCD");
		int i = userService.delete("0000");
		logger.info(JSON.toJSONStringWithDateFormat("delete "+i, "yyyy-MM-dd HH:mm:ss"));
	}
	
}
