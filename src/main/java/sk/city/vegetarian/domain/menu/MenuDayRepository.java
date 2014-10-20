package sk.city.vegetarian.domain.menu;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface MenuDayRepository extends CrudRepository<MenuDay,Long>, MenuDayRepositoryCustom{
	
	MenuDay findByMenuDate(Date menuDate);

}
