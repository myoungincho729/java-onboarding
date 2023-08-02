package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Set<String>> map = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for (var form : forms) {
            String email = form.get(0);
            String nick = form.get(1);
            for (int start=0; start < nick.length()-1; start++) {
                for (int end=start+2; end <= nick.length(); end++) {
                    String part = nick.substring(start, end);
                    if (map.containsKey(part)) {
                        map.get(part).add(email);
                    } else {
                        map.put(part, new HashSet<>());
                        map.get(part).add(email);
                    }
                }
            }
        }
        for (var m : map.keySet()) {
            if (map.get(m).size() >= 2) {
                for (var email : map.get(m)) {
                    emails.add(email);
                }
            }
        }
        return List.copyOf(emails).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
