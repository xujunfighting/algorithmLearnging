package com.niuke.tree;

import com.zto.algorithm.TreeNode;

import java.util.*;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/29
 **/
public class ConstructTreeFromPreAndPost {
    static int[] preList=null;
    static int[] postList=null;
    public static void main(String[] args) {
//        输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//        输出：[1,2,3,4,5,6,7]
        //TreeNode result = getResult(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
//        TreeNode result=constructFromPrePost(new int[]{1,3,2,4},new int[]{3,4,2,1});
//        System.out.println(result);
         int[] pre=new int[]{2,1};
         int[] post=new int[]{1,2};
         preList=new int[pre.length];
         postList=new int[post.length];
//        TreeNode treeNode = constructFromPrePost2(pre, 0, pre.length - 1, post, 0, post.length - 1);
//        System.out.println(treeNode);
         for(int i=0;i<pre.length;i++){
             preList[i]=pre[i];
         }
         for(int j=0;j<post.length;j++){
             postList[j]=post[j];
         }
        TreeNode treeNode = constructFromPrePost3( 0, pre.length - 1,0, post.length - 1);
        System.out.println(treeNode);
    }
    public static TreeNode getResult(int[] pre, int[] post){
        TreeNode root=null;
        int preStart=0;
        int postEnd=post.length-1;
        int count=1;
        if(pre.length==0){
            return null;
        }
        if(pre.length==1){
            return new TreeNode(pre[0]);
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(new TreeNode(pre[preStart]));
        while(count<pre.length){
            TreeNode node=queue.poll();
            if(preStart==0){
                root=node;
            }
            while(pre[preStart]!=node.val){
                preStart++;
            }
            postEnd=post.length-1;
            while(post[postEnd]!=pre[preStart]){
                postEnd--;
            }
            if(postEnd-1<0||preStart+1>=pre.length){
                continue;
            }
            //左边相邻的节点为树的左子树
            if(preStart+1<pre.length) {
                node.left = new TreeNode(pre[++preStart]);
                queue.add(node.left);
                count++;
            }else{
                node.left=null;
            }
            if(count==pre.length){
                break;
            }
            if(post[postEnd-1]==pre[preStart]){
               continue;
            }
            if(postEnd-1>=0) {
                node.right = new TreeNode(post[--postEnd]);
                queue.add(node.right);
                count++;
            }else{
                node.right=null;
            }
        }
        return root;
    }
    public static TreeNode constructFromPrePost(int[] pre,int[] post){
        int N = pre.length;
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) return root;

        int L = 0;
        for (int i = 0; i < N; ++i)
            if (post[i] == pre[1]) {
                L = i;
                break;
            }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+2),
                Arrays.copyOfRange(post, 0, L+1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+2, N),
                Arrays.copyOfRange(post, L+1, N-1));
        return root;


    }


    public static TreeNode constructFromPrePost2(int[] pre,int preStart,int preEnd,int[] post,int postStart,int postEnd){

        if (preStart>preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart==preEnd) return root;

        int L = 0;
        for (int i = postStart; i <=postEnd; ++i)
            if (post[i] == pre[preStart+1]) {
                L = i;
                break;
            }


        root.left=constructFromPrePost2(pre,preStart+1,preStart+1+(L-postStart),post,postStart,L);
        root.right=constructFromPrePost2(pre,preStart+2+(L-postStart),preEnd,post,L+1,postEnd-1);
        return root;


    }
    public static TreeNode constructFromPrePost3(int preStart,int preEnd,int postStart,int postEnd){

        if (preStart>preEnd) return null;
        TreeNode root = new TreeNode(preList[preStart]);
        /**
         * 前序和后续只有一个节点 直接返回当前节点
         */
        if (preStart==preEnd) return root;

        int L = 0;
        for (int i = postStart; i <=postEnd; ++i)
        /**
         * 从后续遍历中查找到当前节点的左子树部分
         */
            if (postList[i] == preList[preStart+1]) {
                L = i;
                break;
            }

        /**
         * 构建左子树
         */
        root.left=constructFromPrePost3(preStart+1,preStart+1+(L-postStart),postStart,L);
        /**
         * 构建右子树
         */
        root.right=constructFromPrePost3(preStart+2+(L-postStart),preEnd,L+1,postEnd-1);
        return root;


    }

}
