package dao.impl;

import java.util.List;

import dao.Userable;
import map.UserMapper;
import model.*;

public class UserDao extends Generic<UserModel > implements Userable  {

	@Override
	public model.UserModel  findUser(String userName, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u"); 
		sql.append(" WHERE username = ? AND pass = ?  ");
		List<model.UserModel> users = query(sql.toString(), new UserMapper(), userName, password);
		return users.isEmpty() ? null : users.get(0);
	}
	
}
