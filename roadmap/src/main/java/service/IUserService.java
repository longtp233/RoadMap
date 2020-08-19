package service;

import model.*;

public interface IUserService {
	UserModel  findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
