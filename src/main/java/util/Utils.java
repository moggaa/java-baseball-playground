package util;

import baseballgame.domain.Balls;

import java.util.*;

public class Utils{
    public static boolean checkDuplicated(List<Integer> integerList){
        return new HashSet<>(integerList).size() >= integerList.size();
    }


    public static boolean validateNumbers(List<Integer> numberList,Integer size){
        return numberList.size() == size && Utils.checkDuplicated(numberList);
    }


    public static List<Integer> randomNumberGenerate(int size) {
        if(size < 0 || size > 9){
            return null;
        }
        List<Integer> numberList = new ArrayList<>();
        List<Integer> totalNumberList = new ArrayList<>();
        for(int i = 1 ; i <= 9; i++){
            totalNumberList.add(i);
        }
        Random random = new Random();
        for(int i = 0 ; i < size ; i++){
            int min = 0;
            int max = 10 - i - 1;
            int index = random.ints(min,max)
                    .findFirst()
                    .orElseThrow(() -> {throw new ArrayIndexOutOfBoundsException();});
            numberList.add(totalNumberList.get(index));
            totalNumberList.remove(index);
        }

        return numberList;
    }
}
