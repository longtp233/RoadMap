package service.impl;

import java.sql.Timestamp;
import java.util.List;

//import dao.Categoryable;
import dao.Newable;
import dao.impl.NewsDao;
//import model.CategoryModel;
import model.NewModel;
import service.INewService;
import javax.inject.Inject;

 

public class NewService implements INewService {
	
	private Newable newDao;

	
	public NewService() {
		// TODO Auto-generated constructor stub
		newDao=new NewsDao();
	}


	@Override
	public NewModel add(NewModel newModel) { 
		Long newId = newDao.add(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());  
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long ids) {
		 
			newDao.delete(ids);
		 
	}

	
	public List<NewModel> takeAll() { 
		return newDao.takeAll();
	}


    @Override
    public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id); 
        return newModel;
    }


	@Override
	public List<NewModel> findByCategoryId(Long categoryId) { 
		return newDao.findByCategoryId(categoryId);
	}


	

}
