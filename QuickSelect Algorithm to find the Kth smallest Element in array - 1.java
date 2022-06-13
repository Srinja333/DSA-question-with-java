/*QuickSelect Algorithm to find the Kth smallest Element in array - 1
Asked In: VmwareSapLabsWalmartLabs
Find kth smallest element in that in an unsorted integer array in Time Complexity O(n) and Space Complexity O(1) Asked in :Vmware, SapLabs, WalmartLabs

Example:

Best and Average Case Complexity : O(n)
[In Quick Select method, choosing one element as a pivot and partitioning the data in two based on the pivot accordingly, as less than or greater than the pivot. However, instead of recursing into both sides as in quicksort, quickselect only recurs into one side – the side with the element it is searching for. Since the pivot is in its final sorted position, all those preceding it in an unsorted order and all those following it in an unsorted order]
Input : A[] = {10, 3, 6, 9, 2, 4, 15, 23}, K = 4

Input : A[] = {5, -8, 10, 37, 101, 2, 9}, K = 6
Output: 6
Output: 37
Hint 1: Unlike quicksort, which processes both sides of the array recursively, this algorithm works on only one side of the partition
Hint2: Recur for either the left or right side according to the position of pivot.
Problem level: Hard

*/
public class Main 
{ 
    //finds the kth position in a given unsorted array i.e this function can be used to find both kth largest and kth smallest element in the array. 
    public static int findKthElement(int array[], int low, int high, int k) 
    { 
         //Practise Yourself : Write your code Here 
         if(k>0 && k<=high-low+1)
         {
             int index=division(array,low,high);
             if(index-low==k-1)
             return array[index];
             
             if(index-low>k-1)
             return findKthElement(array, low, index-1, k) ;
             
             return findKthElement(array, index+1, high, k-index+low-1) ;
        
         }
         
        return Integer.MAX_VALUE;
    } 
    
   public static void swap(int array[],int i,int j)
   {
      int temp=array[i];
      array[i]=array[j];
      array[j]=temp;
   }
    
    public static int division(int array[],int low,int high)
    {
        
        int i=low;
        int x=array[high];
        for(int j=low;j<=high-1;j++)
        {
            if(array[j]<=x)
            {
                swap(array,i,j);
                i++;
            }
        }
        swap(array,i,high);
        return i;
    }
   
   
 
    public static void main(String args[]) 
    { 
        Main ob = new Main(); 
        int array[] = {54, 26, 93, 17, 77, 31, 44,20,55}; 
        int n = array.length,k = 3; 
        System.out.println("K'th smallest element is "+ 
                           ob.findKthElement(array, 0, n-1, k)); 
    } 
} 


/* Try more Inputs
case 1: 
actual = findKthElement([7, 10, 4, 3, 20, 15],0,5,3)
expected = 7

case2: 
 actual = findKthElement([7, 10, 4, 3, 20, 15],0,5,4)
 expected = 10
 
case3: 
actual = findKthElement([12, 3, 5, 7, 19],0,4,2)
expected = 5
*/
