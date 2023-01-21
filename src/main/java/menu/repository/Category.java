package menu.repository;

import menu.domain.Food;

import java.util.List;

public class Category {
    private String name;
    private List<Food> menus;

    public Category(String name, List<Food> menus) {
            this.name = name;
            this.menus = menus;
    }

    public List<Food> getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }
}
