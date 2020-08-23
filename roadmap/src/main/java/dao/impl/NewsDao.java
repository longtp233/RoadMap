package dao.impl;

import java.util.List;

import dao.Newable;
import map.NewMapper;
import model.NewModel;

public class NewsDao extends Generic<NewModel> implements Newable {
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long add(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news");
		sql.append(" (title, content, categoryid)");
		sql.append(" VALUES(?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),newModel.getCategoryId());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news");
		sql.append(" SET title = ?, content = ?, categoryid = ?,");
		sql.append(" WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getContent(),updateNew.getCategoryId(),
				updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}


	@Override
	public List<NewModel> takeAll() {
		String sql="SELECT * FROM news";
		List<NewModel> res=query(sql, new NewMapper());
		return res;
	}

}
