import java.util.*;
import java.io.*;

public class KthSmallestElement_EIUMEDARRAY4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();     
        while (T-- > 0) {
            int N = scanner.nextInt();
            int A = scanner.nextInt();
            int P = scanner.nextInt();
            int K = scanner.nextInt();
            
            System.out.println(findKthSmallest(N, A, P, K));
        }
    }
    
    public static int findKthSmallest(int N, int A, int P, int K) {
        int[] arr = new int[N];
        arr[0] = (int) ((1L * A * A) % P);
        for (int i = 1; i < N; i++) {
            arr[i] = (int) ((1L * arr[i - 1] * A) % P);
        }
        return quickSelect(arr, 0, N - 1, K - 1);
    }
    
    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];
        
        int pivotIndex = partition(arr, left, right);
        
        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return quickSelect(arr, left, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, right, k);
    }
    
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
