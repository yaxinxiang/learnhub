package designpatterns.ceratepatterns.FactoryMethod;

public class ConcreteFactory extends AbstractFactory {
    @Override
    Product createProduct() {
        return new ConcreteOne();
    }
}
