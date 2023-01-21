package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.repository.Category;
import menu.repository.CategoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {
    public static void createRecommendationMenu(String coachName, List<Food> notEating, RecommendationMenu menu) {
        CategoryRepository categoryRepository = new CategoryRepository();

        HashMap<String, Integer> categoryCheck = new HashMap<>();
        categoryCheck.put("일식", 0);
        categoryCheck.put("한식", 0);
        categoryCheck.put("중식", 0);
        categoryCheck.put("아시안", 0);
        categoryCheck.put("양식", 0);

        // 5요일 추천
        for (int i = 0; i < 5; i++) {
            List<Category> categories = categoryRepository.getCategories();

            Category category = selectRandomCategory(categories, categoryCheck);
            Food randomMenu =  selectRandomMenu(category, notEating, menu);

            menu.add(randomMenu);
        }
    }

    private static Category selectRandomCategory(List<Category> categories, HashMap<String, Integer> categoryCheck) {
        Category category;
        while (true) {
            category = categories.get(Randoms.pickNumberInRange(0, 4));
            String name = category.getName();
            if (categoryCheck.get(name) < 2) {
                categoryCheck.put(name, categoryCheck.get(name) + 1);
                break;
            }
        }
        return category;
    }

    private static Food selectRandomMenu(Category category, List<Food> notEating, RecommendationMenu menu) {
        String randomMenuName;

        // 지금까지 추천된 메뉴 이름들
        List<String> menuNames = menu.getMenus().stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());

        // 못먹는 메뉴 이름들
        List<String> notEatingName = notEating.stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());

        while (true) {
            randomMenuName = Randoms.shuffle(category.getMenus()).get(0).getName();

            // 먼저 중복되는 메뉴 있는지 체크
            if (!menuNames.contains(randomMenuName) && !notEatingName.contains(randomMenuName)) {
                break;
            }
        }

        return new Food(randomMenuName, category.getName());
    }
}
