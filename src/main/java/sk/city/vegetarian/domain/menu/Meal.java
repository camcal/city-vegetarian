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
    
    private Integer weight;

    /**
     *  Alternative side dishes
     */
    @OneToMany
    private List<MealVariant> variants;
    
    public Meal(Long id, String base, Float price, Integer weight){
    	
    	Assert.notNull(id);
    	Assert.hasText(base);
    	Assert.notNull(price);
    	Assert.notNull(weight);
    	
    	this.setId(id);
    	this.base = base;
    	this.price = price;
    	this.weight = weight;
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	
    
}
