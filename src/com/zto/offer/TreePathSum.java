package com.zto.offer;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujun on 2018-12-06.
 */
public class TreePathSum {
    private static List<List<Integer>> lists=new ArrayList<>();
    private static List<Integer> list=new ArrayList<Integer>();
    private static Integer sum=5;
    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(5);
        TreeNode n4=new TreeNode(2);
        TreeNode n5=new TreeNode(3);
        TreeNode n6=new TreeNode(1);
        TreeNode n7=new TreeNode(6);
        n1.left=n2;
        n1.right=n5;
        n2.left=n3;
        n2.right=n4;
        n5.left=n6;
        n5.right=n7;
        path(n1,lists,list,sum);
        for(List<Integer> list:lists){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void path(TreeNode node,List<List<Integer>> lists,List<Integer> list,Integer sum){
        if(node.left==null&&node.right==null){
            list.add(node.getVal());
            boolean result=judgePath(list,sum);
            if(result==true){
                List<Integer> integerList=new ArrayList<>(list);
                lists.add(integerList);
            }
            list.remove(list.size()-1);
            return;
        }
        list.add(node.getVal());
        path(node.left,lists,list,sum);
        path(node.right,lists,list,sum);
        list.remove(list.size()-1);
    }
    public static boolean judgePath(List<Integer> list,Integer sum){
        int all=0;
        for(Integer i:list){
            all+=i;
        }
        if(all==sum){
            return true;
        }else{
            return false;
        }
    }
}
