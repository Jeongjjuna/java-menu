package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> notEatMenu;
    private final List<String> recommendedMenu;

    public Coach(String name, List<String> notEatMenus) {
        this.name = name;
        this.notEatMenu = notEatMenus;
        recommendedMenu = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<String> getNotEatMenu() {
        return this.notEatMenu;
    }

    public List<String> getRecommendedMenu() {
        return this.recommendedMenu;
    }
}
