/*Kth Smallest Element
Asked In: GoogleMicrosoft
Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array Time Complexity: O(log n + log m)

Example:

Input : Array 1 - 2 3 6 7 9
        Array 2 - 1 4 8 10
        k = 5
[Hint : Think of using binary search to kth smallest element] 
Output : 6
Explanation: The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Problem level: Hard*/
/* i did this in more efficient way then before  from  gfg*/
// Java Program to find kth element
// from two sorted arrays
// Time Complexity: O(log k)
import java.util.Arrays;

class Main {
	static int kth(int arr1[], int m, int arr2[], int n,
				int k)
	{
		if (k > (m + n) || k < 1)
			return -1;

		// let m > n
		if (m > n)
			return kth(arr2, n, arr1, m, k);

		// Check if arr1 is empty returning
		// k-th element of arr2
		if (m == 0)
			return arr2[k - 1];

		// Check if k = 1 return minimum of first
		// two elements of both arrays
		if (k == 1)
			return Math.min(arr1[0], arr2[0]);

		// Now the divide and conquer part
		int i = Math.min(m, k / 2);
		int j = Math.min(n, k / 2);

		if (arr1[i - 1] > arr2[j - 1]) {
		
			// Now we need to find only k-j th element
			// since we have found out the lowest j
			int temp[] = Arrays.copyOfRange(arr2, j, n);
			return kth(arr1, m, temp, n - j, k - j);
		}

		// Now we need to find only k-i th element
		// since we have found out the lowest i
		int temp[] = Arrays.copyOfRange(arr1, i, m);
		return kth(temp, m - i, arr2, n, k - i);
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr1[] = { 2, 3, 6, 7, 9 };
		int arr2[] = { 1, 4, 8, 10 };
		int m = arr1.length;
		int n = arr2.length;

		int k = 5;
		int ans = kth(arr1, m, arr2, n, k);
		if (ans == -1)
			System.out.println("Invalid query");
		else
			System.out.println(ans);
	}
}



