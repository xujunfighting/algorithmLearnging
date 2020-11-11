package study.learning.array;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombationSum {
    private static List<List<Integer>> lists= new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] sums= new int[]{10,1,2,7,6,1,5};
        Arrays.sort(sums);

        List<List<Integer>> res=combinationSum(sums,8);
        System.out.println("end");
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        getResult2(candidates,target,0);
        return lists;
    }
    public static void getResult(int[] sums,int target,int start){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<sums.length;i++){
            list.add(sums[i]);
            target-=sums[i];
            getResult(sums,target,i);
            list.remove(list.size()-1);
            target+=sums[i];
        }
    }
    public static void getResult2(int[] sums,int target,int start){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        int removeData=-1;
        for(int i=start;i<sums.length;i++){
            if(sums[i]==removeData){
                continue;
            }
            list.add(sums[i]);
            target-=sums[i];
            getResult2(sums,target,i+1);
            list.remove(list.size()-1);
            removeData=sums[i];
            target+=sums[i];
        }
    }
}
