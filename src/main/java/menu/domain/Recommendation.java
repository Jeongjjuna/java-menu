package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommendation {
    private List<RecommendationMenu> recommendation;
    private HashMap<String, List<Food>> notEating;

    public Recommendation(HashMap<String, List<Food>> notEating) {
        recommendation = new ArrayList<>();
        this.notEating = notEating;
    }

    public void creatRecommendaionMenu(HashMap<String, List<Food>> notEating) {
        // 각 코치에 대해 추천메뉴 생성
        for (Map.Entry<String, List<Food>> entry : notEating.entrySet()) {
            RecommendationMenu menu = new RecommendationMenu(entry.getKey());
            Algorithm.createRecommendationMenu(entry.getKey(), entry.getValue(), menu);
            recommendation.add(menu);
        }
    }

    public List<RecommendationMenu> getRecommendation() {
        return recommendation;
    }
}
