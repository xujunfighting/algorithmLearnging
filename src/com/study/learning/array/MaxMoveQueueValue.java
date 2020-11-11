package study.learning.array;

import java.util.LinkedList;

public class MaxMoveQueueValue {
    private static LinkedList<Integer> linkedList = new LinkedList<>();
    public static void main(String[] args) {
      //如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
        // 那么一共存在6个滑动窗口，
        // 他们的最大值分别为{4,4,6,6,6,5}；
        int[] nums = new int[]{2,3,4,2,6,2,5,1,1};
        int[] res= new int[nums.length-2];
        getResult(nums,res,3);
    }
    public static int[] getResult(int[] nums,int result[],int size){
        int i=0;
        while(i<nums.length){
            if(i<size){
                if(linkedList.size()==0) {
                    linkedList.add(i);
                }else{
                    int res=linkedList.peekFirst();
                    while(!linkedList.isEmpty()&&nums[res]<nums[i]){
                        linkedList.pollFirst();
                    }
                    linkedList.addFirst(i);
                }
            }else {
                if (nums[i] < nums[linkedList.peekFirst()]) {
                    if (i-linkedList.peekFirst() >2) {//数组长度大于2
                       linkedList.pollFirst();//直接取出第一个数值
                    }
                    while(!linkedList.isEmpty()&&nums[linkedList.peekLast()]<nums[i]){
                        linkedList.pollLast();
                    }
                    linkedList.addLast(i);
                } else {//大于最大值 清空数据 填充当前值
                    while(!linkedList.isEmpty()){
                        linkedList.poll();
                    }
                    linkedList.addFirst(i);
                }

            }
            if(i>=2){
                result[i-2]=nums[linkedList.peekFirst()];
            }
            i++;
        }
        return result;
    }
}
