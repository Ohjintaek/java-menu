package menu.controller;

import menu.model.Category;
import menu.model.Coach;
import menu.model.Validator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RecommenderController {
    private final InputView inputView;
    private final OutputView outputView;

    private List<Category> recommendedCategories = new ArrayList<>();
    private List<Coach> coaches;

    public RecommenderController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.showStartRecommender();
    }

    private void registerCoaches() {
        List<String> coachesName = getValidCoachesName();
        for (String name : coachesName) {
            coaches.add(new Coach(name));
        }
    }

    private List<String> getValidCoachesName() {
        List<String> coachesName = new ArrayList<>();
        while(coachesName.size() == 0) {
            try {
                String userInput = inputView.getCoachesName();
                coachesName = Validator.isValidCoachesName(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return coachesName;
    }
}
