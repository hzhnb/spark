package bean.bean;

public class MyApp {
    public static void main(String[] args) {
        //第一种写法
        Animal cat = new Cat();
        test(cat);
        //第二种，匿名内部类
        test(new Animal() {
            @Override
            public void run() {
                System.out.println("不知道什么东西再跑");
            }
        });
        //3,Lambda表达式
        test(()->System.out.println("不知道什么东西再跑"));
    }
    public static void test(Animal animal){
        System.out.println("开始");
        animal.run();
        System.out.println("结束");
    }
}
