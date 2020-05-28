package com.lm.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liming
 * <p>
 * created at 2020/5/28 14:16
 */
@RestController
@RequestMapping("/jstack")
@Slf4j
public class JstackTestController {

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public void helloJenkins(){

        new Thread(null,()->{
            System.err.println("1..........");
            while (true){

            }
        },"thread1111111111").start();

        new Thread(null,()->{
            System.err.println("2..........");
            try {
                Thread.sleep(1000000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"thread222222222").start();

        new Thread(null,()->{
            System.err.println("3..........");
            try{
                Thread.sleep(1000000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"thread333333333").start();

    }
}
