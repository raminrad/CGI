package gov.gsa._18f.hackathon.fall2015.datacenter.application.user;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class UserServiceImplTest {

	private static UserService userService ;
	
	@BeforeClass
	public static void init() {
		userService = new UserServiceImpl();
		
	}
	@Test
	public void testAuthenticate() {
		// TODO - add user to DB first
		
		User user = new User();
		
		user = userService.login(user);
		Assert.assertTrue(user.getAuthenticated());
	}
}
