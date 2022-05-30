/*Linear time approach to solve Stock Buy Sell Problem
Asked In: AmazonMicrosoftFlipkartDE-Shaw
An array is given as Input where ith element is the price of a given stock on day You were permitted to complete unlimited transaction. Derive an algorithm to find the maximum profit in O(n) Time complexity and O(n) Space Complexity Asked in: Amazon, Microsoft, Flipkart, DE-Shaw

Example:

Input: [7,1,5,3,6,4]

Input: [7,6,4,3,1]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 2 (price = 5) and Buy on day 3 (price = 3) and sell on day 4 (price = 4),  profit = (5-1) + (6-3) = 7.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
Hint 1:  find out the maximum difference (which will be the maximum profit) between two numbers in the given array
Hint2: You need to solve this problem in O(n) time complexity 
Problem level: Medium*/


import java.util.ArrayList; 
    
public class Main { 
  static class Result { 
    int buy, sell; 
}
    void findProfit(int array[], int n) 
    { 
        
         //Practise Yourself : Write your code Here
          ArrayList<Result>result=new ArrayList<Result>();
        int c=0;
        int i=0;
        while(i<n-1)
        {
            if(i==n-1)
            break;
            
            while(i<n-1 && array[i+1]<=array[i])
            {
                i++;
            }
            Result temp= new Result();
            temp.buy=i++;
            
            while(i<n && array[i-1]<=array[i])
            {
                i++;
            }
            temp.sell=i-1;
            result.add(temp);
            c++;
        }
        if(c>0)
        {
            for(int j=0;j<c;j++)
            System.out.println("buy on "+result.get(j).buy+" sell on "+result.get(j).sell);
        }
        
    } 
  
    public static void main(String args[]) 
    { 
        Main stock = new Main(); 
  
        int array[] = { 98, 178, 250, 300, 40, 540, 690 }; 
        int n = array.length; 
  
        stock.findProfit(array, n); 
    } 
} 


/* Try more Inputs
case 1: 
actual = findProfit([7,1,5,3,6,4],6)
expected = 2

Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3

case2: 
 actual = findProfit([1,2,3,4,5],5)
 expected = 4
 Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4
 
case3: 
actual = findProfit([7,6,4,3,1],5)
expected = 0
In this case, no transaction is done, i.e., max profit = 0
*/
