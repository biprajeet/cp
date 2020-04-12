package cp.practice.trees;

public class BinaryTreePrinter {

	public void traversePreOrder(StringBuilder sb, Node node) {
	    if (node != null) {
	        sb.append(node.data);
	        sb.append("\n");
	        traversePreOrder(sb, node.left);
	        traversePreOrder(sb, node.right);
	    }
	}
	
	public void print(Node node) {
		/*
		 * StringBuilder sb = new StringBuilder(); traversePreOrder(sb, "", "", node);
		 */
	    System.out.println(traversePreOrder(node));
		StringBuilder sb = new StringBuilder();
		preorderPrinting(node, sb, 0);
		System.out.println(sb.toString());
	}
	
	public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
	    if (node != null) {
	        sb.append(padding);
	        sb.append(pointer);
	        sb.append(node.data);
	        sb.append("\n");
	 
	        StringBuilder paddingBuilder = new StringBuilder(padding);
	        paddingBuilder.append("│  ");
	 
	        String paddingForBoth = paddingBuilder.toString();
	        String pointerForRight = "└──";
	        String pointerForLeft = (node.right != null) ? "├──" : "└──";
	 
	        traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
	        traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
	    }
	}
	
	public String traversePreOrder(Node root) {
		 
	    if (root == null) {
	        return "";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	    sb.append(root.data);
	 
	    String pointerRight = "└──";
	    String pointerLeft = (root.right != null) ? "├──" : "└──";
	 
	    traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
	    traverseNodes(sb, "", pointerRight, root.right, false);
	 
	    return sb.toString();
	}
	
	public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, 
			  boolean hasRightSibling) {
			    if (node != null) {
			        sb.append("\n");
			        sb.append(padding);
			        sb.append(pointer);
			        sb.append(node.data);
			 
			        StringBuilder paddingBuilder = new StringBuilder(padding);
			        if (hasRightSibling) {
			            paddingBuilder.append("│  ");
			        } else {
			            paddingBuilder.append("   ");
			        }
			 
			        String paddingForBoth = paddingBuilder.toString();
			        String pointerRight = "└──";
			        String pointerLeft = (node.right != null) ? "├──" : "└──";
			 
			        traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
			        traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
			    }
			}
	
	
	
	void preorderPrinting(Node node, StringBuilder sb, int n) {
		if(node == null)
			return;
		sb.append("\n");
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
		sb.append(node.data);
		
		
		preorderPrinting(node.left, sb, n+3);
		preorderPrinting(node.right, sb, n+3);
	}
}
