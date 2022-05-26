package lmytest.p3;

public class NextDate {
    private boolean bool;
    // 判断某一年是不是闰年的函数
    public void leapYear(int year) {
        bool = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            // 是闰年
            bool = true;
        }
    }
    public boolean getResult() {
        return bool;
    }
}
