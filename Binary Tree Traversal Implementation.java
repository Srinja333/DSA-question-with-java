/*Binary Tree Traversal Implementation
Asked In:
Traversal scheme is core Concept of BT. Almost all the problems of Binary tree involves the complete understanding of traversal process.

Example:

Problem level: Medium*/
import java.util.*;

public class Main {
    static class Node
    {
        int key;
        Node left,right;
        public  Node(int item)
        {
            key=item;
            left=null;
            right=null;
        }
    }
    Node root;
    Main()
    {
        root=null;
    }
    void preorder(Node node)
    {
        if(node==null)
        return;
        
        System.out.print(node.key+" ");
        preorder(node.left);
        preorder(node.right);
    }
    void postorder(Node node)
    {
        if(node==null)
        return;
        
        
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key+" ");
    }
    void inorder(Node node)
    {
        if(node==null)
        return;
        
        
        inorder(node.left);
        System.out.print(node.key+" ");
        inorder(node.right);
        
    }
    
    
    
    void preorder()
    {
        preorder(root);
    }
     void postorder()
    {
        postorder(root);
    }
     void inorder()
    {
        inorder(root);
    }
    public static void main(String[] args) throws Exception {
        
     Main tree = new Main();
     tree.root=new Node(1);
     tree.root.left=new Node(2);
     tree.root.right=new Node(3);
     tree.root.left.left=new Node(4);
     tree.root.left.right=new Node(5);
     
     System.out.println("preorder:");
    tree.preorder();
     
     System.out.println("\npostorder:");
     tree.postorder();
     
     System.out.println("\ninorder:");
     tree.inorder();
    }
}
