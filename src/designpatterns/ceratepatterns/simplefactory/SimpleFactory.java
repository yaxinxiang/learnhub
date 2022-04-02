package designpatterns.ceratepatterns.simplefactory;

/**
 * 简单工厂模式
 * 产品类有一个共同的抽象产品父类
 * 通过一个工厂创建类得到产品类的实例
 */
public class SimpleFactory {
    public Vehicle createVehicle(String vehicle){
        switch(vehicle){
            case "Car":
                return new Car();
            case "Plane":
                return new Plane();
            default:
                return null;
        }
    }
}
