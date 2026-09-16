import java.util.*;

public class MergeCost_EIUMERGECOST {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long s = sc.nextLong();
            pq.add(s);
        }

        long total = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            long sum = a + b;
            total += sum;
            pq.add(sum);
        }

        System.out.println(total);
    }
}