package study.learning.array;

public class MaxArea {
    public static void main(String[] args) {
        int[] arr=new int[]{1,8,6,2,5,4,8,3,7};
        int res=getResult(arr);
        System.out.println(res);
    }
    public static int getResult(int[] array){
        int curr=0;
        int max=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(i!=j){
                    curr=Math.abs(i-j)*Math.min(array[i],array[j]);
                    if(max<curr){
                        max=curr;
                    }
                }
            }
        }
        return max;
    }
}
