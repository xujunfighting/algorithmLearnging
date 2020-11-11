package com.middle;

import com.zto.algorithm.TreeNode;

import java.util.concurrent.ArrayBlockingQueue;

public class IsCompleteTree {
    public static void main(String[] args) {
        TreeNode t1= new TreeNode(1);
        TreeNode t2= new TreeNode(2);
        TreeNode t3= new TreeNode(3);
        t1.left=t2;
        t1.right=null;
        boolean res =isCompleteTree(t1);
        System.out.println(res);
    }
    public static boolean isCompleteTree(TreeNode node){
        boolean result=true;
        boolean ispossibled=false;
        int count=1;
        int index=0;
        int nextCount=0;
        ArrayBlockingQueue<TreeNode> arrayBlockingQueue = new ArrayBlockingQueue(10);
        arrayBlockingQueue.add(node);
        while(!arrayBlockingQueue.isEmpty()){
            TreeNode poll = arrayBlockingQueue.poll();
            if(poll.left==null&&poll.right!=null){//碰到第一个节点没有左子树 只有右子树
                result=false;
                return result;
            }else{
                if((poll.right==null||poll.left==null)&&ispossibled==false){
                    ispossibled=true;
                }else if(ispossibled==true&&(poll.right!=null||poll.left!=null)){
                    result=true;
                    return result;
                }
            }

            if(poll.left!=null){
                arrayBlockingQueue.add(poll.left);
            }
            if(poll.right!=null){
                arrayBlockingQueue.add(poll.right);
            }
        }
        return result;
    }
}
