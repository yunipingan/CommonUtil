package pingweb.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String, Number> map = new HashMap<String, Number>();
        map.put("9.1", 9.1);
        map.put("9.2", 9.2f);
        map.put("9.3", 10);
        Probability tClass = new Probability();
        for (int i=0; i<10; i++) {
            String result = null;
            try {
                // Probability.<String>getResultOfProbability(map)
                // 方法的泛型只适用于赋值，默认可以采用类型参数推断，如果要作为参数传递，则要调用上面那种显示方法
                result = Probability.getResultOfProbability(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }

        System.out.println( "Hello World!" );
    }

    private Object getResultOfProbability(Map<? extends Object, Integer> map) {
        Object[] idArr = new Object[map.keySet().size()];
        Integer[] proArr = new Integer[map.values().size()];

        int i = 0;
        int randomSum = 0;
        for (Map.Entry<? extends Object, Integer> entry : map.entrySet()) {
            idArr[i] = entry.getKey();
            proArr[i] = entry.getValue();
            randomSum += proArr[i];
            i++;
        }

        for (int j = 1; j < proArr.length; j++) {
            proArr[j] = proArr[j] + proArr[j - 1];
        }

        int random = RandomUtils.randomRange(1, randomSum);
        int flag = 0;
        for (int k = 0; k < proArr.length; k++) {
            if (random <= proArr[k]) {
                flag = k;
                break;
            } else
                continue;
        }
        return idArr[flag];
    }
}

