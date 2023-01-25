package menu.controller;

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

    }

}
