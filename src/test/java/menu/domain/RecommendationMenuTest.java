package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RecommendationMenuTest {

    @DisplayName("추천메뉴 생성테스트")
    @Test
    void creatTest() {
        assertThatCode(() -> new RecommendationMenu("박과장"))
                .doesNotThrowAnyException();
    }

    @DisplayName("추천메뉴 추가기능 확인")
    @Test
    void addMenu() {
        RecommendationMenu recommendationMenu = new RecommendationMenu("박과장");

        recommendationMenu.add(new Food("짜장면", "중식"));
        recommendationMenu.add(new Food("짬뽕", "중식"));

        assertThat(recommendationMenu.getMenus().stream()
                .map(food -> food.getName())
                .collect(Collectors.toList())).containsExactly("짜장면", "짬뽕");
    }
}