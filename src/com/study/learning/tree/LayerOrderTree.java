package study.learning.tree;

import com.zto.algorithm.TreeNode;
import study.learning.array.ArrayTest;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LayerOrderTree {
    public static void main(String[] args) {
//        3
//                / \
//        9  20
//                /  \
////        15   7
        TreeNode node3= new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20=new TreeNode(20);
        TreeNode node15=new TreeNode(15);
        TreeNode node7=new TreeNode(7);
        node3.left=node9;
        node3.right=node20;
        node20.left=node15;
        node20.right=node7;
        List<List<Integer>> res=levelOrder(node3);
        System.out.println("end");
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists= new ArrayList<>();
        if(root==null){
             return lists;
        }
        Queue<TreeNode> queue= new LinkedBlockingQueue<>();
        int currCount=1;
        int nextCount=0;
        int index=0;
        queue.add(root);
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
             TreeNode curr = queue.poll();
             list.add(curr.getVal());
             index++;
             if(curr.left!=null){
                queue.add(curr.left);
                nextCount++;
             }
             if(curr.right!=null){
                 queue.add(curr.right);
                 nextCount++;
             }
             if(index==currCount){
                  index=0;
                  currCount=nextCount;
                  lists.add(new ArrayList<>(list));
                  list= new ArrayList<>();
                  nextCount=0;
             }
        }
       return lists;
    }
}
