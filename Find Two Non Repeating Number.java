/*Find Two Non Repeating Number
Asked In: GoogleOLA
Given an array in which all numbers except two are repeated once. (i.e. we have 2n+2 numbers and n numbers are occurring twice and the remaining two have occurred once). Find those two numbers in the most efficient way

Example:

int [] arrA = {4,5,4,5,3,2,9,3,9,8};
Output: 2 and 8
Problem level: Hard*/
public class Main {

    public void find2Element(int [] nums)
    {
        //Write your Code here 
        int n=nums.length;
        int sum=0;
        
        for(int i=0;i<n;i++)
        {
            sum=(sum^nums[i]);
        }
        
        sum=(sum & -sum);
        int sum1=0;
        int sum2=0;
      for(int i=0;i<n;i++)
      {
            if((sum&nums[i])>0)
            {
                sum1=(sum1^nums[i]);
            }
            else
            {
                sum2=(sum2^nums[i]);
            }
        
          
         
      }
       System.out.print(sum1+" "+sum2);
    }
    public static void main(String[] args) {
        Main t = new Main();
        int [] array = {2,4,7,9,2,4};
        t.find2Element(array);

    }
}

/* Try more Inputs

case1:
actual = find2Element([2,4,7,9,2,4])
expected = 7,9

case2:
actual = find2Element([4,5,4,5,3,2,9,3,9,8])
expected = 2,8

case3:
actual = find2Element([1,1,2,2,3,3,4,5,5,6,7,7])
expected = 6,4
        

*/
