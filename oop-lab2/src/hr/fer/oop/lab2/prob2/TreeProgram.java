package hr.fer.oop.lab2.prob2;

class TreeNode{
	TreeNode left;
	TreeNode right;
	String Data;
}



class TreeProgram {
	
	 public static void main(String[] args) {
		TreeNode node = null;
		node = insert(node, "Jasna");
		node = insert(node, "Ana");
		node = insert(node, "Ivana");
		node = insert(node, "Anamarija");
		node = insert(node, "Vesna");
		node = insert(node, "Kristina");
		System.out.println("Writing tree inorder:");
		writeTree(node);
		 node = reverseTreeOrder(node);
		System.out.println("Writing reversed tree inorder:");
		writeTree(node);
		int size = sizeOfTree(node);
		System.out.println("Number of nodes in tree is "+size+".");
		boolean found = containsData2(node, "Ivana");
		System.out.println("Searched element is found: "+found);
		 }
		 static boolean containsData(TreeNode treeRoot, String data) {

			 while(!treeRoot.equals(null) && !data.equals(treeRoot.Data)){
				 	
				 if(data.compareTo(treeRoot.Data)==1) treeRoot=treeRoot.right;
				 
				 else if(data.compareTo(treeRoot.Data)==-1) treeRoot=treeRoot.left;
				 
			 
			 }
			 
			 if(data.equals(treeRoot.Data)) return true;
			 
			 else return false;
			 
			 
		 }

		 static int sizeOfTree(TreeNode treeRoot) {
			 if(treeRoot==null) return 0;
			 else return 1+ sizeOfTree(treeRoot.left)+sizeOfTree(treeRoot.right);
		 
		 }
		 static TreeNode insert(TreeNode treeRoot, String data) {
			 	
			 
			 	if(treeRoot==null){
			 		treeRoot = new TreeNode();
			 		treeRoot.Data=data;
			 		treeRoot.left=treeRoot.right=null;
			 	}
			 	
			 	else if(data.compareTo(treeRoot.Data)<=0){
			 		treeRoot.left=insert(treeRoot.left, data);
			 	}
			 	
			 	else{
			 		treeRoot.right=insert(treeRoot.right,data);
			 	}
			 	
			 	return treeRoot;
		 }

		 static void writeTree(TreeNode treeRoot) {
			 if(treeRoot==null) return;
			 writeTree(treeRoot.left);
			 System.out.println(treeRoot.Data);
			 writeTree(treeRoot.right);
		 }

		 static TreeNode reverseTreeOrder(TreeNode treeRoot) {
			 if(treeRoot==null) return treeRoot;
			 
			 else{
			 TreeNode temp= treeRoot.left;
			 treeRoot.left=reverseTreeOrder(treeRoot.right);
			 treeRoot.right=reverseTreeOrder(temp);
			 return treeRoot;
			 }
		 }

		 static boolean containsData2(TreeNode treeRoot, String data){
			 
			 if(treeRoot==null){
				 return false;
			 }
			 
			 if (data.equals(treeRoot.Data)){
				 return true;
			 }
			 
			 else{
				 if(containsData2(treeRoot.left, data)) return true;
				 else if(containsData2(treeRoot.right, data)) return true;
				 else return false;
			 }
		 }

}
