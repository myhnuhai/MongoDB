package org.myhnuhai.util;

/**
 * Created by Administrator on 14-1-16.
 */
public class StringUtil {

    public static boolean isNull(String s){
        return s==null||s.equals("");
    }

    public static boolean isNotNull(String s){
        return s!=null&&!s.equals("");
    }
}
