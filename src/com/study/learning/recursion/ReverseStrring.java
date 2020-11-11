package study.learning.recursion;

public class ReverseStrring {

        private static int i=0;
        public static void reverseString(char[] s) {
            if(s.length==i) return;
            char val=s[i++];
            reverseString(s);
            i--;
            s[s.length-1-i]=val;
        }

    public static void main(String[] args) {
        String str="abc";
        reverseString(str.toCharArray());
        System.out.println(str);
    }

}
