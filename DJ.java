import java.io.*;
import java.util.*;

public class DJ {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        
        if (isPowerOfFour(N)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // Hàm kiểm tra lũy thừa của 4
    public static boolean isPowerOfFour(long n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    static class Vertex {
        public int id;
        public List<Vertex> neighbors = new ArrayList<>();
        public boolean visited;

        public Vertex(int id) {
            this.id = id;
            this.visited = false;
        }

        public void addNeighbor(Vertex v) {
            neighbors.add(v);
        }
    }
}