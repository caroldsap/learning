package trees;

public class ValidateBSTRecursiveApproach {
    public static void main(String args[]){

        TreeNode left = new TreeNode(15);
        TreeNode right = new TreeNode(12);
        TreeNode root = new TreeNode(10,left,right);
        System.out.println(new ValidateBSTRecursiveApproach().isValidBST(root));
    }

    public boolean isValidBST(TreeNode<Integer> root){
        return isNodeValuesInRange(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isNodeValuesInRange(TreeNode<Integer> root, long min , long max){
        //base cases
        if(root == null){
            return true;
        } else if(root.val<=min || root.val>=max){
            return false;
        }

       return isNodeValuesInRange(root.left,min,root.val)
                && isNodeValuesInRange(root.right,root.val,max);
    }
}
