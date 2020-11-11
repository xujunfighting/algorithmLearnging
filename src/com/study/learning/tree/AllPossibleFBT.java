package study.learning.tree;

import java.util.*;

import com.zto.algorithm.TreeNode;

import javax.jnlp.ClipboardService;

public class AllPossibleFBT {
    private static List<TreeNode> lists= new ArrayList<>();
    private  static Map<Integer, List<TreeNode>> memo = new HashMap();
    public static void main(String[] args) {
             lists=allPossibleFBT(5);
        System.out.println("end");
    }
    public static TreeNode getAllPossible(int n){
        if(n==0){
            return null;
        }else if(n==1){
            TreeNode node = new TreeNode(0);
            node.right=null;
            node.left=null;
            return node;
        }
        TreeNode node=new TreeNode(0);
        node.left=getAllPossible(n-2);
        node.right=getAllPossible(n-2);
        return node;
    }
    public static List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }
        return memo.get(N);
    }
}
