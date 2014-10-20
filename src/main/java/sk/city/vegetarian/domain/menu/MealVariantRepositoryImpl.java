package sk.city.vegetarian.domain.menu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MealVariantRepositoryImpl implements MealVariantRepositoryCustom  {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<MealVariant> getMealVariants(Long mealId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate.query("SELECT mv.* FROM mealvariant mv RIGHT JOIN meal_mealvariant mmv ON mv.id = mmv.variants_id where mmv.Meal_id = ?", new VariantMapper(), mealId);
	}

}
