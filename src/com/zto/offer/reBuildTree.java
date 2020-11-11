package com.zto.offer;

import com.zto.algorithm.TreeNode;
import com.zto.algorithm.TreeNodeVistTest;


/**
 * Created by xujun on 2018-11-26.
 */
public class reBuildTree {
   public  static void main(String[] args){
       int[] pre=new int[]{1,2,4,7,3,5,6,8};
       int[] mid=new int[]{4,7,2,1,5,3,8,6};
       TreeNode node=method1(pre,mid,0,7,0,7);
       TreeNodeVistTest.layerOrder(node);

   }
   public static TreeNode method1(int[] pre,int[] mid,int start1,int end1,int start2,int end2){
//       if(end1<=start1){
//           return new TreeNode(pre[start1]);
//       }
//       if(end2<=start2){
//           return new TreeNode(pre[start2]);
//       }
      int index=pre[start1];
      TreeNode node=new TreeNode(index);

     int i=start2;
     while (mid[i]!=index&&i<=end2){
         i++;
     }
       TreeNode left=null;
       if(start1<=i-1) {
           left= method1(pre, mid, start1 + 1, start1 - start2 + i, start2, i - 1);
      }
       TreeNode right=null;
     if(i+1<=end2) {
         right = method1(pre, mid, start1 - start2 + i + 1, end1, i + 1, end2);
   }
     node.left=left;
     node.right=right;
     return node;
   }
}
