package designpatterns.ceratepatterns.abstractfactory;

/**
 * 抽象工厂模式(Abstract Factory Pattern)：
 * 提供一个创建一系列相关或相互依赖对象的接口，
 * 而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。
 * 抽象工厂模式结构：抽象工厂、抽象产品、具体工厂、具体产品
 */
public abstract class AbstractFactory {
    abstract ProductA createProductA();
    abstract ProductB createProductB();
}
