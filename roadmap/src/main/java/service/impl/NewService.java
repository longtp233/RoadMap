package service.impl;

import java.sql.Timestamp;
import java.util.List;

import dao.Categoryable;
import dao.Newable;
import dao.impl.NewsDao;
import model.CategoryModel;
import model.NewModel;
import service.INewService;
import javax.inject.Inject;

 

public class NewService implements INewService {
	
	//@Inject
	private Newable newDao;

	//@Inject
	private Categoryable categoryDAO;
	
	public NewService() {
		// TODO Auto-generated constructor stub
		newDao=new NewsDao();
	}


	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel  category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel  category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			newDao.delete(id);
		}
	}

//	@Override
//	public List<NewModel> findAll(Pageble pageble) {
//		return newDao.findAll(pageble);
//	}
	
	public List<NewModel> takeAll() {
		//newDao=new NewsDao();
		System.out.println("call service");
		return newDao.takeAll();
	}


    @Override
    public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel  categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
        return newModel;
    }


	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDao.findByCategoryId(categoryId);
	}


	

}
