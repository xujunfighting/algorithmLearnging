package com.niuke;

import com.zto.algorithm.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/29
 */
public class GetBST {
    public static void main(String[] args) {

        int[] res=new int[]{1,3};
        TreeNode result = getResult(res, 0, res.length - 1);
        System.out.println(result);
    }
    public static TreeNode getResult(int[] res,int start,int end){
        if(start>end){
            return null;
        }
        if(start==end){
            TreeNode n=new TreeNode(res[start]);
            return n;
        }
         int middle=(start+end)%2==0?(start+end)/2:(start+end)/2+1;
         int val=res[middle];
         TreeNode node=new TreeNode(val);
         TreeNode left=getResult(res,start,middle-1);
         TreeNode right=getResult(res,middle+1,end);
         if(left!=null&&right!=null){
             node.left=left;
             node.right=right;
         }else if(left!=null&&right==null){
             node.left=left;
             node.right=null;
         }else if(left==null&&right!=null){
             node.left=right;
             node.right=null;
         }
         return node;
    }
}
