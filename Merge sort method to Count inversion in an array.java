/*Merge sort method to Count inversion in an array
Asked In: GoogleMicrosoft
Given an unsorted Array, Find the count of Inversion required to make this array sorted in Time Complexity:O(nlogn) and Space Complexity: O(n) Asked in : Google, Microsoft

Example:

[[The inversions of an array indicate; how many changes are required to convert the array into its sorted form]
[Array of integers A[], if i < j and A[i] > A[j] then the pair (i, j) is called the inversion of an array A[]]
Input :  
A = [1, 2, 5, 4, 3]
 A = [5, 17, 100, 11]
Output:  
  3
  2
Problem level: Medium*/
import java.util.Arrays; 
  
public class Main { 
  
       public static int mergesort(int [] array,int l,int m,int r)
    {
         int [] left= Arrays.copyOfRange(array,l,m+1);
         int [] right= Arrays.copyOfRange(array,m+1,r+1);
         int i=0,j=0,k=l,swap=0;
         while(i<left.length && j<right.length)
         {
             if(right[j]>=left[i])
             {
                 array[k++]=left[i++];
             }
             else
             {
                 array[k++]=right[j++];
                 swap+=(m+1)-(l+i);
                 
             }
         }
         while(i<left.length)
         { 
             array[k++]=left[i++];
             
         }
          while(j<right.length)
         { 
             array[k++]=right[j++];
             
         }
         
         return swap;
    }
    public static int mergeSortAndCount(int[] array, int left, int right) 
    { 
         //Practise Yourself : Write your code Here
         
	        int inv_count = 0; 
	  
	        if (left < right) { 
	            int mid = (left + right) / 2; 
	            
	            inv_count += mergeSortAndCount(array, left, mid); 
	  
                inv_count += mergeSortAndCount(array, mid + 1, right); 
	  
	            inv_count += mergesort(array, left, mid, right); 
	        } 
	  
        return inv_count;	    
    } 
    public static void main(String[] args) 
    { 
        int[] array = { 9, 1, 6, 4, 5 }; 
        //get inversion count by performing modified merge sort on list
        System.out.println(mergeSortAndCount(array, 0, array.length - 1)); 
    } 
} 

/* Try more Inputs
case 1: 
actual = mergeSortAndCount([3, 2, 1],0,2)
expected = 3

case2: 
 actual = mergeSortAndCount([4, 1, 3, 2],0,3)
 expected = 4
 
case3: 
actual = mergeSortAndCount([8, 4, 2, 1],0,3)
expected = 6
*/
