/*Lexicographical order method to solve next smallest palindrome
Asked In: FlipkartOracle
Find next smallest palindrome larger than this given number Asked in: Flipkart, Oracle

Example:

[if the number is 125, next smallest palindrome is 131.] 
[if the input number is “2 3 5 4 5”, the output should be “2 3 6 3 2”]
Input number is “2 3 5 4 5”

input number is “9 9 9”
output should be “2 3 6 3 2”

Output should be “1 0 0 1”

Hint1: Check symmetry for making a number a palindrome
Hint2: Start checking from mid point of a given number for palindrome
Problem level: Hard*/

// Java program to find next smallest
// palindrome

public class Main
{
	// Returns next palindrome of a given
	// number num[]. This function is for
	// input type 2 and 3
	static void generateNextPalindromeUtil(int num[], int n)
	{
		int mid = n / 2;

		// end of left side is always 'mid -1'
		int i = mid - 1;
		
		// Beginning of right side depends
		// if n is odd or even
		
		int j = (n % 2 == 0) ? mid : mid + 1;
		
		// A bool variable to check if copy of left
		// side to right
		// is sufficient or not
		boolean leftsmaller = false;

		// Initially, ignore the middle same digits
		while (i >= 0 && num[i] == num[j])
		{
			i--;
			j++;
		}
		
		// Find if the middle digit(s) need to
		// be incremented or not (or copying left
		// side is not sufficient)
		if (i < 0 || num[i] < num[j])
		{
			leftsmaller = true;
		}
		
		// Copy the mirror of left to tight
		while (i >= 0)
		{
			num[j++] = num[i--];
		}
		
		// Handle the case where middle digit(s)
		// must be incremented. This part of code
		// is for CASE 1 and CASE 2.2
		if (leftsmaller)
		{
			int carry = 1;
		
			// If there are odd digits, then increment
			// the middle digit and store the carry
			if (n % 2 == 1) {
				num[mid] += 1;
				carry = num[mid] / 10;
				num[mid] %= 10;
			}
			i = mid - 1;
			j = (n % 2 == 0 ? mid : mid + 1);
			
			// Add 1 to the rightmost digit of the left
			// side, propagate the carry towards MSB digit
			// and simultaneously copying mirror of the
			// left side to the right side.
			//when carry is zero no need to loop through till i>=0
			while (i >= 0 && carry>0)
			{
				num[i] = num[i] + carry;
				carry = num[i] / 10;
				num[i] %= 10;
				num[j] = num[i];// copy mirror to right
				i--;
				j++;
			}

		}
	}

	// The function that prints next palindrome
	// of a given number num[] with n digits.
	static void generateNextPalindrome(int num[], int n)
	{
		System.out.println("Next Palindrome is:");
		
		// Input type 1: All the digits are 9,
		// simply o/p 1 followed by n-1 0's
		// followed by 1.
		if (isAll9(num, n)) {
			System.out.print("1");
			for (int i = 0; i < n - 1; i++)
				System.out.print("0");
			System.out.println("1");

		}
	
		// Input type 2 and 3
		else {
			generateNextPalindromeUtil(num, n);
			printarray(num);
		}
	}

	// A utility function to check if num has all 9s
	static boolean isAll9(int num[], int n) {
		for (int i = 0; i < n; i++)
			if (num[i] != 9)
				return false;
		return true;
	}

	/* Utility that prints out an array on a line */
	static void printarray(int num[]) {
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]);
		System.out.println();
	}

	public static void main(String[] args)
	{
		int num[] = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
		generateNextPalindrome(num, num.length);
	}
}


/* Try more Inputs
case 1: 
actual = nextPalindromeProblem([9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2],11)
expected = 94188088149

case2: 
 actual = nextPalindromeProblem([1,2,1],3)
 expected = 131
 
case3: 
actual = nextPalindromeProblem([2,3,5,4,5],5)
expected = 23632
*/
