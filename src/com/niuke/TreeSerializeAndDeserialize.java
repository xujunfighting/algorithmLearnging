package com.niuke;

import com.zto.algorithm.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/6/25
 **/
public class TreeSerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(-1);
        TreeNode node2=new TreeNode(0);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
//        node3.left=node4;
//        node3.right=node5;
        String serialize = serialize(node1);
        System.out.println(serialize);
       TreeNode root=deserialize(serialize);
        System.out.println(root);
    }
    private static String serialize(TreeNode root){
        if(root==null){
            return "[null]";
        }
        String result=null;
        List<Integer> lists=new ArrayList<>();
        int cur=1;
        int index=0;
        int next=0;
        Queue<TreeNode> queue=new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            /**
             * Queue不允许存储空节点 使用-100标识空节点
             */
            if(node.val!=-100) {
                lists.add(node.val);
                index++;
                if(node.left!=null) {
                    next++;
                    queue.add(node.left);
                }else{
                    queue.add(new TreeNode(-100));
                }
                if(node.right!=null) {
                    next++;
                    queue.add(node.right);
                }else{
                    queue.add(new TreeNode(-100));
                }
            }else if(node.val==-100&&cur!=0){
                /**
                 * 节点为空 但是当前层级还有后续节点不是空节点
                 */
                lists.add(null);
            }else{
                /**
                 * cur=0 标识当前层级节点数为空 直接退出循环
                 */
                break;
            }
            if(index==cur){
                cur=next;
                index=0;
                next=0;
            }

        }
        result=lists.toString();
        return result;
    }
    private static TreeNode deserialize(String result){
        if(result.trim().equals("[null]")){
            return null;
        }
        TreeNode root=null;
        String res=result.substring(1,result.length()-1);
        if(!res.contains(",")){
            root=new TreeNode(Integer.parseInt(res));
            return root;
        }
        List<String> stringList = Arrays.asList(res.split(","));
        int cur=1;
        int next=2;
        int index=0;
        int count=0;
        Queue<TreeNode> queue=new LinkedBlockingQueue<>();
        queue.add(new TreeNode(Integer.parseInt(stringList.get(count).trim())));
        count++;
        while(count<stringList.size()){
           TreeNode node=queue.poll();
           if(count==1){
               root=node;
           }
           index++;
           if(node.val!=-100){
               if(stringList.get(count).trim().equals("null")) {
                    node.left=null;
               }else{
                   node.left=new TreeNode(Integer.parseInt(stringList.get(count).trim()));
                   queue.add(node.left);
               }
               //记录左子树

               count++;
               if(count<stringList.size()) {
                   if (stringList.get(count).trim().equals("null")) {
                       node.right = null;
                   } else {
                       node.right = new TreeNode(Integer.parseInt(stringList.get(count).trim()));
                       queue.add(node.right);
                   }
                   //记录右子树

                   count++;
               }
           }

           if(index==cur){
               cur=next;
               index=0;
               next=next*2;
           }

        }
        return root;
    }
}
