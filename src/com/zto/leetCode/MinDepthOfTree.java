package com.zto.leetCode;

import com.zto.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * Author xujun
 * Create date 2019-03-04.
 * desc:
 */
public class MinDepthOfTree {
    public static void main(String[] args) {
      TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        int res=getMinDepthTree(node1);
        System.out.println("the min depth is:"+res);
    }
    public static int getMinDepthTree(TreeNode node){
        if(node==null) return 0;
        LinkedList<TreeNode> queen=new LinkedList<TreeNode>();
        queen.add(node);
        int current=1;
        int next=0;
        int index=0;
        int ideaNum=1;
        int depth=0;
        boolean finded=false;
        while (!queen.isEmpty()&&!finded){
            TreeNode n=queen.poll();//当前节点被访问
            index++;
            if(n.left!=null){
                queen.add(n.left);
                next++;
            }
            if(n.right!=null){
                queen.add(n.right);
                next++;
            }
            if(index==current){
                if(index==ideaNum){
                    depth++;
                }else{
                    finded=true;
                }
                current=next;
                next=0;
                index=0;
                ideaNum=ideaNum*2;
            }
        }
        return depth;
    }
}
