package study.learning.tree;
import com.zto.algorithm.TreeNode;

public class BuildTree1 {
    public static void main(String[] args) {
        int [] preorder =new int[] {1,2};
        int[] inorder = new int[]{2,1};
        TreeNode node=buildTree(preorder,inorder);
        System.out.println("end");

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        if(preorder.length==1&&inorder.length==1){
            return new TreeNode(preorder[0]);
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode buildTree(int[] preOrder,int start1,int end1,int[] inOrder,int start2,int end2){
        if(start1==end1){
            return new TreeNode(preOrder[end1]);
        }
        if(start1>end1){
            return null;
        }
        if(start2==end2){
            return new TreeNode(inOrder[end2]);
        }
        if(start2>end2){
            return null;
        }
        TreeNode root= new TreeNode(preOrder[start1]);
        int i=start2;
        for(i=start2;i<inOrder.length;i++){
            if(inOrder[i]==preOrder[start1]){
                break;
            }
        }
        root.left=buildTree(preOrder,start1+1,start1+(i-start2),inOrder,start2,i-1);
        root.right=buildTree(preOrder,start1+(i-start2)+1,end1,inOrder,i+1,end2);
        return root;
    }
}
