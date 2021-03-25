package com.niuke;

import com.sun.xml.internal.bind.v2.util.StackRecorder;
import com.zto.algorithm.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/2/24
 */
public class FindTwoNumInBST {
    //先把二叉查找树转成有序数组
    //利用两个指针遍历数查找需要满足的结果
      //         5
       //       / \
       //      3   6
       //     / \   \
        //   2   4   8
    public static void main(String[] args) {
        TreeNode n5=new TreeNode(5);
        TreeNode n3=new TreeNode(3);
        TreeNode n6=new TreeNode(6);
        TreeNode n2=new TreeNode(2);
        TreeNode n4=new TreeNode(4);
        TreeNode n7=new TreeNode(8);
        n5.left=n3;
        n5.right=n6;
        n3.left=n2;
        n3.right=n4;
        n6.right=n7;
        boolean result = getResult(n5, 6);
        System.out.println(result);
    }
     public static boolean getResult(TreeNode root,int target){
        boolean result=false;
        List<Integer> lists=new ArrayList<>();
        convertTreeToList(root,lists);
        int start=0;
        int end=lists.size()-1;
        while(start<end){
            if(lists.get(start)+lists.get(end)==target){
                result=true;
                return result;
            }else if(lists.get(start)+lists.get(end)>target){
                end--;
            }else{
                start++;
            }
        }
        return result;
     }
     public static void convertTreeToList(TreeNode root,List<Integer> lists){
        if(root==null){
            return;
        }
        convertTreeToList(root.left,lists);
        lists.add(root.val);
        convertTreeToList(root.right,lists);
     }
}
