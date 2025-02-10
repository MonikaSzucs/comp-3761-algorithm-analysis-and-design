package smallestnnumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestNNumbers {
    private PriorityQueue<Integer> pq;
    int size;
    public SmallestNNumbers(int size){
        this.size = size;
        MaxComparator pqMaxComparetor = new MaxComparator();
        this.pq = new PriorityQueue<>(size, pqMaxComparetor);
    }

    // the overall effiency of the method is O(logk)  // k is a constant
    public void insert(int number){
        if(pq.size()<size){
            pq.offer(number); // this is just adding number to a list O(logk) as the priority size max k
        }
        else if(pq.peek()>number){
            pq.poll(); // O(1)
            pq.offer(number); // // this is just adding number to a list O(logk) as the priority size max k
        }
    }

    public ArrayList<Integer> getList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!pq.isEmpty()) {
            arrayList.add(pq.poll());
        }
        return arrayList;
    }


    static class MaxComparator implements Comparator<Integer> {

        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
}
