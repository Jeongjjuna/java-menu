package menu.domain;

import menu.repository.Category;
import menu.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmTest {
    @DisplayName("못먹는 음식을 포함하진 않았는지 확인")
    @Test
    void algorithmTest1() {
        String coachName = "김부장";
        RecommendationMenu menu = new RecommendationMenu(coachName);

        Algorithm.createRecommendationMenu(coachName, List.of(new Food("우동", "일식"), new Food("스시", "일식")), menu);

        assertThat(menu.getMenus().stream()
                .map(food -> food.getName())
                .collect(Collectors.toList()))
                .doesNotContain("우동", "스시");
    }

    @DisplayName("추천 음식중에 중복된 음식이 있는지")
    @Test
    void algorithmTest2() {
    }

    @DisplayName("같은 카테고리가 최대2개 이하로 있는지")
    @Test
    void algorithmTest3() {
        // 랜덤함수 분리 리팩토링 필요
    }
}
