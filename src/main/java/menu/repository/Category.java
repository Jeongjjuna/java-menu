package menu.repository;

import java.util.List;

public class Category {
    private String name;
    private List<String> menus;

    public Category(String name, List<String> menus) {
            this.name = name;
            this.menus = menus;
    }

    public List<String> getMenus() {
        return menus;
    }
}
