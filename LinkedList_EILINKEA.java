import java.util.*;

public class LinkedList_EILINKEA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            switch (command) {
                case "sum":
                    System.out.println(sum(list));
                    break;
                case "average":
                    System.out.println(average(list));
                    break;
                case "getAt":
                    int index = sc.nextInt();
                    System.out.println(getAt(list, index));
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "firstIndexOf":
                    int value = sc.nextInt();
                    System.out.println(firstIndexOf(list, value));
                    break;
                case "lastIndexOf":
                    value = sc.nextInt();
                    System.out.println(lastIndexOf(list, value));
                    break;
                case "add":
                    value = sc.nextInt();
                    list.add(value);
                    break;
                case "removeAt":
                    index = sc.nextInt();
                    removeAt(list, index);
                    break;
                case "clear":
                    list.clear();
                    break;
            }
        }
    }
    
    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
    
    private static double average(List<Integer> list) {
        return list.isEmpty() ? 0 : (double) sum(list) / list.size();
    }
    
    private static int getAt(List<Integer> list, int index) {
        return (index >= 0 && index < list.size()) ? list.get(index) : -1;
    }
    
    private static int firstIndexOf(List<Integer> list, int value) {
        return list.indexOf(value);
    }
    
    private static int lastIndexOf(List<Integer> list, int value) {
        return list.lastIndexOf(value);
    }
    
    private static void removeAt(List<Integer> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }
}
