import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExamples {

    public static List<String> filter(List<String> list, StringChecker checker) {
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (checker.checkString(s)) {
                result.add(s);
            }
        }

        return result;
    }

    public static List<String> merge(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();

        result.addAll(list1);
        result.addAll(list2);
        Collections.sort(result);

        return result;
    }
}
