package study.learning.count;

public class newDivision {
    public static void main(String[] args) {
       int result=method2(-2147483648,
               -1);
        System.out.println(result);
    }
    public static int method(long p,long q){
        int res=0;
        int pre=0;
        int next=1;
        boolean flag=true;
        boolean isCount=false;
        if(p>0&&q>0||p<0&&q<0){
          flag=true;
        }else{
            flag=false;
        }
        p=Math.abs(p);
        q=Math.abs(q);
        while(p>q){
            isCount=true;
            q=q<<1;
            pre=next;
            next=next<<1;
        }
        if(p==q){
            res=next;
        }
        //pre-next
        if(q>p&&isCount==true){

        }
        if(!flag){
            res=-res;
        }
        return res;
    }
    public static int method2(long p,long q){
        int pre=0;
        int res=0;
        int next=0;
        boolean flag=true;
        boolean isCount=false;
        if(p>0&&q>0||p<0&&q<0){
            flag=true;
        }else{
            flag=false;
        }
        p=p<0?-p:p;
        q=q<0?-q:q;
        int index=0;
        while(index<p){
            isCount=true;
            index+=q;
            pre=next;
            next++;
        }
        if(index==q){
            res=next;
        }
        if(index>p&&isCount==true){
            res=(pre+next)>>1;
        }
        if(!flag){
            res=-res;
        }
        return res;

    }
}
