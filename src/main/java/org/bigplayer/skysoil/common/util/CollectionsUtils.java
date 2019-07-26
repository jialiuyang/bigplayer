package org.bigplayer.skysoil.common.util;


import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionsUtils {


    /**
     * 对list数组进行排序,返回字符串
     * 返回 ,1,2,3,3
     *
     * @param list
     * @return
     */
    public static String listToString(List<Integer> list) {
        StringBuffer key = new StringBuffer();
        if (list == null) {
            return "";
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        for (Integer integer : collect) {
            key = key.append(",");
            key = key.append(integer);
        }
        return key.toString();
    }

    /**
     * 获取String 数组中index下面元素
     */
     public static String getIndex(String str, int index){
         String[] split = StringUtils.split(str, ",");
         if (split.length>index){
             return split[index];
         }
         return null;
     }




}
