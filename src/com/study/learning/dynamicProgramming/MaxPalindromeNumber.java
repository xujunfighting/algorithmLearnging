package study.learning.dynamicProgramming;

public class MaxPalindromeNumber {
    public static void main(String[] args) {
        String res="aba";
        String result = getResult3(res);
        System.out.println(result);
    }
    public static String getResult(String s){
        int res=0;
        int p=0;
        int q=0;
        char[] nums=s.toCharArray();
        if(nums.length==0) return s;
        if(nums.length==1) return s;
        int[][] chars=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            chars[i][i]=1;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(0<=j-1&&nums[i]==nums[j]&&nums[j-1]==nums[i]){
                    chars[i][j]=chars[i][j-1]+1;
                    if(res<chars[i][j]){
                        res=chars[i][j];
                        p=i;
                        q=j;
                    }
                } else if((0<=i-1&&j+1<nums.length&&nums[i-1]==nums[j+1]&&(i-1!=j+1)||0<=j-1&&i+1<nums.length&&nums[j-1]==nums[i+1]&&(j-1!=i+1))&&chars[i][j]>0){
                    if(i-1>=0&&j+1<nums.length) {
                        chars[i - 1][j + 1] = chars[i][j] + 2;
                        chars[j + 1][i - 1] = chars[i][j] + 2;
                        if(chars[i][j]+1>res){
                            res=chars[i][j]+2;
                            if(i>j){
                                p=j-1;
                                q=i+1;
                            }else if(i==j){
                                p=j-1;
                                q=j+1;
                            }else{
                                p=i-1;
                                q=j+1;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(p,q+1);
    }

    public static int getResult1(char[] s){
        int len = s.length;
        int[][] dp = new int[len+1][len+1];
        //dp数组初始化
        for(int i=0; i<len; i++) {
            dp[i][i] = 1;
        }
        //dp中相邻元素
        for(int i=0; i<len-1; i++) {
            if(s[i] == s[i+1]) {
                dp[i][i+1] = 2;
            }else {
                dp[i][i+1] = 1;
            }
        }
        /**dp中至少相隔一个元素*/
        /**k代表相隔的区间长度*/
        for(int k=2; k<len; k++) {
            //i代表区间起始位置
            for(int i=0; i+k<len; i++) {
                //j代表区间末尾位置
                int j = i+k;
                if(s[i] == s[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] =Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
    public static String getResult2(String s){
        int curstart=0;
        int curend=0;
        int current=0;
        int max=0;
        int maxstart=0;
	  int len=s.length();
	 int i=0;
	for(i=0;i<len;i++){
	curstart=i;
	 curend=i;
	while(curstart>=00&&curend<len){
	if(s.charAt(curstart)==s.charAt(curend)){
	curstart--;
	curend++;
	} else break;
	}
	current=curend-curstart-1;//当前长度 
	if(current>max){//替换最长回文串
	max=current;
	maxstart=curstart+1;
	}
	curstart=i;//假设回文串长度是偶数数
	 curend=i+1;//从第i，i+1个位置开始向两面依次便利
	while(curstart>=00&&curend<len){
	if(s.charAt(curstart)==s.charAt(curend)){
	curstart--;
	curend++;
	}
	else
	break;
	}
	current=curend-curstart-1;
	if(current>max){
	max=current;
	maxstart=curstart+1;
	}
	}
	String result=s.substring(maxstart,maxstart+max);
	return result;
    }
    public static String getResult3(String s){
        if(s.length()==0||s.length()==1) return s;
        char[]  chars=s.toCharArray();
        int max=0;
        int start=0;
        int end=0;
        int[][] temp=new int[s.length()][s.length()];
        for(int len=1;len<=chars.length;len++){
            for(int i=0;i+len<=chars.length;i++){
                int j=i+len-1;
                if(len==1){
                    temp[i][j]=1;
                }else if(len==2){
                    if(chars[i]==chars[j]){
                        temp[i][j]=2;
                    }
                }else if(chars[i]==chars[j]&&temp[i+1][j-1]>0){
                    temp[i][j]=temp[i+1][j-1]+2;
                }
                if(temp[i][j]>max){
                  max=temp[i][j];
                  start=i;
                  end=j;
                }
            }
        }
        System.out.println(max);
        return s.substring(start,end+1);
    }
}
