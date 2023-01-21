package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.repository.Category;
import menu.repository.CategoryRepository;

import java.util.HashMap;
import java.util.List;

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


            // 카테고리 랜덤 선택
            Category category = selectRandomCategory(categories, categoryCheck);

            // 카테고리에서 랜덤 메뉴 선택
            String randomMenu = Randoms.shuffle(category.getMenus()).get(0).getName();

            // 이제 여러가지 조건에 맞으면 menu.add(randomMenu)
            menu.add(new Food(randomMenu, category.getName()));
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

}
