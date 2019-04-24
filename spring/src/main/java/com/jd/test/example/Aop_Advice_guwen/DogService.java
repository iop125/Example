package com.jd.test.example.Aop_Advice_guwen;

public class DogService implements AnimalService {



    @Override
    public void eat() {
        System.out.println("吃 ");
    }

    @Override
    public void wc() {
        System.out.println("上 ");
    }
}
