package service.impl;

import dao.Userable;
import dao.impl.UserDao;
import model.UserModel;
import service.IUserService;

public class UserService implements IUserService {
	 
	 
	private Userable userDAO;
 
	
	@Override
	public UserModel  findUser(String userName, String password) {
		userDAO=new UserDao();
		return userDAO.findUser(userName, password);
	}
	
}
