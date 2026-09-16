import java.util.*;

public class BuildingPyramid_EIUCUBES {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int Bricks = sc.nextInt();
		int Layers = 0;
		while (Bricks >= 0) {
			Layers += 1;
			Bricks -= Layers * (Layers + 1) / 2;
		}
		System.out.println(Layers - 1);
	}
}
