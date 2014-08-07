package sk.city.vegetarian.domain.menu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import sk.city.vegetarian.domain.AbstractEntity;

@Entity
public class MenuCategory extends AbstractEntity {

    private String name;

    private Short categoryOrder;

    /**
     *  Meals in this category
     */
    @OneToMany
    private List<Meal> meals;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(Short categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
    
    
}
