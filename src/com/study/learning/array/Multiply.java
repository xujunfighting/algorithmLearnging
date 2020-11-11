package study.learning.array;

public class Multiply {
    public static void main(String[] args) {
        String res=multiply("6","3");
        System.out.println(res);
    }
    public static String multiply(String num1, String num2) {
        String res="0";
        if(num1.trim().equals("0")||num2.trim().equals("0"))
        {
            return res;
        }
        char[] chars=num2.toCharArray();
        String index="0";
        boolean isStarted=true;

        for(int i=chars.length-1;i>=0;i--){
            if(isStarted) {
                res = addMethod(res, multiplyMethod(num1, chars[i] + ""));
                isStarted=false;
            }else{
                res = addMethod(res, multiplyMethod(num1, chars[i] + "")+index);
                index=index+"0";
            }
        }
        return res;
    }
    public  static String multiplyMethod(String m1,String m2){
        String res="";
        char[] chars= m1.toCharArray();
        int d=Integer.valueOf(m2);
        int p=0;
        int q=0;
        for(int i=chars.length-1;i>=0;i--){
            int data=Integer.valueOf(chars[i]+"")*d;
            String cur="";
            q=0;
            if((data%10+p)<10){
                cur=(data%10+p)+"";
            }else{
                cur=(data%10+p)%10+"";
                q=(data%10+p)/10;
            }
            res=cur+res;
            p=data/10+q;
        }
        if(p!=0){
            res=p+res;
        }
        return res;
    }
    public static String addMethod(String m1,String m2){
        String res="";
        char[] chars1=m1.toCharArray();
        char[] chars2=m2.toCharArray();
        int p=chars1.length-1;
        int q=chars2.length-1;
        int assist=0;
        int ass=0;
        while(p>=0&&q>=0){
            int data=Integer.valueOf(chars1[p]+"")+Integer.valueOf(chars2[q]+"");
            String cur="";
            if((data%10+assist)<10){
                cur=(data%10+assist)+"";
                ass=0;
            }else{
                cur=(data%10+assist)%10+"";
                ass=(data%10+assist)/10;
            }
            res=cur+res;
            assist=data/10+ass;
            p--;
            q--;
        }
        //进位数不为零
        while (p>=0){
            int cur=Integer.valueOf(chars1[p]+"");
            if(cur+assist<10){
                res=(cur+assist)+res;
                assist=0;
            }else{
                res=(cur+assist)%10+res;
                assist=(cur+assist)/10;
            }
            p--;
        }
        while(q>=0){
            int cur=Integer.valueOf(chars2[q]+"");
            if(cur+assist<10){
                res=(cur+assist)+res;
                assist=0;
            }else{
                res=(cur+assist)%10+res;
                assist=(cur+assist)/10;
            }
            q--;
        }
        if(assist!=0){
            res=assist+res;
        }
        return res;
    }
}
