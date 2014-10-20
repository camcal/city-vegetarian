package sk.city.vegetarian.domain.menu;

import java.util.List;

public interface MealVariantRepositoryCustom {
	List<MealVariant> getMealVariants(Long mealId);
}
