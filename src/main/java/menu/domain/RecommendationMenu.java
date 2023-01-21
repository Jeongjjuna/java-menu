package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendationMenu {
    private final String targetCoachName;
    private final List<Food> menus;

    public RecommendationMenu(String targetCoachName) {
        this.targetCoachName = targetCoachName;
        menus = new ArrayList<>();
    }

    public List<Food> getMenus() {
        return menus;
    }

    public void add(Food food) {
        menus.add(food);
    }
}
