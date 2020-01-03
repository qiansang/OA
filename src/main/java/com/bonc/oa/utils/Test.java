package com.bonc.oa.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test {
    public static boolean checkTime(){
        long time = System.currentTimeMillis();
        String path = System.getProperty("user.dir") + File.separator + "lic.txt";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
               CacheUtil.lic = lineTxt;
            }
            br.close();
            if(Long.parseLong(DesUtils.decode(CacheUtil.lic, "1,2,3,4,5")) > time){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /*public static void main(String[] args) {
        String encode = DesUtils.encode("1578585600000", "1,2,3,4,5");
        System.out.println(encode);
        System.out.println(DesUtils.decode("E0DE0E8905B1E686047226D0EB6F3A0C4FBE92C4209B36A1F26BD29820DD1837", "1,2,3,4,5"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String test = "2020-01-10 00:00:00";
        try {
            Date date = sdf.parse(test);
            System.out.println(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
