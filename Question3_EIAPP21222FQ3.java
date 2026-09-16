import java.util.Scanner;

public class Question3_EIAPP21222FQ3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (m == 1)
			System.out.print(Math.round(n * (1 - 0.039 / 12)));
		else if (m == 2)
			System.out.print(Math.round(n * (1 - 0.0392 / 12 * m)));
		else if (m == 3)
			System.out.print(Math.round(n * (1 - 0.0395 / 12 * m)));
		else if (m == 4)
			System.out.print(Math.round(n * (1 - 0.0399 / 12 * m)));
		else if (m == 5)
			System.out.print(Math.round(n * (1 - 0.0404 / 12 * m)));
		else if (m == 6)
			System.out.print(Math.round(n * (1 - 0.0554 / 12 * m)));
		else if (m == 7)
			System.out.print(Math.round(n * (1 - 0.0572 / 12 * m)));
		else if (m == 8)
			System.out.print(Math.round(n * (1 - 0.0592 / 12 * m)));
		else if (m == 9)
			System.out.print(Math.round(n * (1 - 0.0614 / 12 * m)));
		else if (m == 10)
			System.out.print(Math.round(n * (1 + 0.0638 / 12 * m)));
		else if (m == 11)
			System.out.print(Math.round(n * (1 + 0.0664 / 12 * m)));
		else if (m >= 11)
			System.out.print(Math.round(n * (1 + 0.0692 / 12 * m)));
		

	}
}