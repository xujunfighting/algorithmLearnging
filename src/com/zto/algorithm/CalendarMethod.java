package com.zto.algorithm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xujun on 2018-08-09.
 */
public class CalendarMethod {
    public static  void main(String[] args){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        Calendar calendar1=Calendar.getInstance();
        calendar1.set(2019,07,9);
        while(calendar.before(calendar1)){
           Date date=calendar.getTime();
           String result=dateFormat.format(date);
           System.out.println("insert into ztkb.zto_coc_dingding_auth_status(areaname,only_name,business_dingding,dingding_status,dingding_time,dingding_success)\n" +
                   "values('全国','jgyhuzhou','jgyhuzhou','1',0,'false',to_date('"+result+"','yyyymmdd'));");
           //System.out.println("insert into ztkb.zto_coc_dingding_auth_status(areaname,only_name,create_time) select areaname,only_name,to_date('"+result+"','yyyymmdd') from ztkb.zto_coc_wechart_auth_status");
           calendar.add(Calendar.DATE,1);
        }
    }
}
