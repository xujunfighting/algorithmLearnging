package study.learning.tree;
import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildMIddleOrderTree {
    private static List<Integer> lists= new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
         node1.left=null;
         node1.right=node2;
         node2.left=node3;
         List<Integer> results=method1(node1);
        System.out.println("end");
    }
    public static List<Integer> method(TreeNode root){
        if(root!=null){
            method(root.left);
            lists.add(root.getVal());
            method(root.right);
        }
        return lists;
    }

    public static List<Integer> method1(TreeNode root){
        Stack<TreeNode> stack= new Stack<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            TreeNode node=stack.pop();
            lists.add(node.getVal());
            if(node.right!=null){
                root=node.right;
            }
        }
        return lists;
    }
}
