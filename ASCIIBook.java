/**
 *  Draws ASCII textbooks similar to (but not quite
 *  the same as) Chapter 2, Programming Project 8
 *  in Building Java Programs by Reges & Stepp,
 *  3rd edition.
 *  
 *  @author Molly Thomson	
 *  @version G00892755
 */
class ASCIIBook {
	/**
	 *  Size of the book.
	 */
	private int size;
	
	/**
	 *  Constructor that restricts the size to even
	 *  numbers and ensures the book is not too small
	 *  (not smaller than size 8).
	 *  
	 *  @param size height of the cover of the book
	 */
	public ASCIIBook(int size) {
		this.size = size;
		if(this.size%2 != 0) this.size -= 1;
		if(this.size < 8) this.size = 8;
	}
	
	/**
	 *  Prints the entire ASCII book to the console.
	 */
	public void print() {
		//print top of the book
		printIndent(this.size+1);
		printHorizontalBorder();
		System.out.println();
		
		//print the cover of the book (plus right side)
		for(int i = 1; i <= this.size; i++) {
			printIndent(this.size+1-i);
			printCover(i);
			printRightSide(i+1);
			System.out.println();
		}
		
		printHorizontalBorder();
		printRightSide((this.size/2)+1);
		System.out.println();
		
		//print the bottom side of the book (plus right side)
		for(int i = this.size/2; i > 0; i--) {
			printBottomEdge();
			printRightSide(i);
			System.out.println();
		}
		
		printHorizontalBorder();
		System.out.println();
	}
	
	/**
	 *  Prints some number of spaces to the console. 
	 *
	 *  The for-loop starts at 0, then prints the number of
	 *  spaces according to the integer numSpaces.
	 */
	public void printIndent(int numSpaces) {
		for(int i = 0; i < numSpaces; i++) {
			System.out.print(" ");
		}
	}
	
	/**
	 *  Prints one line of the cover of the book. Does
	 *  not print the first "/" at the right edge of the book.
	 *
	 *  
	 * The method begins by printing the first "/". The first for-loop prints the number of spaces that
	 * needs to be printed depending on the rowNumber. As the rowNumber gets bigger, the number of spaces
	 * gets smaller. The second for-loop has two conditions. If the rowNumber is equal to one, it will 
	 * print 3 underscores. Otherwise, it will only print three underscores at the end of each row 
	 * given by formula "block - this.size +rowNumber = rowNumber". To get the program to not print two 
	 * "/"s at the end, the method prints the last "__" (or "___" if the rowNumber is 1) at the end.
	 */
	public void printCover(int rowNumber) {
		System.out.print("/");
		//printing spaces on inside
		for(int j = this.size; j > rowNumber; j--) {
			System.out.print("   ");
		}
		for(int block = this.size; block>=((this.size+2)-rowNumber);block--) { //this.size+1
			if(rowNumber == 1){
				System.out.print("___");
			}
			
			
			if (block - this.size + rowNumber == rowNumber) {
				System.out.print("___/");
			} else {
				System.out.print("__/");
			}	
		}
		if (rowNumber == 1){
			System.out.print("___");
		} else {
			System.out.print("__");
		}
	}
	
	/**
	 *  Prints some number of dashes which represent
	 *  the right side of the book. If the number of
	 *  dashes is larger than the maximum number of
	 *  dashes needed on any given line, prints the
	 *  maximum instead.
	 *
	 *  @param numDashes the number of dashes requested
	 */


	 /*
	 *  There are two conditions. If the numDashes is greater "this.size-(this.size/2 -1)", then the 
	 *  method prints the maximum number of dashes (formula above ^ in quotes.). Otherwise, it will print
	 *  the number of dashes requested through the parameter "numDashes".
	 */
	public void printRightSide(int numDashes) {
		if (numDashes > this.size-(this.size/2-1)){
			for(int i = 0; i<=(this.size-((this.size/2)-1));i++){
				System.out.print("/");
			}
		} else {
			for(int j = 0; j<numDashes; j++){
				System.out.print("/");
			}
		}
	}
	
	/**
	 *  Prints the part of the book that looks like:
	 *  |    Building Java Programs    |
	 *  The number of spaces between the words and the "|"
	 *  is determined by the size of the book.
	 */

	/**
	 * The printBottomEdge method checks to see if the size is greater than 8, which is the smallest
	 * size the book can be. If the size is equal to 8, it prints only one space, then it prints the text
	 * then it prints one space at the end. If the size is greater than 8, it prints a number of spaces 
	 * determined by the size of the book. The formula "((this.size-8)*3)/2" determines the number of 
	 * spaces. Starting at the lowest book size, 8, the space will start with one, and then increase by 3
	 * for each next book size. For example, 8 -> 1,  10 -> 4, 12 -> 7...
	 */
	public void printBottomEdge() {
		System.out.print("|");
		if (this.size > 8) {
			int spaceNum = ((this.size-8)*3)/2;
			for(int i = 0; i <= spaceNum; i++){
				System.out.print(" ");
			}
		} else {
			System.out.print(" ");
		}
		
		System.out.print("Building Java Programs");
	
		if (this.size > 8) {
			int spaceNum = ((this.size-8)*3)/2;
			for(int i = 0; i <= spaceNum; i++){
				System.out.print(" ");
			}
		} else {
			System.out.print(" ");
		}
		System.out.print("|");
	}
	
	/**
	 *  Prints the part of the book that looks like:
	 *  +------------------------------+
	 *  The number of dashes is determined by the size
	 *  of the book.
	 */


	/*
	 * The method printHorizontalBorder first prints the "+" sign, the prints "-" the book size * 3 using 
	 * a for loop then prints another "+" at the end. 
	 */
	public void printHorizontalBorder() {
		System.out.print("+");
		for(int i=1; i<=(this.size*3);i++) {
			System.out.print("-");		
		}	
		System.out.print("+");	
	}
}