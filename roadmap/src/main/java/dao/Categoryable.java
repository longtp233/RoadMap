package dao;

import java.util.List;

import model.*;

public interface Categoryable extends Genericable <CategoryModel > {
	List<CategoryModel > findAll();
	CategoryModel  findOne(long id);
	CategoryModel  findOneByCode(String code);
}
