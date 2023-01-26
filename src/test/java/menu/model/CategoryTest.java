package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CategoryTest {

    @DisplayName("카테고리에 1~5가 들어갔을 때 잘 생성되는지")
    @ParameterizedTest
    @MethodSource("CategoryAndResult")
    void createTest1(int input, String result) {
        Category category = Category.create(input);

        assertThat(category.getCategoryName()).isEqualTo(result);
    }

    private static Stream<Arguments> CategoryAndResult() {
        return Stream.of(
                arguments(1, "일식"),
                arguments(2, "한식"),
                arguments(3, "중식"),
                arguments(4, "아시안"),
                arguments(5, "양식")
        );
    }

    @DisplayName("카테고리에 범위외에 다른 값이 들어갔을 때 예외가 발생하는지")
    @ValueSource(ints = {0, 6, -1})
    @ParameterizedTest
    void createTest2(int input) {
        assertThatCode(() -> Category.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 생성값이 아닙니다.");
    }
}