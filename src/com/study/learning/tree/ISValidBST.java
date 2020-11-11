package study.learning.tree;
import com.zto.algorithm.TreeNode;

public class ISValidBST {
    private class Result{
        public Result(boolean isVliad, Integer max, Integer min) {
            this.isVliad = isVliad;
            this.max = max;
            this.min = min;
        }

        public boolean isVliad;
        public Integer max;
        public Integer min;
    }
    public static void main(String[] args) {
        ISValidBST isValidBST= new ISValidBST();
        TreeNode node3= new TreeNode(3);
        TreeNode node1= new TreeNode(1);
        TreeNode node5= new TreeNode(5);
        TreeNode node0= new TreeNode(0);
        TreeNode node2= new TreeNode(2);
        TreeNode node4= new TreeNode(4);
        TreeNode node6= new TreeNode(6);
        TreeNode node33=new TreeNode(3);
      node3.left=node1;
      node3.right=node5;
      node1.left=node0;
      node1.right=node2;
      node0.left=null;
      node0.right=null;
      node5.left=node4;
      node5.right=node6;
      node2.left=null;
        node2.right=node33;
        Result res=isValidBST.isValid(node3);
        System.out.println(res.isVliad);
    }
    public  Result isValid(TreeNode node){
        if(node==null){
            Result result= new Result(true,null,null);
            return result;
        }
        if(node!=null&&node.left==null&&node.right==null){
            Result result= new Result(true,node.getVal(),node.getVal());
            return result;
        }
        Result left=isValid(node.left);
        Result right=isValid(node.right);
        if(left.isVliad&&right.isVliad){
            if(left.max!=null&&left.min!=null
                    &&node.getVal()>left.max&&node.getVal()>left.min
                &&
               right.min!=null&&right.max!=null
                    &&node.getVal()<right.max&&node.getVal()<right.min
            ){
                return new Result(true,Math.max(right.max,left.max),Math.min(left.min,right.min));
            }else if(left.max==null&&left.min==null
                    &&
                    right.min!=null&&right.max!=null
                    &&node.getVal()<right.max&&node.getVal()<right.min){
                return new Result(true,Math.max(right.min,right.max),node.getVal());
            }else if(left.max!=null&&left.min!=null
                    &&node.getVal()>left.max&&node.getVal()>left.min
                    &&
                    right.min==null&&right.max==null){
                return new Result(true,node.getVal(),Math.min(left.max,left.min));
            }else{
                 return new Result(false,null,null);
            }
        }else{
             return new Result(false,null,null);
        }
    }
}
