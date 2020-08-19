package service.impl;

import dao.Userable;
import model.UserModel;
import service.IUserService;

public class UserService implements IUserService {
	 
	//@Inject
	private Userable userDAO;
 
	
	@Override
	public UserModel  findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
