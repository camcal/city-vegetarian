package sk.city.vegetarian.domain.menu;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

import sk.city.vegetarian.domain.AbstractEntity;

/**
 *  A Meal
 */
@Entity
public class Meal extends AbstractEntity{

	private String base;

    private Float price;

    /**
     *  Alternative side dishes
     */
    @OneToMany
    private Set<MealVariant> variants = new HashSet<MealVariant>();
    
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

	public Set<MealVariant> getVariants() {
		return Collections.unmodifiableSet(variants);
	}

	public void setVariants(Set<MealVariant> variants) {
		this.variants = variants;
	}
    
    
}
