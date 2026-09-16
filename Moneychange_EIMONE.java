import java.util.Scanner;

public class Moneychange_EIMONE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = n / 20;
		int i = n - (20 * a);
		int b = i / 10;
		int j = i - (10 * b);
		int c = j / 5;
		int k = j - (5 * c);
		int d = k;
		int l = k - (5 * d);

		if (a != 0 && b != 0 && c != 0 && d != 0) {
			System.out.println("20" + " " + a);
			System.out.println("10" + " " + b);
			System.out.println("5" + " " + c);
			System.out.println("1" + " " + d);
		} else if (a == 0 && b != 0 && c != 0 && d != 0) {
			System.out.println("10" + " " + b);
			System.out.println("5" + " " + c);
			System.out.println("1" + " " + d);
		} else if (a != 0 && b == 0 && c != 0 && d != 0) {
			System.out.println("20" + " " + a);
			System.out.println("5" + " " + c);
			System.out.println("1" + " " + d);
		} else if (a != 0 && b != 0 && c == 0 && d != 0) {
			System.out.println("20" + " " + a);
			System.out.println("10" + " " + b);
			System.out.println("1" + " " + d);
		} else if (a != 0 && b != 0 && c != 0 && d == 0) {
			System.out.println("20" + " " + a);
			System.out.println("10" + " " + b);
			System.out.println("5" + " " + c);
		} else if (a == 0 && b == 0 && c != 0 && d != 0) {
			System.out.println("5" + " " + c);
			System.out.println("1" + " " + d);
		} else if (a == 0 && b != 0 && c == 0 && d != 0) {
			System.out.println("10" + " " + b);
			System.out.println("1" + " " + d);
		} else if (a == 0 && b != 0 && c != 0 && d == 0) {
			System.out.println("10" + " " + b);
			System.out.println("5" + " " + c);
		} else if (a != 0 && b == 0 && c == 0 && d != 0) {
			System.out.println("20" + " " + a);
			System.out.println("1" + " " + d);
		} else if (a != 0 && b == 0 && c != 0 && d == 0) {
			System.out.println("20" + " " + a);
			System.out.println("5" + " " + c);
		} else if (a != 0 && b != 0 && c == 0 && d == 0) {
			System.out.println("20" + " " + a);
			System.out.println("10" + " " + b);
		} else if (a != 0 && b == 0 && c == 0 && d == 0)
			System.out.println("20" + " " + a);
		else if (a == 0 && b != 0 && c == 0 && d == 0)
			System.out.println("10" + " " + b);
		else if (a == 0 && b == 0 && c != 0 && d == 0)
			System.out.println("5" + " " + c);
		else if (a == 0 && b == 0 && c == 0 && d != 0)
			System.out.println("1" + " " + d);
	}
}
