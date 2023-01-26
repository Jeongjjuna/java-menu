package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Recommender {
    List<Category> recommendedCategory;
    List<Coach> coaches;

    public Recommender(List<Coach> coaches) {
        recommendedCategory = new ArrayList<>();
        this.coaches = coaches;
    }

    public void recommendCategory(RandomGenerator generator) {
        Category category;
        do {
            category = Category.create(generator.generateRandomNumber());
        }while (is_duplicated(category));
        recommendedCategory.add(category);
    }

    private boolean is_duplicated(Category category) {
        // 두번이상 중복되는지 아닌지
        return recommendedCategory.stream().filter(n -> n == category).count() >= 2;
    }

    public void recommendMenu() {
        // | 한식 | 한식 | 일식 | 중식 | 아시안 ]
        // 토미, 제임스, 포코
        for (Coach coach : coaches) {
            // coach에게 5일간의 메뉴 추천
            for (Category category : recommendedCategory) {
                Food foods = category.getFood();
                String menu;
                do {
                    menu = Randoms.shuffle(foods.getFoods()).get(0);
                }while (isDuplicatedMenu(coach, menu) || isContainNotEatMenu(coach, menu));
                List<String> recommended = coach.getRecommendedMenu();
                recommended.add(menu);
            }
        }
    }

    private boolean isDuplicatedMenu(Coach coach, String menu) {
        return coach.getRecommendedMenu().contains(menu);
    }

    private boolean isContainNotEatMenu(Coach coach, String menu) {
        return coach.getNotEatMenu().contains(menu);
    }

    public List<Category> getRecommendedCategory() {
        return recommendedCategory;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
