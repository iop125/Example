package com.example.javaex.javaex.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class PrimeNumbersCollector
        implements Collector<Integer,
                Map<Boolean, List<Integer>>,
                Map<Boolean, List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<Integer>());
            put(false, new ArrayList<Integer>());
        }};
    }
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get( isPrime( acc.get(true),
                    candidate) )
                    .add(candidate);
        };
    }
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {

    return (Map<Boolean, List<Integer>> map1,
    Map<Boolean, List<Integer>> map2) -> {
    map1.get(true).addAll(map2.get(true));
    map1.get(false).addAll(map2.get(false));
    return map1;
    };
    }
    @Override
    public Function<Map<Boolean, List<Integer>>,
        Map<Boolean, List<Integer>>> finisher() {
    return Function.identity();
    }
    @Override
    public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
    public static boolean isPrime(List<Integer> primes, int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }
    public static <A> List<A> takeWhile(List<A> list, a.Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            boolean b = !p.test(item);
            if (b) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
    public Map<Boolean, List<Integer>>
    partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    public static void main(String [] a){
        PrimeNumbersCollector primeNumbersCollector = new PrimeNumbersCollector();
        Map<Boolean, List<Integer>> map = primeNumbersCollector.partitionPrimesWithCustomCollector(100);
        map.forEach((Boolean b ,List<Integer> list)->{
            System.out.println(b);
            list.stream().forEach(System.out::println);
        });
    }
}