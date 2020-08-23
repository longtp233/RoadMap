package service;

import java.util.List;

import model.*;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel add(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long ids);
	NewModel  findOne(long id);
	List<NewModel> takeAll();
}
