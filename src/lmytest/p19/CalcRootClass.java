package lmytest.p19;

public class CalcRootClass {
    private double x1, x2;

    public String CalcFun(double a, double b, double c) {
        double mid = 0;
        String st = "";
        if (a != 0) {
            mid = b * b - 4 * a * c;
            if (mid > 0) {
                x1 = (-b + Math.sqrt(mid)) / (2 * a);
                x2 = (-b - Math.sqrt(mid)) / (2 * a);
                st += ("二个实根\n");
            } else {
                if (mid == 0) {
                    x1 = -b / (2 * a);
                    x2=x1;
                    st += ("一个二重实根\n");
                } else {
                    x1 = -b / (2 * a);
                    x2 = Math.sqrt(-mid) / (2 * a);
                    st += ("二个复根,实部和虚部分别为\n");
                }
            }
            st = st + "x1=" + x1 + ",x2=" + x2 + "\n";
        }
        return st;
    }
}
