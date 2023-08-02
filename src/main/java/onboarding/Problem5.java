package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();
        for (int index=0; index < moneyList.length; index++) {
            answer.add(Integer.valueOf(money / moneyList[index]));
            money %= moneyList[index];
        }
        return answer;
    }
}
