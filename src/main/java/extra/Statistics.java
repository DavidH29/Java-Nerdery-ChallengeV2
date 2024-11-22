package extra;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    public static List<Double> getStatistics(List<Double> values){
        List<Double> list = new ArrayList<>();
        var s = values.stream().mapToDouble(a -> a).summaryStatistics();
        list.add(s.getMin());
        list.add(s.getAverage());
        list.add(s.getMax());

        return list;
    }
}
