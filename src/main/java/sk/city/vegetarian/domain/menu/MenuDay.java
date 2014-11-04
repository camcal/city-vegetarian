package sk.city.vegetarian.domain.menu;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import sk.city.vegetarian.domain.AbstractEntity;

/**
 * 	Menu for day specified with menuDate
 */
@Entity
public class MenuDay extends AbstractEntity {
	
	private String holyday;
	
	private Date menuDate;
	
	/**
	 * 	Meals for this day
	 */
	@OneToMany
	private List<Meal> meals;

	public String getHolyday() {
		return holyday;
	}

	public void setHolyday(String holyday) {
		this.holyday = holyday;
	}

	public Date getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(Date menuDate) {
		this.menuDate = menuDate;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	
	
}
