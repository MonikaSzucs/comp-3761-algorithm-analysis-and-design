package DivideAndConquer;
//{1,2,5,7,2,1}
//{1,2,5}   {7,2,1}
//{1,2}{5}  {7,2}{1}
//{1}{2}{5}{7}{2}{1}
public class LargestNumber {
    int lastLargestNumber;
    public static int getNumber(int [] numbers) {
        return getNumberRecursive(numbers, 0, numbers.length-1);
    }
    // [5,3,7,23,2] startIndex=0, lastIndex=3
    // this one is going over every element
    private static int getNumberRecursive(int [] numbers, int startIndex, int lastIndex){
        // big O is O(n) because because we go over each element once

        // System.out.println("startIndex: "+startIndex+", lastIndex: "+lastIndex);
        int middleIndex = (lastIndex + startIndex)/2;
        /**
         * int []array = {2,5,8,3,6,9,1,6,5};
         * startIndex: 0, lastIndex: 8
            startIndex: 0, lastIndex: 3
            startIndex: 0, lastIndex: 0
            startIndex: 2, lastIndex: 3
            startIndex: 2, lastIndex: 1
            startIndex: 2, lastIndex: 0
         */
        // start=2 last=3 middle=2 {2,5,8,3}
        int currentLargestNumber = numbers[middleIndex]; // get the center number
        // (numbers, 2, 2-1);
        if(middleIndex-1>=startIndex){
            int leftHalfLargestNumber = getNumberRecursive(numbers, startIndex, middleIndex-1);
            if (currentLargestNumber < leftHalfLargestNumber){
                currentLargestNumber = leftHalfLargestNumber;
            }
        }
        if(lastIndex>=middleIndex+1){
            int rightHalfLargestNumber = getNumberRecursive(numbers, middleIndex+1, lastIndex);
            // current = 5; left = 10; right = 20
            if(currentLargestNumber < rightHalfLargestNumber){
                currentLargestNumber =  rightHalfLargestNumber;
            }
        }
        return currentLargestNumber;
    }
}