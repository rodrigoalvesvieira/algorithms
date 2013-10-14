package graphs;

import stack.Stack;
import shared.Arquivo;

/**
 * Implementation of a Depth First Search algorithm
 * http://en.wikipedia.org/wiki/Depth-first_search
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 * 
 */
public class DFS {

	public static void main(String[] args) {
		Arquivo file = new Arquivo("./inputs/DFS.txt", "output.txt");
		int K, Q, N, M, x, y, result;
		
		K = file.readInt();
		
		while (K > 0) {
			result = 0;
			Q = file.readInt();
			N = file.readInt();
			M = file.readInt();
			
			int matrix[][] = new int[N][M];
			int marked[] = new int[N];
			
			// Filling the matrix
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					matrix[i][j] = file.readInt();
//					System.out.print(matrix[i][j] + " ");
				}
				
//				System.out.println();
			}
			
			// BFS starts here
			for (int a = 0; a < N; a++) {
				for (int s = 0; s < M; s++) {					
					if (matrix[a][s] <= Q) result++;
				}
			}
			
			System.out.println(result);
			K--;
		}
	}
}