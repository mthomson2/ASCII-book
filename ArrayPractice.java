public class ArrayPractice {
	
	/* The countInRange method starts a counter at 0. For as many times as a number is between the index
	*  of minVal and maxVal (determined by the for-loop) the counter will increase by one. The for-loop works
	*  by iterating through the array arrayOfValues.length amount of times and finding where the minVal 
	*  and maxVal are in the arrays index. 
	*/
	public static int countInRange(int[] arrayOfValues, int minVal, int maxVal) {
		int counter = 0;
		for (int i = 0; i < arrayOfValues.length; i++) {
			if ((arrayOfValues[i] >= minVal) && (arrayOfValues[i] <= maxVal)) {
				counter++;
			} //closing if statement	
		} // closing for loop 
		//System.out.println(counter); //Used for testing
		return counter;
	} //closing countInRange block
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//minGap finds the smallest gap between two adjacent numbers in the array. 

	/* The minGap method takes in a array of integers as its argument. It then checks the differences
	*  between each adjacent element of the array through a for loop. The absolute value method is used
	*  so the numbers will all be positve (i.e. [9,10] would return 1 not -1). A minVal variable is 
	*  declared before the for-loop so each iteration can compare to that minVal value. 
	*/
	public static int minGap(int[] arrayOfValues){
		int minVal = Math.abs(arrayOfValues[0] - arrayOfValues[1]);
		for (int i = 1; i < arrayOfValues.length-1; i++) {
			int minValLoop = Math.abs(arrayOfValues[i] - arrayOfValues[i+1]);
			if (minValLoop < minVal) {
				minVal = minValLoop;
			} //closing if statement
		} // closing for loop
		//System.out.println(minVal); // Used for testing
		return minVal;
	} //closing minGap
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/* The collapse method takes in an array of integers. The first thing the method does is create a new
	*  integer array, colArray, which will be the returned array at the end of the method. The method 
	*  checks to see if the array is even or odd. If the array is odd, it sets colArray's first index
	*  to equal arrayOfValues's  index. If it is even, it will collapse normally. A while loop is created
	*  to loop through arrayOfValues to combine two adjacent elements and then store them in ColArray.
	*  'int i' is used to represent colArray's index and 'int j' is used to represent arrayofValues index.
	*  For the next iteration of the while loop, colArray goes to the next index (i++) while arrayofValues
	*  skips the next index and goes to the one after that (j = j+2) so it does every other sum of adjacent
	*  values. 
	*/	
	public static int[] collapse(int[] arrayOfValues) {
		int[] colArray;
		if ((arrayOfValues.length % 2) != 0) {
			colArray = new int[(arrayOfValues.length / 2) + 1];
			colArray[0] = arrayOfValues[0];
			
			int i = 1;
			int j = 1;
			while ((i < colArray.length) && (j < arrayOfValues.length)) {
				colArray[i] = arrayOfValues[j]  + arrayOfValues[j+1];
				i++;
				j=j+2;
			}
		} else {
			colArray = new int[(arrayOfValues.length / 2)];
			
			int i = 0;
			int j = 0;
			while ((i < colArray.length) && (j < arrayOfValues.length)) {
				colArray[i] = arrayOfValues[j] + arrayOfValues[j+1];
				i++;
				j+=2;
			}
		} //end else
		return colArray;
	} //closing collapse
	
} //closing ArrayPractice
