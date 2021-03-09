package com.feijin.application.business.order;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Samuel
 * @description: 测试
 * @date: 2021-03-09 17:57:42
 */

public class MiniCodeTest {

    public static void main(String[] args) {

        MiniCodeTest test = new MiniCodeTest();
        int[] paramsArr = {2, 3};
        List<String> strings = test.builderResult(paramsArr);
        for (String string : strings) {
            System.out.print(string + " ");
        }

    }

    public List<String> builderResult(int[] paramsArr) {
        Map<Character, String> map = Maps.newHashMap();
        map.put('0', " ");
        map.put('1', " ");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = Lists.newArrayList();
        if (paramsArr.length == 0)
            return list;

        list.add("");
        Character[] characters = Convert.toCharArray(paramsArr);

        for (char c : characters) {
            List<String> temp = new ArrayList<>();
            String tagStr = map.get(c);
            for (String str : list) {
                for (Character tempStr : tagStr.toCharArray()) {
                    String appStr = str + tempStr;
                    temp.add(appStr);
                }
            }
            list = temp;
        }
        return list;
    }
}
