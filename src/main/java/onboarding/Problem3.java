package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int num = 1; num <= number; num++) {
            answer += countThree(num);
        }
        return answer;
    }

    private static int countThree(int num) {
        int countOfThree = 0;
        while (num != 0) {
            int curr = num % 10;
            if (curr == 3 || curr == 6 || curr == 9) {
                countOfThree++;
            }
            num /= 10;
        }
        return countOfThree;
    }
}
