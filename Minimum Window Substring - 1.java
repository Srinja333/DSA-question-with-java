/*Minimum Window Substring - 1
Asked In: WalmartLabsFacebook
Given two strings string1 and string2 , return the minimum window in string1 which will contain all the characters in string2 in Time Complexity O(n) and Space Complexity O(1) Asked-in: WalmartLabs, Facebook

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Hint1: Think of HashMap Ascii 256 method , Every character can have ascii value of 1 to 255
Problem level: Hard

*/
public class Main  
{ 
    
      
    static String findMinWindow(String s, String p) 
    { 
          //Practise Yourself : Write your code Here
            int slen=s.length();
        int plen=p.length();
        if(slen<plen)
        {
            return "-1";
        }
        int ascii_str []=new int [256]; 
        int ascii_ptr  []=new int [256]; 
        for(int j=0;j<plen;j++)
        {
            ascii_ptr[p.charAt(j)]++;
        }
        int start_index=-1,start=0,c=0,minw=Integer.MAX_VALUE;
        for(int i=0;i<slen;i++)
        {
            ascii_str[s.charAt(i)]++;
            if(ascii_str[s.charAt(i)]<=ascii_ptr[s.charAt(i)] && ascii_ptr[s.charAt(i)]!=0)
            {
                c++;
            }
            if(plen==c)
            {
                while(ascii_ptr[s.charAt(start)]<ascii_str[s.charAt(start)] ||
                ascii_ptr[s.charAt(start)]==0)
                {
                    if(ascii_ptr[s.charAt(start)]<ascii_str[s.charAt(start)])
                    {
                        ascii_str[s.charAt(start)]--;
                        
                    }
                    start++;
                    
                }
                int lw=i-start+1;
                if(minw>lw)
                {
                    minw=lw;
                    start_index=start;
                    
                }
                
            }
        }
      if(start_index==-1)
      {
          return "-1";
      }
      return s.substring(start_index,start_index+minw);
    
    } 
      
    public static void main(String[] args) 
    { 
        String str = "ADOBECODEBANC"; 
        String pat = "ABC"; 
      
    System.out.print("Smallest window is :\n " + 
                        findMinWindow(str, pat)); 
    } 
} 

/* Try more Inputs
case 1: 
actual = findMinWindow("a","a")
expected = Smallest window is : a

case2: 
 actual = findMinWindow("zaaskzaa", "zsk")
 expected = Smallest window is : skz
 
case3: 
actual = findMinWindow("tutorial","oti")
expected = Smallest window is : tori


*/
