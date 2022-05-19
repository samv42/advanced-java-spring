package platform.codingnomads.co.javaLogicPuzzles;

import java.util.HashMap;

public class PuzzleTesting {
    public static void main(String[] args) {
        HashMap<String, String> hashmap1 = new HashMap();
        hashmap1.put("Hello", "World");

        System.out.println(hashmap1.get("Hello"));
    }
}
