package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (isInvalidInput(pobi) || isInvalidInput(crong)) {
            return -1;
        }
        int pobiNumber = new Number(pobi).calcMaxBetweenTwoNumbers();
        int crongNumber = new Number(crong).calcMaxBetweenTwoNumbers();

        if (pobiNumber > crongNumber) {
            answer = 1;
        }
        else if (pobiNumber < crongNumber) {
            answer = 2;
        }
        else answer = 0;

        return answer;
    }

    private static boolean isInvalidInput(List<Integer> numList) {
        if (numList.size() != 2) {
            return true;
        }
        Integer left = numList.get(0);
        Integer right = numList.get(1);
        if (left <= 0 || left > 400) {
            return true;
        }
        if (right <= 0 || right > 400) {
            return true;
        }
        if (left % 2 == 0) {
            return true;
        }
        if (right != left + 1) {
            return true;
        }
        return false;
    }
}

class Number {
    private int numberLeft;
    private int numberRight;

    public Number(List<Integer> numbers) {
        this.numberLeft = numbers.get(0);
        this.numberRight = numbers.get(1);
    }

    public int calcMaxBetweenTwoNumbers() {
        int sumOfLeftNumber = calcSumOfNumbers(numberLeft);
        int mulOfLeftNumber = calcMulOfNumbers(numberLeft);

        int sumOfRightNumber = calcMulOfNumbers(numberRight);
        int mulOfRightNumber = calcMulOfNumbers(numberRight);

        int maxOfLeft = Math.max(sumOfLeftNumber, mulOfLeftNumber);
        int maxOfRight = Math.max(sumOfRightNumber, mulOfRightNumber);
        return Math.max(maxOfLeft, maxOfRight);
    }

    private int calcSumOfNumbers(int number) {
        int sumOfNumbers = 0;
        int currNumber = number;
        while (currNumber != 0) {
            sumOfNumbers += currNumber % 10;
            currNumber /= 10;
        }
        return sumOfNumbers;
    }

    private int calcMulOfNumbers(int number) {
        int mulOfNumbers = 1;
        int currNumber = number;
        while (currNumber != 0) {
            mulOfNumbers *= currNumber % 10;
            currNumber /= 10;
        }
        return mulOfNumbers;
    }
}