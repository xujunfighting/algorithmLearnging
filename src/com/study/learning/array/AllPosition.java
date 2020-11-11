package study.learning.array;


import java.util.*;

public class AllPosition {
    private static List<List<Character>> lists= new ArrayList<>();
    private static List<Character> list= new ArrayList<>();
    public static void main(String[] args) {
       String test="22";
       List<String> res=getResult(test);
        System.out.println("end");
    }
    public static List<String> getResult(String digits){
        Map<Character,String> maps = new HashMap<>();
        maps.put('2',"abc");
        maps.put('3',"def");
        maps.put('4',"ghi");
        maps.put('5',"jki");
        maps.put('6',"mno");
        maps.put('7',"pqrs");
        maps.put('8',"tuv");
        maps.put('9',"wxyz");
        char[] cs=digits.toCharArray();
        List<String> strings = new ArrayList<>();
        int index=0;
        if(digits.trim().equals("")) return strings;
        if(digits.length()==1) {
            char[] chars=maps.get(digits.toCharArray()[0]).toCharArray();
            for(int i=0;i<chars.length;i++){
                strings.add(chars[i]+"");
            }
            return strings;
        }
        lists.clear();
        list.clear();
        method(cs,maps,index);
        System.out.println("end");
        for(List<Character> characters:lists){
            StringBuffer stringBuffer= new StringBuffer();
            for(Character character:characters){
                stringBuffer.append(character);
            }
            strings.add(stringBuffer.toString());
        }
        return strings;
    }
    public static void method(char[] cs,Map<Character,String> maps,int index){
        if(index>=cs.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        String res=maps.get(cs[index]);
        char[] chars=res.toCharArray();
        for(int i=0;i<chars.length;i++){
            list.add(chars[i]);
            method(cs,maps,index+1);
            list.remove(list.size()-1);
        }
    }
}
