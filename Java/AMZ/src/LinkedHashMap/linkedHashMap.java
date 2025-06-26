package LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> studentsScores = new LinkedHashMap<>();
        //addking to the linkedhashmap
        studentsScores.put("Alice", 85);
        studentsScores.put("Bob", 90);
        studentsScores.put("Charlie", 78);
        System.out.println("Student Scores " + studentsScores);
        int score = studentsScores.get("Bob");
        System.out.println("Bob's Score is " + score);
        studentsScores.remove("Charlie");
        System.out.println("After removing Charlie: " + studentsScores);
        boolean containsKey = studentsScores.containsKey("Alice");
        System.out.println("Is Alice in the list? " + containsKey);

        for(Map.Entry<String, Integer> entry : studentsScores.entrySet()) {
            System.out.println(entry.getKey() + "'s Score: " + entry.getValue());
        }

        studentsScores.putIfAbsent("David", 92);
        System.out.println("After putting David's Score: " + studentsScores);
    }
}
