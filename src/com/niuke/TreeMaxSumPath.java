package com.niuke;


import com.zto.algorithm.TreeNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/6/28
 **/
public class TreeMaxSumPath {
    private static int total=Integer.MIN_VALUE;
    public static void main(String[] args) {
        //[1,-2,-3,1,3,-2,null,-1]
       TreeNode n1=new TreeNode(-2);
       TreeNode n2=new TreeNode(-1);
       TreeNode n3=new TreeNode(-3);
        TreeNode n4=new TreeNode(1);
        TreeNode n5=new TreeNode(3);
        TreeNode n6=new TreeNode(-2);
        TreeNode n7=new TreeNode(-1);
        n1.left=n2;
//        n1.right=n3;
//        n2.left=n4;
//        n2.right=n5;
//        n3.left=n6;
//        n4.left=n7;
        int maxPath = getMaxPath(n1);
        System.out.println(total);

    }
    public static int getMaxPath(TreeNode node){
        /**
         * 节点值为空直接返回最小值
         */
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int left=getMaxPath(node.left);
        int cur=node.val;
        int right=getMaxPath(node.right);
        /**
         * 当前节点的左子树不为空 且值小于零 设置左子树的值为最小值
         */
        if(node.left!=null&&node.left.val<0){
            left=Integer.MIN_VALUE;
        }
        /**
         * 当前节点的右子树不为空 且值小于零 设置右子树的值为最小值
         */
        if(node.right!=null&&node.right.val<0){
            right=Integer.MIN_VALUE;
        }
         int result=0;
            if (cur >= 0 && left >= 0 && right >= 0) {
                result= cur + left + right;
            } else if (cur <= 0 && left <= 0 && right <= 0) {
                result= Math.max(Math.max(cur, left), right);
            } else if (cur >= 0 && left >= 0 && right <= 0) {
                result= cur + left;
            } else if (cur >= 0 && left <= 0 && right >= 0) {
                result= cur + right;
            } else if (cur >= 0 && left <= 0 && right <= 0) {
                result= cur;
            } else if (cur <= 0 && left <= 0 && right >= 0) {
                result= right;
            } else if (cur <= 0 && left >= 0 && right <= 0) {
                result= left;
            } else if (cur <= 0 && left >= 0 && right >= 0) {
                if (cur + left >= 0) {
                    result= cur + left + right;
                } else {
                    result= Math.max(left, right);
                }
            }
        /**
         * 更新最大值
         */
        if(total<result){
               total=result;
           }
        return result;
    }

}
