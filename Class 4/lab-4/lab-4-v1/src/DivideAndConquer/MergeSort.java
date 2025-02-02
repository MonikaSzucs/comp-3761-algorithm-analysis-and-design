package DivideAndConquer;

import java.util.Arrays;

// original: {2,5,8,3,6,9,1,6,5}
// {2,5,8,3} {6,9,1,6,5} => {1,6,9} {5,6} ([2,5,8,3,1,6,9,5,6])
// ...
// {2,3,5,8} {1,5,6,6,9} - we will use the while loop to combine into one array
// when we split things we only go over the array log n times
//size 10=>5=>2=>1
//size 1000=>500=>250=>...
// splitting over array size
public class MergeSort { 
    public static int[] getSortedArray(int[] array) {
        // deep copy - copying the original array to a new array to prevent modifying the original numbers
        int[] temp = Arrays.copyOf(array,array.length);
        getSortedArrayRecursive(temp, 0, temp.length-1);
        return temp;
    }
    //O(logn)*O(n)= O(nlogn)
    // this recursive function is only going over all sizes/2
    private static void getSortedArrayRecursive(int[] array, int startIndex, int lastIndex){
        if(startIndex >= lastIndex){
            return;
        }
        int middleIndex = (startIndex+lastIndex)/2;
        // whenever we split things in half its always type of logn
        getSortedArrayRecursive(array, startIndex, middleIndex);
        getSortedArrayRecursive(array, middleIndex + 1, lastIndex);
        merge(array,startIndex, middleIndex, lastIndex);
    }
    // O(n)
    private static void merge(int[] array, int firstHalfStart, int firstHalfLast, int secondHalfLast){
        int firstHalfIndex = firstHalfStart;
        int secondHalfIndex = firstHalfLast + 1;
        // firstHalfStart = 4 firstHalfLast=6 secondHalfLast=8
        //
        int[] returnArray = new int[secondHalfLast-firstHalfStart+1];
        int returnArrayIndex = 0;
        while (firstHalfIndex <= firstHalfLast && secondHalfIndex <= secondHalfLast) {
            if (array[firstHalfIndex] < array[secondHalfIndex]) {
                returnArray[returnArrayIndex++] = array[firstHalfIndex++];
            }
            else{
                returnArray[returnArrayIndex++] = array[secondHalfIndex++];
            }
        }
        while (returnArrayIndex < returnArray.length){
            if (firstHalfIndex <= firstHalfLast) {
                returnArray[returnArrayIndex++] = array[firstHalfIndex++];
            }
            else{
                returnArray[returnArrayIndex++] = array[secondHalfIndex++];
            }
        }
        returnArrayIndex = 0;
        for(int i = firstHalfStart;i <= secondHalfLast; i++){
            array[i] = returnArray[returnArrayIndex++];
        }
    }
}
/*
{2,5,8,3,6}=>{2,5,8}{3,6}=>{2,5}{8}{3}{6}=>{2}{5}{8}{3}{6}
{2,5,8} {3,6}
{2,5} {8}
{2} {5}
// if for example it was in the order of:
{5} {2}
// then the merge will swap them and also combine them
{2,5}
{2,5,8}   - then combine 8
// now we have left and right side
{3,5,8} {2,6}
{2,3,5,6,8}
...
*/