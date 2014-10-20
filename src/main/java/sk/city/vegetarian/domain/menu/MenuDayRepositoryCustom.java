package sk.city.vegetarian.domain.menu;

import java.util.List;

public interface MenuDayRepositoryCustom {
	
	MenuDay getCurrentDayMenu();
	List<Meal> getMenuDayMeals(Long menuDayId);
}
