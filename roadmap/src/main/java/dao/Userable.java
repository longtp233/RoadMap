package dao;

import model.*;

public interface Userable extends Genericable <UserModel > {
	UserModel  findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
