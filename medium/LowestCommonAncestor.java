public class LowestCommonAncestor{

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        String ancestorsOfNodeP = getAncestors(root, p, new String(""));
        String ancestorsOfNodeQ = getAncestors(root, q, new String(""));
        int commonAncestorPosition = 0;
        boolean equalSoFar = true;
        for(int i = 0; i < Math.min(ancestorsOfNodeP.length(), ancestorsOfNodeQ.length()); i++){
            if(ancestorsOfNodeP == ancestorsOfNodeQ && equalSoFar){
                commonAncestorPosition++;
            }
            else if(ancestorsOfNodeP != ancestorsOfNodeQ){
                equalSoFar = false;
            }
        }
        return findTreeNode(root, ancestorsOfNodeP.substring(0, commonAncestorPosition + 1));
    }

    public TreeNode findTreeNode(TreeNode root, String path){

        if(path.equals("")){
            return root;
        }
        else{
            char move = path.charAt(0);
            if(path.length() > 1){
                path = path.substring(1);
            }
            else{
                path = "";
            }
            if(move == 'L'){
                return findTreeNode(root.left, path);
            }
            else{
                return findTreeNode(root.right, path);
            }
        }
    }
    
    public String getAncestors(TreeNode root, TreeNode child, String treePath){
        if(root != null){
            if(root.val == child.val){
                return treePath;
            }
            String left = getAncestors(root.left, child, treePath + "L");
            if(!left.equals("")){
                return treePath;
            }
            String right = getAncestors(root.right, child, treePath + "R");
            if(!right.equals("")){
                return treePath;
            }
        }
        return "";
    }

}