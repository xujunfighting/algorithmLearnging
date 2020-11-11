package study.learning.array;

import netscape.javascript.JSUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class ParenthesisMatching {
    private static class Node{
        public String res="";
        public int p;
        public int q;
        public int max;

        public Node(String res, int p, int q, int max) {
            this.res = res;
            this.p = p;
            this.q = q;
            this.max = max;
        }
    }
    private static String res="";
    private static List<String> results= new ArrayList<>();
    public static void main(String[] args) {
        //method(res,0,0,3);
        //method2(res,2,2);
        method5(3);
        System.out.println("end");
    }
    public static void method(String res,int p,int q,int max){
        if(res.length()==max*2){
            results.add(res);
            return;
        }
        if(p<max)
        method(res+"(",p+1,q,max);
        if(q<p)
        method(res+")",p,q+1,max);
    }
    public static void method2(String res,int p,int q){
        if(p==0&&q==0){
            results.add(res);
            return;
        }
        if(p>q){
            return;
        }
        if(p>0){
            method2(res+"(",p-1,q);
        }
        if(q>0){
            method2(res+")",p,q-1);
        }
    }
    public static void method3(int n){
        Queue<Node> queue= new LinkedBlockingQueue<>();
        Node node= new Node("",0,0,n);
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            if(curr.p==curr.max&&curr.q==curr.max){
                results.add(curr.res);
            }
            if(curr.p<curr.max){
                queue.offer(new Node(curr.res+"(",curr.p+1,curr.q,curr.max));
            }
            if(curr.q<curr.max&&curr.q<curr.p){
                queue.offer(new Node(curr.res+")",curr.p,curr.q+1,curr.max));
            }
        }
    }
    public static void method4(int n){
        Stack<Node> stack = new Stack<>();
        String res="";
        Node node=new Node(res,0,0,n);
        stack.add(node);
        while (!stack.isEmpty()){
            Node  curr = stack.pop();
            if(curr.p==curr.max&&curr.q==curr.max){
                results.add(curr.res);
            }
            if(curr.p<curr.max){
                stack.add(new Node(curr.res+"(",curr.p+1,curr.q,curr.max));
            }
            if(curr.q<curr.max&&curr.q<curr.p){
                stack.add(new Node(curr.res+")",curr.p,curr.q+1,curr.max));
            }
        }
    }
    public static void method5(int n){
        if(n==0) results.add("");
        List<List<String>> lists= new ArrayList<>();
        List<String> f= new ArrayList<>();
        String fstr=new String("");
        f.add(fstr);
        lists.add(f);
        for(int i=1;i<=n;i++){
            List<String> array = new ArrayList<>();
            for(int j=1;j<=i;j++){
                List<String> strs1=lists.get(j-1);
                List<String> strs2=lists.get(i-j);
                for(String str1:strs1){
                    for(String str2:strs2){
                        array.add("("+str1+")"+str2);
                    }
                }
            }
            lists.add(new ArrayList<>(array));
        }
        List<String> list=lists.get(lists.size()-1);
        for(String str:list){
            results.add(str);
        }
        System.out.println("end");
    }
}
