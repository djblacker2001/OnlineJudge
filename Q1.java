import java.util.*;

public class Q1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        String s = sc.next();
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n;i++) {
            arr[i] = sc.nextLong();
        }

        switch (s) {
            case "productEqualsP":
                productEqualsP(arr, q);
                break;
        
            default:
                sumFromLToR(arr, q);
                break;
        }
        System.out.println(sb);
    }

    static void productEqualsP(long[] arr, int q) {
        Arrays.sort(arr);
        for (int t = 0; t < q;t++) {
            long target = sc.nextLong();
            int p1 = 0;
            int p2 = arr.length-1;
            boolean found = false;
            while (p1 < p2) {
                long product = arr[p1] * arr[p2];
                if (product == target) {
                    found = true;
                    sb.append(arr[p1]).append(" ").append(arr[p2]);
                    p1++;
                    p2--;
                } else if (product > target) {
                    p2--;
                } else {
                    p1++;
                }
            }
            if (!found) {
                sb.append(-1).append(" ").append(-1);
            }
        }
    }

    static void sumFromLToR(long[] arr, int q) {
        long[] pfs = new long[arr.length];
        pfs[0] = arr[0];
        for (int i = 1; i < arr.length;i++) {
            pfs[i] = pfs[i-1] + arr[i];
        }

        for (int t = 0; t < q;t++) {
            int left = sc.nextInt(), right = sc.nextInt();
            sb.append(left == 0 ? pfs[right] : pfs[right] - pfs[left-1]);
        }
    }
}