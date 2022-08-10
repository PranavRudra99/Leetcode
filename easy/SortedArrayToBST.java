class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructTreeFromArray(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        if(l == r){
            return new TreeNode(nums[l]);
        }
        int mid = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructTreeFromArray(nums, l, mid - 1);
        node.right = constructTreeFromArray(nums, mid + 1, r);
        return node;
        
    }
}