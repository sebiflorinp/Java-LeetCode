import easy.Easy;

public class Main {
    public static void main(String[] args) {
        Easy easy = new Easy();
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(easy.lastStoneWeight(stones));
    }
}