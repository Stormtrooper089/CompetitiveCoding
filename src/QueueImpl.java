import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueImpl {

    public static void main(String [] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });
        for (int i =0 ; i < 100 ; i++){
            int num = (int) (Math.random()*(100-50+1) + 50);
            minHeap.add(num);
            maxheap.add(num);

        }
        while(minHeap.size() != 0){
            System.out.println(minHeap.poll());
        }
        System.out.println("The max heap is as follows");
        while(maxheap.size() != 0){
            System.out.println(maxheap.poll());
        }
    }
}
