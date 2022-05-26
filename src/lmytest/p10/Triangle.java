package lmytest.p10;

public class Triangle {
    //定义三角形的三边
    protected long lborderA = 0;
    protected long lborderB = 0;
    protected long lborderC = 0;

    //构造函数
    public Triangle(long lborderA, long lborderB, long lborderC) {
        this.lborderA = lborderA;
        this.lborderB = lborderB;
        this.lborderC = lborderC;
    }

    /**
     * 判断是否是三角形
     * 是返回true；不是返回false
     */
    public boolean isTriangle(Triangle triangle) {
        boolean isTrue = false;
        //判断边界，大于0小于等于100，出界返回false
        if ((triangle.lborderA > 0 && triangle.lborderA <= 100)
                && (triangle.lborderB > 0 && triangle.lborderB <= 100)
                && (triangle.lborderC > 0 && triangle.lborderC <= 100)) {
            //判断两边之和大于第三边
            if ((triangle.lborderA < (triangle.lborderB + triangle.lborderC))
                    && (triangle.lborderB < (triangle.lborderA + triangle.lborderC))
                    && (triangle.lborderC < (triangle.lborderA + triangle.lborderB)))
                isTrue = true;
        }
        return isTrue;
    }

    /**
     * 判断三角形类型
     * 等腰三角形返回字符串“等腰三角形”；
     * 等边三角形返回字符串“等边三角形”；
     * 其它三角形返回字符串“不等边三角形”；
     */
    public String isType(Triangle triangle) {
        String strType = "";
        // 判断是否是三角形
        if (this.isTriangle(triangle)) {
            //判断是否是等边三角形
            if (triangle.lborderA == triangle.lborderB && triangle.lborderB == triangle.lborderC)
                strType = "等边三角形";
                //判断是否是不等边三角形
            else if ((triangle.lborderA != triangle.lborderB) &&
                    (triangle.lborderB != triangle.lborderC) &&
                    (triangle.lborderA != triangle.lborderC))
                strType = "不等边三角形";
            else
                strType = "等腰三角形";
        }
        return strType;
    }

    public static void main(String[] args) {
        Triangle aTriangle;
        aTriangle=new Triangle(-1,2,4);
        if(!aTriangle.isTriangle(aTriangle))
            System.out.println("不是三角形");

    }
}
