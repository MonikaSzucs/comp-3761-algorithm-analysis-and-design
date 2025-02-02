package DecreaseAndConquer;
// {0,1,2,3,4,5,6}
// {1,2,3}{4,5,6}
public class FindIndex {
    public static boolean doesIndexExist(int []array) {
        return getIndexRecursive(array, 0, array.length-1) >=0;
    }

    private static int getIndexRecursive(int[]array, int startIndex, int lastIndex) {
        int middleIndex = (lastIndex + startIndex) / 2;
        if(startIndex>lastIndex){
            return -1;
        }
        else if(array[middleIndex] == middleIndex){
            return middleIndex;
        }
        else if(array[middleIndex] < middleIndex){
            return getIndexRecursive(array, middleIndex+1, lastIndex);
        }
        else{
            return getIndexRecursive(array, startIndex, middleIndex-1);
        }
    }
}
