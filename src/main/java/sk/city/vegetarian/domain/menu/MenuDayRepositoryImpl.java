package sk.city.vegetarian.domain.menu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class MenuDayRepositoryImpl implements MenuDayRepositoryCustom {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public MenuDay getCurrentDayMenu() {
		MenuDay menuDay = new MenuDay();
		return menuDay;
	}
	
	@Override
	public List<Meal> getMenuDayMeals(Long menuDayId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate.query("SELECT m.* FROM meal m RIGHT JOIN menuday_meal mm ON m.id = mm.meals_id where mm.MenuDay_id = ?", new MealMapper(), menuDayId);
	}

}
