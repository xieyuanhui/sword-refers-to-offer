package interview_question_02;

import annotation.NotRecommend;
import annotation.NotThreadSafe;
import annotation.Recommend;
import annotation.ThreadSafe;

public class Singleton {

    /**
     * 饿汉式单例模式,线程安全
     */
    @ThreadSafe
    public static class Singleton1 {
        private final static Singleton1 instance = new Singleton1();

        private Singleton1() {

        }

        public static Singleton1 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式单例模式，线程不安全
     */
    @NotThreadSafe
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 懒汉式单例模式，线程安全，多线程环境下效率不高
     */
    @ThreadSafe
    @NotRecommend
    public static class Singleton3 {
        private static Singleton3 instance = null;

        private Singleton3() {

        }

        public synchronized static Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /**
     * 饿汉式单例模式变种，线程安全
     */
    @ThreadSafe
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式单例模式，使用内部静态类，线程安全，推荐
     */
    @ThreadSafe
    @Recommend
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 instance = new Singleton5();
        }

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.instance;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全，推荐
     */
    @ThreadSafe
    @Recommend
    public enum Singleton6 {
        instance;
    }

    /**
     * 使用双重校验锁，线程安全，推荐
     */
    @ThreadSafe
    @Recommend
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.instance == Singleton6.instance);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }
}
