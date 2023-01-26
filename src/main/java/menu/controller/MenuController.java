package menu.controller;

import menu.model.Category;
import menu.model.RandomGeneratorImpl;
import menu.model.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> coaches = new ArrayList<>();
    List<String> coachNotEat = new ArrayList<>();

    public void run() {
        outputView.printServiceStart();

        outputView.printInputCoachName();
        coaches = inputView.inputCoachName();

        for (String coach : coaches) {
            outputView.printInputCoachNotEat(coach);
            coachNotEat = inputView.inputCoachNotEat();
            System.out.println(coachNotEat);
        }

        recommend();
        outputView.printServiceResult();
        outputView.printServiceEnd();
    }

    private void recommend() {
        // 카테고리 추천하기 기능
        Recommender recommender = new Recommender();
        do {
            Category category = recommender.recommendCategory(new RandomGeneratorImpl());
        }while (recommender.getRecommendedCategory().size() < 5);
    }
}