import java.util.ArrayList;
import java.util.List;

public final class ArrayService {
    ArrayService() {
    }

    public static int[] getValueAfterLastNumberFour(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                integers.clear();
            }else {
                integers.add(arr[i]);
            }
        }

        int[] resultArray = new int[integers.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = integers.get(i);
        }

        return resultArray;
    }

    public static boolean checkArrayForOneAndFour(int[] arr){
        boolean itsOne = false;
        boolean itsFour = false;

        for (int j : arr) {
            if (j == 1) {
                itsOne = true;
            }
            if (j == 4) {
                itsFour = true;
            }
        }
        return (itsFour && itsOne);
    }

}
