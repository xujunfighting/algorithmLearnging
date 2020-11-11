package SqlTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by xujun on 2018-09-30.
 */
public class FileSql {
    public  static  void main(String[] args){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        c2.set(2019,11,20);
        while(c2.compareTo(c1)>0){
            String date=simpleDateFormat.format(c1.getTime());
            c1.add(Calendar.DATE,1);
            System.out.println("insert into zto_coc_dingding_auth_status(areaname,only_name,business_dingding,dingding_status,dingding_time,dingding_success,create_time)\n" +
                    "values('全国','xuqiang666','18221716637','1',0,'false',to_date('"+date+"','yyyymmdd'));");
        }
    }
}
