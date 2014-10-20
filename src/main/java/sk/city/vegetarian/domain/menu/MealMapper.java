package sk.city.vegetarian.domain.menu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class MealMapper implements RowMapper<Meal> {

	public Meal mapRow(ResultSet rs, int i) throws SQLException{
		Meal meal = new Meal(rs.getLong("id") ,rs.getString("base"), rs.getFloat("price"), rs.getInt("weight"));
		return meal;
	}

}
