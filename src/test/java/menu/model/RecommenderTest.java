package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecommenderTest {
    @DisplayName("카테고리 5개를 잘 추천하는가?")
    @Test
    void recommendCategory() {
        List<Coach> coaches = new ArrayList<>();
        coaches.add(new Coach("토미", List.of("우동", "스시")));
        coaches.add(new Coach("제임스", List.of("뇨끼", "월남쌈")));
        coaches.add(new Coach("포코", List.of("마파두부", "월남쌈")));
        Recommender recommender = new Recommender(coaches);

        for (int i = 0; i < 5; i++) {
            recommender.recommendCategory(new RandomGeneratorImpl());
        }

        assertThat(recommender.getRecommendedCategory().size()).isEqualTo(5);
    }

    // 중복 2개초과로 있는지 확인하는 테스트 -> 어떻게 해볼까 고민해보자


    @DisplayName("메뉴가 잘 추가되는가")
    @Test
    void recommendMenu() {
        List<Coach> coaches = new ArrayList<>();
        Coach coach1 = new Coach("토미", List.of("우동", "스시"));
        coaches.add(coach1);
        Recommender recommender = new Recommender(coaches);


        recommender.recommendMenu(Category.KOREAN);

        assertThat(coach1.getRecommendedMenu().size()).isEqualTo(1);
    }
}