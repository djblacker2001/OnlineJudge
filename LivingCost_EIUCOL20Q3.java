import java.util.*;

public class LivingCost_EIUCOL20Q3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long X = sc.nextLong();
        long p1 = sc.nextLong();
        long p2 = sc.nextLong();
        long p3 = sc.nextLong();

        long count = 0;

        for (long a = 0; a * p1 <= X; a++) {
            long remainAfterA = X - a * p1;

            for (long b = 0; b * p2 <= remainAfterA; b++) {
                long remainAfterB = remainAfterA - b * p2;
                if (remainAfterB % p3 == 0) {
                    long c = remainAfterB / p3;
                    if (c >= 0) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
