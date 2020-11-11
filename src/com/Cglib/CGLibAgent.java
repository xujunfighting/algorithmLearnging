//package Cglib;
//
//import dynamicProxy.Apple;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
//public class CGLibAgent implements MethodInterceptor {
//    private Object proxy;
//    public Object getInstance(Object obj){
//        this.proxy=obj;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(this.proxy.getClass());
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("before invoking");
//        Object ret= method.invoke(o,objects);
//        System.out.println("after invoking");
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        CGLibAgent cgLibAgent = new CGLibAgent();
//        Apple apple =(Apple)cgLibAgent.getInstance(new Apple());
//        apple.show();
//    }
//}
