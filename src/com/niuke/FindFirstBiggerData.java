package com.niuke;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/3/3
 */
public class FindFirstBiggerData {
    public static void main(String[] args) {
        int[] arrays=new int[]{4,3,4,2,1,5,6,7,3,8};
        getResult(arrays);
    }
    public static int[] getResult(int[] arrays){
        int[] result=new int[arrays.length];
        for(int i=0;i<result.length;i++){
            result[i]=-1;
        }
        Queue<Integer> queue=new ArrayBlockingQueue<>(result.length);
        int index=1;
        int i=0;
        while(i<arrays.length-1){
            System.out.println(i);
            if(queue.isEmpty()) {
                while (index < arrays.length && arrays[i] >= arrays[index]) {
                    if(arrays[i]>arrays[index]) {
                        queue.add(arrays[index]);
                    }
                    index++;
                }
                result[i]=arrays[index];
                i++;
            }else{

                while(!queue.isEmpty()&&queue.peek()<=arrays[i]){
                    queue.poll();
                }
                if(!queue.isEmpty()) {
                    result[i] = queue.poll();
                    i++;
                }
            }
        }
        return result;
    }
}
