package dynamicProxy;

public class RelflectTest {
    public static void main(String[] args) {
        Fruit fruit =(Fruit)DynamicAgent.agent(Fruit.class,new Apple());
        fruit.show();
    }
}
