import java.util.*;

public class DeletionvaQueries_EIUPH013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLong());
        }

        for (int q = 0; q < m; q++) {
            int type = sc.nextInt();
            int idx = sc.nextInt();

            if (type == 0) { // delete
                if (idx >= 0 && idx < list.size()) {
                    list.remove(idx);
                }
            } else if (type == 1) { // query
                if (idx >= 0 && idx < list.size()) {
                    System.out.println(list.get(idx));
                } else {
                    System.out.println("-1");
                }
            }
        }

        sc.close();
    }
}
