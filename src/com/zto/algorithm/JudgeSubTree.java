package com.zto.algorithm;

/**
 * Created by xujun on 2018-11-06.
 */
public class JudgeSubTree {
    public static void main(String[] args){
         TreeNode t1=new TreeNode(1);
         TreeNode t2=new TreeNode(2);
         TreeNode t3=new TreeNode(3);
         TreeNode t4=new TreeNode(4);
         TreeNode t5=new TreeNode(5);
         TreeNode t6=new TreeNode(6);
         t1.left=t2;
         t1.right=t3;
         t2.left=t4;
         t3.left=t5;
         t3.right=t6;
        TreeNode p1=new TreeNode(1);
        TreeNode p2=new TreeNode(2);
        TreeNode p4=new TreeNode(4);
        p1.left=p2;
        p2.left=p4;
        boolean result=isSubTree(t1,p1);
        System.out.print(result);
    }
    public boolean judgeSubTree(TreeNode t1,TreeNode t2){
        boolean result=false;
        while(t1!=null){
            if(t1.getVal()==t2.getVal()){
                result=isSubTree(t1,t2);
            }
            if(result==false&&t1.left!=null){
                judgeSubTree(t1.left,t2);
            }
            if(result==false&&t1.right!=null){
                judgeSubTree(t1.right,t2);
            }
        }
        return result;
    }
    public static boolean isSubTree(TreeNode t1,TreeNode t2){ //t1表示参照树   t2表示子树
       if(t1==null&&t2==null){
           return true;
       }
       if(t1==null&&t2!=null){
           return false;
       }
       if(t1!=null&&t2==null){
           return true;
       }
       if(t1.getVal()!=t2.getVal()){
            return false;
        }
       boolean  left=isSubTree(t1.left,t2.left);
       boolean right=isSubTree(t1.right,t2.right);
       return left&&right;
    }
}
