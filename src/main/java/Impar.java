import jdk.internal.math.FloatingDecimal;

import java.util.List;
import java.util.ArrayList;
public class Impar {
    public static List<Integer> impa(int start, int end){
        List<Integer> list = new ArrayList<>();
        for (int a=start; a<=end; a++){
            if(a % 2 != 0){
                list.add(a);

            }
        }
        return list;
    }
}
