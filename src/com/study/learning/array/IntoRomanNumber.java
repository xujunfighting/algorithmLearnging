package study.learning.array;

import com.sun.deploy.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

public class IntoRomanNumber {
    private static boolean singleData=false;
    public static void main(String[] args) {
       int res=58;
        System.out.println(intoRomanNumber(res));
    }
    public static String dataJudge(int number){
        String res="";
        if(number==4){
            res="IV";
            return res;
        }else if(number==9){
            res="IX";
            return res;
        }else if(number==40){
            res="XL";
            return res;
        }else if(number==90){
            res="XC";
            return res;
        }else if(number==400){
            res="CD";
            return res;
        }else if(number==900){
            res="CM";
            return res;
        }
        return res;
    }
    public static String intoRomanNumber(int num){
        String res=null;
        int[] nums= new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] chars=new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] indexNum= new int[nums.length];
        int index=nums.length-1;
        while(index>=0&&num!=0){
            indexNum[index]=num/nums[index];
            if(indexNum[index]!=0){
                num=num%nums[index];
            }
            index--;
        }
        StringBuffer stringBuffer=new StringBuffer();
        for(int i = nums.length-1;i>=0;i--){
            if(indexNum[i]!=0){
                    for (int k = 0; k < indexNum[i]; k++) {
                        stringBuffer.append("" + chars[i]);
                    }
                }
            }
        return stringBuffer.toString();
    }
}
