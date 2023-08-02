package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            char convertedChar = c;
            if ('a' <= c && c <= 'z') {
                convertedChar = convertLowerChar(c);
            } else if ('A' <= c && c <= 'Z') {
                convertedChar = convertUpperChar(c);
            }
            answer += convertedChar;
        }
        return answer;
    }

    private static char convertUpperChar(char c) {
        int diff = (int) c - (int) 'A';
        return (char) ( (int) 'Z' - diff);
    }

    private static char convertLowerChar(char c) {
        int diff = (int) c - (int) 'a';
        return (char) ( (int) 'z' - diff);
    }
}
