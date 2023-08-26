package com.niuke.tree;

/**
 * Description
 *剑指 Offer 33
 * @author xujun
 * @date 2023.08.20 08:46
 */
public class IsBackOrder {

    public static void main(String[] args) {
        int[] res=new int[]{1,4,3,7,9,6,8};
        boolean result = getResult(res);
        System.out.println(result);
    }

    public static boolean getResult(int[] postorder){
        if(postorder.length==0||postorder.length==1){
            return true;
        }
        return checkResult(postorder,0,postorder.length-1);
    }


    public static boolean checkResult(int[] postorder,int start,int end){
        if (start >= end) {
            return true;
        }
        /**
         * 获取数组最后的节点为根节点
         */
        int mid=postorder[end];
        int index=start;
        /**
         * 从头开始查找小于根节点的元素 为左子树的元素
         */
        while(postorder[index]<mid){
            index++;
        }
        /**
         * 判断右子树中的元素是否存在小于根节点的元素 如果存在则不是一个后续遍历
         */
        for(int i=index;i<=end-1;i++){
            if(postorder[i]<mid){
               return false;
            }
        }
        boolean left=checkResult(postorder,start,index-1);
        boolean right=checkResult(postorder,index,end-1);
        return left&&right;
    }
}
