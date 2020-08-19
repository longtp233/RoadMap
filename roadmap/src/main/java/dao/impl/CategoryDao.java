package dao.impl;

import java.util.List;

import dao.Categoryable;
import map.*;
import model.*;

public class CategoryDao extends Generic<CategoryModel > implements Categoryable {

	@Override
	public List<CategoryModel > findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel  findOne(long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel > category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

    @Override
    public CategoryModel  findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel > category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
    }

	
}


