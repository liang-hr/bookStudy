package com.liang3hua.study.otherdemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lianghuarong
 * @date 2020-05-06  10:27
 */
public class RegexDemo {

    public static void main(String[] args) {

//        testMatch6();
//        testMatch();
//        testMatch2();

//        System.out.println("4401000300000".replaceAll("(00)*$", ""));

        List<String> vals = Arrays.asList("00","1","1003","50.2","180.263","200.","2",".");
        String  reg = "^(1|2)$";
        listMatch(vals,reg);
//        List<String> vals = Arrays.asList("00","3","1003","50.2","180.263","200.");
//        String  reg = "(^[0-9]{1,3}$)|(^[0-9]{1,3}[.]{1}[0-9]{1,2}$)";
//        listMatch(vals,reg);
    }

    private static void testMatch5(){
        List<String> vals = Arrays.asList("2020-05-06","2020-05-06 15:31:25");
        String DATE_FORMAT = "yyyy-MM-dd";
        for (String val : vals) {
            try {
                LocalDate.parse(val, DateTimeFormatter.ofPattern(DATE_FORMAT));
                System.out.println(val + ",符合日期格式yyyy-MM-dd");
            } catch (Exception e) {
                System.out.println(val + ",不符合日期格式yyyy-MM-dd");
            }
        }
    }

    private static void testMatch(){
        String val = null;
        String val2 = "";
        String  reg = "^(\\S|\\s){1,20}$\n";
        Pattern pn = Pattern.compile(reg);
        Matcher mr = pn.matcher(val2);
        if(mr.find()){
            System.out.println("match");
        }else{
            System.out.println("non match");
        }
    }

    private static void testMatch2(){
        // 10-180之间,如不限，则填写0；单位km/h
        List<String> vals = Arrays.asList("0","5","10","50","180","200");
        String  reg = "^([1-9][0-9]|1[0-9][0-9]|0)$";
        listMatch(vals,reg);
    }

    private static void testMatch3(){
        // 参照GB/T 28181 20位国标编码规定执行，第11-13位类型编码固定填写为118
        List<String> vals = Arrays.asList("12345678901241112222","12345678901181112222");
        String  reg = "(^.{10}118)|(^.{10}123)";
        listMatch(vals,reg);

    }

    private static void testMatch4(){
        // 参照GB/T 28181 20位国标编码规定执行，第11-13位类型编码固定填写为118
        List<String> vals = Arrays.asList("1234","12345678");
        String  reg = "^(\\d{4})$";
        listMatch(vals,reg);
    }

    private static void testMatch6(){
        // 参照GB/T 28181 20位国标编码规定执行，第11-13位类型编码固定填写为118
        List<String> vals = Arrays.asList("1234","12345678","华为");
        String  reg = "^(\\S|\\s){1,128}$";
        listMatch(vals,reg);
    }

    private static void listMatch(List<String> vals, String  reg){
        Pattern pn = Pattern.compile(reg);
        for (String val : vals) {
            Matcher mr = pn.matcher(val);
            if(mr.find()){
                System.out.println(val + ",match");
            }else{
                System.out.println(val + ",non match");
            }

        }
    }
}
