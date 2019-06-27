package com.example.javaex.javaex.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class a {

    public a(int weight) {
        this.weight = weight;
    }

    private int weight;

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
    public void ss(a a) {
        System.out.println(a);

    }
    public static void main(String[] s) {
        List<a> list = new ArrayList<a>();
        list.add(new a(123));
        list.add(new a(1123));
        list.add(new a(12113));
        List<a> lsit1 = list.stream().filter(a::isHeavyApple).map(a -> {
            new a(12345).ss(a);
            return a;
        }).collect(Collectors.toList());
        List<a> lsit2 = list.stream().filter(a -> a.getWeight() > 1110).map(a -> {
//            System.out.println(a);
            return a;
        }).collect(Collectors.toList());
    }
}
