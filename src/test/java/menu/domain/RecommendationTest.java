package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RecommendationTest {

    @DisplayName("못먹는 정보를 줬을 때 추천서가 잘 생성이 되나")
    @Test
    void creatTest() {
        HashMap<String, List<Food>> notEating = new HashMap<>();
        notEating.put("토미", List.of(new Food("우동", "일식"), new Food("스시", "일식")));
        notEating.put("제임스", List.of(new Food("뇨끼", "양식"), new Food("월남쌈", "아시안")));
        notEating.put("포코", List.of(new Food("마파두부", "중식"), new Food("고추잡채", "중식")));

        assertThatCode(() -> new Recommendation(notEating))
                .doesNotThrowAnyException();
    }

    @DisplayName("코치수와 생성된 추천메뉴 수가 같은지")
    @Test
    void createRecommendationMenu1() {
        HashMap<String, List<Food>> notEating = new HashMap<>();
        notEating.put("토미", List.of(new Food("우동", "일식"), new Food("스시", "일식")));
        notEating.put("제임스", List.of(new Food("뇨끼", "양식"), new Food("월남쌈", "아시안")));
        notEating.put("포코", List.of(new Food("마파두부", "중식"), new Food("고추잡채", "중식")));
        Recommendation recommendation = new Recommendation(notEating);

        recommendation.creatRecommendaionMenu(notEating);

        assertThat(recommendation.getRecommendation().size()).isEqualTo(3);
    }
}
