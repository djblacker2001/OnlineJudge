import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        // Regex for validation
        String regex = "^([a-z]+)\\.([a-z]+)(\\.[a-z0-9]+)?@eiu\\.edu\\.vn$";

        if (!input.matches(regex)) {
            System.out.println("INVALID");
            return;
        }

        // Check Student or Lecturer
        if (input.split("\\.").length == 3) {
            System.out.println(input + " Lecturer");
        } else {
            System.out.println(input + " Student");
        }
    }
}
