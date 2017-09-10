package pingweb.cn;

import java.util.Random;

public class RandomUtils {
    /**
     * 随机生成范围中的数字，包括start和end在内
     * @param start
     * @param end
     * @return
     */
    public static int randomRange(int start, int end){
        Random random = new Random();
        return random.nextInt(end+1-start) + start;
    }

    public static double randomRange(double bound){
        Random random = new Random();
        return random.nextDouble() * bound;
    }

    public static void main(String[] args) {
        System.out.println(Number.class.getName());
    }

}
