package com.example.javaex.javaex.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class a {
   static List<a> inventory = Arrays.asList(new a(1111123),new a(1123),new a(11123));

    public a(int weight) {
        this.weight = weight;
    }

    private int weight;

    public a() {

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static boolean isHeavyApple(a a) {
        return a.getWeight() > 1110;
    }

    @Override
    public String toString() {
        return "a{" +
                "weight=" + weight +
                '}';
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    static List<a> filterA(List<a> list, Predicate<a> p) {
        List<a> resule = new ArrayList<>();
        for (a a : list) {
            if (p.test(a)) {
                resule.add(a);
            }
        }
        return resule;
    }
    public void ss(a a,int i) {
        i= 100;
        System.out.println(a+"     "+i);

    }


    public static void test() {
        Supplier<a> s = a::new;
        a a1 = s.get();

        Comparator<a> c = comparing(( a a) -> a.getWeight());
        ToIntFunction<a> f1 = a::getWeight;
        c = comparing(a::getWeight);
        inventory.sort(c);
        Function<Integer,a> f = a::new;
        Function<Integer,a> f2= a::new;
        f.apply(100);
    }
    public static void main(String[] s) {
        List<a> list = new ArrayList<a>();
        list.add(new a(123));
        list.add(new a(1123));
        list.add(new a(12113));
        int i =10;
        List<a> lsit1 = list.stream().filter(a::isHeavyApple).map(a -> {
            new a(12345+i).ss(a,i);
            return a;
        }).collect(Collectors.toList());
        List<a> lsit2 = list.stream().filter(a -> a.getWeight() > 1110).map(a -> {
//            System.out.println(a);
            return a;
        }).collect(Collectors.toList());

        a.test();

        long uniqueWords = 0;

    }
}
