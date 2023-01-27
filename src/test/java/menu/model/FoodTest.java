package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodTest {
    @DisplayName("Food가 잘 생성 되는지")
    @Test
    void createTest() {
        Food food = Food.ASIAN_FOOD;
        assertThat(food.getFoods()).containsExactly("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    }
}