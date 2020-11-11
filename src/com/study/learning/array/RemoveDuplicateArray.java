package study.learning.array;

public class RemoveDuplicateArray {
    public static void main(String[] args) {
        String res="yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        String result=removeDuplicates1(res,4);
        System.out.println(result);
    }
    public static String removeDuplicates(String s, int k) {
        char[] chars=s.toCharArray();
        char[] result=new char[s.length()];
        int i=0;
        int index=0;
        while(index<chars.length){
            int count=1;
            boolean isRemoved=false;
            int start=index;
            if(index+1<chars.length&&chars[index]==chars[index+1]){
                while(index+1<chars.length&&chars[index]==chars[index+1]){
                    count++;
                    index++;
                }
                if(count==k){
                    isRemoved=true;
                }
            }
            if(isRemoved){
                if(index+1<chars.length&&index+2<chars.length&&chars[index+1]!=chars[index+2]) {
                    result[i++] = chars[index + 1];
                    index+=2;
                }else{
                    index++;
                }
            }else{
                index=start;
                result[i++]=chars[index];
                index++;
            }
        }
        String res=appendChars(result,i-1);
        if(i==chars.length){
            return res;
        }else{
            res=removeDuplicates(res,k);
        }
        return res;
    }
    public static String appendChars(char[] chars,int end){
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<=end;i++){
            sb.append(chars[i]+"");
        }
        return sb.toString();
    }
    public static String removeDuplicates1(String s,int k){
        char[] chars=s.toCharArray();
        String res="";
        int charsLen=chars.length;//主数组的长度
        char[] result=new char[s.length()];
        int i=0;//副数组的长度
        int index=0;
        boolean isFinished=false;
        while(!isFinished) {
            while (index < charsLen) {
                int count = 1;
                boolean isRemoved = false;
                int start = index;
                if (index + 1 < chars.length && chars[index] == chars[index + 1]) {
                    while (index + 1 < chars.length && chars[index] == chars[index + 1]) {
                        count++;
                        index++;
                    }
                    if (count == k) {
                        isRemoved = true;
                    }
                }
                if (isRemoved) {
                    if (index + 1 < chars.length && index + 2 < chars.length && chars[index + 1] != chars[index + 2]) {
                        result[i++] = chars[index + 1];
                        index += 2;
                    } else {
                        index++;
                    }
                } else {
                    index = start;
                    result[i++] = chars[index];
                    index++;
                }

            }
            if (i == charsLen) {
                res = appendChars(result, i - 1);
                isFinished=true;
            } else {
                chars = result;
                charsLen = i;
                result = new char[i];
                i = 0;
                index = 0;
            }
        }
        return res;
    }

}
