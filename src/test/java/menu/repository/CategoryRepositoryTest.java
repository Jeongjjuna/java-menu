package menu.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRepositoryTest {

    @DisplayName("초기화한 전체 카테고리가 5개가 맞는가")
    @Test
    void createRepository() {
        CategoryRepository categoryRepository = new CategoryRepository();

        List<Category> categories = categoryRepository.getCategories();

        assertThat(categories.size()).isEqualTo(5);
    }

    @DisplayName("카테소리속 메뉴가 잘 저장 되었는가")
    @Test
    void saveCategoryMenu() {
        CategoryRepository categoryRepository = new CategoryRepository();

        List<Category> categories = categoryRepository.getCategories();

        assertThat(categories.get(0).getMenus())
                .isEqualTo(List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    }
}