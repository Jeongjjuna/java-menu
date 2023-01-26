package menu.controller;

import menu.model.Category;
import menu.model.Coach;
import menu.model.RandomGeneratorImpl;
import menu.model.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final int recommendDays = 5;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> coachNames = new ArrayList<>();
    List<Coach> coaches = new ArrayList<>();

    public void run() {
        outputView.printServiceStart();

        outputView.printInputCoachName();
        coachNames = inputView.inputCoachName();

        for (String coachName : coachNames) {
            outputView.printInputCoachNotEat(coachName);
            Coach coach = new Coach(coachName, inputView.inputCoachNotEat());
            coaches.add(coach);
        }

        recommend();
        outputView.printServiceResult();
        outputView.printServiceEnd();
    }

    private void recommend() {
        Recommender recommender = new Recommender(coaches);

        // 카테고리 추천하기 기능
        for (int day = 0; day < recommendDays; day++) {
            recommender.recommendCategory(new RandomGeneratorImpl());
        }

        // 메뉴 추천하기 기능
        recommender.recommendMenu();
    }
}