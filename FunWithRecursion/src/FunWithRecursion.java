public class FunWithRecursion {

	public int[] bitArray;
	public char[] kArray;
	
	public static void main(String[] args) {
		FunWithRecursion rc = new FunWithRecursion();

		//System.out.println(rc.factorial(4));
		//System.out.println(rc.factorial(2));
		//System.out.println(rc.factorial(5));
		
		//rc.hanoi(3, "A", "B", "C");
		
//		StringBuilder sb = new StringBuilder();
//		for(int i = 1; i <= 5; i++) {
//			
//			if(sb.length() != 0) {
//				sb.append(", ");
//			}
//			sb.append(rc.fibonacci(i));
//		}
//		System.out.println(sb.toString());
		
		//rc.generateBinary(4);
		
		//System.out.println(rc.gcd(10, 45));
		//rc.pascals(9);
		
		
		String word = "ab";
		for(int i = 0; i<word.length(); i++) {
			rc.printAllStrings(word, 1);
			word = rc.shiftToRight(word);
		}
	}
	
	//factorial recursion
	public int factorial(int n) {
		if(n == 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
	
	//towers of hanoi
	public void hanoi(int disks, String startPeg, String helperPeg, String endPeg) {
		if(disks == 1) {
			System.out.println("Move Disk "+disks+": "+startPeg+" -> "+endPeg);
		} else {
			hanoi(disks - 1, startPeg, endPeg, helperPeg);
			System.out.println("Move Disk "+disks+": "+startPeg+" -> "+endPeg);
			hanoi(disks - 1, helperPeg, startPeg, endPeg);
		}
	}
	
	//fibonacci sequence
	public int fibonacci(int n) {
		
		if ( n == 1 || n == 2) {
			return 1;
		} else {
			return (fibonacci(n - 1) + fibonacci(n - 2));
		}
	}
	
	//Greatest Common Divisor
	public int gcd(int x, int y) {
		if(x == y) {
			return x;
		} else {	
			if(x > y) {
				return gcd(x-y, y);
			} else {
				return gcd(x, y-x);
			}
		}
	}
	
	public void pascals(int n) {
		
		for(int i = 0; i < n; i++) {
			
			StringBuffer sb = new StringBuffer();
			
			for(int j = 0; j <= i; j++) {
				if(sb.length() != 0) {
					sb.append(" ");
				}
				sb.append(triangle(i, j));
			}
			
			System.out.println(sb.toString());
		}
			
	}
	
	//pascals triangle
	public int triangle(int column, int row) {
		if( column < row || row < 0 ) {
			return 0;
		} else if ( column == row || row == 0 ) {
	        return 1;
		} else {
	        return triangle(column-1, row) + triangle(column-1, row-1);
	    }
	}
	
	//generate all possible binary numbers for n bits
	public void generateBinary(int n) {
		
		bitArray = new int[n];
		binary(n);
		
	}
	
	//string of all binary numbers for n bits
	public void binary(int n) {
		if(n < 1) {
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<bitArray.length; i++) {
				if(sb.length() != 0) {
					sb.append(" ");
				}
				sb.append(bitArray[i]);
			}
			System.out.println(sb.toString());
			
		} else {
			bitArray[n - 1] = 0;
			binary(n - 1);
			bitArray[n - 1] = 1;
			binary(n - 1);
		}
	}
	
    public void printAllStrings(String word, int end) {
        if(end > word.length()) {
        	return;
        } else {
        	System.out.println(word.substring(0, end));
        	printAllStrings(word, end+1);
        }
    }
    
    public String shiftToRight(String word) {
    	
    	char[] array = word.toCharArray();
    	char last = array[word.length()-1];
    	
    	for(int i = 0; i < word.length()-1; i++) {
    		array[i+1] = word.charAt(i);
    	}
    	array[0] = last;
    	
    	return String.valueOf(array);
    }

}
