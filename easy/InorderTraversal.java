//https://leetcode.com/problems/binary-tree-inorder-traversal/
class Solution {
   
    List<Integer> list;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        list = new LinkedList<>();
        iterate(root);
        return list;
        
    }
    
    public void iterate(TreeNode root){
        
        if(root != null){
            iterate(root.left);
            list.add(root.val);
            iterate(root.right);
        }
        
    }
}