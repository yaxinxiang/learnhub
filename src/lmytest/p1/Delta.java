package lmytest.p1;

public class Delta {
    public boolean delta(double a, double b, double c) {
        if (b * b - 4 * a * c >= 0)
            return (true);
        else
            return (false);
    }
}
