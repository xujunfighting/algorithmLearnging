package com.zto.test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by xujun on 2018-12-11.
 */
public class DayTest {
    public static void main(String[] args){
        Date day=new Date();
        Calendar today = Calendar.getInstance();
        today.setTime(day);
        today.add(Calendar.DAY_OF_YEAR, 1);
        today.add(Calendar.SECOND, -1);
         System.out.print(today.getTime());
    }
}
