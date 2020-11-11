package study.learning.tree;
import com.zto.algorithm.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class IsCompleteTree {
    public static void main(String[] args) {

    }
    public boolean isCompleteTree(TreeNode root){
        if(root==null) return true;
        Queue<TreeNode>  queue= new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){

        }
        return false;
    }
}
