import java.util.*;
public class FloydWarshallAlgo {
	static int max = Integer.MAX_VALUE;
	public static void main(String args[]) {
		float[][]  initial = {{0,3,max,7}, {8,0,2,max}, {5,max,0,1}, {2,max,max,0}};
//		float[][] next = new float[4][4];

		for(int i = 0; i<4; i++) {
			float[][] next = new float[4][4];
			
			for(int j = 0; j<4; j++) {
				for(int k = 0; k<4; k++) {
					if(j == i || k == i) {
						next[j][k] = initial[j][k];
					}
					
					next[j][k] = Math.min(initial[j][k], initial[j][i] + initial[i][k]);
				}
			}
			
			for(int j = 0; j<4; j++)
				for(int k = 0; k<4; k++)
					initial[j][k] = next[j][k];
		}
		

		for(int j = 0; j<4; j++) {
			for(int k = 0; k<4; k++)
				System.out.print((int)initial[j][k] + " ");
			System.out.println();
		}
	}
}
