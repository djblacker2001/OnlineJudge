import java.util.*;

public class Postorder_EITREORD {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int index = 0;

    public static void main(String[] args) {
        HashMap<Integer, Integer> in = new HashMap<>();
        int n = sc.nextInt();
        int preOrder[] = new int[n];
        for (int i = 0; i < n; i++) {
            preOrder[i] = sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            int inOrder = sc.nextInt();
            in.put(inOrder, i);
        }

        printPostOrder(preOrder, in, 0, n - 1);
        System.out.println(sb);
    }

    static void printPostOrder(int[] preOrder, HashMap<Integer, Integer> inOrder, int start, int end) {
        if (start > end) {
            return;
        }
        int root = preOrder[index++];
        int indexNode = inOrder.get(root);
        printPostOrder(preOrder, inOrder, start, indexNode - 1);
        printPostOrder(preOrder, inOrder, indexNode + 1, end);
        sb.append(root).append(" ");
    }
}
