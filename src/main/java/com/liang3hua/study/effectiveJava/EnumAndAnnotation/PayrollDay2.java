package com.liang3hua.study.effectiveJava.EnumAndAnnotation;

/**
 * 策略枚举
 * @author lianghuarong
 * @date 2020-04-28  20:41
 */
public enum PayrollDay2 {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY(PayType.WEEKEND),SUNDAY;
    private final PayType payType;

    PayrollDay2(){
        this.payType = PayType.WEEKDAY;
    }

    PayrollDay2(PayType payType){
        this.payType = payType;
    }

    int pay(int mins, int payRate){
        return payType.pay(mins,payRate);
    }

    private enum PayType{
        WEEKDAY{
            int overtimePay(int mins, int payRate){
                return mins <= MIN_PER_SHIFT ? 0 : (mins - MIN_PER_SHIFT) * payRate / 2;
            }
        },WEEKEND{
            int overtimePay(int mins, int payRate){
                return mins * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MIN_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate){
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked,payRate);
        }
    }

    public static void main(String[] args) {
        System.out.println(PayrollDay2.SATURDAY.pay(240, 10));
    }
}
