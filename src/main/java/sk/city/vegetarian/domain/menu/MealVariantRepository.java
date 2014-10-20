package sk.city.vegetarian.domain.menu;
import org.springframework.data.repository.CrudRepository;

public interface MealVariantRepository extends CrudRepository<MealVariant,Long>, MealVariantRepositoryCustom{

}
