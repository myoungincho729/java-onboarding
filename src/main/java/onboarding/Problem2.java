package onboarding;

import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char chr : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(Character.valueOf(chr))) {
                stack.pop();
            } else {
                stack.push(Character.valueOf(chr));
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        StringBuffer sb = new StringBuffer(answer);
        sb.reverse();
        return sb.toString();
    }
}
