package sk.city.vegetarian.domain.menu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.util.Assert;

import sk.city.vegetarian.domain.AbstractEntity;

/**
 *  A Meal
 */
@Entity
public class Meal extends AbstractEntity{

	private String base;

    private Float price;
    
    private Short mealOrder;

    /**
     *  Alternative side dishes
     */
    @OneToMany
    private List<MealVariant> variants;
    
    public Meal(String base, Float price){
    	
    	Assert.hasText(base);
    	Assert.notNull(price);
    	
    	this.base = base;
    	this.price = price;
    }
    
    public Meal() {

    }

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Short getMealOrder() {
		return mealOrder;
	}

	public void setMealOrder(Short mealOrder) {
		this.mealOrder = mealOrder;
	}

	public List<MealVariant> getVariants() {
		return variants;
	}

	public void setVariants(List<MealVariant> variants) {
		this.variants = variants;
	}

	
    
}
