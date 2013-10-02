package shared;

import sorting.Quick;

public class TestQuicksort {

	public static void main(String[] args) {
		Arquivo file = new Arquivo("./inputs/many-integers.txt", "output.txt");
		
		int N = file.readInt();
		Quick quick = new Quick();
		int[] inputs = new int[N];
		
		for (int i = 0; i < N; i++) inputs[i] = file.readInt();
		Quick.sort(inputs);
		
		for (int k = 0; k < N; k++) System.out.print(inputs[k] + ", ");		
	}
}