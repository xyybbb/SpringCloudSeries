package com.yangyang.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chenshunyang on 2017/5/24.
 */
@RestController
public class BackEnd2UserController {

    private static final Logger logger = LoggerFactory.getLogger(BackEnd2UserController.class);


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/call/{id}")
    public String callHome(@PathVariable String id){
        logger.info("calling trace demo backend2");
        return "(This is BackEnd2)hello "+id;
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
