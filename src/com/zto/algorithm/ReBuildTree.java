package com.zto.algorithm;

import com.zto.algorithm.TreeNode;

import java.util.List;

/**
 * Created by xujun on 2018-11-05.
 */
public class ReBuildTree {
    public static void main(String[] args){
        int[] pre=new int[]{1,2,4,7,3,5,6,8};
        int[] post=new int[]{4,7,2,1,5,3,8,6};
        TreeNode node=rebuild(pre,0,pre.length-1,post,0,post.length-1);

    }
    public static TreeNode rebuild(int[] pre,int start1,int end1, int[] middle,int start2,int end2){
        TreeNode node=new TreeNode(0);
        int val=pre[start1];
        node.setVal(val);

        int index=0;
        for(int i=start2;i<=end2;i++){
            if(middle[i]==val){
                index=i;
                break;
            }
        }
        TreeNode left=null;
        TreeNode right=null;
        if(start1+1<=start1+index-start2) {
           left = rebuild(pre, start1 + 1, start1 + index - start2, middle, start2, index - 1);
        }
        if(start1+index-start2+1<=end1) {
           right = rebuild(pre, start1 + index - start2 + 1, end1, middle, index + 1, end2);
        }
        node.left=left;
        node.right=right;
        return node;
    }
}
