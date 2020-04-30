package com.liang3hua.study.effectiveJava.EnumAndAnnotation;

/**
 * @author lianghuarong
 * @date 2020-04-28  20:33
 */
public enum Enseble1 {
    SOLO, DUET,TRIO;

    public int numberOfMusiccians(){
        return ordinal() + 1;
    }

    public static void main(String[] args) {
        System.out.println(Enseble1.SOLO.numberOfMusiccians());
        System.out.println(Enseble1.valueOf("SOLO"));
    }
}
