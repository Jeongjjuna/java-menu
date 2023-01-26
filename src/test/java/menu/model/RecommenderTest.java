package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecommenderTest {
    @DisplayName("카테고리 5개를 잘 추천하는가?")
    @Test
    void recommendCategory() {
        Recommender recommender = new Recommender();

        for (int i = 0; i < 5; i++) {
            recommender.recommendCategory(new RandomGeneratorImpl());
        }

        assertThat(recommender.getRecommendedCategory().size()).isEqualTo(5);
    }

    // 중복 2개초과로 있는지 확인하는 테스트 -> 어떻게 해볼까 고민해보자
}