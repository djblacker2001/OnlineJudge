import java.util.*;

public class Postorder_EIUEASPOST {
	static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		int n = sc.nextInt();
		Vertex ver[]  = new Vertex[n + 1];
		for (int i = 1; i <= n; i++) {
			ver[i] = new Vertex(i);
		}

		for (int i = 1; i <= n; i++) {
			int u = sc.nextInt();
            int v = sc.nextInt();
			Vertex left = null;
			if (u != 0) {
				left = ver[u];
			}

			Vertex right = null;
			if (v != 0) {
				right = ver[v];
			}

			if (left != null) {
				left.addRootNode(ver[i]);
			}
			if (right != null) {
				right.addRootNode(ver[i]);
			}
			
			ver[i].addChildNode(left, right);
		}
		
		printPostOrder(ver[1]);
		System.out.println(sb);
	}

	static void printPostOrder(Vertex vertex) {
		if (vertex.leftNode != null) {
			printPostOrder(vertex.leftNode);
		}
		
		if (vertex.rightNode != null) {
			printPostOrder(vertex.rightNode);
		}
		sb.append(vertex.id).append(" ");
	
	}

	static class Vertex {
		int id;
		Vertex rightNode;
		Vertex leftNode;
		Vertex rootNode;

		public Vertex(int id) {
			this.id = id;
		}

		public void addRootNode(Vertex v) {
			rootNode = v;
		}

		public void addChildNode(Vertex left, Vertex right) {
			leftNode = left;
			rightNode = right;
		}
	}
}
