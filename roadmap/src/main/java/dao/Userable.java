package dao;

import model.*;

public interface Userable extends Genericable <UserModel > {
	UserModel  findUser(String userName, String password);
}
