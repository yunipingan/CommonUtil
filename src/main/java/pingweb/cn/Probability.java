package pingweb.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @param <K> 奖品对象
 * @param <V> 整数/小数 的概率
 */
public class Probability {

    // 泛型作为返回值，方法不能为static，泛型没有数组
    public static <K> K getResultOfProbability(Map<K, ? extends Number> map) throws Exception {
        // 泛型没有数组
        List<K> idArr = new ArrayList<K>();
        Object o = new Object();
        K ko = (K)o;
        double[] proArr = new double[map.size()];
        int i = 0;
        double randomSum = 0;
        for (Map.Entry<K, ? extends Number> entry : map.entrySet()) {
            idArr.add(entry.getKey());
            double tempPro = changeType(entry.getValue());
            proArr[i] = tempPro;
            randomSum += tempPro;
            i++;
        }
        for (int j = 1; j < proArr.length; j++) {
            proArr[j] = proArr[j] + proArr[j - 1];
        }
        // 生成随机数
        double random = RandomUtils.randomRange(randomSum);
        int flag = 0;
        for (int k = 0; k < proArr.length; k++) {
            if (random <= proArr[k]) {
                flag = k;
                break;
            }
        }
        return idArr.get(flag);
    }

    private static double changeType(Number number) throws Exception {
        if (number instanceof Byte) {
            return (double) number.byteValue();
        }
        if (number instanceof Short) {
            return (double)number.shortValue();
        }
        if (number instanceof Integer) {
            return (double)number.intValue();
        }
        if (number instanceof Long) {
            return (double)number.longValue();
        }
        if (number instanceof Float) {
            return (double)number.floatValue();
        }
        if (number instanceof Double) {
            return number.doubleValue();
        }
        throw new Exception("数据类型异常");
    }

}