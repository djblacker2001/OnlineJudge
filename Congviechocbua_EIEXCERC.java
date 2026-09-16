import java.util.*;

public class Congviechocbua_EIEXCERC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int tu = 0, dat = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                tu++;
            } else {
                dat++; 
            }
            n = n / 2; 
        }

        System.out.println(tu + " " + dat);
    }
}
