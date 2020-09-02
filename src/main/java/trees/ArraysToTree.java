package trees;

public class ArraysToTree {
    public TreeNode insert(TreeNode node, int[] arr, int i){
        if(i<arr.length){
            TreeNode temp = new TreeNode(arr[i]);
            node  = temp;

            node.left  = insert(node.left,arr,(2*i)+1);
            node.right = insert(node.right,arr,(2*i)+2);

        }
        return node;
    }

    public static void main(String args[]){
        ArraysToTree a  = new ArraysToTree();
        Tree t = new Tree();
        int arr[] = {1,2,3,4,5,6};
        t.root = a.insert(t.root,arr,0);
        System.out.println(t);
    }
}
