package service;

import model.*;

public interface IUserService {
	UserModel  findUser(String userName, String password);
}
