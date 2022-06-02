/*Array puzzle of solving celebrity problem
Asked In: GoogleFlipkartAmazonMicrosoft
You are in a party of N people, where only one person is known to everyone. Such a person may be present at the party, if yes, (s)he doesn’t know anyone at the party. Your task is to find the celebrity at the party in Time Complexity O(n) Asked in: Google, Flipkart, Amazon, Microsoft

Example:

Input: 
matrix = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. matrix[i][j] = 1 means person i knows person j, otherwise matrix[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.

Hint1: create boolean matrix to find wether person A knows person B or not
Hint2 : No constraint for space complexity but time complexity should be O(n)
Problem level: Easy

*/
class Main  
{ 
    static int matrix[][] = { { 0, 0, 1, 0 }, 
                               { 0, 0, 1, 0 },  
                              { 0, 0, 0, 0 }, 
                              { 0, 0, 1, 0 } }; 
  
    static boolean knows(int a, int b)  
    { 
         //Practise Yourself : Write your code Here
             
     boolean result= (matrix[a][b]==1) ? true : false;
         
         return result;
         
        
    } 
     // Returns -1 if celebrity is not present. If present,returns id (value from 0 to n-1). 
    static int findCelebrity(int n)  
    { 
         //Practise Yourself : Write your code Here
           int a=0;
         int b=n-1;
         while(a<b)
         {
             if(knows(a,b))
             a++;
             
             else
             b--;
         }
         for(int i=0;i<n;i++)
         {
             if(i!=a && (knows(a,i) || !knows(i,a)))
             return -1;
         }
         
         return a;
    } 
  
    public static void main(String[] args)  
    { 
        int n = 4; 
        int result = findCelebrity(n); 
        if (result == -1)  
        { 
            System.out.println("No Celebrity"); 
        }  
        else
            System.out.println("Celebrity is " + result); 
    } 
} 


/* Try more Inputs
case 1: 
static int matrix[][] = {{0 1 0}, 
                         {0 0 0}, 
                         {0 1 0}};
expected = 1

case2: 
static int matrix[][] = {{0 1},
                        {1 0}};
 expected = -1
 
Note: The two people at the party both
know each other. None of them is a celebrity
 
case 3: 
static int matrix[][] = { {0, 0, 1, 0},
                            {0, 0, 1, 0},
                         {0, 1, 0, 0},
                         {0, 0, 1, 0} };
expected = -1
*/
