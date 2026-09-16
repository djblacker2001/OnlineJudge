import java.util.*;
import java.io.*;


public class hashSet {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(3);
		list.add(5);
		list.add(5);
		System.out.println(list);
		
		Set<Integer> set = new HashSet<>();
		set.add(4);
		set.add(3);
		set.add(5);
		set.add(5);
		System.out.println(set);
		
		Set<Integer> set1 = new TreeSet<>();
		set1.add(4);
		set1.add(3);
		set1.add(5);
		System.out.println(set1);

		LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
		set2.add(9);
		set2.add(4);
		set2.add(3);
		set2.add(5);
		set2.add(5);
		set2.add(9);
		System.out.println(set2);
	}

}
