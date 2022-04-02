package designpatterns.ceratepatterns.abstractfactory;

public class ConcreteFactory01 extends AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA01();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB01();
    }
}
