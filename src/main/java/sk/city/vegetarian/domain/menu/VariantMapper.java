package sk.city.vegetarian.domain.menu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VariantMapper implements RowMapper<MealVariant> {
	
	@Override
	public MealVariant mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new MealVariant(rs.getLong("id"), rs.getString("variant"), rs.getInt("variantOrder"));
	}
}
