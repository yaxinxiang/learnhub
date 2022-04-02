package designpatterns.ceratepatterns.FactoryMethod;

/**
 * 工厂方法模式:工厂父类负责定义创建产品对象的公共接口，
 * 而工厂子类则负责生成具体的产品对象，
 * 即通过工厂子类来确定究竟应该实例化哪一个具体产品类。
 */
public abstract class AbstractFactory {
    abstract Product createProduct();
}
