package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Recommender {
    List<Category> recommendedCategory;
    List<Food> recommendedFoods;

    public Recommender() {
        recommendedCategory = new ArrayList<>();
        recommendedFoods = new ArrayList<>();
    }

    public Category recommendCategory(RandomGenerator generator) {
        Category category;
        do {
            category = Category.create(generator.generateRandomNumber());
        }while (is_duplicated(category));
        recommendedCategory.add(category);
        return category;
    }

    private boolean is_duplicated(Category category) {
        // 두번이상 중복되는지 아닌지
        return recommendedCategory.stream().filter(n -> n == category).count() >= 2;
    }

    public List<Category> getRecommendedCategory() {
        return recommendedCategory;
    }
}
