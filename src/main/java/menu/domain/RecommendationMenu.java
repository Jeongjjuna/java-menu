package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendationMenu {
    private final String targetCoachName;
    private final List<String> menus;

    public RecommendationMenu(String targetCoachName) {
        this.targetCoachName = targetCoachName;
        menus = new ArrayList<>();
    }

    public List<String> getMenus() {
        return menus;
    }

    public void add(String name) {
        menus.add(name);
    }
}
