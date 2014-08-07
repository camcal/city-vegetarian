package sk.city.vegetarian.domain.menu;

import javax.persistence.Entity;

import org.springframework.util.Assert;

import sk.city.vegetarian.domain.AbstractEntity;

@Entity
public class MealVariant extends AbstractEntity {
	
	private String variant;
	
	private Integer variantOrder;
	
	public MealVariant(String variant) {
		
		Assert.hasText(variant);
		
		this.variant = variant;
	}
	
	public MealVariant() {

	}
	
	public String getVariant() {
		return variant;
	}
	
	public void setVariant(String variant) {
		this.variant = variant;
	}
	
	public Integer getVariantOrder() {
		return variantOrder;
	}

	public void setVariantOrder(Integer variantOrder) {
		this.variantOrder = variantOrder;
	}

}
