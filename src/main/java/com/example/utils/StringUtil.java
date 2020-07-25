package com.example.utils;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2020年07月25日 22:50
 * @ModificationHistory:
 */
import org.apache.commons.lang3.StringUtils;
public class StringUtil extends StringUtils {
    public StringUtil() {
    }


    public static boolean hasBlank(CharSequence... items) {
        CharSequence[] arr$ = items;
        int len$ = items.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            CharSequence cs = arr$[i$];
            if(isBlank(cs)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notHasBlank(CharSequence... items) {
        return !hasBlank(items);
    }

    public static Integer parseInt(String str) {
        if(isBlank(str)) {
            return null;
        } else {
            str = str.trim();
            return str.matches("\\d+")?Integer.valueOf(str):null;
        }
    }

    public static Long parseLong(String str) {
        if(isBlank(str)) {
            return null;
        } else {
            str = str.trim();
            return str.matches("\\d+")?Long.valueOf(str):null;
        }
    }

    public static String toString(Object o) {
        return o == null?null:o.toString();
    }
}
