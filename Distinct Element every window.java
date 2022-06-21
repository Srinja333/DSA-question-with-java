/*Distinct Element every window
Asked In: UberFacebookWalmartLabs
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array in Time Complexity : O(n) and Space Complexity: O(n)

Example:

Input : 1 2 1 3 4 2 3  K = 4

[Hint: Think of counting of the previous window while sliding the window]
Output: 3 4 4 3

Explanation:
Testcase 1 : 
Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
Problem level: Hard*/
import java.util.HashMap;
public class Main 
{ 
    // Counts distinct elements in arraydow of size k 
    static void distinctElement(int arr[], int k) 
    { 
        //Write your Code here 
        
            HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        
        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < k; i++)
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
  
        // Print count of first window
          System.out.println(hM.size());
  
        // Traverse through the remaining array
        for (int i = k; i < arr.length; i++) {
  
            // Remove first element of previous window
            // If there was only one occurrence
            if (hM.get(arr[i - k]) == 1) {
                hM.remove(arr[i - k]);
            }
  
            else // reduce count of the removed element
                hM.put(arr[i - k],  hM.get(arr[i - k]) - 1);            
  
            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
  
            // Print count of current window
            System.out.println(hM.size());
        } 
    } 
      
    public static void main(String args[]) 
    { 
         int array[] = {1, 2, 1, 3, 4, 2, 3},  k = 4; 
            
         distinctElement(array, k); 
    } 
}
/* Try more Inputs
case1:
actual = distinctElement([1,2,1,3,4,2,3],4)
expected = 3,4,4,3

case2:
actual = distinctElement([4,1,1],2)
expected = 2,1

case3:
actual = distinctElement([1,2,1,3,4,3],3)
expected = 2,3,3,2

case4:
actual = distinctElement([1,1,2,2],1)
expected = 1,1,2,2

*/
