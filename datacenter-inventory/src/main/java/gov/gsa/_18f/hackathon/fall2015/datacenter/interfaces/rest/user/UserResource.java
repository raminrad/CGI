package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.user;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationErrorCode;
import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;
import gov.gsa._18f.hackathon.fall2015.datacenter.application.user.UserService;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/user")
public class UserResource {
	private static final Log logger = LogFactory.getLog(UserResource.class);
	
	@Autowired
	UserService userService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse authenticate(@QueryParam("username") String username, 
				@QueryParam("password") String password,
				@Context HttpServletRequest request) {
		User user = new User();
		
		
		user.setUsername(username);
		user.setPassword(password);
		try {
			user = userService.login(user);
			if (user.getAuthenticated()) {				
				String uuid = UUID.randomUUID().toString();
				HttpSession session = request.getSession();				
				session.setAttribute("UUID", uuid);
				
				return new UserResponse(uuid);			
			}
			else {
				throw new ApplicationException(ApplicationErrorCode.E_AuthenticationFailed, 
						"invalid username or password");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}		
	}

}
