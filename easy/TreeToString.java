//https://leetcode.com/problems/construct-string-from-binary-tree/
class Solution {
   
    StringBuilder stringBuilder = new StringBuilder();
    
    public String tree2str(TreeNode root) {
        
        iterate(root);
        return stringBuilder.toString();
        
    }

    public void iterate(TreeNode node){

        if(node == null){
            return;
        }
        stringBuilder.append(node.val);
        if(node.left == null && node.right == null){
            return;
        } 
        stringBuilder.append('(');
        iterate(node.left);
        stringBuilder.append(')');
        if(node.right != null){
            stringBuilder.append('(');
            iterate(node.right);
            stringBuilder.append(')');
        }
        
    }
}