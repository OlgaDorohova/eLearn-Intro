package my.home.eLearn;

import java.util.HashMap;
import java.util.Scanner;

public class OptTask1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var scanner = new Scanner(System.in);
		String numString = "";
		
		numString += scanner.nextLine();
		String [] numArray = numString.split(" ");
		
		String shortest = numArray[0];
		String longest = numArray[0];
		for(String str: numArray) {
			if(shortest.length() > str.length()) shortest = str;
			if(longest.length() < str.length())	longest = str;
		}
		
		System.out.println("shortest: " + shortest + 
				", length: " + shortest.length() + "\n" + 
				"longest: " + longest + ", length: " + longest.length());
		
		System.out.println("Less than average:");
		lessThanAvg(numArray, shortest.length(), longest.length());
		
		System.out.println("Sorted array:");
		bubbleSort(numArray);
		
		for (String arr: numArray) {
			System.out.print(arr + " ");
		}
	
		System.out.println();
		
		System.out.println("More than average:");
		moreThanAvg(numArray, shortest.length(), longest.length());
		
		System.out.println("Reverse sorted array:");
		bubbleReverseSort(numArray);
		
		for (String arr: numArray) {
			System.out.print(arr + " ");
		}
		System.out.println();
		
		diffPart(numArray);
		
		nextSymIsUpper(numArray);
		
		countOdds(numArray);
		
		scanner.close();
	}

	


	public static void bubbleReverseSort(String [] arr) {
		if(arr.length < 2) return;
	
		boolean isSort = false;
		String temp = "";
	
		while(!isSort) {
			isSort = true;
		
			for(int i = arr.length - 1; i > 0; i--) {
				if(arr[i].length() > arr[i-1].length()) {
					temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					isSort = false;
				}
			}
		}
	}
	
	public static void bubbleSort(String [] arr) {
		if(arr.length < 2) return;
		
		boolean isSort = false;
		String temp = "";
		
		while(!isSort) {
			isSort = true;
			
			for(int i = 0; i < arr.length -1; i++) {
				if(arr[i].length() > arr[i+1].length()) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSort = false;
				}
			}
		}
	}

	public static void lessThanAvg(String [] arr, int sh, int lo) {
		double avg =  (double)(sh + lo) / 2;
		for(String str: arr) {
			if(str.length() < Math.ceil(avg))
				System.out.print(str );
		}
		System.out.println();
	}
	
	public static void moreThanAvg(String [] arr, int sh, int lo) {
		double avg =  (double)(sh + lo) / 2;
		for(String str: arr) {
			if(str.length() > Math.ceil(avg))
				System.out.print(str);
		}
		System.out.println();
	}

	public static void diffPart(String [] arr) {
		int count = arr[0].length();
		String anString = arr[0];
		String onlyDiffString = "";
		for(String str: arr) {
			String [] array = str.split("");
			HashMap<String, String> hm = new HashMap<>();
			
			for(String s: array) {
				hm.put(s, s);
			}
			if(count > hm.size()) {
				count = hm.size();
				anString = str;
			}
			if(hm.size() == array.length) onlyDiffString = str;
			
			
		}
		System.out.println("Minimum different nums: " + anString + "\n" +
		"Only different symbols num: " + onlyDiffString);
	}
	
	public static void nextSymIsUpper(String [] arr) {
		for(String str: arr) {
			int count  = 0;
			String [] array = str.split("");
			for(int i = 0; i < array.length - 1; i++) {
				if(Integer.valueOf(array[i]) >= Integer.valueOf(array[i + 1])) 
					break;
				else count++;
				if(count == array.length -1) {
					System.out.println("Next symbol upper: " + str);
					return;
				}
			} 
		}
	}
	
	public static void countOdds(String [] arr) {
		int countOddNum = 0;
		int countEqOddEven = 0;
		
	
		for(String str: arr) {
			String [] array = str.split("");
				int countOdd = 0;
				int countEven = 0;
				int i = 0;
				
				while(i < array.length) {
					if(Integer.valueOf(array[i]) % 2 == 0) countOdd++;
					else countEven++;
					i++;
					
			}
				if(countOdd == array.length) countOddNum++;
				if(countOdd == countEven) countEqOddEven++;
		}
		System.out.println("Only odd num: " + countOddNum + "\n" +
				"Odd equals even nums:" + countEqOddEven);
	}
}
