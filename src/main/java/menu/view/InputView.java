package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String DELIMITER_STRING = ",";

    public List<String> inputCoachName() {
        return parseWithDelimiter(Console.readLine());
    }

    public List<String> inputCoachNotEat() {
        return parseWithDelimiter(Console.readLine());
    }

    private List<String> parseWithDelimiter(String input) {
        return List.of((input.split(DELIMITER_STRING)));
    }
}
