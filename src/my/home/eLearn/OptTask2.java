package my.home.eLearn;


import java.util.Arrays;
import java.util.Scanner;

public class OptTask2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter size and range of matrix");
		
		int size = scanner.nextInt();
		int range = scanner.nextInt() + 1;
		
		System.out.println("Creating new matrix");
		int [][] matrix = creat(size, range);
		printMatrix(matrix);
		System.out.println("Sort matrix by column");
		sortString(matrix);
		printMatrix(matrix);
		
		System.out.println("\n");
		
		System.out.println("Creating new matrix");
		int [][] matrix2 = creat(size, range);
		printMatrix(matrix2);
		sortColumn(matrix2);
		System.out.println("Sort matrix by string");
		printMatrix(matrix2);
				
		System.out.println("\n");
		
		int [][] matrix3 = creat(size, range); 
		printMatrix(matrix3);
		System.out.print("Sum between two max elemens is: ");
		sumBetweenPos(matrix3);
		System.out.println("\n");
		
		System.out.println("Creating new matrix");
		int [][] matrix4 = creat(size, range);
		printMatrix(matrix4);
		int [][]delMaxMatrix = deleteMax(matrix4);
		System.out.println("Delete strings and columns with max element");
		printMatrix(delMaxMatrix);
		
		scanner.close();
	}
	
	
	public static int[][] creat(int n, int r) {
		int [][] matrix = new int [n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random() * (2 * r) - r);
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int [][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static void sortString(int [][] array) {
		
		for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i].length; j++) {
					Arrays.sort(array[i]);
				
			}
		}
	}
	
	public static void sortColumn(int [][] array) {
		boolean isSort = false;
		int temp = 0;
		int i = 0;
		while(!isSort) {
			isSort = true;
			for(int j = 0; j < array[i].length; j++) {
				i = 0;
				while(i < array.length -1) {
					if(array[i][j] > array[i+1][j]) {
						isSort = false;
						temp = array[i+1][j];
						array[i+1][j] = array[i][j];
						array[i][j] = temp;
					}
				i++;
				}
			}
		}
	}

	
	public static void sumBetweenPos(int [][] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] > 0) {
					j++;
					while(j < array[i].length-1 && array[i][j] < 0) {
						
							sum += array[i][j];
							j++;
					}
					break;
				}
			}
		}
		System.out.println(sum);
	}
	
public static int [][] deleteMax(int matrix [][]) {
		
		int max = matrix[0][0];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] > max) {
					max = matrix[i][j];
				}
			}	
		}
		
		int count = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == max) {
					count ++;
				}
			}
		}
		
		int maxMat [][] = new int [2][count];
		for(int i = 0, a = 0, b = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == max) {
					 maxMat[0][a] = i;
					 maxMat[1][b] = j;
					a++;
					b++;
				}
			}
		}
		
		int countS = count, countC = count;
		for(int i = 0; i < 1; i++) {
			for(int j = 0; j < maxMat[i].length - 1; j++) {				
				if(maxMat[0][j] == maxMat[0][j + 1]) countS--;
				if(maxMat[1][j] == maxMat[1][j + 1]) countC--;
				Arrays.sort(maxMat[0]);
				Arrays.sort(maxMat[1]);
			}
		}
	
		int [][] answerM = new int [matrix.length - countS][matrix.length - countC];
		for(int i = 0, iAnswerM = 0, iMaxMat = 0; i < matrix.length; i++) {
			if(iMaxMat < maxMat[0].length && i == maxMat[0][iMaxMat]) {
					iMaxMat++;
				continue;
			}
			for(int j = 0, jAnswerM = 0, jMaxMat = 0; j < matrix.length; j++ ) {
				if(jMaxMat < maxMat[1].length &&  j == maxMat[1][jMaxMat]) {
						jMaxMat++;
					continue;
				}
				answerM[iAnswerM][jAnswerM] = matrix[i][j];
				jAnswerM++;
			}
			iAnswerM++;
		}
		return answerM;
	}
	
}
