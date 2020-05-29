package com.lm.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liming
 * <p>
 * created at 2020/5/21 13:49
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @RequestMapping(value="/jenkins",method = RequestMethod.GET)
    public String helloJenkins(){

        log.info("======================info======================");
        log.debug("=====================debug=====================");
        log.error("=====================error=====================");
        return "hello jenkins123!!!!";
    }
}
