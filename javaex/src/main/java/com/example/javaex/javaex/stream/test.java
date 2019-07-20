package com.example.javaex.javaex.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingDouble;

public class test {
    public static void main(String []a ){
//        test.map();
//        test.flatMap();
        test.Finding();
    }

    public static void map() {
        List<String> invoices = new ArrayList<String>();
        invoices.add("1,2,3,4,5,566");
        invoices.add("a,d,g,e,d,l");

        invoices.stream().map(str -> str.split("")).forEach(System.out::println);
    }
    public static void flatMap() {
        List<String> invoices = new ArrayList<String>();
        invoices.add("1,2,3,4,5,566");
        invoices.add("a,d,g,e,d,l");

        invoices.stream().map(str -> str.split(",")).flatMap(Arrays::stream).map(str-> str = str +" first").forEach(System.out::println);
    }
    public static void Finding() {
        List<String> invoices = new ArrayList<String>();
        invoices.add("1");
        invoices.add("a");
        invoices.add("1");

        Optional<String[]> o=  invoices.stream()
                .map(str->str.split(""))
                .filter(inv-> inv[0].equals("a")||inv.equals("1")).findAny();
        Stream.of(o).forEach(strings -> System.out.println(strings.toString()));
    }


    class Invoice {
        private long id;
        private String title;
        private double amount;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }




}
