package cp.practice.trees;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class SolutionBSTInsertion {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
		/* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(data); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (data < root.data) 
            root.left = insert(root.left, data); 
        else if (data > root.data) 
            root.right = insert(root.right, data); 
  
        /* return the (unchanged) node pointer */
        return root; 
    }

	public static void main(String[] args) {
        int a[] = {50,30,20,40,70,60,80};
        int t = a.length;
        int i =0;
        Node root = null;
        while(t-- > 0) {
            int data = a[i++];
            root = insert(root, data);
        }
      	//preOrder(root);
      	new BinaryTreePrinter().print(root);
    }	
}