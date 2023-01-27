package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGeneratorImpl implements RandomGenerator {
    private static final int START = 1;
    private static final int END = 5;

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(START, END);
    }
}
