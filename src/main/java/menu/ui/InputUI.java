package menu.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputUI {
    public static List<String> inputCoach() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        List<String> coachNames = List.of(input.split(","));
        return coachNames;
    }

    public static List<String> inputNotEatingFood(String name) {
        System.out.println(name + "이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        List<String> foodNames = List.of(input.split(","));
        return foodNames;
    }
}
