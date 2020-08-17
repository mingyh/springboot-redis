package cn.ming;

import cn.ming.pojo.User;
import cn.ming.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void test1(){
		redisUtil.set("name","ming");
		System.out.println(redisUtil.get("name"));
	}

	//redisTemplate	操作不同的数据类型
	//opsForValue() 操作字符串。。类似String
	//opsForList()  操作List。。类似List    等等

	//除了基本操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的CRUD
	@Test
	public void contextLoads() {

		//获取连接
//		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//		connection.flushDb();
//		connection.flushAll();

		redisTemplate.opsForValue().set("dan","ming");
		System.out.println(redisTemplate.opsForValue().get("dan"));
	}

	@Test
	public void test() throws JsonProcessingException {
		//真实开发一般都使用json来传递数据
		User user = new User("dan", 18);
		/*String jsonUser = new ObjectMapper().writeValueAsString(user);	//序列化	  所有对象需要序列化
		redisTemplate.opsForValue().set("user",jsonUser);*/
		redisTemplate.opsForValue().set("user",user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
