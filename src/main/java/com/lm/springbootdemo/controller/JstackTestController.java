package com.lm.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liming
 * <p>
 * created at 2020/5/28 14:16
 */
@RestController
@RequestMapping("/jstack")
@Slf4j
public class JstackTestController {
    static A a = new A();
    static B b = new B();

    @RequestMapping(value="/highCpu",method = RequestMethod.GET)
    public void highCpu(){

        new Thread(null,()->{
            log.info("1..........");
            while (true){

            }
        },"thread1111111111").start();

        new Thread(null,()->{
            log.info("2..........");
            try {
                Thread.sleep(1000000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"thread222222222").start();

        new Thread(null,()->{
            log.info("3..........");
            try{
                Thread.sleep(1000000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"thread333333333").start();

    }

    @RequestMapping(value="/deadLock",method = RequestMethod.GET)
    public void deadLock() throws InterruptedException {


       new Thread(()->{
           synchronized (a){
               try {
                   Thread.sleep(2000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               synchronized (b){
                   log.info("获得了 a 和 b");
               }
           }
       }).start();

       Thread.sleep(1000);

       new Thread(()->{
           synchronized (b){
               synchronized (a){
                   log.info("获得了 a 和 b");
               }
           }
       }).start();

    }

    @RequestMapping(value="/heapOut",method = RequestMethod.GET)
    public void heapOut(){
        int i =0;
        try{
            List<String>list = new ArrayList<>();
            String a = "hello";
            while(true){
                list.add(a);
                a= a+a;
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            log.info("=============================运行次数"+i);
        }
    }
}
class  A{};
class  B{};
