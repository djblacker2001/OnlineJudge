import java.util.*;

public class SumofKdistinctLargest_EI2122Q1M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        List<Integer> distinctList = new ArrayList<>(set);
        distinctList.sort(Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < Math.min(k, distinctList.size()); i++) {
            sum += distinctList.get(i);
        }

        System.out.println(sum);
    }
}
