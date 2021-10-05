package Leasson1.task1ANDtask2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] intsArray  =  {1, 2};
        String[] stringsArray = {"one", "two"};

        System.out.println("Print original array: ");

        printArray(intsArray);
        printArray(stringsArray);

        swapArray(intsArray);
        swapArray(stringsArray);

        System.out.println("Print swaps array: ");

        printArray(intsArray);
        printArray(stringsArray);

        ArrayList<Integer> intsArrayList = toArraylist(intsArray);
        ArrayList<String> stringsArrayList = toArraylist(stringsArray);

        System.out.println("Print array list: ");

        System.out.println(intsArrayList);
        System.out.println(stringsArrayList);
    }

    public static <T> void printArray(T[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (array.length - 1 != i){
                System.out.print(" | ");
            }
        }
        System.out.println();
    }

    public static <T> void   swapArray(T[] array){
        T res = array[0];
        array[0] = array[1];
        array[1] = res;
    }

    public static <T> ArrayList<T> toArraylist(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

}
