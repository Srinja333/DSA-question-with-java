//same size is in code analyze but it is for diff size like 1st commented testcase
public class Main {

	// Method to find median
	static double Median(int[] A, int[] B)
	{
      int n=A.length;
      int m=B.length;
      if(n>m)
      {
          return Median(B,A);
      }
      int s=0;
      int e=n;
      int rm=(m+n+1)/2;
      while(s<=e)
      {
          int mid=(s+e)/2;
          int lAs=mid;
          int lBs=rm-mid;
         int lA=(lAs>0)?A[lAs-1]:Integer.MIN_VALUE;
         int lB=(lBs>0)?B[lBs-1]:Integer.MIN_VALUE;
         int rA=(lAs<n)?A[lAs]:Integer.MAX_VALUE;
         int rB=(lBs<m)?B[lBs]:Integer.MAX_VALUE;
         if(lA<=rB && lB<=rA)
         {
             if((m+n)%2==0)
             {
                 return (Math.max(lA,lB)+Math.min(rA,rB))/2;
             }
             else
             {
                 return Math.max(lA,lB);
             }
         }
         else if(lA>rB)
         {
             e=mid-1;
         }
         else
         {
             s=mid+1;
         }
       
      }
  return 0.0;
		
	}

// Driver code
	public static void main(String[] args) {
		int[] arr1 = { -5, 3, 6, 12, 15 };
		int[] arr2 = { -12, -10, -6, -3, 4, 10 };
		System.out.println("Median of the two arrays are");
		System.out.println(Median(arr1, arr2));
	}
}

// This code is contributed by Hritik





/* Try more Inputs
case 1: 
actual = find([1,3],[2],0,0,1,0)
expected = 2

case2: 
 actual = find([0,0],[0,0],0,0,1,1)
 expected = 0
 
case3: 
actual = find([2,7],[11,16],0,0,1,1)
expected = 9

case4: 
actual = find([1,2,3,6],[4,6,8,10],0,0,4,4)
expected = 5
*/



