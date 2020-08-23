package map;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;


public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryId"));
			return news;
		} catch (SQLException e) {
			return null;
		}	
	}
}
