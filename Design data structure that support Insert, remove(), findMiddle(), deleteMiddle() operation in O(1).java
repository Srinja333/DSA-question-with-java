/*Design data structure that support Insert, remove(), findMiddle(), deleteMiddle() operation in O(1)
Asked In: IntuitWalmartLabs
You need to design a data structure which support below operation in O(1) time complexity 1) Insert() which adds an element to the data structure 2) remove() which removes an element from the data structure 3) findMiddle() which will return middle element 4) deleteMiddle() which will delete the middle element. Insert(1) --- O(1) time complexity Insert(2) Insert(3) findMiddle() – 2 in O(1) time complexity Insert(4) Insert(5) deleteMiddle() - remove 3 in O(1) time complexity remove(5) – in O(1) time complexity

Example:

Insert(1)  --- O(1) time complexity 
Insert(2)  
Insert(3) 
findMiddle() –  2    in O(1) time complexity 
Insert(4)  
Insert(5) 
deleteMiddle() - remove 3 in O(1) time complexity 
remove(5) –  in O(1) time complexity
Problem level: Hard*/
class Main
{
/* Java Program to implement a stack that supports
findMiddle() and deleteMiddle in O(1) time */
/* A Doubly Linked List Node */
static class DLLNode {
  DLLNode prev;
  int data;
  DLLNode next;
  DLLNode(int data) { this.data = data; }
}

/* Representation of the stack data structure that
supports findMiddle() in O(1) time. The Stack is
implemented using Doubly Linked List. It maintains
pointer to head node, pointer to middle node and
count of nodes */
public static class myStack {
  DLLNode head;
  DLLNode mid;
  DLLNode prev;
  DLLNode next;
  int size;
  /* Function to push an element to the stack */
  void push(int new_data)
  {
    DLLNode new_node=new DLLNode(new_data);
    if(size==0)
    {
        head=new_node;
        mid=new_node;
        size++;
        return;
    }
    head.next=new_node;
    new_node.prev=head;
    head=head.next;
    if(size%2!=1)
    {
        mid=mid.next;
    }
        size++;
  }

  /* Function to pop an element from stack */
  int pop()
  {
    int data=-1;
    if(size==0)
    {
        System.out.print("stack is empty");
        return -1;
    }
    if(size!=0)
    {
        if(size==1)
        {
            head=null;
            mid=null;
            
        }
        else
        {
            data=head.data;
            head=head.prev;
            head.next=null;
            if(size%2==0)
            {
                mid=mid.prev;
            }
        }
        size--;
    }
    return data;
    
  }

  // Function for finding middle of the stack
  int findMiddle()
  {
   if(size==0)
   {
       System.out.println("stack is empty now");
       return -1;
   }
   return mid.data;
  }
  void deleteMiddleElement()
  {
      if(size!=0)
      {
          if(size==1)
          {
              head=null;
              mid=null;
          }
          if(size==2)
          {
              head=head.prev;
              mid=mid.prev;
              head.next=null;
            
              
          }
          else
          {
              mid.prev.next=mid.next;
              mid.next.prev=mid.prev;
              if(size%2==0)
              {
                  mid=mid.prev;
              }
              else
              {
                  mid=mid.next;
              }
          }
          size--;
      }
      
      
      
  }
}
  // Driver program to test functions of myStack
  public static void main(String[] args)
  {
    myStack ms = new myStack();
    ms.push(11);
    ms.push(22);
    ms.push(33);
    ms.push(44);
    ms.push(55);
    ms.push(66);
    ms.push(77);
    ms.push(88);
    ms.push(99);

    System.out.println("Popped : " + ms.pop());
    System.out.println("Popped : " + ms.pop());
    System.out.println("Middle Element : "
            + ms.findMiddle());
    ms.deleteMiddleElement();
    System.out.println("New Middle Element : "
            + ms.findMiddle());
  }

}
// This code is contributed by Abhishek Jha
// Updated by Amsavarthan Lv

