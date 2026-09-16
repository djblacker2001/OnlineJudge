import java.util.*;
import java.io.*;

public class DJSlayerX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		mergesort(arr, 0, arr.length - 1);
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}

	public static void mergesort(int arr[], int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergesort(arr, left, mid);
		mergesort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	public static void merge(int arr[], int left, int mid, int right) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int i = left;
		int j = mid + 1;
		while (i <= mid && j <= right) {
			temp.add(arr[i] <= arr[j] ? arr[i++] : arr[j++]);
		}
		while (i <= mid) {
			temp.add(arr[i++]);
		}
		while (j <= right) {
			temp.add(arr[j++]);
		}
		for (int k = 0; k < temp.size(); k++) {
			arr[left + k] = temp.get(k);
		}
	}
}