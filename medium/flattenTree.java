/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/

public class FlattenTree{

    public void flatten(TreeNode root) {
        preOrderTraversal(root);
    }

    public TreeNode preOrderTraversal(TreeNode root){

        if(root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = null;
            if(left != null){
                root.right = preOrderTraversal(left);
            }
            if(right != null){
                TreeNode rightwardDescendants = preOrderTraversal(right);
                TreeNode rootCopy = root;
                while(rootCopy!=null){
                    if(rootCopy.right == null){
                        break;
                    }
                    rootCopy = rootCopy.right;
                }
                rootCopy.right = rightwardDescendants;
            }
            return root;
        }
        return null;
    }

}