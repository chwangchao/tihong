package test.cache;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zh.cn.wzl.demo.business.entity.ImUser;
import com.zh.cn.wzl.demo.business.service.CacheTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class T_t {

	@Autowired
	CacheTestService cacheTestService;

	@Test
	public void testName_cacheTest_object1() throws Exception {
		cacheTestService.cacheTest_object();
		cacheTestService.cacheTest_object();
	}

	@Test
	public void testName_cacheTest_object2() throws Exception {
		ImUser x = cacheTestService.cacheTest_object("2");
		x = cacheTestService.cacheTest_object("3");
		System.err.println(x);
	}

	@Test
	public void testName_cacheTest_object3() throws Exception {
		ImUser t = new ImUser();
		t.setUid("xxx");
		ImUser imUser = cacheTestService.cacheTest_object(t, "3");
		imUser = cacheTestService.cacheTest_object(t, "3");
		System.err.println(imUser);
	}

	public static String tokenString() {
		UUID uuid = UUID.randomUUID();
		String token = uuid.toString().replaceAll("-", "");
		return token;
	}

	public ImUser getIm() {
		ImUser imUser = new ImUser();
		imUser.setUid(tokenString());
		imUser.setImpwd(tokenString());
		return imUser;
	}

	@Test
	public void testNamecacheTest_list() throws Exception {
		ImUser i1=getIm();
		ImUser i2=getIm();
		List list = cacheTestService.cacheTest_list(i1, i2);
		list = cacheTestService.cacheTest_list(i1, i2);
		for (Object object : list) {
			System.err.println(object.getClass());
		}
	}
	
	@Test
	public void testName() throws Exception {
		for (int i = 0; i < 100; i++) {
			testNamecacheTest_list();
		}
	}

}
