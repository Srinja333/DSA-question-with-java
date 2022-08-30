public class Main {  
      
    //Represent a node of the doubly linked list  
  
    class Node{  
        int data;  
        Node previous;  
        Node next;  
          
        public Node(int data) {  
            this.data = data;  
        }  
    }  
      
    //addNode() will add a node to the list 
    Node head=null;
    Node tail=null;
    public void addNode(int data) {  
       //Write your code here 
       Node newNode=new Node(data);
       if(head==null)
       {
           tail=head=newNode;
           head.previous=null;
           tail.next=null;
       }
       else
       {
           tail.next=newNode;
           newNode.previous=tail;
           tail=newNode;
           tail.next=null;
           
           
           
       }
    }  
      
    //display() will print out the nodes of the list  
    public void display() {  
         //Write your code here   
         Node current=head;
         if(head==null)
         {
             System.out.println("node is empty");
             return;
         }
         
             while(current!=null)
             {
                 System.out.print(" "+current.data);
                 current=current.next;
                 
             }
         System.out.println();
    }  
    
     public void searchNode(int data) {  
         //Write your code here  
         Node curr=head;
         if(head==null)
         {
             System.out.println("list is empty");
             return;
         }
         
         while(curr!=null)
         {
             if(curr.data==data)
             {
                 System.out.println("node found");
                 break;
             }
              curr=curr.next;
         }
         
         if(curr==null)
         {
              System.out.println("node not found");
         }
          
         
     }  
     
     public void delete(int data)
     {
         Node curr=head;
         if(head==null)
         {
             System.out.println("list is empty");
             return;
         }
         while(curr!=null)
         {
             if(curr.data==data)
             {
                 if(head==curr)
                 {
                     head=curr.next;
                 }
                 if(curr.next!=null)
                 {
                     curr.next.previous=curr.previous;
                 }
                 if(curr.previous!=null)
                 {
                     curr.previous.next=curr.next;
                 }
                  break;
             }
             curr=curr.next;
            
         }
         
     }
      
    public static void main(String[] args) {  
          
        Main dList = new Main();  
        //Add nodes to the list  
        dList.addNode(1);  
        dList.addNode(2);  
        dList.addNode(3);
        
        System.out.println("Original list: ");  
        dList.display();  
        
        
        dList.searchNode(1);
        
        dList.delete(3);
        
        System.out.println("list after deletion: ");  
        dList.display(); 
        
        
    }  
}  

