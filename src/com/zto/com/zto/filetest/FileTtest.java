package com.zto.com.zto.filetest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * Created by xujun on 2018-08-14.
 */
public class FileTtest {
    public static void main(String args[]) throws  Exception{
        FileReader reader=new FileReader("F://ids.txt");
        BufferedReader bufferedReader=new BufferedReader(reader);
        String result=null;
        while((result=bufferedReader.readLine())!=null){

            String[] res=result.split(" ");
            String onlyname=res[0];
            String bindingId=res[res.length-1];
            //update ztkb.zto_coc_dingding_auth_status set business_dingding='format' where only_name='format'

            //update ztkb.zto_area_auth_org  set business_dingding='format' where moblie_phone='format'
            //update ztkb.zto_cockpit_wechart_auth  set business_dingding='format' where only_name='format'
            System.out.println("update ztkb.zto_coc_dingding_auth_status set business_dingding='"+bindingId+"' where only_name='"+onlyname+"';");
            System.out.println("update ztkb.zto_area_auth_org  set business_dingding='"+bindingId+"' where moblie_phone='"+onlyname+"';");
            System.out.println("update ztkb.zto_cockpit_wechart_auth  set business_dingding='"+bindingId+"' where only_name='"+onlyname+"';");
            System.out.println();
        }
    }
}
