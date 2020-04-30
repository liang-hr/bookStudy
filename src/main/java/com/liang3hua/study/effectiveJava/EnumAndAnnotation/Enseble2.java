package com.liang3hua.study.effectiveJava.EnumAndAnnotation;

/**
 * @author lianghuarong
 * @date 2020-04-28  20:33
 */
public enum Enseble2 {
    SOLO(10), DUET(2),TRIO(3);

    private final int numberOfMusiccians;
    Enseble2(int num){
        this.numberOfMusiccians = num;
    }
    public int numberOfMusiccians(){
        return this.numberOfMusiccians;
    }

    public static void main(String[] args) {
        System.out.println(Enseble2.SOLO.numberOfMusiccians());
        System.out.println(Enseble2.valueOf("SOLO"));
    }
}
