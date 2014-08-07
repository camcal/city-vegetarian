package sk.city.vegetarian.domain.menu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import sk.city.vegetarian.domain.AbstractEntity;

@Entity
public class MenuWeek extends AbstractEntity {
	
    private Short menuYear;

    private Short weekNumber;

    /**
     *  Menu days for this week
     */
    @OneToMany
    private List<MenuDay> days;

	public Short getMenuYear() {
		return menuYear;
	}

	public void setMenuYear(Short menuYear) {
		this.menuYear = menuYear;
	}

	public Short getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Short weekNumber) {
		this.weekNumber = weekNumber;
	}

	public List<MenuDay> getDays() {
		return days;
	}

	public void setDays(List<MenuDay> days) {
		this.days = days;
	}
    
    
    
}
