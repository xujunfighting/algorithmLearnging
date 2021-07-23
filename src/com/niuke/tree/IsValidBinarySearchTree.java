package com.niuke.tree;

import com.zto.algorithm.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/22
 **/
public class IsValidBinarySearchTree {
    /**
     * 用于记录以当前节点作为根节点的左子树的最大值 和右子树的最小值
     * 需要满足根节点大于左子树的最大值 且小于右子树的最小值
     */
    static int[] res=new int[3];
    static boolean result=true;
    //[5,4,6,null,null,3,7]
    //[32,26,47,19,null,null,56,null,27].
    public static void main(String[] args) {
          TreeNode n32=new TreeNode(32);
          TreeNode n26=new TreeNode(26);
          TreeNode n47=new TreeNode(47);
          TreeNode n19=new TreeNode(19);
          TreeNode n56=new TreeNode(56);
          TreeNode n27=new TreeNode(27);
          n32.left=n26;
          n26.left=n19;
          n19.right=n27;
          n32.right=n47;
          n47.right=n56;

          getResult(n32);
        System.out.println(result);
    }
    public static boolean getResult(TreeNode node){
        if(node==null){
            return true;
        }
        if(node.left==null&&node.right==null){
            res[0]=node.val;
            res[1]=node.val;
            res[2]=node.val;
            return true;
        }
        int val=node.val;
        boolean left=getResult(node.left);
        int leftMIn=res[0];
        int leftMax=res[2];
        boolean right=getResult(node.right);
        int rightMin=res[0];
        int rightMax=res[2];
        if(left&&right){
            if((node.left!=null&&val>leftMax)&&(node.right!=null&&val<rightMin)){
                /**
                 * 左右子树都不为空 记录左子树的最小值 和右子树的最大值
                 */
                res[0]=leftMIn;
                res[1]=val;
                res[2]=rightMax;
                result=true;
            }else if(node.right==null&&node.left!=null&&val>leftMax){
                /**
                 * 右子树为空
                 */
                res[0]=leftMIn;
                res[1]=val;
                res[2]=val;
                result=true;
            }else if(node.left==null&&node.right!=null&&val<rightMin){
                /**
                 * 左子树为空
                 */
                res[0]=val;
                res[1]=val;
                res[2]=rightMax;
                result=true;
            }else{
                result=false;
            }
        }else{
            result=false;
        }
        return result;
    }
}
