package trees;

public class BinaryTreeSymmetric {

    public boolean isSymmetry(TreeNode root){

        if(root == null) return true;
        return checkForSymmetry(root.left, root.right);
    }

    private boolean checkForSymmetry(TreeNode left, TreeNode right) {
        //Base Case
        if(left == null && right == null){
            return true;
        }
        if(left!=null && right !=null){
            return left.val == right.val && checkForSymmetry(left.left, right.right)
                    && checkForSymmetry(left.right,right.left);
        }
        return false;
    }
}
