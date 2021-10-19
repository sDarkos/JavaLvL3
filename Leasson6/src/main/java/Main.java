import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayService arrayService = new ArrayService();

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] emptyArr = new int[0];
        int[] arrWithoutFour = {1,2,3,5,6,7,8,9,10};

        System.out.println(Arrays.toString(arrayService.getValueAfterLastNumberFour(arr)));
        System.out.println(Arrays.toString(arrayService.getValueAfterLastNumberFour(emptyArr)));
        System.out.println(Arrays.toString(arrayService.getValueAfterLastNumberFour(arrWithoutFour)));
        System.out.println("______________________________________________");
        System.out.println(arrayService.checkArrayForOneAndFour(arr));
        System.out.println(arrayService.checkArrayForOneAndFour(emptyArr));
        System.out.println(arrayService.checkArrayForOneAndFour(arrWithoutFour));
    }
}
