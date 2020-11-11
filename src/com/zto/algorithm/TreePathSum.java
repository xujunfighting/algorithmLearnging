package com.zto.algorithm;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xujun on 2018-11-06.
 */
public class TreePathSum {
    public static List<Integer> path=new ArrayList<Integer>();
    public static List<List<Integer>> paths=new ArrayList<List<Integer>>();
    public static void  main(String[] args){
       TreeNode t1=new TreeNode(1);
       TreeNode t2=new TreeNode(2);
       TreeNode t3=new TreeNode(3);
       TreeNode t4=new TreeNode(4);
       TreeNode t5=new TreeNode(3);
       TreeNode t6=new TreeNode(6);
       t1.left=t2;
       t1.right=t3;
       t2.left=t4;
       t3.left=t5;
       t3.right=t6;
       Stack<Integer> path=new Stack<Integer>();
       int val=7;
        solution2(t1,0,7);
   }
   public static void sultion(TreeNode node,int val){
        if(val<0){
            return;
        }else if(node==null&&val==0){
          List<Integer> realPath=new ArrayList<>(path);
          printStack(realPath);
          return;
       } else if(node==null){
          return;
      }
          path.add(node.getVal());
          val -= node.getVal();
         sultion(node.left, val);
         sultion(node.right, val);
          int change = path.remove(path.size()-1);
          val += change;
         return ;
   }
   public static void solution2(TreeNode tree,int index,int sum){
       if(tree==null) return;
       index+=tree.getVal();
       if(tree.left==null&&tree.right==null&&index==sum){
           path.add(tree.getVal());
           List<Integer> realPath=new ArrayList<>(path);
           printStack(realPath);
           int val=path.get(path.size()-1);
           sum-=val;
           path.remove(path.size()-1);
           return;
       }
       path.add(tree.getVal());

       solution2(tree.left,index,sum);
       solution2(tree.right,index,sum);
       path.remove(path.size()-1);
   }
    public  static void FindPathCore(TreeNode root,int target,ArrayList<Integer> curResult,ArrayList<ArrayList<Integer>> result,int curSum){
            if(root==null){
                        return;
                  }
               boolean isLeaf=(root.left==null&&root.right==null);

              curSum+=root.getVal();
             //如果让前节点是叶子节点
              if(isLeaf){
                      if(curSum==target){
                              curResult.add(root.getVal());
                               result.add(new ArrayList<Integer>(curResult));
                               //路径中取出该叶子节点
                              curResult.remove(curResult.size()-1);
                          }
                       //返回上层节点,并从当前路径和中减去该叶子节点
                       curSum-=root.getVal();
                       return;
                   }
                curResult.add(root.getVal());
                FindPathCore(root.left,target,curResult,result,curSum);
                FindPathCore(root.right,target,curResult,result,curSum);
               curResult.remove(curResult.size()-1);

           }



   public static void printStack(List<Integer> path){
       for(int i=0;i<path.size();i++){
           System.out.print(path.get(i)+" ");
       }
       System.out.println();
   }
}
