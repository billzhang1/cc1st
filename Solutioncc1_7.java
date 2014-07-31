public class Solutioncc1_7 {
	//TC: O(M*N), SC:O(M+N)
	public static void setZero(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];

		for (int x = 0; x < matrix.length; x ++) {
			for (int y = 0; y < matrix[0].length; y ++) {
				if (matrix[x][y] == 0) {
					row[x] = 1;
					column[y] = 1;
				}
			}
		}

		for (int x = 0; x < matrix.length; x ++) {
			for (int y = 0; y < matrix[0].length; y ++) {
				if (row[x] == 1 | column[y] == 1) {
					matrix[x][y] = 0;
				}
			}
		}
	}

	public static void setZero2(int[][] matrix) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;

		for (int y = 0; y < matrix.length; y ++) {
			if (matrix[y][0] == 0) {
				columnHasZero = true;
				break;
			}
		}

		for (int x = 0; x < matrix[0].length; x ++) {
			if (matrix[0][x] == 0) {
				rowHasZero = true;
				break;
			}
		}

		for (int x = 0; x < matrix.length; x ++) {
			for (int y = 0; y < matrix[0].length; y ++) {
				if (matrix[x][y] == 0) {
					matrix[0][y] = 0;
					matrix[x][0] = 0;
				}
			}
		}
		// avoid to nullify first row
		for (int x = 1; x < matrix.length; x ++) {
			if (matrix[x][0] == 0) {
				for (int y = 0; y < matrix[0].length; y ++) {
					matrix[x][y] = 0; 
				}
			}
		}
		// avoid to nullify first column
		for (int y = 1; y < matrix[0].length; y ++) {
			if (matrix[0][y] == 0) {
				for (int x = 0; x < matrix.length; x ++) {
					matrix[x][y] = 0;	
				}
			}
		}

		if (rowHasZero) {
			for (int y = 0; y < matrix[0].length; y ++) {
				matrix[0][y] = 0;
			}
		}	

		if (columnHasZero) {
			for (int x = 0; x < matrix.length; x ++) {
				matrix[x][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0,1,2,3},{4,5,0,7},{8,9,10,11},{12,13,14,15},{16,17,18,19}};
		setZero2(matrix);
		for (int x = 0; x < matrix.length; x ++) {
			for (int y = 0; y < matrix[0].length; y ++) {
				System.out.print(matrix[x][y] + "    ");
			}
			System.out.println("");
		}
	}
}
