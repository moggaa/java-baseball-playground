package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils{
    public static boolean checkDuplicated(List<Integer> integerList){
        return new HashSet<>(integerList).size() >= integerList.size();
    }
}
