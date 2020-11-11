package learning.threadLocal;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>(){
        @Override
        protected Integer  initialValue() {
            System.out.println("init value");
            return 11;
        }
    };
    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(x.get());
                    }
                }
        ).start();
        x.set(20);
        System.out.println(x.get());
    }
}
