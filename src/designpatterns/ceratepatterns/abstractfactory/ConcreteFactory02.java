package designpatterns.ceratepatterns.abstractfactory;

public class ConcreteFactory02 extends AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA02();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB02();
    }
}
