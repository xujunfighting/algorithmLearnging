package study.learning.array;

public class FindNextArray {
    public static void main(String[] args) {
       int[] res=new int[]{1,1,5};
       getResult(res);
        System.out.println("end");
    }
    public static void getResult(int[] res){
        if(res.length==1||res.length==0) return;
        int index=res.length-1;
        boolean isFined=false;
        while (index>=2){
            if(res[index]<=res[index-1]){
                index--;
            }else{
                isFined=true;
                break;
            }
        }
        if(isFined){
            int change= res.length-1;
            while(res[change]<=res[index-1]){
                change--;
            }
            int temp=res[index-1];
            res[index-1]=res[change];
            res[change]=temp;
            int start=index;
            int end=res.length-1;
            while (start <= end) {
                temp = res[start];
                res[start] = res[end];
                res[end] = temp;
                start++;
                end--;
            }
        }else{
            if(res[0]>=res[1]) {
                int start = 0;
                int end = res.length - 1;
                while (start <= end) {
                    int temp = res[start];
                    res[start] = res[end];
                    res[end] = temp;
                    start++;
                    end--;
                }
            }else{
                int start=0;
                int end=res.length-1;
                while(res[end]<=res[start]){
                    end--;
                }
                int temp=res[start];
                res[start]=res[end];
                res[end]=temp;
                start=1;
                end=res.length-1;
                while (start <= end) {
                    temp = res[start];
                    res[start] = res[end];
                    res[end] = temp;
                    start++;
                    end--;
                }
            }
        }
    }
}
