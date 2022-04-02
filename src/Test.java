import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
    }
}

class A{
    public float getNum(){
        return 3.0f;
    }
}
class B extends A{
    public double getNum(float d){return 4.0d;}
}
