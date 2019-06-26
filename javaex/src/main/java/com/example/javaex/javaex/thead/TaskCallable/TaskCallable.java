package com.example.javaex.javaex.thead.TaskCallable;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TaskCallable implements Callable<String> {
    private int id;
    public TaskCallable(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {

        return "result of taskWithResult "+id;
    }

    public static void main(String [] a) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();//工头
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();//
        for(int i = 0 ; i < 10 ;i++){
            results.add(exec.submit(new TaskCallable(i)));//submit返回一个Future，代表了即将要返回的结果
        }
        for(Future<String> f:results){
            System.out.println(f.get());
            System.out.println(f.isDone());
            System.out.println(f.isCancelled());
        }

    }
}
