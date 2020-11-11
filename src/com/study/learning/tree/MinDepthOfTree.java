package study.learning.tree;
import com.zto.algorithm.TreeNode;
public class MinDepthOfTree {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node5;
        node2.right=node3;
        node2.left=node4;
        int res = method(node1);
        System.out.println(res);
    }
    public static int method(TreeNode node){
          if(node==null){
              return 0;
          }
          int leftDepth=method(node.left);
          int rightDepth=method(node.right);
          return Math.min(leftDepth,rightDepth)+1;
    }
}
