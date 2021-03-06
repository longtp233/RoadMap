package dao;

import java.util.List;

import model.*;

public interface Newable extends Genericable <NewModel> {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long add(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> takeAll();
}
