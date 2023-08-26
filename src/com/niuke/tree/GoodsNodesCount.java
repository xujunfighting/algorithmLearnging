package com.niuke.tree;

import com.zto.algorithm.TreeNode;

import java.util.Stack;

/**
 * @Author xujun
 * @Description 1448. 统计二叉树中好节点的数目
 * @Date 2023/8/26 09:31
 */
public class GoodsNodesCount {

    private static int curMax=Integer.MIN_VALUE;
    private static int totalCount=0;
    private static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(5);
        //TreeNode n7=new TreeNode();
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.left=n5;
        n4.right=n6;
        int result = getResult(n1);
        System.out.println(result);
    }


    public static int getResult(TreeNode node){
        stack=new Stack<>();
        preOrder2(node,curMax);
        return totalCount;
    }

    /**
     * 使用单调栈维护当前最大元素
     * @param node
     * @return
     */
    public static void preOrder(TreeNode node){
        if (node == null) {
            return;
        }
        /**
         * 判断当前值是否是大于维护的最大值 如果是 总值+1  并把当前元素直接插入到单调栈中
         */
        if (node.val >= curMax) {
            totalCount++;
            curMax = node.val;
            if(stack.isEmpty()){
                stack.push(curMax);
            }else{
                if(stack.peek()<=curMax){
                    stack.add(curMax);
                }
            }
        }

        preOrder(node.left);
        preOrder(node.right);
        /**
         * 完成当前元素遍历后 如果该元素是最大值 弹出该元素 并将单调栈中的前面一个元素的值赋值给维护的最大值
         */
        if(curMax==node.val){
            stack.pop();
            if(!stack.isEmpty()) {
                curMax = stack.peek();
            }
        }
    }

    /**
     * 使用局部变量维护当前最大元素
     * @param node
     * @param curMax
     */
    public static void preOrder2(TreeNode node,Integer curMax){
        if(node==null){
            return;
        }
        if(node.val>=curMax){
            curMax=node.val;
            totalCount++;
        }
        preOrder2(node.left,curMax);
        preOrder2(node.right,curMax);
    }
}
