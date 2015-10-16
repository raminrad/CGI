package gov.gsa._18f.hackathon.fall2015.datacenter.application.user;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.user.User;

public interface UserService {

	public abstract User login(User user);

	public abstract User create(User user);

	public abstract User update(User user);

}