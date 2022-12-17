package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static menu.view.ViewConstants.error;

public class Validator {
    private final int MIN_COACH_NUMBER = 2;
    private final int MAX_COACH_NUMBER = 5;
    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 4;

    public List<String> isValidCoachesName(String userInput) {
        List<String> coachesName = new ArrayList<>(Arrays.asList(userInput.split(",")));
        isValidCoachesSize(coachesName);
        isValidCoachName(coachesName);
        return coachesName;
    }

    private void isValidCoachesSize(List<String> coachesName) {
        int numberOfCoach = coachesName.size();
        if (numberOfCoach < MIN_COACH_NUMBER || numberOfCoach > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(error + "코치는 최소 2명, 최대 5명까지만 함께 식사할 수 있습니다.");
        }
    }

    private void isValidCoachName(List<String> coachesName) {
        for (String name : coachesName) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(error + "코치의 이름은 최소 2글자, 최대 4글자 내에서 입력해 주세요.");
            }
        }
    }
}