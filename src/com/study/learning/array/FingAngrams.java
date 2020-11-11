package study.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FingAngrams {
    private static List<Integer> lists= new ArrayList<>();
    public static void main(String[] args) {
        findAnagrams("baba","ab");
        System.out.println("end");
    }
    public static List<Integer> findAnagrams(String s, String p) {
          char[] charP=p.toCharArray();
          char[] charS=s.toCharArray();
          if(charP.length==charS.length){
              Arrays.sort(charP);
              Arrays.sort(charS);
              boolean isSame=true;
              for(int i=0;i<charP.length;i++){
                  if(charP[i]!=charS[i]){
                      isSame=false;
                      break;
                  }
              }
              if(isSame){
                  lists.add(0);
              }
              return lists;
          }else if(charP.length>charS.length){
              return  lists;
          }else{
              for(int i=0;i<=charS.length-charP.length;i++){
                  String sub=s.substring(i,p.length()+i);
                  char[] charSub=sub.toCharArray();
                  Arrays.sort(charSub);
                  Arrays.sort(charP);
                  boolean isSame=true;
                  for(int k=0;k<charSub.length;k++){
                      if(charP[k]!=charSub[k]){
                          isSame=false;
                          break;
                      }
                  }
                  if(isSame){
                      lists.add(i);
                  }
               }
          }
         return  lists;
    }
}
