package com.middle;

public class MiddleOrderTreeNextValue {
    private static int count=0;
    private static TreeLinkNode result=null;
    private static TreeLinkNode cur= new TreeLinkNode(2);
    public static void  main(String[] args) {
        TreeLinkNode treeLinkNode1 = new TreeLinkNode(1);
        TreeLinkNode treeLinkNode2 = new TreeLinkNode(2);
        TreeLinkNode treeLinkNode3 = new TreeLinkNode(3);
        TreeLinkNode treeLinkNode4 = new TreeLinkNode(4);
        TreeLinkNode treeLinkNode5 = new TreeLinkNode(5);
        TreeLinkNode treeLinkNode6 = new TreeLinkNode(6);

        treeLinkNode2.right=treeLinkNode3;
        treeLinkNode2.left=null;
        treeLinkNode2.next=null;
        treeLinkNode3.next=treeLinkNode2;
        treeLinkNode3.left=null;
        treeLinkNode3.right=treeLinkNode4;
        treeLinkNode4.next=treeLinkNode3;
        treeLinkNode4.left=null;
        treeLinkNode4.right=treeLinkNode5;
        treeLinkNode5.left=null;
        treeLinkNode5.right=null;
        treeLinkNode5.next=treeLinkNode4;
        result=getNext(treeLinkNode5);
        System.out.println("获取到结果");
    }
    public static TreeLinkNode getNext(TreeLinkNode treeLinkNode){

            if(treeLinkNode==null){
                return null;
            }
            if(treeLinkNode.right!=null){//右子树不为空
                TreeLinkNode cur=treeLinkNode.right;
                if(cur.left!=null){
                    while(cur.left!=null){
                        cur=cur.left;
                    }
                    return cur;
                }
                return cur;
            }else if(treeLinkNode.right==null){

                TreeLinkNode parent=treeLinkNode.next;
                if(parent!=null){
                    if(parent.left!=null&&parent.left.val==treeLinkNode.val){//该节点为数的左子树
                        return parent;
                    }else if(parent.right.val==treeLinkNode.val){//为节点的右子树
                        if(parent.next!=null){
                            TreeLinkNode par=parent;
                            parent=parent.next;
                            while(parent.next!=null){
                                par=parent;
                                parent=parent.next;
                            }
                            if(parent.left==par){
                                return parent;
                            }
                        }
                    }
                }

            }

            return null;
    }



    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
