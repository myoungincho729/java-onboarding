package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> scores = new HashMap<>();
        HashSet<String> myFriends = new HashSet<>();
        HashSet<String> mark = new HashSet<>();

        for (String visitor : visitors) {
            if (scores.containsKey(visitor)) {
                scores.put(visitor, scores.get(visitor) + 1);
            } else {
                scores.put(visitor, 1);
            }
        }

        for (var friend : friends) {
            if (friend.get(0).equals(user)) {
                myFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                myFriends.add(friend.get(0));
            }
        }

        for (var friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                continue;
            }
            if (myFriends.contains(friend.get(0)) && !myFriends.contains(friend.get(1))) {
                if (mark.contains(friend.get(1))) {
                    continue;
                }
                if (scores.containsKey(friend.get(1))) {
                    scores.put(friend.get(1), scores.get(friend.get(1)) + 10);
                } else {
                    scores.put(friend.get(1), 10);
                }
                mark.add(friend.get(1));
            }
            if (myFriends.contains(friend.get(1)) && !myFriends.contains(friend.get(0))) {
                if (mark.contains(friend.get(0))) {
                    continue;
                }
                if (scores.containsKey(friend.get(0))) {
                    scores.put(friend.get(0), scores.get(friend.get(0)) + 10);
                } else {
                    scores.put(friend.get(0), 10);
                }
                mark.add(friend.get(0));
            }
        }

        List<String> names = new ArrayList<>(scores.keySet());
        List<String> collect = names.stream()
                .filter(e -> myFriends.contains(e) == false)
                .sorted((o1, o2) -> {
                    if (scores.get(o1).equals(scores.get(o2))) {
                        return o1.compareTo(o2);
                    }
                    return scores.get(o2) - scores.get(o1);
                })
                .limit(5)
                .collect(Collectors.toList());
        return collect;
    }
}
