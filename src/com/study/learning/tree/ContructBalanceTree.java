package study.learning.tree;
import com.zto.algorithm.TreeNode;

public class ContructBalanceTree {
    public static void main(String[] args) {
        int[] nums= new int[]{-13,-10,3,9};
        TreeNode node = contructBalanceTree(nums,0,nums.length-1);
        System.out.println("end");

    }
    public static TreeNode contructBalanceTree(int[] muns,int start,int end){
        if(start>end){
           return null;
        }
        TreeNode node=new TreeNode(0);
        int middle=(start+end)/2;
        node.setVal(muns[middle]);
        TreeNode left = contructBalanceTree(muns,start,middle-1);
        TreeNode right = contructBalanceTree(muns,middle+1,end);
        node.left=left;
        node.right=right;
        return node;
    }
}
