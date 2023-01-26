package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGeneratorImpl implements RandomGenerator {
    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
