package com.liang3hua.study.effectiveJava.LambdaAndStream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghuarong
 * @date 2020-04-29  20:52
 */
public class LambdaDemo {
    public static void main(String[] args) {
        merge();
    }

    private static void merge(){
        Map<String,Integer> map = new HashMap<>();
        map.merge("a",1,(old,ne) -> old + ne);
        System.out.println(map);
    }
}
