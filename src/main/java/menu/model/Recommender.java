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

    public void recommendMenu(Category category) {
        // | 한식 | 한식 | 일식 | 중식 | 아시안 ]
        // 토미, 제임스, 포코

        Food foods;
        String menu;
        for (Coach coach : coaches) {
            foods = category.getFood();
            do {
                System.out.println(foods.getFoods() + "여기서");
                menu = Randoms.shuffle(foods.getFoods()).get(0);
                System.out.println(coach.getName() + category.getCategoryName() + menu + " -> 이게 어떻게 나옴? \n");
            }while (isDuplicatedMenu(coach, menu) || isContainNotEatMenu(coach, menu));
            List<String> recommended = coach.getRecommendedMenu();
            recommended.add(menu);
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
