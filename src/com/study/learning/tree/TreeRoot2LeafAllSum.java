package study.learning.tree;
import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeRoot2LeafAllSum {
    private static List<List<Integer>> lists= new ArrayList<>();
    private static List<Integer> list= new ArrayList<>();

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
         method(node1);
    }
    public static void method(TreeNode node){
        if(node==null) return;
        if(node.right==null&&node.left==null){
            list.add(node.getVal());
            lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(node.getVal());
        method(node.left);
        method(node.right);
        list.remove(list.size()-1);
    }
}
