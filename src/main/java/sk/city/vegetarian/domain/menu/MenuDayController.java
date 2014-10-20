package sk.city.vegetarian.domain.menu;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/currentMenuDay")
public class MenuDayController {
	
	private static Logger LOG = LoggerFactory.getLogger(MenuDayController.class);
	
	@Autowired
	public MenuDayRepository menuDayRepository;
	
	@Autowired
	public MealVariantRepository mealVariantRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody MenuDay getCurrentMenuDay(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    LOG.debug("Current date: {}", calendar.getTime()); 
		
		MenuDay menuDay = menuDayRepository.findByMenuDate(calendar.getTime());
		List<Meal> meals = menuDayRepository.getMenuDayMeals(menuDay.getId());
		
		for (Meal meal : meals) {
			meal.setVariants(mealVariantRepository.getMealVariants(meal.getId()));
		}
		
		menuDay.setMeals(meals);
		LOG.debug("getCurrentDayMenu(): " + menuDay);
		
		return menuDay;
	}

	public MenuDayRepository getMenuDayRepository() {
		return menuDayRepository;
	}

	public void setMenuDayRepository(MenuDayRepository menuDayRepository) {
		this.menuDayRepository = menuDayRepository;
	}

	public MealVariantRepository getMealVariantRepository() {
		return mealVariantRepository;
	}

	public void setMealVariantRepository(MealVariantRepository mealVariantRepository) {
		this.mealVariantRepository = mealVariantRepository;
	}
	
	
}
