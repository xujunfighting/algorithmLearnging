package study.learning.array;

public class ZTypeNumber {
    public static void main(String[] args) {
        String result="AB";
        getResult(result,1);
    }
    public static String getResult(String s,int numRows){
        if(s.length()==1) return s;
        char[] chars=s.toCharArray();
         int sum=numRows+numRows-2;
         int num=chars.length/sum;
         int rest=chars.length%sum;
         int y=(numRows-1)*num+rest;
         char[][] temp= new char[numRows][y];
         for(int i=1;i<=chars.length;i++){
             int next=(i-1)/sum;
             int res=(i-1)%sum;
             if(res<numRows){
                 temp[res][next*(numRows-1)]=chars[i-1];
             }else{
                 temp[2*numRows-res-2][(numRows-1)*next+1+(res-numRows)]=chars[i-1];
             }
         }
         StringBuffer sb=new StringBuffer();
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                if(temp[i][j]!=0){
                    sb.append(temp[i][j]);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
