package com.example.javaex.javaex.suo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子更新基本类型
 * atomic包提高原子更新基本类型的工具类，主要有这些：
 *
 * AtomicBoolean：以原子更新的方式更新boolean；
 * AtomicInteger：以原子更新的方式更新Integer;
 * AtomicLong：以原子更新的方式更新Long；
 *
 * 这几个类的用法基本一致，这里以AtomicInteger为例总结常用的方法
 *
 * addAndGet(int delta) ：以原子方式将输入的数值与实例中原本的值相加，并返回最后的结果；
 * incrementAndGet() ：以原子的方式将实例中的原值进行加1操作，并返回最终相加后的结果；
 * getAndSet(int newValue)：将实例中的值更新为新值，并返回旧值；
 * getAndIncrement()：以原子的方式将实例中的原值加1，返回的是自增前的旧值；
 *
 * 还有一些方法，可以查看API，不再赘述。为了能够弄懂AtomicInteger的实现原理，以getAndIncrement方法为例，来看下源码：
 * public final int getAndIncrement() {
 *     return unsafe.getAndAddInt(this, valueOffset, 1);
 * }
 *
 * 可以看出，该方法实际上是调用了unsafe实例的getAndAddInt方法，unsafe实例的获取时通过UnSafe类的静态方法getUnsafe获取：
 * private static final Unsafe unsafe = Unsafe.getUnsafe();
 *
 * Unsafe类在sun.misc包下，Unsafer类提供了一些底层操作，atomic包下的原子操作类的也主要是通过Unsafe类提供的compareAndSwapInt，compareAndSwapLong等一系列提供CAS操作的方法来进行实现。下面用一个简单的例子来说明AtomicInteger的用法：
 * public class AtomicDemo {
 *     private static AtomicInteger atomicInteger = new AtomicInteger(1);
 *
 *     public static void main(String[] args) {
 *         System.out.println(atomicInteger.getAndIncrement());
 *         System.out.println(atomicInteger.get());
 *     }
 * }
 * 输出结果：
 * 1
 * 2
 *
 * 例子很简单，就是新建了一个atomicInteger对象，而atomicInteger的构造方法也就是传入一个基本类型数据即可，对其进行了封装。对基本变量的操作比如自增，自减，相加，更新等操作，atomicInteger也提供了相应的方法进行这些操作。但是，因为atomicInteger借助了UnSafe提供的CAS操作能够保证数据更新的时候是线程安全的，并且由于CAS是采用乐观锁策略，因此，这种数据更新的方法也具有高效性。
 * AtomicLong的实现原理和AtomicInteger一致，只不过一个针对的是long变量，一个针对的是int变量。而boolean变量的更新类AtomicBoolean类是怎样实现更新的呢?核心方法是compareAndSett方法，其源码如下：
 * public final boolean compareAndSet(boolean expect, boolean update) {
 *     int e = expect ? 1 : 0;
 *     int u = update ? 1 : 0;
 *     return unsafe.compareAndSwapInt(this, valueOffset, e, u);
 * }
 *
 * 可以看出，compareAndSet方法的实际上也是先转换成0,1的整型变量，然后是通过针对int型变量的原子更新方法compareAndSwapInt来实现的。可以看出atomic包中只提供了对boolean,int ,long这三种基本类型的原子更新的方法，参考对boolean更新的方式，原子更新char,doule,float也可以采用类似的思路进行实现。
 * 4. 原子更新数组类型
 * atomic包下提供能原子更新数组中元素的类有：
 *
 * AtomicIntegerArray：原子更新整型数组中的元素；
 * AtomicLongArray：原子更新长整型数组中的元素；
 * AtomicReferenceArray：原子更新引用类型数组中的元素
 *
 * 这几个类的用法一致，就以AtomicIntegerArray来总结下常用的方法：
 *
 * addAndGet(int i, int delta)：以原子更新的方式将数组中索引为i的元素与输入值相加；
 * getAndIncrement(int i)：以原子更新的方式将数组中索引为i的元素自增加1；
 * compareAndSet(int i, int expect, int update)：将数组中索引为i的位置的元素进行更新
 *
 * 可以看出，AtomicIntegerArray与AtomicInteger的方法基本一致，只不过在AtomicIntegerArray的方法中会多一个指定数组索引位i。下面举一个简单的例子：
 * public class AtomicDemo {
 *     //    private static AtomicInteger atomicInteger = new AtomicInteger(1);
 *     private static int[] value = new int[]{1, 2, 3};
 *     private static AtomicIntegerArray integerArray = new AtomicIntegerArray(value);
 *
 *     public static void main(String[] args) {
 *         //对数组中索引为1的位置的元素加5
 *         int result = integerArray.getAndAdd(1, 5);
 *         System.out.println(integerArray.get(1));
 *         System.out.println(result);
 *     }
 * }
 * 输出结果：
 * 7
 * 2
 *
 * 通过getAndAdd方法将位置为1的元素加5，从结果可以看出索引为1的元素变成了7，该方法返回的也是相加之前的数为2。
 * 5. 原子更新引用类型
 * 如果需要原子更新引用类型变量的话，为了保证线程安全，atomic也提供了相关的类：
 *
 * AtomicReference：原子更新引用类型；
 * AtomicReferenceFieldUpdater：原子更新引用类型里的字段；
 * AtomicMarkableReference：原子更新带有标记位的引用类型；
 *
 * 这几个类的使用方法也是基本一样的，以AtomicReference为例，来说明这些类的基本用法。下面是一个demo
 * public class AtomicDemo {
 *
 *     private static AtomicReference<User> reference = new AtomicReference<>();
 *
 *     public static void main(String[] args) {
 *         User user1 = new User("a", 1);
 *         reference.set(user1);
 *         User user2 = new User("b",2);
 *         User user = reference.getAndSet(user2);
 *         System.out.println(user);
 *         System.out.println(reference.get());
 *     }
 *
 *     static class User {
 *         private String userName;
 *         private int age;
 *
 *         public User(String userName, int age) {
 *             this.userName = userName;
 *             this.age = age;
 *         }
 *
 *         @Override
 *         public String toString() {
 *             return "User{" +
 *                     "userName='" + userName + '\'' +
 *                     ", age=" + age +
 *                     '}';
 *         }
 *     }
 * }
 *
 * 输出结果：
 * User{userName='a', age=1}
 * User{userName='b', age=2}
 *
 * 首先将对象User1用AtomicReference进行封装，然后调用getAndSet方法，从结果可以看出，该方法会原子更新引用的user对象，变为User{userName='b', age=2}，返回的是原来的user对象User{userName='a', age=1}。
 * 6. 原子更新字段类型
 * 如果需要更新对象的某个字段，并在多线程的情况下，能够保证线程安全，atomic同样也提供了相应的原子操作类：
 *
 * AtomicIntegeFieldUpdater：原子更新整型字段类；
 * AtomicLongFieldUpdater：原子更新长整型字段类；
 * AtomicStampedReference：原子更新引用类型，这种更新方式会带有版本号。而为什么在更新的时候会带有版本号，是为了解决CAS的ABA问题；
 *
 * 要想使用原子更新字段需要两步操作：
 *
 * 原子更新字段类都是抽象类，只能通过静态方法newUpdater来创建一个更新器，并且需要设置想要更新的类和属性；
 * 更新类的属性必须使用public volatile进行修饰；

 */

/**
 * Atomic 原理看lock2
 */
public class Lock1 {

    /**
     * 线程安全的i++
     */
    public void ss(){
        AtomicInteger i = new AtomicInteger();
        System.out.println(i.incrementAndGet());
    }
    /**
     * 线程安全的累加
     */
    public void add(){
        AtomicInteger i = new AtomicInteger(11);
        System.out.println(i.addAndGet(23));
        System.out.println(i.addAndGet(23));
    }
    public static void main(String a []){
        Lock1 lock1 = new Lock1();
        lock1.ss();
        lock1.add();
    }
}
