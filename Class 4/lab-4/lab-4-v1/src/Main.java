import DecreaseAndConquer.FindIndex;
import DivideAndConquer.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []array = {2,5,8,3,6,9,1,6,5};
        int []arrayDecreaseAndConquer1 = {1,2,3,4,5,6};
        int []arrayDecreaseAndConquer2 = {0,1,2,3,4,5};
        int []arrayDecreaseAndConquer3 = {};
        int []arrayDecreaseAndConquer4 = {10,20,30,40,50};
        int []arrayDecreaseAndConquer5 = {-5,-3,0,2};

        System.out.println("Largest number is: " + LargestNumber.getNumber(array));
        System.out.println("Sorted array is: " + Arrays.toString(MergeSort.getSortedArray(array)));

        System.out.println("Checking if array #1 equals index: " + FindIndex.doesIndexExist(arrayDecreaseAndConquer1));
        System.out.println("Checking if array #2 equals index: " + FindIndex.doesIndexExist(arrayDecreaseAndConquer2));
        System.out.println("Checking if array #2 equals index: " + FindIndex.doesIndexExist(arrayDecreaseAndConquer3));
        System.out.println("Checking if array #2 equals index: " + FindIndex.doesIndexExist(arrayDecreaseAndConquer4));
        System.out.println("Checking if array #2 equals index: " + FindIndex.doesIndexExist(arrayDecreaseAndConquer5));
    }
}