import smallestnnumbers.SmallestNNumbers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8}; // Input array
        //int[] numbers = {100, 5, 50, 6, 2, 60, 3, 8};
        int k = 4;
        SmallestNNumbers smallestNumbers = new SmallestNNumbers(k);

        // the overall effiency of the loop is O(nlogk)
        for(int i=0;i<numbers.length;i++){ // O(n)
            smallestNumbers.insert(numbers[i]); // its O(logk)
        }

        ArrayList<Integer> result = smallestNumbers.getList();
        System.out.println("The smallest " + k + " numbers are: ");
        for(int i=0;i<result.size();i++){ // this is just printing
            System.out.println(result.get(i));
        }
    }
}