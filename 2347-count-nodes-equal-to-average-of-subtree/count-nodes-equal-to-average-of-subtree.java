/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int matchingCount = 0;
    public int averageOfSubtree(TreeNode root) {
      traverse(root);
      return matchingCount;
    }
    private int[] traverse(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);

        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;

        if(currentSum / currentCount == node.val){
            matchingCount++;
        }
        return new int[] {currentSum, currentCount};
    }
}