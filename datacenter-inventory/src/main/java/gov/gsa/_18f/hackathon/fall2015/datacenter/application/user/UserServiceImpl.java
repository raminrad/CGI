package gov.gsa._18f.hackathon.fall2015.datacenter.application.user;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see gov.gsa._18f.hackathon.fall2015.datacenter.application.user.UserService#login(gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User)
	 */
	@Override
	public User login(User user) {
		
		// TODO - implement database
		user.setAuthenticated(Boolean.TRUE);
		return user;
	}
	
	/* (non-Javadoc)
	 * @see gov.gsa._18f.hackathon.fall2015.datacenter.application.user.UserService#create(gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User)
	 */
	@Override
	public User create(User user) {
		return user;
	}
	
	/* (non-Javadoc)
	 * @see gov.gsa._18f.hackathon.fall2015.datacenter.application.user.UserService#update(gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User)
	 */
	@Override
	public User update(User user) {
		return user;
	}
}
