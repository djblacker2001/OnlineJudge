import java.util.*;
import java.io.*;

public class Management_EIUFISH {
    public static void main(String[] args) throws IOException {
        // Faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int M = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        Map<Integer, Integer> employeeTaskMap = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] parts = br.readLine().split(" ");
            int empId = Integer.parseInt(parts[0]);
            int taskId = Integer.parseInt(parts[1]);
            employeeTaskMap.put(empId, taskId);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int queryId = Integer.parseInt(br.readLine());
            sb.append(employeeTaskMap.get(queryId)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
