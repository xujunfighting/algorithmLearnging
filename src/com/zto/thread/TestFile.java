package com.zto.thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujun on 2018-07-31.
 */
public class TestFile {
    public static void main(String[] args){
        try {
            FileReader reader=new FileReader("F:\\1234.txt");
            FileWriter writer=new FileWriter("F:\\newtest.txt");
            BufferedReader bufferedReader=new BufferedReader(reader);
            List<String> strs=new ArrayList<String>();
            String res=null;
            while((res=bufferedReader.readLine())!=null){
                if(!strs.contains(res)){
                    strs.add(res);
                }else{
                    strs.remove(res);
                }
            }
            for(String r:strs){
                writer.write(r);
                writer.write("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
