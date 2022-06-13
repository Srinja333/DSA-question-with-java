/*Maximum Sum Subarray
Asked In: SamsungAdobe
Find the contiguous subarray within an array[] of length N which has the largest sum in Time Complexity O(n) and Space Complexity O(1) - Kadane Algorithm

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
[Hint : Look for all positive contiguous segments of the array and also keep track of the maximum sum contiguous segment until the end]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6
Problem level: Hard*/
import java.io.*; 
import java.util.*; 
  
public class Main 
{ 
    public static void main (String[] args) 
    { 
        int [] a = {-5,6,-7,1,4,-8,16}; 
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a)); 
    } 
  
    static int maxSubArraySum(int array[]) 
    { 
        //Write your code here 
        int n=array.length;
        int resultsum=Integer.MIN_VALUE;
        int intermediatesum=0;
        for(int i=0;i<n;i++)
        {
            intermediatesum=intermediatesum+array[i];
            if(intermediatesum<0)
            {
                intermediatesum=0;
                
            }
            if(array[i]>intermediatesum)
            {
                intermediatesum=array[i];
            }
            if(intermediatesum>resultsum)
            {
                resultsum=intermediatesum;
            }
        }
        return resultsum;
    } 
} 
/* Try more Inputs

case1:
actual = maxSubArraySum([-2,1,-3,4,-1,2,1,-5,4],9)
expected = 6

case2:
actual = maxSubArraySum([1],1)
expected = 1

case3:
actual = maxSubArraySum([-4, 2, -5, 1, 2, 3, 6, -5, 1],9)
expected = 12

case4:
actual = maxSubArraySum([-5, 6, -7, 1, 4, -8, 16],7)
expected = 16

*/
