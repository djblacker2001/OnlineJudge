import java.util.*;

public class Traohocbong_EIUSCH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] t = new long[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextLong();
        }
        Arrays.sort(t);
        long totalWait = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (totalWait <= t[i]) {
                count++;
                totalWait += t[i];
            }
        }
        System.out.println(count);
    }
}