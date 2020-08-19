package service.impl;

import java.util.List;

import dao.Categoryable;
import model.CategoryModel;
import service.ICategoryService;



public class CategoryService implements ICategoryService {
	
	//@Inject
	private Categoryable categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
