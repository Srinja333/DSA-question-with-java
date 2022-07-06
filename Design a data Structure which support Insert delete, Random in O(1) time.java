/*Design a data Structure which support Insert delete, Random in O(1) time
Asked In: GoogleFacebookAmazon
Design a data structure which performs the following operations(Insert an element/Remove an element /find random element) in O(1) time complexity Asked in : Google, Facebook, Amazon

Example:

insert(Num): Inserts a Num to the set if not already present.
remove(Num): Removes a Num from the set if present.
getRandom: Returns a random element from current set of elements 
Set set = new Set();
// Inserts 5 to the set. Returns true as 5 was inserted successfully.
set.insert(5);  – O(1) Time
// Inserts 6 to the set, returns true. Set now contains [5,6].
set.insert(6);
// getRandom should return either 5 or 6 randomly.
randomSet.getRandom();  – O(1) Time
// Removes 5 from the set, returns true. Set now contains [6].
randomSet.remove(5); – O(1) Time
Hint1: For Finding Random Number Module operator with the size of the set
Hint2: Hashmap takes O(1) time in Get() and Put() Operation
Problem level: Medium*/
import java.util.*; 
public class Main 
{ 
   //My first Data Structure to perform all operations in O(1) Time
   ArrayList<Integer> array;   
   //My second Data Structure to perform all operations in O(1) Time
   HashMap<Integer, Integer>  hash; 
  
   public Main() 
   { 
       array = new ArrayList<Integer>(); 
       hash = new HashMap<Integer, Integer>(); 
   } 
  //Inserting value in data structure involve two operations
  //addition in the arraList and inserting entry in HashMap
   void insert(int Num) 
   { 
       //Practise Yourself : Write your code Here
       if(hash.get(Num)!=null)
       {
           return;
       }
       int size=array.size();
       array.add(Num);
       hash.put(Num,size);
      
   } 
  //Removing element is Tricky and most imp 
   void remove(int Num) 
   { 
       //Practise Yourself : Write your code Here
      
       
       if(hash.get(Num) == null)
       {
           return;
       }
       
       int index=hash.get(Num);
       
       hash.remove(index);
       
       int s=array.size();
       
       int last=array.get(s-1);
       
       Collections.swap(array,index,s-1);
       
       array.remove(s-1);
       
       hash.put(last,index);
    } 
    //Returns the ransom element from array 
    int getRandom() 
    { 
        //Practise Yourself : Write your code Here
        Random rand= new Random();
        int i=rand.nextInt(array.size());
        return array.get(i);
    } 
  
    Integer search(int Num) 
    { 
        //Practise Yourself : Write your code Here
        return hash.get(Num);
    } 

  
public static void main (String[] args) 
{ 
    Main ds = new Main(); 
    ds.insert(1); 
    ds.insert(2); 
    // ds.insert(14); 
    // ds.insert(20);
    ds.insert(-1);
    System.out.println(ds.search(-1)); 
    // ds.remove(30); 
    // System.out.println(ds.search(12)); 
    System.out.println(ds.getRandom()); 
} 
} 

/* Try more Inputs
Case 1:
Main ds = new Main();
ds.insert(12); 
ds.insert(16);
ds.insert(30);
result = ds.search(30);
expected = [2]
ds.remove(30);
result = ds.search(12);
expected = [0]

Case2:
Main ds = new Main();
ds.insert(1); 
ds.insert(2);
ds.insert(-1);
result = ds.search(-1);
expected = [2]
*/  
