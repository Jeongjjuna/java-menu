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
        // notEating에 있는 코치수만큼 반복
        for (Map.Entry<String, List<Food>> entry : notEating.entrySet()) {
            RecommendationMenu menu = new RecommendationMenu(entry.getKey()); // 코치 추천메뉴서 생성(비었음)

            //Algorithm.createRecommendationMenu(entry.getKey(), entry.getValue(), menu)
            // entry.getValue();

            // 월화수목금 5번에 걸쳐서 menu에 추천메뉴 삽입
            menu.add(new Food("짜장면", "중식"));
            menu.add(new Food("짬뽕", "중식"));
            menu.add(new Food("군만두", "중식"));
            menu.add(new Food("팔보채", "중식"));
            menu.add(new Food("김밥", "중식"));

            recommendation.add(menu);
        }
    }

    public List<RecommendationMenu> getRecommendation() {
        return recommendation;
    }
}
