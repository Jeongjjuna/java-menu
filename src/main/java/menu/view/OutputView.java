package menu.view;

import menu.model.Category;
import menu.model.Coach;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private enum ServiceControlMessage {
        SERVICE_START("점심 메뉴 추천을 시작합니다."),
        INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        INPUT_COACH_NOT_EAT("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
        SERVICE_RESULT("메뉴 추천 결과입니다."),
        SERVICE_END("추천을 완료했습니다.");

        private final String message;

        ServiceControlMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

    private static final String DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String FRONT_BRACKET = "[ ";
    private static final String CATEGORY = "카테고리 | ";
    private static final String BACK_BRACKET = " ]";
    private static final String PATH_DELIMITER = " | ";

    public void printServiceStart() {
        System.out.println(ServiceControlMessage.SERVICE_START.getMessage());
    }

    public void printInputCoachName() {
        System.out.println(ServiceControlMessage.INPUT_COACH_NAME.getMessage());
    }

    public void printInputCoachNotEat(String coach) {
        System.out.printf(ServiceControlMessage.INPUT_COACH_NOT_EAT.getMessage(), coach);
    }

    public void printServiceResult(List<Category> recommendedCategory, List<Coach> coaches) {
        System.out.println(ServiceControlMessage.SERVICE_RESULT.getMessage());
        System.out.println(DAYS);
        printRecommendedCategory(recommendedCategory);
        printRecommendedMenu(coaches);
    }

    public void printServiceEnd() {
        System.out.println(ServiceControlMessage.SERVICE_END.getMessage());
    }

    private void printRecommendedCategory(List<Category> recommendedCategory) {
        List<String> categories = recommendedCategory.stream().map(Category::getCategoryName).collect(Collectors.toList());
        System.out.println(FRONT_BRACKET + CATEGORY + String.join(PATH_DELIMITER, categories) + BACK_BRACKET);
    }

    private void printRecommendedMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> recommendedMenu = coach.getRecommendedMenu();
            System.out.println(FRONT_BRACKET + coach.getName() + PATH_DELIMITER + String.join(PATH_DELIMITER, recommendedMenu) + BACK_BRACKET);
        }
    }
}
