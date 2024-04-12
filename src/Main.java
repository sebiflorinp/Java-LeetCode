import easy.Easy;
import medium.Medium;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Easy easy = new Easy();
        Medium medium = new Medium();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(-12, 3);
        map.put(12, 45);
        map.put(12, 555);
        for(Integer keys: map.keySet()) {
            System.out.printf("%s %s%n", keys, map.get(keys));
        }
    }
}